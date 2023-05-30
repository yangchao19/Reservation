package com.yang.reservation.infrastructure.dao;

import com.yang.reservation.infrastructure.po.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author：杨超
 * @date: 2023/5/24
 * @Copyright：
 */
@Mapper
public interface IOrderDao {
    /**
     * 新增学生预约课程信息
     * @param order 学生预约课程信息
     */
    void insert (Order order);

    /**
     * 根据学生id查询已预约课程
     * @param studentId 学生ud 
     * @return 预约课程信息
     */
    List<Order> queryListByStudentId (Long studentId);

    /**
     * 查询该学生是否已经预约过该课程
     * @param order 学生预约课程信息
     * @return 查询结果(非空则为已经预约过，不能重复预约)
     */
    Order query (Order order);

    /**
     * 根据订单id查询订单
     * @param orderId
     * @return
     */
    Order queryByOrderId(long orderId);

    /**
     * 根据开始和截至时间查询订单
     * @param startTime
     * @param endTime
     * @return
     */
    Order queryByStartAndEndTime (@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /**
     * 分页查询
     * @param page 当前页数
     * @param pageSize 页大小
     * @param orderId 订单ID
     * @param beginTime 开始时间
     * @param endTime 截止时间
     * @return 订单信息
     */
    List<Order> queryList (@Param("page") long page, @Param("pageSize") long pageSize, @Param("orderId") long orderId, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);

    /**
     * 根据课程id删除学生预约课程信息
     * @param curriculumId 预约课程id
     */
    void deleteByCurriculumId (Long curriculumId);

    /**
     * 根据学生id删除预约课程信息
     * @param studentId 学生id
     */
    void deleteByStudentId (Long studentId);


    /**
     * 查询符合条件的订单数
     * @param orderId
     * @param beginTime
     * @param endTime
     * @return
     */
    int count (@Param("orderId") long orderId, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);
}
