package com.cqu.travelsystem.controller;

import com.cqu.travelsystem.entity.ComplaintEvent;
import com.cqu.travelsystem.service.ComplaintEventService;
import com.cqu.travelsystem.utils.DateUtil;
import com.cqu.travelsystem.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ComplaintEvent)表控制层
 *
 * @author makejava
 * @since 2022-06-25 09:42:32
 */
@RestController
@RequestMapping("complaintEvent")
public class ComplaintEventController {
    /**
     * 服务对象
     */
    @Resource
    private ComplaintEventService complaintEventService;

    /**
     * 分页查询
     *
     * @param complaintEvent 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<ComplaintEvent>> queryByPage(ComplaintEvent complaintEvent, PageRequest pageRequest) {
        return ResponseEntity.ok(this.complaintEventService.queryByPage(complaintEvent, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<ComplaintEvent> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.complaintEventService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param complaintEvent 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<ComplaintEvent> add(ComplaintEvent complaintEvent) {
        return ResponseEntity.ok(this.complaintEventService.insert(complaintEvent));
    }

    /**
     * 编辑数据
     *
     * @param complaintEvent 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<ComplaintEvent> edit(ComplaintEvent complaintEvent) {
        return ResponseEntity.ok(this.complaintEventService.update(complaintEvent));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.complaintEventService.deleteById(id));
    }

    /**
     * 返回所有投诉列表
     * @return
     */
    @GetMapping("showAllComEvent")
    public DataResult showAllComEvent(){
        return DataResult.successByDataArray(this.complaintEventService.showAllComEvent());
    }

    /**
     * 获取投诉详情
     * @param complaintEvent
     * @return
     */
    @PostMapping("checkComEvent")
    public DataResult checkComEvent(@RequestBody ComplaintEvent complaintEvent){
        return DataResult.successByData(this.complaintEventService.checkComEvent(complaintEvent.getComplaintId()));
    }

    /**
     * 提交投诉处理方案
     * @param complaintEvent
     * @return
     */
    @PostMapping("solveComEvent")
    public DataResult solveComEvent(@RequestBody ComplaintEvent complaintEvent){
        complaintEvent.setComplaintEndtime(DateUtil.getNow());
        complaintEvent.setComplaintStatus("2");
        //System.out.println(complaintEvent.getComplaintId());
        System.out.println(complaintEvent.toString());
        return DataResult.successByData(this.complaintEventService.solveComEvent(complaintEvent));
    }

    /**
     * 获取游客投诉列表
     * @param complaintEvent
     * @return
     */
    @PostMapping("showVisComEvent")
    public DataResult showVisComEvent(@RequestBody ComplaintEvent complaintEvent){
        return DataResult.successByDataArray(this.complaintEventService.showVisComEvent(complaintEvent.getTuserId()));
    }

    /**
     * 新建投诉
     * @param complaintEvent
     * @return
     */
    @PostMapping("createComEvent")
    public DataResult createComEvent(@RequestBody ComplaintEvent complaintEvent){
        //Date date = new Date(System.currentTimeMillis());
        complaintEvent.setComplaintBegintime(DateUtil.getStringDate());
        complaintEvent.setComplaintStatus("0");
        //System.out.println(complaintEvent.getComplaintId());
        System.out.println(complaintEvent.toString());
        return DataResult.successByData(this.complaintEventService.createComEvent(complaintEvent));
    }
}

