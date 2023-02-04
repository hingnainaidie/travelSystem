package com.cqu.travelsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.cqu.travelsystem.entity.Emergency;
import com.cqu.travelsystem.service.EmergencyService;
import com.cqu.travelsystem.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * (Emergency)表控制层
 *
 * @author makejava
 * @since 2022-06-25 09:43:01
 */
@RestController
@RequestMapping("emergency")
public class EmergencyController {
    /**
     * 服务对象
     */
    @Resource
    private EmergencyService emergencyService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping(value = "queryById")
    public ResponseEntity<Emergency> queryById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(this.emergencyService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param emergency 实体
     * @return 新增结果
     */
    @PostMapping(value ="add")
    public ResponseEntity<Emergency> add(@RequestBody Emergency emergency) {
        return ResponseEntity.ok(this.emergencyService.insert(emergency));
    }

    /**
     * 编辑数据
     *
     * @param emergency 实体
     * @return 编辑结果
     */
    @PutMapping(value ="edit")
    public ResponseEntity<Emergency> edit(@RequestBody Emergency emergency) {
        return ResponseEntity.ok(this.emergencyService.update(emergency));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping(value ="deleteById")
    public ResponseEntity<Boolean> deleteById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(this.emergencyService.deleteById(id));
    }


    /**
     * 根据类别返回预案列表
     * @return
     */
    @PostMapping(value ="showEmergesByType")
    public DataResult showEmergesByType(@RequestBody Emergency emergency) {
        return DataResult.successByDataArray(this.emergencyService.showEmergesByType(emergency.getEmergencyClassification()));
    }


    /**
     * 查询所有预案
     * @return
     */
    @GetMapping("showEmerges")
    public DataResult showEmerges() {
        System.out.println("显示所有预案");
        return DataResult.successByDataArray(this.emergencyService.showEmerges());
    }

    /**
     * 查看紧急预案详情
     *
     * @param
     * @return 单条数据
     */
    @PostMapping("emergeDetail")
    public DataResult emergeDetail(@RequestBody Emergency emergency) {
        return DataResult.successByData(this.emergencyService.emergeDetail(emergency));
    }

    /**
     * 删除紧急预案
     * @param emergency
     * @return
     */
    @PostMapping("deleteEmerge")
    public DataResult emergeDelete(@RequestBody Emergency emergency){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isSuccess", this.emergencyService.deleteEmerge(emergency.getEmergencyId()));
        return DataResult.successByData(jsonObject);
    }

    /**
     * 新增紧急预案
     * @param emergency
     * @return
     */
    @PostMapping("addEmerge")
    public DataResult addEmerge(@RequestBody Emergency emergency){
        //获取提交紧急预案时间
        Date date = new Date(System.currentTimeMillis());
        emergency.setEmergencyTime(date);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isSuccess", this.emergencyService.addEmerge(emergency));
        return DataResult.successByData(jsonObject);
    }

    /**
     * 修改预案
     * @param emergency
     * @return
     */
    @PostMapping("editEmerge")
    public DataResult editEmerge(@RequestBody Emergency emergency){
        //更新提交紧急预案时间
        Date date = new Date(System.currentTimeMillis());
        emergency.setEmergencyTime(date);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isSuccess", this.emergencyService.editEmerge(emergency));
        return DataResult.successByData(jsonObject);
    }


}

