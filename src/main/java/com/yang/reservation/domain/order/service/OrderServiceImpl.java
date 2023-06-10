package com.yang.reservation.domain.order.service;

import com.yang.reservation.application.IOrderService;
import com.yang.reservation.common.Page;
import com.yang.reservation.domain.order.model.OrderVO;
import com.yang.reservation.domain.support.id.IIdGenerator;
import com.yang.reservation.infrastructure.dao.ICurriculumDao;
import com.yang.reservation.infrastructure.dao.IOrderDao;
import com.yang.reservation.infrastructure.dao.IStudentDao;
import com.yang.reservation.infrastructure.dao.ITeacherDao;
import com.yang.reservation.infrastructure.po.Curriculum;
import com.yang.reservation.infrastructure.po.Order;
import com.yang.reservation.infrastructure.po.Student;
import com.yang.reservation.infrastructure.po.Teacher;
import org.springframework.beans.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author：杨超
 * @date: 2023/5/30
 * @Copyright：
 */
@Service
public class OrderServiceImpl implements IOrderService {

    private Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Resource
    private IOrderDao orderDao;

    @Resource
    private IStudentDao studentDao;

    @Resource
    private ICurriculumDao curriculumDao;

    @Resource
    private ITeacherDao teacherDao;

    @Resource(name =  "snowflake")
    private IIdGenerator idGenerator;


    @Override
    public Page<OrderVO> queryList(long page, long pageSize, String orderId, Date beginTime, Date endTime) {


        //1. 检查orderId是否为空，并转化为long类型
        long orderIdNew = -1L;
        if (orderId != null) {
            orderIdNew = Long.parseLong(orderId);
        }
        //2. 查询订单信息，并转换类型
        List<Order> orderList = orderDao.queryList((page - 1) * pageSize, pageSize, orderIdNew, beginTime, endTime);
        ArrayList<OrderVO> orderVOList = new ArrayList<>();

        if (null != orderList) {
            for (Order order : orderList) {
                OrderVO orderVO = orderToVO(order);
                orderVOList.add(orderVO);
            }
        }else {
            return null;
        }

        //3. 查询订单总数
        int count = orderDao.count(orderIdNew, beginTime, endTime);


        Page<OrderVO> orderVOPage = new Page<>();
        orderVOPage.setCurrent(page);
        orderVOPage.setSize(pageSize);
        orderVOPage.setTotal(count);
        orderVOPage.setRecords(orderVOList);
        return orderVOPage;
    }

    @Override
    public Page<OrderVO> queryPageListByStudentId(long page, long pageSize, long studentId) {

        //2. 查询订单信息，并转换类型
        List<Order> orderList = orderDao.queryPageListByStudentId((page - 1) * pageSize, pageSize, studentId);

        ArrayList<OrderVO> orderVOList = new ArrayList<>();

        if (null != orderList) {
            for (Order order : orderList) {
                OrderVO orderVO = orderToVO(order);
                orderVOList.add(orderVO);
            }
        }
        //3. 查询订单总数
        int count = orderDao.countByStudentId(studentId);

        Page<OrderVO> orderVOPage = new Page<>();

        if (orderList == null) {
            orderVOPage.setCurrent(0);
        }else {
            orderVOPage.setCurrent(page);
        }

        orderVOPage.setSize(pageSize);
        orderVOPage.setTotal(count);
        orderVOPage.setRecords(orderVOList);
        return orderVOPage;
    }

    @Override
    public List<OrderVO> queryListByStudentId(long studentId) {

        List<Order> orderList = orderDao.queryListByStudentId(studentId);


        if (null != orderList) {
            ArrayList<OrderVO> orderVOList = new ArrayList<>();
            for (Order order : orderList) {
                OrderVO orderVO = orderToVO(order);
                orderVOList.add(orderVO);
            }
            return orderVOList;
        }
        return null;
    }

    @Override
    public boolean addOrder(long studentId, long curriculumId) {
        Curriculum curriculum = curriculumDao.queryCurriculumById(curriculumId);
        Order order = new Order();
        order.setOrderId(idGenerator.nextId());
        order.setStudentId(studentId);
        order.setCurriculumId(curriculumId);
        order.setTeacherId(curriculum.getTeacherId());
        orderDao.insert(order);

        // 扣减对应课程的库存
        int i = curriculumDao.decStock(curriculumId);

        return i != 0;
    }

    @Override
    public boolean quitOrder(long orderId) {
        int quit = orderDao.quit(orderId);
        Order order = orderDao.queryByOrderId(orderId);
        if (quit != 0) {
            //退换占用库存
            int i = curriculumDao.addStock(order.getCurriculumId());
            return i != 0;
        }else{
            return false;
        }
    }

    @Override
    public Order queryByCurriculumId(long studentId, long curriculumId) {
        return orderDao.queryByCurriculumId(studentId,curriculumId);
    }



    /**
     * 将order 转化为 orderVO 对象
     * @param order
     * @return
     */
    private OrderVO orderToVO(Order order) {
        OrderVO orderVO = new OrderVO();

        BeanUtils.copyProperties(order, orderVO);

        Student student = studentDao.queryByStudentId(orderVO.getStudentId());
        orderVO.setStudentName(student.getStudentName());
        orderVO.setPhone(student.getPhone());

        Curriculum curriculum = curriculumDao.queryCurriculumById(orderVO.getCurriculumId());
        orderVO.setCurriculumName(curriculum.getCurriculumName());

        Teacher teacher = teacherDao.queryTeacherById(orderVO.getTeacherId());
        orderVO.setTeacherName(teacher.getTeacherName());
        return orderVO;
    }
}
