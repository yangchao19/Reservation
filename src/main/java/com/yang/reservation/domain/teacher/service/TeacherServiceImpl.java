package com.yang.reservation.domain.teacher.service;

import com.yang.reservation.application.ITeacherService;
import com.yang.reservation.common.Page;
import com.yang.reservation.common.Return;
import com.yang.reservation.domain.support.id.IIdGenerator;
import com.yang.reservation.infrastructure.dao.ITeacherDao;
import com.yang.reservation.infrastructure.po.Teacher;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author：杨超
 * @date: 2023/5/26
 * @Copyright：
 */
@Service
public class TeacherServiceImpl implements ITeacherService {

    @Resource
    private ITeacherDao teacherDao;

    @Resource(name = "snowflake")
    private IIdGenerator idGenerator;

    @Override
    public Return<Teacher> loginCheck(Teacher teacher) {
        //1. 将页面提交的密码password进行md5加密处理
        String password = teacher.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //2. 根据页面提交的用户名username查询数据库
        Teacher t = teacherDao.queryByUsername(teacher.getUsername());


        //3. 如果没有查询到则返回失败结果
        if (t == null) {
            return Return.error("登陆失败");
        }

        //4. 密码对比，如果不一致则返回登录结果失败结果
        if (!t.getPassword().equals(password)) {
            return Return.error("登陆失败");
        }

        //5. 查看员工（教师）状态，如果为已禁用状态，则返回员工已禁用结果
        if (t.getStatus() != 1) {
            return Return.error("账号已禁用");
        }
        //6.返回校验成功结果
        return Return.success(t);
    }

    @Override
    public Return<String> save(Teacher teacher) {

        //设置初始密码123456，需要进行md5加密
        teacher.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));


        teacher.setTeacherId(idGenerator.nextId());
        teacher.setStatus(1);
        teacherDao.insert(teacher);
        return Return.success("新增教师成功");
    }

    @Override
    public Return<Page<Teacher>> queryList(Page<Teacher> page, String teacherName) {
        List<Teacher> teacherList = teacherDao.queryTeacherList((page.getCurrent() - 1) * page.getSize(), page.getSize(), teacherName);
        page.setRecords(teacherList);
        return Return.success(page);
    }

    @Override
    public long count() {
        return teacherDao.count();
    }

    @Override
    public int update(Teacher teacher) {

        return teacherDao.update(teacher);
    }

    @Override
    public Teacher queryTeacherById(Long teacherId) {

        return teacherDao.queryTeacherById(teacherId);
    }

}
