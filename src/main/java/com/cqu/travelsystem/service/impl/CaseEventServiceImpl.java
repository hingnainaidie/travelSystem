package com.cqu.travelsystem.service.impl;

import com.cqu.travelsystem.entity.CaseEvent;
import com.cqu.travelsystem.dao.CaseEventDao;
import com.cqu.travelsystem.service.CaseEventService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CaseEvent)表服务实现类
 *
 * @author makejava
 * @since 2022-06-25 09:42:18
 */
@Service("caseEventService")
@Transactional
public class CaseEventServiceImpl implements CaseEventService {
    @Resource
    private CaseEventDao caseEventDao;

    /**
     * 通过ID查询单条数据
     *
     * @param caseId 主键
     * @return 实例对象
     */
    @Override
    public CaseEvent queryById(Long caseId) {
        return this.caseEventDao.queryById(caseId);
    }

    /**
     * 分页查询
     *
     * @param caseEvent 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<CaseEvent> queryByPage(CaseEvent caseEvent, PageRequest pageRequest) {
        long total = this.caseEventDao.count(caseEvent);
        return new PageImpl<>(this.caseEventDao.queryAllByLimit(caseEvent, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param caseEvent 实例对象
     * @return 实例对象
     */
    @Override
    public CaseEvent insert(CaseEvent caseEvent) {
        this.caseEventDao.insert(caseEvent);
        return caseEvent;
    }

    /**
     * 修改数据
     *
     * @param caseEvent 实例对象
     * @return 实例对象
     */
    @Override
    public CaseEvent update(CaseEvent caseEvent) {
        this.caseEventDao.update(caseEvent);
        return this.queryById(caseEvent.getCaseId());
    }

    /**
     * 通过主键删除数据
     *
     * @param caseId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long caseId) {
        return this.caseEventDao.deleteById(caseId) > 0;
    }

    /**
     * 返回所有案件列表
     * @return
     */
    @Override
    public List<CaseEvent> showAllCaseEvent(){
        return this.caseEventDao.quaryAllCaseEvent();
    }

    /**
     * 查看案件详情
     * @param caseId
     * @return
     */
    @Override
    public CaseEvent checkCaEvent(Long caseId){
        return this.caseEventDao.queryCaseById(caseId);
    }

    @Override
    public CaseEvent solveCaEvent(CaseEvent caseEvent){
        this.caseEventDao.updateCaseById(caseEvent);
        return this.queryById(caseEvent.getCaseId());
    }
    /**
     * 查看游客案件列表
     * @param tuserId
     * @return
     */
    @Override
    public List<CaseEvent> showVisCaseEvent(Long tuserId) {
        return this.caseEventDao.quaryVisCaseEvent(tuserId);
    }
    /**
     * 新建报案
     * @param caseEvent
     * @return
     */
    @Override
    public CaseEvent createCaEvent(CaseEvent caseEvent){
        this.caseEventDao.insertCase(caseEvent);
        return this.queryById(caseEvent.getCaseId());
    }
}
