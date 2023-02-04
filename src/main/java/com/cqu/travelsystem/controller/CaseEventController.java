package com.cqu.travelsystem.controller;

import com.cqu.travelsystem.entity.CaseEvent;
import com.cqu.travelsystem.service.CaseEventService;
import com.cqu.travelsystem.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * (CaseEvent)表控制层
 *
 * @author makejava
 * @since 2022-06-25 09:42:15
 */
@RestController
@RequestMapping("caseEvent")
public class CaseEventController {
    /**
     * 服务对象
     */
    @Resource
    private CaseEventService caseEventService;

    /**
     * 分页查询
     *
     * @param caseEvent 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<CaseEvent>> queryByPage(CaseEvent caseEvent, PageRequest pageRequest) {
        return ResponseEntity.ok(this.caseEventService.queryByPage(caseEvent, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<CaseEvent> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.caseEventService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param caseEvent 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<CaseEvent> add(CaseEvent caseEvent) {
        return ResponseEntity.ok(this.caseEventService.insert(caseEvent));
    }

    /**
     * 编辑数据
     *
     * @param caseEvent 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<CaseEvent> edit(CaseEvent caseEvent) {
        return ResponseEntity.ok(this.caseEventService.update(caseEvent));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.caseEventService.deleteById(id));
    }
    /**
     * 返回所有案件列表
     * @return
     */
    @GetMapping("showAllCaseEvent")
    public DataResult showAllCaseEvent(){
        return DataResult.successByDataArray(this.caseEventService.showAllCaseEvent());
    }

    /**
     * 查询案件详情
     * @param caseEvent
     * @return
     */
    @PostMapping("checkCaEvent")
    public DataResult checkCaEvent(@RequestBody CaseEvent caseEvent){
        System.out.println("caseId:"+caseEvent.getCaseId());
        return DataResult.successByData(this.caseEventService.checkCaEvent(caseEvent.getCaseId()));
    }

    /**
     * 提交报案处理方案
     * @param caseEvent
     * @return
     */
    @PostMapping("solveCaEvent")
    public DataResult solveCaEvent(@RequestBody CaseEvent caseEvent){
        Date date = new Date(System.currentTimeMillis());
        caseEvent.setCaseEndtime(date);
        //caseEvent.setCaseEndtime(DateUtil.getNowDateShort());
        caseEvent.setCaseStatus(2);
        //System.out.println(complaintEvent.getComplaintId());
        return DataResult.successByData(this.caseEventService.solveCaEvent(caseEvent));
    }
    /**
     * 获取游客案件列表
     * @param caseEvent
     * @return
     */
    @PostMapping("showVisCaseEvent")
    public DataResult showVisCaseEvent(@RequestBody CaseEvent caseEvent){
        return DataResult.successByDataArray(this.caseEventService.showVisCaseEvent(caseEvent.getTuserId()));
    }
    /**
     * 新建报案
     * @param caseEvent
     * @return
     */
    @PostMapping("createCaEvent")
    public DataResult createCaEvent(@RequestBody CaseEvent caseEvent){
        Date date = new Date(System.currentTimeMillis());
        caseEvent.setCaseBegintime(date);
        caseEvent.setCaseStatus(0);
        //System.out.println(complaintEvent.getComplaintId());
        return DataResult.successByData(this.caseEventService.createCaEvent(caseEvent));
    }
}

