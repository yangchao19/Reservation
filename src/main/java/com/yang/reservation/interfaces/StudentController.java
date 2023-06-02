package com.yang.reservation.interfaces;

import com.yang.reservation.application.IStudentService;
import com.yang.reservation.common.Page;
import com.yang.reservation.common.Return;
import com.yang.reservation.infrastructure.dao.IStudentDao;
import com.yang.reservation.infrastructure.po.Student;
import com.yang.reservation.infrastructure.po.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @description:
 * @author：杨超
 * @date: 2023/5/25
 * @Copyright：
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    private Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Resource
    private IStudentService studentService;

    @GetMapping("/page")
    public Return<Page<Student>> queryList (long page, long pageSize, String studentName) {

        logger.info("page:{}, pageSize:{}, name:{}",page, pageSize, studentName);
        Page<Student> studentPage = new Page<>();
        studentPage.setCurrent(page);
        studentPage.setSize(pageSize);
        long count = studentService.count();
        studentPage.setTotal(count);
        return studentService.queryList(studentPage,studentName);
    }

    @GetMapping("/{studentId}")
    public Return<Student> queryStudentById (@PathVariable long studentId) {
        Student student = studentService.queryStudentById(studentId);
        if (null != student) {
            return Return.success(student);
        }else {
            return Return.error("查询消息失败");
        }
    }

    @PutMapping
    public Return<String> update(@RequestBody Student student) {
        int update = studentService.update(student);
        if (update != 0) {
            return Return.success("更新成功");
        }else {
            return Return.error("更新失败");
        }
    }

    @PostMapping
    public Return<String> add (@RequestBody Student student) {
        studentService.add(student);
        return Return.success("新增成功");
    }

    /**
     * 发送手机验证码，并验证
     * @param student
     * @return
     */
    @PostMapping("/sendMsg")
    public Return<String> sendMsg (HttpSession session, @RequestBody Student student) throws Exception {
        logger.info("student:{}",student);
        String phone = student.getPhone();
        if (null !=phone) {
            String code = studentService.sendMsg(phone);
            session.setAttribute(phone,code);
            logger.info("phone:{},code:{}",phone,code);
            return Return.success("发送验证码成功");
        }
        return Return.error("出错啦");
    }
}
