package com.cqu.travelsystem.service.impl;

import com.cqu.travelsystem.entity.ComplaintEvent;
import com.cqu.travelsystem.dao.ComplaintEventDao;
import com.cqu.travelsystem.service.ComplaintEventService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ComplaintEvent)表服务实现类
 *
 * @author makejava
 * @since 2022-06-25 09:42:32
 */
@Service("complaintEventService")
@Transactional
public class ComplaintEventServiceImpl implements ComplaintEventService {
    @Resource
    private ComplaintEventDao complaintEventDao;

    /**
     * 通过ID查询单条数据
     *
     * @param complaintId 主键
     * @return 实例对象
     */
    @Override
    public ComplaintEvent queryById(Long complaintId) {
        return this.complaintEventDao.queryById(complaintId);
    }

    /**
     * 分页查询
     *
     * @param complaintEvent 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<ComplaintEvent> queryByPage(ComplaintEvent complaintEvent, PageRequest pageRequest) {
        long total = this.complaintEventDao.count(complaintEvent);
        return new PageImpl<>(this.complaintEventDao.queryAllByLimit(complaintEvent, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param complaintEvent 实例对象
     * @return 实例对象
     */
    @Override
    public ComplaintEvent insert(ComplaintEvent complaintEvent) {
        this.complaintEventDao.insert(complaintEvent);
        return complaintEvent;
    }

    /**
     * 修改数据
     *
     * @param complaintEvent 实例对象
     * @return 实例对象
     */
    @Override
    public ComplaintEvent update(ComplaintEvent complaintEvent) {
        this.complaintEventDao.update(complaintEvent);
        return this.queryById(complaintEvent.getComplaintId());
    }

    /**
     * 通过主键删除数据
     *
     * @param complaintId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long complaintId) {
        return this.complaintEventDao.deleteById(complaintId) > 0;
    }

    /**
     * 查看所有投诉列表
     * @return
     */
    @Override
    public List<ComplaintEvent> showAllComEvent(){
        return this.complaintEventDao.quaryAllComEvent();
    }

    /**
     * 查看投诉详情
     * @param complaintId
     * @return
     */
    @Override
    public ComplaintEvent checkComEvent(Long complaintId){
        return  this.complaintEventDao.queryComplaintById(complaintId);
    }

    /**
     * 提交处理方案
     * @param complaintEvent
     * @return
     */
    @Override
    public ComplaintEvent solveComEvent(ComplaintEvent complaintEvent){
        this.complaintEventDao.updateComplaintById(complaintEvent);
        return this.queryById(complaintEvent.getComplaintId());
    }

    /**
     * 获取游客的投诉列表
     * @param tuserId
     * @return
     */
    @Override
    public List<ComplaintEvent> showVisComEvent(Long tuserId){
        return  this.complaintEventDao.queryTComplaintById(tuserId);
    }

    /**
     * 新建投诉
     * @param complaintEvent
     * @return
     */
    @Override
    public ComplaintEvent createComEvent(ComplaintEvent complaintEvent){
        this.complaintEventDao.insertComplaint(complaintEvent);
        return this.queryById(complaintEvent.getComplaintId());
    }
}
