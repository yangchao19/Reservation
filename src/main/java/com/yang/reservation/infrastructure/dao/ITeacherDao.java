package com.yang.reservation.infrastructure.dao;

import com.yang.reservation.common.Page;
import com.yang.reservation.infrastructure.po.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
     * 分页查询
     * @param page
     * @param pageSize
     * @param teacherName
     * @return
     */
    List<Teacher> queryTeacherList (@Param("page") long page, @Param("pageSize") long pageSize, @Param("teacherName") String teacherName);

    /**
     *列表行数
     * @return
     */
    int count ();

    /**
     * 根据教师Id查询教师信息
     * @param TeacherId 教师ID
     * @return 教师信息
     */
    Teacher queryTeacherById (Long TeacherId);

    /**
     * 根据用户名查询教师信息
     * @param username 用户名
     * @return 教师信息
     */
    Teacher queryByUsername (String username);

    /**
     * 根据教师名查询 教师信息
     * @param teacherName
     * @return
     */
    Teacher queryByTeacherName (String teacherName);
}
