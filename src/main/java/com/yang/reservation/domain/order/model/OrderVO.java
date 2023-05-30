package com.yang.reservation.domain.order.model;

import java.util.Date;

/**
 * @description:
 * @author：杨超
 * @date: 2023/5/30
 * @Copyright：
 */
public class OrderVO {


    /**
     * 预约订单号
     */
    private Long orderId;
    /**
     * 学生id
     */
    private Long studentId;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 学生家长的电话号码
     */
    private String phone;

    /**
     * 预约课程id
     */
    private Long curriculumId;

    /**
     * 课程名称
     */
    private String curriculumName;

    /**
     * 教师id
     */
    private Long teacherId;

    /**
     * 教师姓名
     */
    private String teacherName;


    /**
     * 订单状态信息
     */
    private Integer status;

    /**
     * 预约课程的下单时间
     */
    private Date date;

    /**
     * 实收金额
     */
    private Integer money;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Long curriculumId) {
        this.curriculumId = curriculumId;
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "orderVO{" +
                "orderId=" + orderId +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", curriculumId=" + curriculumId +
                ", curriculumName='" + curriculumName + '\'' +
                ", teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", status=" + status +
                ", date=" + date +
                ", money=" + money +
                '}';
    }
}
