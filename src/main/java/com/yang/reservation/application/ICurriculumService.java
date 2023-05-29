package com.yang.reservation.application;

import com.yang.reservation.common.Page;
import com.yang.reservation.infrastructure.po.Curriculum;

import java.util.List;

/**
 * @description:
 * @author：杨超
 * @date: 2023/5/28
 * @Copyright：
 */
public interface ICurriculumService {

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @param curriculumName
     * @return
     */
    Page<Curriculum> queryList(long page, long pageSize, String curriculumName);

    /**
     * 根据id查询课程信息
     * @param id
     * @return
     */
    Curriculum queryById(long id);

    /**
     * 更新课程信息
     * @param curriculum
     * @return
     */
    int update(Curriculum curriculum);

    /**
     * 新增颏课程信息
     * @param curriculum
     */
    void add(Curriculum curriculum);
}
