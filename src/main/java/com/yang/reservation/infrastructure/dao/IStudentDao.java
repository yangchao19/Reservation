package com.yang.reservation.infrastructure.dao;

import com.yang.reservation.infrastructure.po.Student;
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
public interface IStudentDao {
    /**
     * 新增学生
     * @param student 学生信息
     */
    void insert (Student student);

    /**
     * 更新学生信息
     * @param student 学生信息
     * @return 更新结果
     */
    int update (Student student);

    /**
     * 删除学生信息
     * @param studentId 学生ID
     */
    void deleteByStudentId (Long studentId);

    /**
     * 根据
     * @param studentId 学生ID
     * @return
     */
    Student queryByStudentId (Long studentId);

    /**
     * 根据手机号查询学生信息
     * @param phone
     * @return
     */
    Student queryByPhone (String phone);

    /**
     * 查询总数
     * @return
     */
    int count ();

    /**
     * 分页查询学生信息
     * @param page
     * @param pageSize
     * @param studentName
     * @return
     */
    List<Student> queryList (@Param("page") long page, @Param("pageSize") long pageSize, @Param("studentName") String studentName);
}
