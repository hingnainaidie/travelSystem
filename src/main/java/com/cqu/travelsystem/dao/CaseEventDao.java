package com.cqu.travelsystem.dao;

import com.cqu.travelsystem.entity.CaseEvent;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (CaseEvent)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-25 09:42:16
 */
public interface CaseEventDao {

    /**
     * 通过ID查询单条数据
     *
     * @param caseId 主键
     * @return 实例对象
     */
    CaseEvent queryById(Long caseId);

    /**
     * 查询指定行数据
     *
     * @param caseEvent 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<CaseEvent> queryAllByLimit(CaseEvent caseEvent, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param caseEvent 查询条件
     * @return 总行数
     */
    long count(CaseEvent caseEvent);

    /**
     * 新增数据
     *
     * @param caseEvent 实例对象
     * @return 影响行数
     */
    int insert(CaseEvent caseEvent);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CaseEvent> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CaseEvent> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CaseEvent> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<CaseEvent> entities);

    /**
     * 修改数据
     *
     * @param caseEvent 实例对象
     * @return 影响行数
     */
    int update(CaseEvent caseEvent);

    /**
     * 通过主键删除数据
     *
     * @param caseId 主键
     * @return 影响行数
     */
    int deleteById(Long caseId);

    /**
     * 查询全部案件列表
     * @return
     */
    List<CaseEvent> quaryAllCaseEvent();

    /**
     * 查询一个案件的详细信息
     * @param caseId
     * @return
     */
    CaseEvent queryCaseById(Long caseId);

    /**
     * 查询游客的案件列表
     * @return
     */
    List<CaseEvent> quaryVisCaseEvent(Long tuserId);

    /**
     * 提交案件处理结果
     * @param caseEvent
     * @return
     */
    int updateCaseById(CaseEvent caseEvent);

    /**
     * 新建报案
     * @param caseEvent
     * @return
     */
    int insertCase(CaseEvent caseEvent);
}

