package com.yang.reservation.application;

import com.yang.reservation.common.Page;
import com.yang.reservation.domain.order.model.OrderVO;
import com.yang.reservation.infrastructure.po.Order;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author：杨超
 * @date: 2023/5/30
 * @Copyright：
 */
public interface IOrderService {

    /**
     * 根据条件分页查询订单列表
     * @param page
     * @param pageSize
     * @param orderId
     * @param beginTime
     * @param endTime
     * @return
     */
    Page<OrderVO> queryList (long page, long pageSize, String orderId, Date beginTime, Date endTime);

    List<OrderVO> queryListById(long studentId);
}
