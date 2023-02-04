package com.cqu.travelsystem.service.impl;

import com.cqu.travelsystem.entity.Parking;
import com.cqu.travelsystem.dao.ParkingDao;
import com.cqu.travelsystem.service.ParkingService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Parking)表服务实现类
 *
 * @author makejava
 * @since 2022-06-25 09:43:45
 */
@Service("parkingService")
@Transactional
public class ParkingServiceImpl implements ParkingService {
    @Resource
    private ParkingDao parkingDao;

    /**
     * 通过ID查询单条数据
     *
     * @param parkingId 主键
     * @return 实例对象
     */
    @Override
    public Parking queryById(Long parkingId) {
        return this.parkingDao.queryById(parkingId);
    }

    /**
     * 分页查询
     *
     * @param parking 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Parking> queryByPage(Parking parking, PageRequest pageRequest) {
        long total = this.parkingDao.count(parking);
        return new PageImpl<>(this.parkingDao.queryAllByLimit(parking, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param parking 实例对象
     * @return 实例对象
     */
    @Override
    public Parking insert(Parking parking) {
        this.parkingDao.insert(parking);
        return parking;
    }

    /**
     * 修改数据
     *
     * @param parking 实例对象
     * @return 实例对象
     */
    @Override
    public Parking update(Parking parking) {
        this.parkingDao.update(parking);
        return this.queryById(parking.getParkingId());
    }

    /**
     * 通过主键删除数据
     *
     * @param parkingId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long parkingId) {
        return this.parkingDao.deleteById(parkingId) > 0;
    }

    /**
     * 获取停车场基本信息
     * @return
     */
    @Override
    public List<Parking> queryAllParking(){
        return this.parkingDao.queryAllParking();
    }

    /**
     * 根据选中地址字段查询停车场信息
     * @return
     */
    @Override
    public List<Parking> queryByLocation(Parking parking) {
        return this.parkingDao.queryByLocation(parking);
    }

}
