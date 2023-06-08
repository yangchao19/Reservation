package com.yang.reservation.interfaces;

import com.yang.reservation.application.IOrderService;
import com.yang.reservation.common.Page;
import com.yang.reservation.common.Return;
import com.yang.reservation.domain.order.model.OrderVO;
import com.yang.reservation.infrastructure.po.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author：杨超
 * @date: 2023/5/30
 * @Copyright：
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    private Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private IOrderService orderService;

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @param orderId orderId可能为空，所有不能使用long类型，不然会报错
     * @param beginTime
     * @param endTime
     * @return
     */
    @GetMapping("/page")
    public Return<Page<OrderVO>> queryPage (long page, long pageSize, String orderId, Date beginTime, Date endTime) {
        logger.info("page:{},pageSize:{},orderId:{},beginTime:{},endTime:{}",page,pageSize,orderId,beginTime,endTime);

        Page<OrderVO> orderVOPage = orderService.queryList(page, pageSize, orderId, beginTime, endTime);
        if (null != orderVOPage) {
            return Return.success(orderVOPage);
        }else {
            return Return.error("查询失败");
        }
    }

    /**
     * 获取当前学生的预约订单信息
     * @param session
     * @return
     */
    @GetMapping("/oneList")
    public Return<List<OrderVO>> queryOrderById(HttpSession session){

        long studentId = Long.parseLong(session.getAttribute("student").toString());

        List<OrderVO> orderVOList = orderService.queryListByStudentId(studentId);
        return Return.success(orderVOList);
    }

    @PutMapping
    public Return<String> addOrder(HttpSession session, long curriculumId) {
        long studentId = Long.parseLong(session.getAttribute("student").toString());

        //1.检验是否已经预约过

        Order order = orderService.queryByCurriculumId(studentId, curriculumId);
        if (order != null) {
            return Return.error("课程已经预约过，请勿重复预约");
        }

        //2.预约课程
        boolean b = orderService.addOrder(studentId, curriculumId);
        if (b) {
            logger.info("课程预约成功 studentId:{} curriculumId:{}",studentId,curriculumId);
            return Return.success("预订成功");
        }
        return Return.error("预定失败");
    }

    @GetMapping("/userPage")
    public Return<Page<OrderVO>> queryList(long page,long pageSize,HttpSession session) {
        long  studentId = (long) session.getAttribute("student");
        Page<OrderVO> orderVOPage = orderService.queryPageListByStudentId(page, pageSize, studentId);
        return Return.success(orderVOPage);
    }

    @PutMapping("/quit")
    public Return<String> quitOrder(long orderId) {
        boolean b = orderService.quitOrder(orderId);
        if (b) {
            return Return.success("取消成功");
        }else {
            return Return.error("取消失败");
        }
    }
}
