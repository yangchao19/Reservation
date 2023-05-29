package com.yang.reservation.domain.curriculum.service;

import com.yang.reservation.application.ICurriculumService;
import com.yang.reservation.common.Page;
import com.yang.reservation.infrastructure.dao.ICurriculumDao;
import com.yang.reservation.infrastructure.dao.ITeacherDao;
import com.yang.reservation.infrastructure.po.Curriculum;
import com.yang.reservation.infrastructure.po.Teacher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author：杨超
 * @date: 2023/5/28
 * @Copyright：
 */
@Service
public class CurriculumServiceImpl implements ICurriculumService {

    @Resource
    private ICurriculumDao curriculumDao;

    @Resource
    private ITeacherDao teacherDao;

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

        if (!teacher.getTeacherName().equals(curriculum.getTeacherName())) {
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
        //2.新增课程信息
        curriculumDao.insertCurriculum(curriculum);
    }
}
