package com.yang.reservation.infrastructure.dao;

import com.yang.reservation.infrastructure.po.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description:
 * @author：杨超
 * @date: 2023/5/22
 * @Copyright：
 */
@Mapper
public interface ITeacherDao {
    /**
     * 新增教师信息
     * @param teacher 教师信息
     */
    void insert(Teacher teacher);

    /**
     * 删除教师信息
     * @param teacherId 教师ID
     */
    void delete(Long teacherId);

    /**
     * 更新教师信息
     * @param teacher 教师信息
     * @return 更新结果
     */
    int update(Teacher teacher);

    /**
     * 查询所有教师信息列表
     * @return 教师信息列表
     */
    List<Teacher> queryTeacherList ();

    /**
     * 查询教师信息
     * @param TeacherId 教师ID
     * @return 教师信息
     */
    Teacher queryTeacherById (Long TeacherId);
}
