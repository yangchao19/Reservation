package com.yang.reservation.dao;

import com.yang.reservation.infrastructure.dao.IStudentDao;
import com.yang.reservation.infrastructure.po.Student;
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
 * @date: 2023/5/23
 * @Copyright：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDaoTest {

    private Logger logger = LoggerFactory.getLogger(StudentDaoTest.class);

    @Resource
    IStudentDao studentDao;

    @Test
    public void test_insert () {
        Student student = new Student();
        student.setStudentId(20230523001L);
        student.setStudentName("杨超");
        student.setParentName("wen");
        student.setPhone("123456789011");
        student.setGrade("二年级");
        studentDao.insert(student);
    }

    @Test
    public void test_update () {
        Student student = new Student();
        student.setStudentId(20230523001L);
        student.setStudentName("杨超");
        student.setParentName("wen");
        student.setPhone("19857295829");
        student.setGrade("三年级");
        studentDao.update(student);
    }

    @Test
    public void test_queryByStudentId () {
        Student student = studentDao.queryByStudentId(20230523001L);
        logger.info("student:{}",student);
    }
//
//    @Test
//    public void test_queryList () {
//        List<Student> students = studentDao.queryList();
//        for (Student student : students) {
//            logger.info("student:{}", student);
//        }
//    }
}
