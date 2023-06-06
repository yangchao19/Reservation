package com.yang.reservation.domain.curriculum.service;

import com.yang.reservation.application.ICurriculumService;
import com.yang.reservation.common.Page;
import com.yang.reservation.common.Subject;
import com.yang.reservation.domain.curriculum.model.SubjectVO;
import com.yang.reservation.domain.support.id.IIdGenerator;
import com.yang.reservation.infrastructure.dao.ICurriculumDao;
import com.yang.reservation.infrastructure.dao.ITeacherDao;
import com.yang.reservation.infrastructure.po.Curriculum;
import com.yang.reservation.infrastructure.po.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author：杨超
 * @date: 2023/5/28
 * @Copyright：
 */
@Service
public class CurriculumServiceImpl implements ICurriculumService {

    private Logger logger = LoggerFactory.getLogger(CurriculumServiceImpl.class);

    @Resource
    private ICurriculumDao curriculumDao;

    @Resource
    private ITeacherDao teacherDao;

    @Resource(name = "shortcode")
    private IIdGenerator iIdGenerator;

    @Override
    public Page<Curriculum> queryList(long page, long pageSize, String curriculumName) {

        Page<Curriculum> curriculumPage = new Page<>();
        List<Curriculum> list = curriculumDao.queryList((page - 1) * pageSize, pageSize, curriculumName);
        int count = curriculumDao.count();

        curriculumPage.setRecords(list);
        curriculumPage.setTotal(count);
        curriculumPage.setCurrent(page);
        curriculumPage.setSize(pageSize);

        return curriculumPage;
    }

    @Override
    public Curriculum queryById(long id) {
        Curriculum curriculum = curriculumDao.queryCurriculumById(id);
        return curriculum;
    }

    @Override
    public int update(Curriculum curriculum) {

        //1.检验教师信息是否修改
        Teacher teacher = teacherDao.queryTeacherById(curriculum.getTeacherId());

        logger.info("teacher:{} , curriculum:{}",teacher,curriculum);

        if (!teacher.getTeacherName().equals(curriculum.getTeacherName())) {
            logger.info("原教师名：{}，新教师名：{}",teacher.getTeacherName(),curriculum.getTeacherName());
            Teacher teacher1 = teacherDao.queryByUsername(teacher.getTeacherName());
            curriculum.setTeacherId(teacher1.getTeacherId());
        }
        //2.更新课程信息

        int i = curriculumDao.updateCurriculum(curriculum);

        return i;
    }

    @Override
    public void add(Curriculum curriculum) {
        //1.查询教师信息
        Teacher teacher = teacherDao.queryTeacherById(curriculum.getTeacherId());
        curriculum.setTeacherName(teacher.getTeacherName());
        logger.info("查询教师信息");

        //2.设置课程id
        curriculum.setCurriculumId(iIdGenerator.nextId());

        //3.新增课程信息
        curriculumDao.insertCurriculum(curriculum);
        logger.info("新增课程信息");
    }

    @Override
    public List<SubjectVO> querySubject() {
        List<Integer> integerList = curriculumDao.querySubjectList();
        ArrayList<SubjectVO> subjectList = new ArrayList<>();

        if (null == integerList) {
            return null;
        }

        for (Integer i : integerList) {
            SubjectVO subjectVO = new SubjectVO();
            subjectVO.setId(i);
            subjectVO.setName(Subject.getSubject(i));
            subjectList.add(subjectVO);
        }
        return subjectList;
    }

    @Override
    public List<Curriculum> queryListBySubject(int subject, int status) {
        return curriculumDao.queryListBySubject(subject,status);
    }
}
