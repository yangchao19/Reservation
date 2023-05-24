package com.yang.reservation.dao;

import com.alibaba.fastjson.JSON;
import com.yang.reservation.infrastructure.dao.ITeacherDao;
import com.yang.reservation.infrastructure.po.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author：杨超
 * @date: 2023/5/24
 * @Copyright：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherDaoTest {

    private Logger logger = LoggerFactory.getLogger(TeacherDaoTest.class);

    @Resource
    private ITeacherDao teacherDao;

    @Test
    public void test_insert () {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(202305220001L);
        teacher.setTeacherName("李晓红");
        teacher.setSubject("物理");
        teacher.setPhone("15670246029");
        teacher.setInfo("测试信息");
        teacherDao.insert(teacher);
    }

    @Test
    public void test_update () {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(202305220001L);
        teacher.setTeacherName("李晓红");
        teacher.setSubject("化学");
        teacher.setPhone("1234567891011");
        teacher.setInfo("更新测试信息");
        int update = teacherDao.update(teacher);
        if (update != 0) {
            logger.info("更新成功:{}", JSON.toJSONString(teacher));
        }
    }

    @Test
    public void test_queryList () {
        List<Teacher> teachers = teacherDao.queryTeacherList();
        for (Teacher teacher : teachers) {
            logger.info("教师信息：{}",JSON.toJSONString(teacher));
        }
    }

    @Test
    public void test_queryById () {
        Teacher teacher = teacherDao.queryTeacherById(202305220001L);
        logger.info("teacher:{}",JSON.toJSONString(teacher));
    }
}
