package com.yang.reservation.domain.student.service;

import com.yang.reservation.application.IStudentService;
import com.yang.reservation.common.Page;
import com.yang.reservation.common.Return;
import com.yang.reservation.infrastructure.dao.IStudentDao;
import com.yang.reservation.infrastructure.po.Student;
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
public class StudentServiceImpl implements IStudentService {

    @Resource
    private IStudentDao studentDao;

    @Override
    public int count() {
        return studentDao.count();
    }

    @Override
    public Return<Page<Student>> queryList(Page<Student> page, String studentName) {

        int count = studentDao.count();
        page.setTotal(count);

        long current = page.getCurrent();
        long size = page.getSize();
        List<Student> studentList = studentDao.queryList((current - 1) * size, size, studentName);

        page.setRecords(studentList);
        return Return.success(page);
    }

    @Override
    public Student queryStudentById(long id) {
        return studentDao.queryByStudentId(id);
    }

    @Override
    public int update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public void add(Student student) {
        studentDao.insert(student);
    }
}
