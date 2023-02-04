package com.cqu.travelsystem.service.impl;

import com.cqu.travelsystem.entity.Monitor;
import com.cqu.travelsystem.dao.MonitorDao;
import com.cqu.travelsystem.service.MonitorService;
import com.cqu.travelsystem.Vo.MoniScenVo;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Monitor)表服务实现类
 *
 * @author makejava
 * @since 2022-06-25 09:43:35
 */
@Service("monitorService")
@Transactional
public class MonitorServiceImpl implements MonitorService {
    @Resource
    private MonitorDao monitorDao;

    /**
     * 通过ID查询单条数据
     *
     * @param monitorId 主键
     * @return 实例对象
     */
    @Override
    public Monitor queryById(Long monitorId) {
        return this.monitorDao.queryById(monitorId);
    }

    /**
     * 分页查询
     *
     * @param monitor 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Monitor> queryByPage(Monitor monitor, PageRequest pageRequest) {
        long total = this.monitorDao.count(monitor);
        return new PageImpl<>(this.monitorDao.queryAllByLimit(monitor, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param monitor 实例对象
     * @return 实例对象
     */
    @Override
    public Monitor insert(Monitor monitor) {
        this.monitorDao.insert(monitor);
        return monitor;
    }

    /**
     * 修改数据
     *
     * @param monitor 实例对象
     * @return 实例对象
     */
    @Override
    public Monitor update(Monitor monitor) {
        this.monitorDao.update(monitor);
        return this.queryById(monitor.getMonitorId());
    }

    /**
     * 通过主键删除数据
     *
     * @param monitorId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long monitorId) {
        return this.monitorDao.deleteById(monitorId) > 0;
    }

    /**
     * 工作人员根据景区获取所有监控信息
     * @return
     */
    @Override
    public List<Monitor> getAllMonitorByScenic(Monitor monitor) {
        return this.monitorDao.getAllMonitorByScenic(monitor);
    }

    /**
     * 工作人员根据景区根据时间查监控
     * @param monitor
     * @return
     */
    @Override
    public List<Monitor> getMonitorByDate(Monitor monitor) {
        return this.monitorDao.getMonitorByDate(monitor);
    }

    /**
     * 查询所有监控
     * @param monitor
     * @return
     */
    @Override
    public List<MoniScenVo> getAllMonitor() {
        return this.monitorDao.getAllMonitor();
    }

    /**
     * 根据日期查询所有监控
     * @param monitor
     * @return
     */
    @Override
    public List<MoniScenVo> getAllMonitorByDate(Monitor monitor) {
        return this.monitorDao.getAllMonitorByDate(monitor);
    }

    /**
     *景区名称查询所有监控
     * @param monitor
     * @return
     */
    @Override
    public List<MoniScenVo> getMonitorByName(MoniScenVo moniScenVo) {
        return this.monitorDao.getMonitorByName(moniScenVo);
    }
}
