package com.cqu.travelsystem.dao;

import com.cqu.travelsystem.entity.Monitor;
import com.cqu.travelsystem.Vo.MoniScenVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Monitor)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-25 09:43:35
 */
public interface MonitorDao {

    /**
     * 通过ID查询单条数据
     *
     * @param monitorId 主键
     * @return 实例对象
     */
    Monitor queryById(Long monitorId);

    /**
     * 查询指定行数据
     *
     * @param monitor 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Monitor> queryAllByLimit(Monitor monitor, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param monitor 查询条件
     * @return 总行数
     */
    long count(Monitor monitor);

    /**
     * 新增数据
     *
     * @param monitor 实例对象
     * @return 影响行数
     */
    int insert(Monitor monitor);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Monitor> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Monitor> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Monitor> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Monitor> entities);

    /**
     * 修改数据
     *
     * @param monitor 实例对象
     * @return 影响行数
     */
    int update(Monitor monitor);

    /**
     * 通过主键删除数据
     *
     * @param monitorId 主键
     * @return 影响行数
     */
    int deleteById(Long monitorId);

    /**
     * 工作人员根据景区获取所有监控信息
     * @param monitor
     * @return
     */
    List<Monitor> getAllMonitorByScenic(Monitor monitor);

    /**
     * 工作人员根据景区根据时间查监控
     * @param monitor
     * @return
     */
    List<Monitor> getMonitorByDate(Monitor monitor);

    /**
     * 查询所有监控
     * @param monitor
     * @return
     */
    List<MoniScenVo> getAllMonitor();

    /**
     * 根据日期查询所有监控
     * @param monitor
     * @return
     */
    List<MoniScenVo> getAllMonitorByDate(Monitor monitor);

    /**
     * 景区名称查询所有监控
     * @param monitor
     * @return
     */
    List<MoniScenVo> getMonitorByName(MoniScenVo moniScenVo);
}

