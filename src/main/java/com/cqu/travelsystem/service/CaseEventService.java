package com.cqu.travelsystem.service;

import com.cqu.travelsystem.entity.CaseEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (CaseEvent)表服务接口
 *
 * @author makejava
 * @since 2022-06-25 09:42:18
 */
public interface CaseEventService {

    /**
     * 通过ID查询单条数据
     *
     * @param caseId 主键
     * @return 实例对象
     */
    CaseEvent queryById(Long caseId);

    /**
     * 分页查询
     *
     * @param caseEvent 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<CaseEvent> queryByPage(CaseEvent caseEvent, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param caseEvent 实例对象
     * @return 实例对象
     */
    CaseEvent insert(CaseEvent caseEvent);

    /**
     * 修改数据
     *
     * @param caseEvent 实例对象
     * @return 实例对象
     */
    CaseEvent update(CaseEvent caseEvent);

    /**
     * 通过主键删除数据
     *
     * @param caseId 主键
     * @return 是否成功
     */
    boolean deleteById(Long caseId);

    /**
     * 返回所有案件列表
     */
    List<CaseEvent> showAllCaseEvent();

    /**
     * 获取案件详情
     * @param caseId
     * @return
     */
    CaseEvent checkCaEvent(Long caseId);

    /**
     * 提交案件处理结果
     * @param caseEvent
     * @return
     */
    CaseEvent solveCaEvent(CaseEvent caseEvent);

    /**
     * 获取游客案件列表
     * @param tuserId
     * @return
     */
    List<CaseEvent> showVisCaseEvent(Long tuserId);

    /**
     * 新建报案
     * @param caseEvent
     * @return
     */
    CaseEvent createCaEvent(CaseEvent caseEvent);
}
