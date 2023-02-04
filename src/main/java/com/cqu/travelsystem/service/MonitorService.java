package com.cqu.travelsystem.service;

import com.cqu.travelsystem.entity.Monitor;
import com.cqu.travelsystem.Vo.MoniScenVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Monitor)表服务接口
 *
 * @author makejava
 * @since 2022-06-25 09:43:35
 */
public interface MonitorService {

    /**
     * 通过ID查询单条数据
     *
     * @param monitorId 主键
     * @return 实例对象
     */
    Monitor queryById(Long monitorId);

    /**
     * 分页查询
     *
     * @param monitor 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Monitor> queryByPage(Monitor monitor, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param monitor 实例对象
     * @return 实例对象
     */
    Monitor insert(Monitor monitor);

    /**
     * 修改数据
     *
     * @param monitor 实例对象
     * @return 实例对象
     */
    Monitor update(Monitor monitor);

    /**
     * 通过主键删除数据
     *
     * @param monitorId 主键
     * @return 是否成功
     */
    boolean deleteById(Long monitorId);

    /**
     * 工作人员根据景区获取所有监控
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
