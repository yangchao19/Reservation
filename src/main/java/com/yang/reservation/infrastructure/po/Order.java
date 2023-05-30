package com.yang.reservation.infrastructure.po;

import java.util.Date;

/**
 * @description: 课程预约订单
 * @author：杨超
 * @date: 2023/5/24
 * @Copyright：
 */
public class Order {

    /**
     * 自增id
     */
    private Long id;

    /**
     * 预约订单号
     */
    private Long orderId;
    /**
     * 学生id
     */
    private Long studentId;

    /**
     * 预约课程id
     */
    private Long curriculumId;

    /**
     * 教师id
     */
    private Long teacherId;

    /**
     * 订单状态：0：待付款 1：已付款
     */
    private int status;


    /**
     * 预约课程的下单时间
     */
    private Date date;

    /**
     * 实收金额
     */
    private int money;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Long curriculumId) {
        this.curriculumId = curriculumId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", studentId=" + studentId +
                ", curriculumId=" + curriculumId +
                ", teacherId=" + teacherId +
                ", status=" + status +
                ", date=" + date +
                ", money=" + money +
                '}';
    }
}
