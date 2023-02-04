package com.cqu.travelsystem.service;

import com.cqu.travelsystem.entity.ComplaintEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (ComplaintEvent)表服务接口
 *
 * @author makejava
 * @since 2022-06-25 09:42:32
 */
public interface ComplaintEventService {

    /**
     * 通过ID查询单条数据
     *
     * @param complaintId 主键
     * @return 实例对象
     */
    ComplaintEvent queryById(Long complaintId);

    /**
     * 分页查询
     *
     * @param complaintEvent 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<ComplaintEvent> queryByPage(ComplaintEvent complaintEvent, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param complaintEvent 实例对象
     * @return 实例对象
     */
    ComplaintEvent insert(ComplaintEvent complaintEvent);

    /**
     * 修改数据
     *
     * @param complaintEvent 实例对象
     * @return 实例对象
     */
    ComplaintEvent update(ComplaintEvent complaintEvent);

    /**
     * 通过主键删除数据
     *
     * @param complaintId 主键
     * @return 是否成功
     */
    boolean deleteById(Long complaintId);

    /**
     * 返回所有投诉列表
     */
    List<ComplaintEvent> showAllComEvent();

    /**
     * 返回投诉详情
     * @param complaintId
     * @return
     */
    ComplaintEvent checkComEvent(Long complaintId);

    /**
     * 提交投诉处理方案
     * @param complaintEvent
     * @return
     */
    ComplaintEvent solveComEvent(ComplaintEvent complaintEvent);

    /**
     * 获取游客投诉列表
     * @param tuserId
     * @return
     */
    List<ComplaintEvent> showVisComEvent(Long tuserId);

    /**
     * 新建投诉
     * @param complaintEvent
     * @return
     */
    ComplaintEvent createComEvent(ComplaintEvent complaintEvent);
}
