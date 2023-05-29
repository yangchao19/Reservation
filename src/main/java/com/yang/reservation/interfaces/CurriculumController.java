package com.yang.reservation.interfaces;

import com.yang.reservation.application.ICurriculumService;
import com.yang.reservation.common.Page;
import com.yang.reservation.common.Return;
import com.yang.reservation.infrastructure.po.Curriculum;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.attribute.UserPrincipalLookupService;

/**
 * @description:
 * @author：杨超
 * @date: 2023/5/28
 * @Copyright：
 */
@RestController
@RequestMapping("/curriculum")
public class CurriculumController {

    @Resource
    private ICurriculumService curriculumService;

//    function getCurriculumList (params) {
//        return $axios({
//                url: '/curriculum/page',
//                method: 'get',
//                params
//    })
//    }

    /**
     * 根据当前页数，和页大小，以及查询的名字（可能为空） 查询列表
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public Return<Page<Curriculum>> queryList (long page, long pageSize, String name) {
        Page<Curriculum> curriculumPage = curriculumService.queryList(page, pageSize, name);
        if (null != curriculumPage) {
            return Return.success(curriculumPage);
        }else {
            return Return.error("查询失败");
        }

    }

//
//    function queryCurriculumById (id) {
//        return $axios({
//                url: `/curriculum/${id}`,
//        method: 'get',
//    })
//    }
//

    /**
     * 根据id查询课程信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Return<Curriculum> queryCurriculumById (@PathVariable long id) {
        Curriculum curriculum = curriculumService.queryById(id);
        if (null != curriculum) {
            return Return.success(curriculum);
        }else {
            return Return.error("未查到此课程");
        }
    }

//    function editCurriculum (params) {
//        return $axios({
//                url: '/curriculum',
//                method: 'put',
//                data: { ...params }
//    })
//    }

    @PutMapping
    public Return<String> update (@RequestBody Curriculum curriculum) {

        int update = curriculumService.update(curriculum);
        if (update != 0) {
            return Return.success("更新成功");
        }else {
            return  Return.error("更新失败");
        }
    }

//
//    function addCurriculum (params) {
//        return $axios({
//                url: '/curriculum',
//                method: 'post',
//                data: { ...params }
//    })
//    }

    /**
     * 新增课程
     * @param curriculum
     * @return
     */
    @PostMapping
    public Return<String> add (HttpServletRequest request, @RequestBody Curriculum curriculum) {
        long teacherId = (long)request.getSession().getAttribute("teacher");
        curriculum.setTeacherId(teacherId);
        return Return.success("新增成功");
    }
}
