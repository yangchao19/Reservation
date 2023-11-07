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

    /**
     * 根据学生id获取预约订单信息
     * @param page
     * @param pageSize
     * @param studentId
     * @return
     */
    Page<OrderVO> queryPageListByStudentId(long page, long pageSize, long studentId);

    /**
     * 根据学生id查询该学生的课程预约信息列表
     * @param studentId
     * @return
     */
    List<OrderVO> queryListByStudentId(long studentId);


    /**
     * 根据学生id和课程id 预约课程，新增订单信息
     * @param studentId
     * @param curriculumId
     * @return
     */
    boolean addOrder(long studentId,long curriculumId);

    /**
     * 根据订单id取消订单
     * @param orderId
     * @return
     */
    boolean quitOrder(long orderId);

    /**
     * 根据学生id和课程id 查询order
     * @param studentId
     * @param curriculumId
     * @return
     */
    List<Order> queryByCurriculumId(long studentId,long curriculumId);

}
