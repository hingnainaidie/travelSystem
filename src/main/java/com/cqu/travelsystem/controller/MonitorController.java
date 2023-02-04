package com.cqu.travelsystem.controller;

import com.cqu.travelsystem.entity.Monitor;
import com.cqu.travelsystem.service.MonitorService;
import com.cqu.travelsystem.utils.result.DataResult;
import com.cqu.travelsystem.Vo.MoniScenVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Monitor)表控制层
 *
 * @author makejava
 * @since 2022-06-25 09:43:35
 */
@RestController
@RequestMapping("monitor")
public class MonitorController {
    /**
     * 服务对象
     */
    @Resource
    private MonitorService monitorService;

    /**
     * 分页查询
     *
     * @param monitor 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Monitor>> queryByPage(Monitor monitor, PageRequest pageRequest) {
        return ResponseEntity.ok(this.monitorService.queryByPage(monitor, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Monitor> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.monitorService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param monitor 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Monitor> add(Monitor monitor) {
        return ResponseEntity.ok(this.monitorService.insert(monitor));
    }

    /**
     * 编辑数据
     *
     * @param monitor 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Monitor> edit(Monitor monitor) {
        return ResponseEntity.ok(this.monitorService.update(monitor));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.monitorService.deleteById(id));
    }


    /**
     * 工作人员根据景区获取所有监控
     */
    @PostMapping("getAllMonitorByScenic")
    public DataResult getAllMonitorByScenic(@RequestBody Monitor monitor) {
        List<Monitor> monitorList = this.monitorService.getAllMonitorByScenic(monitor);
        return DataResult.successByDataArray(this.monitorService.getAllMonitorByScenic(monitor));
    }

    /**
     * 工作人员根据景区根据时间查监控
     * @param monitor
     * @return
     */
    @PostMapping("getMonitorByDate")
    public DataResult getMonitorByDate(@RequestBody Monitor monitor)
    {
        System.out.println(monitor.toString());
        return DataResult.successByDataArray(this.monitorService.getMonitorByDate(monitor));
    }

    /**
     * 查询所有监控
     */
    @GetMapping("getAllMonitor")
    public DataResult getAllMonitor(){
        return DataResult.successByDataArray(this.monitorService.getAllMonitor());
    }

    /**
     * 根据日期查询所有监控
     */
    @PostMapping("getAllMonitorByDate")
    public DataResult getAllMonitorByDate(@RequestBody Monitor monitor){
        return DataResult.successByDataArray(this.monitorService.getAllMonitorByDate(monitor));
    }

    /**
     * 景区名称查询所有监控
     */
    @PostMapping("getMonitorByName")
    public DataResult getMonitorByName(@RequestBody MoniScenVo moniScenVo){
        return DataResult.successByDataArray(this.monitorService.getMonitorByName(moniScenVo));
    }

}

