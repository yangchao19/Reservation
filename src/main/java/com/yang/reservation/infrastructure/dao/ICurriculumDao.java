package com.yang.reservation.infrastructure.dao;

import com.yang.reservation.infrastructure.po.Curriculum;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author：杨超
 * @date: 2023/5/22
 * @Copyright：
 */
@Mapper
public interface ICurriculumDao {

    /**
     * 插入课程
     * @param curriculum 课程信息
     */
    void insertCurriculum (Curriculum curriculum);

    /**
     * 根据截至时间查询课程列表
     * @param end 截止时间
     * @return 符合要求的课程列表
     */
    List<Curriculum> queryList (Date end);

    /**
     * 根据课程id查询课程
     * @param curriculumId 课程id
     * @return
     */
    Curriculum queryCurriculumById (Long curriculumId);

    /**
     * 删除过期课程
     */
    void deleteCurriculum ();

    /**
     * 更新课程信息
     * @param curriculum 课程信息
     */
    void updateCurriculum (Curriculum curriculum);

    /**
     * 根据预约课程id，增加预约人数
     * @param curriculumId 预约课程id
     * @return 扣减结果
     */
    int subtractionCurriculumStock(Long curriculumId);
}
