package com.cqu.travelsystem.controller;

import com.cqu.travelsystem.entity.Parking;
import com.cqu.travelsystem.service.ParkingService;
import com.cqu.travelsystem.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Parking)表控制层
 *
 * @author makejava
 * @since 2022-06-25 09:43:45
 */
@RestController
@RequestMapping("parking")
public class ParkingController {
    /**
     * 服务对象
     */
    @Resource
    private ParkingService parkingService;

    /**
     * 分页查询
     *
     * @param parking 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Parking>> queryByPage(Parking parking, PageRequest pageRequest) {
        return ResponseEntity.ok(this.parkingService.queryByPage(parking, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Parking> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.parkingService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param parking 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Parking> add(Parking parking) {
        return ResponseEntity.ok(this.parkingService.insert(parking));
    }

    /**
     * 编辑数据
     *
     * @param parking 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Parking> edit(Parking parking) {
        return ResponseEntity.ok(this.parkingService.update(parking));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.parkingService.deleteById(id));
    }

    /**
     * 查询停车场所有信息
     * @return
     */
    @GetMapping("getParkingBasicInfo")
    public DataResult getParkingBasicInfo(){
        System.out.println("11");
        System.out.println(this.parkingService.queryAllParking());
        return DataResult.successByDataArray(this.parkingService.queryAllParking());
    }

    /**
     * 根据选中地址字段查询停车场信息
     * @param parking
     * @return
     */
    @PostMapping("queryByLocation")
    public DataResult queryByLocation(@RequestBody Parking parking){
        System.out.println("停车场信息"+parking.toString());
        System.out.println("查询结果");
        System.out.println(this.parkingService.queryByLocation(parking));
        return DataResult.successByDataArray(this.parkingService.queryByLocation(parking));
    }

}

