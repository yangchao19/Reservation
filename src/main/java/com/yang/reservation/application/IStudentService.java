package com.yang.reservation.application;

import com.yang.reservation.common.Page;
import com.yang.reservation.common.Return;
import com.yang.reservation.infrastructure.po.Student;

import java.util.List;

/**
 * @description: 学生端
 * @author：杨超
 * @date: 2023/5/25
 * @Copyright：
 */
public interface IStudentService {

    /**
     * 查询学生总数
     * @return
     */
    int count ();

    /**
     * 分页查询学生信息，也可按学生姓名查询
     * @param page
     * @param studentName
     * @return
     */
    Return<Page<Student>> queryList (Page<Student> page,String studentName);

    /**
     * 根据学生id查询信息
     * @param id
     * @return
     */
    Student queryStudentById (long id);

    /**
     * 更新对应学生id的个人信息
     * @param student
     * @return
     */
    int update (Student student);

    /**
     * 新增学生信息
     * @param student
     */
    void add (Student student);

    /**
     * 发送手机验证码
     * @param phone
     * @return 发送给手机的验证码
     */
    String sendMsg(String phone) throws Exception;
}
