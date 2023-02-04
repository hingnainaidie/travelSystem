package com.cqu.travelsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.cqu.travelsystem.entity.TripEvent;
import com.cqu.travelsystem.service.TripEventService;
import com.cqu.travelsystem.utils.DateUtil;
import com.cqu.travelsystem.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * (TripEvent)表控制层
 *
 * @author makejava
 * @since 2022-06-25 09:53:27
 */
@RestController
@RequestMapping("tripEvent")
public class TripEventController {
    /**
     * 服务对象
     */
    @Resource
    private TripEventService tripEventService;

    /**
     * 分页查询
     *
     * @param tripEvent 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TripEvent>> queryByPage(TripEvent tripEvent, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tripEventService.queryByPage(tripEvent, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TripEvent> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.tripEventService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tripEvent 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TripEvent> add(TripEvent tripEvent) {
        return ResponseEntity.ok(this.tripEventService.insert(tripEvent));
    }

    /**
     * 编辑数据
     *
     * @param tripEvent 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TripEvent> edit(TripEvent tripEvent) {
        return ResponseEntity.ok(this.tripEventService.update(tripEvent));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.tripEventService.deleteById(id));
    }

    @PostMapping(value = "getUnTEs")
    public DataResult getUnTEs(){
        return DataResult.successByDataArray(this.tripEventService.getUnTEs());
    }

    /**
     * 获取预警消息列表
     * @return
     */
    @PostMapping("getEmergency")
    public DataResult getEmergency(){
        System.out.println("这里是预警消息列表！！！");
        return DataResult.successByDataArray(this.tripEventService.getEmergency());
    }

    /**
     * 获取历史旅游事件列表
     * @return
     */
    @PostMapping("getChTEs")
    public DataResult getChTEs(){
        return DataResult.successByDataArray(this.tripEventService.getChTEs());
    }

    /**
     * 查看历史旅游事件详情
     * @param tripEvent
     * @return
     */
    @PostMapping("getDetailChecked")
    public DataResult getDetailChecked(@RequestBody TripEvent tripEvent){
        return DataResult.successByData(this.tripEventService.getDetailChecked(tripEvent));
    }

    /**
     * 删除历史旅游事件
     * @param tripEvent
     * @return
     */
    @PostMapping("deleteTripEvent")
    public DataResult deleteTripEvent(@RequestBody TripEvent tripEvent){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isSuccess", this.tripEventService.deleteTripEvent(tripEvent.getTripEventId()));
        return DataResult.successByData(jsonObject);
    }

    @PostMapping("saveEmergency")
    public DataResult saveEmergency(@RequestBody TripEvent tripEvent){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isSuccess", this.tripEventService.saveEmergency(tripEvent));
        return DataResult.successByData(jsonObject);
    }

    /**
     * 由游客报案转换为旅游事件
     * @param tripEvent
     * @return
     */
    @PostMapping("changeCaEvent")
    public DataResult changeCaEvent(@RequestBody TripEvent tripEvent){
        Date date = new Date(System.currentTimeMillis());
        tripEvent.setTripEventTime(date);
        tripEvent.setTripEventStatus(0);
        return DataResult.successByData(this.tripEventService.changeCaEvent(tripEvent));
    }

    /**
     *显示预警信息
     * @param tripEvent
     * @return
     */
    @PostMapping("showEmergency")
    public DataResult showEmergency(@RequestBody TripEvent tripEvent){
        tripEvent.setTripEventStatus(0);//只获取未处理的
        return DataResult.successByDataArray(this.tripEventService.showEmergency(tripEvent));
    }

    /**
     * 添加旅游信息
     * @param tripEvent
     * @return
     */
    @PostMapping("createTripEvent")
    public DataResult createTripEvent(@RequestBody TripEvent tripEvent){
//        System.out.println(DateUtil.getNow());
        tripEvent.setTripEventTime(DateUtil.getNow());
        tripEvent.setTripEventStatus(0);//未处理
        System.out.println(tripEvent.toString());
        return DataResult.successByData(this.tripEventService.createTripEvent(tripEvent));

    }

    /**
     *显示旅游信息列表
     * @return
     */
    @GetMapping("showTripEvent")
    public DataResult showTripEvent(){
        return DataResult.successByDataArray(this.tripEventService.showTripEvent());
    }

    /**
     *查看单个旅游信息
     * @param tripEvent
     * @return
     */
    @PostMapping("checkTripEvent")
    public DataResult checkTripEvent(@RequestBody TripEvent tripEvent){
        System.out.println(tripEvent.toString());

        return DataResult.successByData(this.tripEventService.checkTripEvent(tripEvent.getTripEventId()));
    }
}

