package com.yang.reservation.dao;

import com.alibaba.fastjson.JSON;
import com.yang.reservation.infrastructure.dao.IOrderDao;
import com.yang.reservation.infrastructure.po.Order;
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
public class OrderDaoTest {

    private Logger logger = LoggerFactory.getLogger(OrderDaoTest.class);

    @Resource
    private IOrderDao studentReserveCurriculumDao;

    @Test
    public void test_insert () {
        Order src = new Order();
        src.setStudentId(20230523001L);
        src.setCurriculumId(100007L);
        src.setTeacherId(100001L);
        studentReserveCurriculumDao.insert(src);
    }

    @Test
    public void test_queryById () {
        List<Order> src = studentReserveCurriculumDao.queryListByStudentId(20230523001L);
        logger.info("学生预约课程信息：{}", JSON.toJSONString(src));
    }

    @Test
    public void test_query () {
        Order src = new Order();
        src.setStudentId(20230523001L);
        src.setCurriculumId(100007L);
        Order query = studentReserveCurriculumDao.query(src);
        if (query != null) {
            logger.info("已经预约过该课程，不能重复预约");
        }else {
            logger.info("没有预约过该课程，可以预约");
        }
    }

    @Test
    public void test_deleteByCurriculumId () {
        studentReserveCurriculumDao.deleteByCurriculumId(100007L);
    }

    @Test
    public void test_deleteByStudentId () {
        studentReserveCurriculumDao.deleteByStudentId(20230523001L);
    }
}
