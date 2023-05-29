package com.yang.reservation.dao;

import com.yang.reservation.infrastructure.dao.ICurriculumDao;
import com.yang.reservation.infrastructure.po.Curriculum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author：杨超
 * @date: 2023/5/22
 * @Copyright：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class curriculumDaoTest {

    private Logger logger = LoggerFactory.getLogger(curriculumDaoTest.class);

    @Resource
    private ICurriculumDao curriculumDao;
//    void insertCurriculum (Curriculum curriculum);
    @Test
    public void test_insert() throws ParseException {
        Curriculum curriculum = new Curriculum();
        curriculum.setCurriculumId(100007L);
        curriculum.setCurriculumName("增加测试课程");
        curriculum.setTeacherId(100001L);
        curriculum.setStock(60);
        curriculum.setStockUsed(0);
        curriculum.setBeginTime(new Date());

        String dateString = "2023-05-30";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(dateString);

        curriculum.setEndTime(date);
        curriculum.setInfo("测试课程");
        curriculumDao.insertCurriculum(curriculum);
    }

//    List<Curriculum> queryList (Date end);

//    @Test
//    public void test_query() throws ParseException {
//        String dateString = "2023-06-30";
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = format.parse(dateString);
//        List<Curriculum> curriculumList = curriculumDao.queryList(date);
//        for (Curriculum curriculum : curriculumList) {
//            logger.info("课程信息：{}",curriculum);
//            System.out.println(curriculum + "\n");
//        }
//    }

//    Curriculum queryCurriculumById (Long curriculumId);
    @Test
    public void test_query_id() {
        Curriculum curriculum = curriculumDao.queryCurriculumById(100006L);
        logger.info("课程信息：{}",curriculum);
    }
//    void deleteCurriculum ();
    @Test
    public void test_del() {
        curriculumDao.deleteCurriculum();
    }

//    void updateCurriculum (Curriculum curriculum);

    @Test
    public void test_update () throws ParseException {

        Curriculum curriculum = new Curriculum();
        curriculum.setCurriculumId(100007L);
        curriculum.setCurriculumName("更新测试课程");
        curriculum.setTeacherId(100001L);
        curriculum.setStock(60);
        curriculum.setStockUsed(6);
        curriculum.setBeginTime(new Date());

        String dateString = "2023-06-15";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(dateString);

        curriculum.setEndTime(date);
        curriculum.setInfo("测试课程");

        curriculumDao.updateCurriculum(curriculum);
    }
//    int subtractionCurriculumStock(Long curriculumId);

    @Test
    public void test_sub () {
        int i = curriculumDao.subtractionCurriculumStock(100007L);
        if (i != 0) {
            logger.info("预定成功");
        }
    }
}
