package com.cqu.travelsystem.service;

import com.cqu.travelsystem.entity.Parking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Parking)表服务接口
 *
 * @author makejava
 * @since 2022-06-25 09:43:45
 */
public interface ParkingService {

    /**
     * 通过ID查询单条数据
     *
     * @param parkingId 主键
     * @return 实例对象
     */
    Parking queryById(Long parkingId);

    /**
     * 分页查询
     *
     * @param parking 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Parking> queryByPage(Parking parking, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param parking 实例对象
     * @return 实例对象
     */
    Parking insert(Parking parking);

    /**
     * 修改数据
     *
     * @param parking 实例对象
     * @return 实例对象
     */
    Parking update(Parking parking);

    /**
     * 通过主键删除数据
     *
     * @param parkingId 主键
     * @return 是否成功
     */
    boolean deleteById(Long parkingId);

    /**
     * 查询所有停车场信息
     * @return
     */
    List<Parking> queryAllParking();


    /**
     * 根据选中地址字段查询停车场信息
     * @param parking
     * @return
     */
    List<Parking> queryByLocation(Parking parking);
}
