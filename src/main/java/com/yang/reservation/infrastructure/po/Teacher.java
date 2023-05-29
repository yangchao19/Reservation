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
     * 用户登录名
     */
    private String username;

    /**
     * 登录密码，使用 m5 加密
     */
    private String password;

    /**
     * 账户是否可用 1代表可用 0代表不可用
     */
    private int status;

    /**
     * 教师姓名
     */
    private String teacherName;

    /**
     * 任课科目 0：其他 1:语文 2：数学 3：外语 4：物理 5：化学 6：生物 7：政治 8：历史 9：地理 10：技术
     */
    private int subject;

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

    /**
     * 创建者
     */
    private Long creatorId;

    /**
     * 更新者
     */
    private Long updaterId;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
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

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Long getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", teacherName='" + teacherName + '\'' +
                ", subject=" + subject +
                ", phone='" + phone + '\'' +
                ", info='" + info + '\'' +
                ", registerDate=" + registerDate +
                ", updateDate=" + updateDate +
                ", creatorId=" + creatorId +
                ", updaterId=" + updaterId +
                '}';
    }
}
