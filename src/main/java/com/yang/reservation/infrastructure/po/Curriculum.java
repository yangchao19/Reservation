package com.yang.reservation.infrastructure.po;

import java.util.Date;

/**
 * @description: 课程类
 * @author：杨超
 * @date: 2023/5/22
 * @Copyright：
 */
public class Curriculum {
    /**
     * 自增id
     */
    private Long id;

    /**
     * 课程id
     */
    private Long curriculumId;

    /**
     * 课程名称
     */
    private String curriculumName;

    /**
     * 该课程对应老师的id
     */
    private Long teacherId;

    /**
     * 课程可预约总人数
     */
    private int stock;

    /**
     * 课程已预约人数
     */
    private int stockUsed;

    /**
     * 课程开始时间
     */
    private Date beginTime;

    /**
     * 课程结束时间
     */
    private Date endTime;

    /**
     * 课程备注信息
     */
    private String info;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockUsed() {
        return stockUsed;
    }

    public void setStockUsed(int stockUsed) {
        this.stockUsed = stockUsed;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "id=" + id +
                ", curriculumId=" + curriculumId +
                ", curriculumName='" + curriculumName + '\'' +
                ", teacherId=" + teacherId +
                ", stock=" + stock +
                ", stockUsed=" + stockUsed +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", info='" + info + '\'' +
                '}';
    }
}
