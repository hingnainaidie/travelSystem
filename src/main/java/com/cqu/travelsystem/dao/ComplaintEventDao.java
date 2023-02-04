package com.cqu.travelsystem.dao;

import com.cqu.travelsystem.entity.ComplaintEvent;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (ComplaintEvent)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-25 09:42:32
 */
public interface ComplaintEventDao {

    /**
     * 通过ID查询单条数据
     *
     * @param complaintId 主键
     * @return 实例对象
     */
    ComplaintEvent queryById(Long complaintId);

    /**
     * 查询指定行数据
     *
     * @param complaintEvent 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<ComplaintEvent> queryAllByLimit(ComplaintEvent complaintEvent, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param complaintEvent 查询条件
     * @return 总行数
     */
    long count(ComplaintEvent complaintEvent);

    /**
     * 新增数据
     *
     * @param complaintEvent 实例对象
     * @return 影响行数
     */
    int insert(ComplaintEvent complaintEvent);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ComplaintEvent> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ComplaintEvent> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ComplaintEvent> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ComplaintEvent> entities);

    /**
     * 修改数据
     *
     * @param complaintEvent 实例对象
     * @return 影响行数
     */
    int update(ComplaintEvent complaintEvent);

    /**
     * 通过主键删除数据
     *
     * @param complaintId 主键
     * @return 影响行数
     */
    int deleteById(Long complaintId);

    /**
     * 查询所有投诉事件
     * @return
     */
    List<ComplaintEvent> quaryAllComEvent();

    /**
     * 查询投诉详情
     * @param complaintId
     * @return
     */
    ComplaintEvent queryComplaintById(Long complaintId);

    /**
     * 提交投诉处理方法
     * @param complaintEvent
     * @return
     */
    int updateComplaintById(ComplaintEvent complaintEvent);

    /**
     *游客投诉列表
     * @param tuserId
     * @return
     */
    List<ComplaintEvent> queryTComplaintById(Long tuserId);

    /**
     * 新建投诉
     * @param complaintEvent
     * @return
     */
    int insertComplaint(ComplaintEvent complaintEvent);
}

