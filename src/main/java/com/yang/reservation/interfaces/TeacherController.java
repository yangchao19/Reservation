package com.yang.reservation.interfaces;

import com.yang.reservation.application.ITeacherService;
import com.yang.reservation.common.Page;
import com.yang.reservation.common.Return;
import com.yang.reservation.infrastructure.po.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author：杨超
 * @date: 2023/5/25
 * @Copyright：
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {


    private Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @Resource
    private ITeacherService teacherService;

    /**
     * 教师登录
     * @param request
     * @param teacher
     * @return
     */
    @PostMapping("/login")
    public Return<Teacher> login(HttpServletRequest request, @RequestBody Teacher teacher) {

        Return<Teacher> r = teacherService.loginCheck(teacher);

        //登陆成功，将员工id存入Session并返回登录成功结果
        if (r.getCode() != 0) {
            Teacher t = r.getData();
            request.getSession().setAttribute("teacher",t.getTeacherId());
        }

        return r;
    }

    /**
     * 教师退出
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public Return<String> logout(HttpServletRequest request) {
        //清理Session中保存的当前员工的id
        request.getSession().removeAttribute("teacher");
        return Return.success("退出成功");
    }

    /**
     * 新增教师
     * @param teacher
     * @return
     */
    @PostMapping
    public Return<String> save(HttpServletRequest request, @RequestBody Teacher teacher) {
        //获取当前用户的id
        Long teacherId = (Long) request.getSession().getAttribute("teacher");
        teacher.setCreatorId(teacherId);
        teacher.setUpdaterId(teacherId);
        logger.info("新增信息：{}",teacher);
        Return<String> r = teacherService.save(teacher);
        return r;
    }

    /**
     * 教师信息分页查询
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public Return<Page<Teacher>> queryList(long page, long pageSize, String name) {
        logger.info("page:{}, pageSize:{}, name:{}",page, pageSize, name);
        Page<Teacher> teacherPage = new Page<>();
        teacherPage.setCurrent(page);
        teacherPage.setSize(pageSize);
        long count = teacherService.count();
        teacherPage.setTotal(count);
        return teacherService.queryList(teacherPage, name);
    }

    /**
     * 根据教师id修改信息
     * @param teacher
     * @return
     */
    @PutMapping
    public Return<String> update(HttpServletRequest request,@RequestBody Teacher teacher) {
        logger.info(teacher.toString());
        Long updaterId = (Long) request.getSession().getAttribute("teacher");
        teacher.setUpdaterId(updaterId);
        int update = teacherService.update(teacher);
        if (update == 0) {
            return Return.error("更新失败");
        }else {
            return Return.success("更新成功");
        }
    }

    @GetMapping("/{teacherId}")
    public Return<Teacher> query(@PathVariable long teacherId) {

        Teacher teacher = teacherService.queryTeacherById(teacherId);

        if (null != teacher) {
            return Return.success(teacher);
        }else {
            return Return.error("没有该用户信息");
        }
    }
}
