package com.yang.reservation.domain.support.id.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import com.yang.reservation.domain.support.id.IIdGenerator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @description:
 * @author：杨超
 * @date: 2023/5/27
 * @Copyright：
 */
@Component("snowflake")
public class SnowFlake implements IIdGenerator {
    /** 分布式id生成器*/
    private Snowflake snowflake;

    @PostConstruct
    public void init() {

        /** 工作机器id*/
        long workerId;
        /** 数据中心id*/
        long dataCenterId = 1L;
        try {
            //根据IP地址计算出long型数据
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        } catch (Exception e) {
            //获取本机ip地址字符串
            workerId = NetUtil.getLocalhostStr().hashCode();
        }
        /** 31二进制为： 0001 1111 */
        workerId = workerId >> 16 & 31;

        snowflake = IdUtil.createSnowflake(workerId,dataCenterId);

    }
    @Override
    public synchronized long nextId() {
        return snowflake.nextId();
    }
}
