package com.yang.reservation.application;

import com.yang.reservation.common.Page;
import com.yang.reservation.common.Return;
import com.yang.reservation.infrastructure.po.Teacher;

/**
 * @description: 教师端
 * @author：杨超
 * @date: 2023/5/25
 * @Copyright：
 */
public interface ITeacherService {

    /**
     * 登录校验接口
     * @param teacher 教师信息，提供教师的用户名和密码用来校对
     * @return 校验结果（教师信息，校验是否成功）
     */
    Return<Teacher> loginCheck (Teacher teacher);

    /**
     * 新增教师
     * @param teacher 教师信息
     * @return
     */
    Return<String> save (Teacher teacher);

    /**
     * 分页查询
     * @param page
     * @param teacherName
     * @return
     */
    Return<Page<Teacher>> queryList (Page<Teacher> page, String teacherName);

    /**
     * 列表行数
     * @return
     */
    long count();

    /**
     * 更新教师信息
     * @param teacher
     * @return
     */
    int update (Teacher teacher);

    /**
     * 根据id查询教师信息
     * @param teacherId
     * @return
     */
    Teacher queryTeacherById(Long teacherId);
}
