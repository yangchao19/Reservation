package com.yang.reservation.infrastructure.po;

import java.util.Date;

/**
 * @description: 学生类
 * @author：杨超
 * @date: 2023/5/22
 * @Copyright：
 */
public class Student {

    /**
     * 自增id
     */
    private Long id;

    /**
     * 学生id
     */
    private Long studentId;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 家长姓名
     */
    private String parentName;

    /**
     * 家长电话号码
     */
    private String phone;

    /**
     * 学生年级
     */
    private String grade;

    /**
     * 注册时间
     */
    private Date registerDate;

    /**
     * 更新时间
     */
    private Date updateDate;

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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", parentName='" + parentName + '\'' +
                ", phone='" + phone + '\'' +
                ", grade='" + grade + '\'' +
                ", registerDate=" + registerDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
