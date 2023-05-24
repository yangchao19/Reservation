package com.yang.reservation.infrastructure.po;

import java.util.Date;

/**
 * @description: 教师类
 * @author：杨超
 * @date: 2023/5/22
 * @Copyright：
 */
public class Teacher {

    /**
     * 自增id
     */
    private Long id;

    /**
     * 教师id
     */
    private Long teacherId;

    /**
     * 教师姓名
     */
    private String teacherName;

    /**
     * 任课科目
     */
    private String subject;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 备注信息
     */
    private String info;

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
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
        return "Teacher{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", subject='" + subject + '\'' +
                ", phone='" + phone + '\'' +
                ", info='" + info + '\'' +
                ", registerDate=" + registerDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
