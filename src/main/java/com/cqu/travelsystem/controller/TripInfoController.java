package com.cqu.travelsystem.controller;

import com.cqu.travelsystem.entity.TripInfo;
import com.cqu.travelsystem.service.TripInfoService;
import com.cqu.travelsystem.utils.DateUtil;
import com.cqu.travelsystem.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TripInfo)表控制层
 *
 * @author makejava
 * @since 2022-06-25 09:53:44
 */
@RestController
@RequestMapping("tripInfo")
public class TripInfoController {
    /**
     * 服务对象
     */
    @Resource
    private TripInfoService tripInfoService;

    /**
     * 分页查询
     *
     * @param tripInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TripInfo>> queryByPage(TripInfo tripInfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tripInfoService.queryByPage(tripInfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TripInfo> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.tripInfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tripInfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TripInfo> add(TripInfo tripInfo) {
        return ResponseEntity.ok(this.tripInfoService.insert(tripInfo));
    }

    /**
     * 编辑数据
     *
     * @param tripInfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TripInfo> edit(TripInfo tripInfo) {
        return ResponseEntity.ok(this.tripInfoService.update(tripInfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.tripInfoService.deleteById(id));
    }

    /**
     *添加旅游信息
     * @param tripInfo
     * @return
     */
    @PostMapping("createTripInfo")
    public DataResult createTripInfo(@RequestBody TripInfo tripInfo){
//        System.out.println(DateUtil.getNow());
        tripInfo.setTripInfoTime(DateUtil.getNow());
        tripInfo.setTripInfoStatus(0);//未处理
        System.out.println(tripInfo.toString());
        return DataResult.successByData(this.tripInfoService.createTripInfo(tripInfo));

    }

    /**
     *显示旅游信息列表
     * @return
     */
    @GetMapping("showTripInfos")
    public DataResult showTripInfos(){
        return DataResult.successByDataArray(this.tripInfoService.showTripInfos());
    }

    /**
     *查看单个旅游信息
     * @param tripInfo
     * @return
     */
    @PostMapping("checkTripInfo")
    public DataResult checkTripInfo(@RequestBody TripInfo tripInfo){
        System.out.println(tripInfo.toString());

        return DataResult.successByData(this.tripInfoService.checkTripInfo(tripInfo.getTripInfoId()));
    }

    /**
     *删除旅游信息
     * @param tripInfo
     * @return
     */
    @PostMapping("deleteTripInfo")
    public DataResult deleteTripInfo(@RequestBody TripInfo tripInfo){
        System.out.println(tripInfo.toString());
        return DataResult.successByData(this.tripInfoService.deleteTripInfo(tripInfo.getTripInfoId()));
    }

}

