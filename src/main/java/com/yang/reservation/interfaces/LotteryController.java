package com.yang.reservation.interfaces;

import com.yang.lottery.rpc.activity.booth.ILotteryActivityBooth;
import com.yang.lottery.rpc.activity.booth.req.DrawReq;
import com.yang.lottery.rpc.activity.booth.res.DrawRes;
import com.yang.lottery.rpc.activity.deploy.ILotteryActivityDeploy;
import com.yang.lottery.rpc.activity.deploy.dto.StrategyDTO;
import com.yang.lottery.rpc.activity.deploy.res.StrategyRes;
import com.yang.reservation.domain.luck.model.Prize;
import com.yang.reservation.domain.luck.model.Strategy;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 抽奖接口
 * @author：杨超
 * @date: 2023/11/6
 * @Copyright：
 */
@RestController
@RequestMapping("/lottery")
public class LotteryController {

    private Logger logger = LoggerFactory.getLogger(LotteryController.class);

    @DubboReference
    private ILotteryActivityDeploy lotteryActivityDeploy;

    @DubboReference
    private ILotteryActivityBooth lotteryActivityBooth;

    private List<Prize> list = new ArrayList<>();

    /**
     * 查询奖品列表
     * @param id
     * @return
     */
    @GetMapping(value = "/queryLucky", produces = "application/json;charset=utf-8")
    public List<Prize> queryLuckyList(@RequestParam Long id) {
        StrategyRes strategyRes = lotteryActivityDeploy.queryStrategyDetailByActivityId(id);
        List<StrategyDTO> strategyList = strategyRes.getStrategyList();

        list.clear();
        for (StrategyDTO strategyDTO : strategyList) {
            String top = strategyDTO.getAwardRate().multiply(new BigDecimal(100)).intValue() + "%";
            list.add(new Prize(new Strategy(strategyDTO.getAwardName(),top),"#e9e8fe"));
        }
        return list;
    }


    /**
     * 开始抽奖，返回奖品id
     * @param userId 用户id
     * @return
     */
    @GetMapping(value = "/doDraw", produces = "application/json;charset=utf-8")
    public int lottery(@RequestParam Long userId) {
        DrawReq drawReq = new DrawReq();
        drawReq.setuId(userId.toString());
        drawReq.setActivityId(100001L);
        DrawRes drawRes = lotteryActivityBooth.doDraw(drawReq);
        logger.info("code:{},info:{}",drawRes.getCode(),drawRes.getInfo());

        int index = -1;
        for (int i = 0;i < list.size();i++) {
            if (list.get(i).getFonts().get(0).getText().equals(drawRes.getAwardDTO().getAwardName())) {
                index = i;
                break;
            }
        }
        return index == -1 ? 0 : index;
    }
}
