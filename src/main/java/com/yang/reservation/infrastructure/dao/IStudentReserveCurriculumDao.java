package com.yang.reservation.infrastructure.dao;

import com.yang.reservation.infrastructure.po.StudentReserveCurriculum;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description:
 * @author：杨超
 * @date: 2023/5/24
 * @Copyright：
 */
@Mapper
public interface IStudentReserveCurriculumDao {
    /**
     * 新增学生预约课程信息
     * @param studentReserveCurriculum 学生预约课程信息
     */
    void insert (StudentReserveCurriculum studentReserveCurriculum);

    /**
     * 根据学生id查询已预约课程
     * @param studentId 学生ud
     * @return 预约课程信息
     */
    List<StudentReserveCurriculum> queryListByStudentId (Long studentId);

    /**
     * 查询该学生是否已经预约过该课程
     * @param studentReserveCurriculum 学生预约课程信息
     * @return 查询结果(非空则为已经预约过，不能重复预约)
     */
    StudentReserveCurriculum query (StudentReserveCurriculum studentReserveCurriculum);

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
}
