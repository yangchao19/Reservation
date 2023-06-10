package com.yang.reservation.interfaces;

import com.yang.reservation.application.IStudentService;
import com.yang.reservation.common.Page;
import com.yang.reservation.common.Return;
import com.yang.reservation.infrastructure.dao.IStudentDao;
import com.yang.reservation.infrastructure.po.Student;
import com.yang.reservation.infrastructure.po.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

    @Autowired
    private RedisTemplate redisTemplate;

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
            //实际发送验证码
            //String code = studentService.sendMsg(phone);

            //测试使用
            String code = "1234";

            //1.将用户手机号和验证码存入session中
            //session.setAttribute(phone,code);

            //2.将用户的手机号和验证码存入redis中，并设置有效期五分钟
            redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);


            logger.info("phone:{},code:{}",phone,code);
            return Return.success("发送验证码成功");
        }
        return Return.error("出错啦");
    }

    @PostMapping("/login")
    public Return<Student> login (@RequestBody Map map,HttpSession session) {
        String phone = map.get("phone").toString();
        String code = map.get("code").toString();

        //1. 获取session中发送给用户的验证码
        //Object codeInSession = session.getAttribute(phone);

        //1.1 从redis中获取缓存的验证码
        Object codeInSession = redisTemplate.opsForValue().get(phone);


        logger.info("登录信息 phone:{},code:{},codeInSession:{}",phone,code,codeInSession);


        //2. 检验验证码是否与发送的验证匹配
        if (null != codeInSession && codeInSession.equals(code)) {
            Student student = studentService.checkAndInit(phone);

            //将用户id存入session中，标识用户已登录
            session.setAttribute("student",student.getStudentId());
            logger.info("登录成功studentId:{}",student.getStudentId());

            //登陆成功后将redis中的验证码删除
            redisTemplate.delete(phone);
            return Return.success(student);
        }
        return Return.error("验证码错误");
    }
}
