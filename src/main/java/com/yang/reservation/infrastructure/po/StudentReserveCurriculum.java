package com.yang.reservation.infrastructure.po;

/**
 * @description: 学生预约课程类
 * @author：杨超
 * @date: 2023/5/24
 * @Copyright：
 */
public class StudentReserveCurriculum {

    /**
     * 自增id
     */
    private  Long id;
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

    @Override
    public String toString() {
        return "StudentReserveCurriculum{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", curriculumId=" + curriculumId +
                ", teacherId=" + teacherId +
                '}';
    }
}
