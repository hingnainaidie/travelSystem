package com.cqu.travelsystem.service.impl;

import com.cqu.travelsystem.entity.TripInfo;
import com.cqu.travelsystem.dao.TripInfoDao;
import com.cqu.travelsystem.service.TripInfoService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TripInfo)表服务实现类
 *
 * @author makejava
 * @since 2022-06-25 09:53:44
 */
@Service("tripInfoService")
@Transactional
public class TripInfoServiceImpl implements TripInfoService {
    @Resource
    private TripInfoDao tripInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param tripInfoId 主键
     * @return 实例对象
     */
    @Override
    public TripInfo queryById(Long tripInfoId) {
        return this.tripInfoDao.queryById(tripInfoId);
    }

    /**
     * 分页查询
     *
     * @param tripInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TripInfo> queryByPage(TripInfo tripInfo, PageRequest pageRequest) {
        long total = this.tripInfoDao.count(tripInfo);
        return new PageImpl<>(this.tripInfoDao.queryAllByLimit(tripInfo, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tripInfo 实例对象
     * @return 实例对象
     */
    @Override
    public TripInfo insert(TripInfo tripInfo) {
        this.tripInfoDao.insert(tripInfo);
        return tripInfo;
    }

    /**
     * 修改数据
     *
     * @param tripInfo 实例对象
     * @return 实例对象
     */
    @Override
    public TripInfo update(TripInfo tripInfo) {
        this.tripInfoDao.update(tripInfo);
        return this.queryById(tripInfo.getTripInfoId());
    }

    /**
     * 通过主键删除数据
     *
     * @param tripInfoId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long tripInfoId) {
        return this.tripInfoDao.deleteById(tripInfoId) > 0;
    }

    /**
     * 添加旅游信息
     * @param tripInfo 实例对象
     * @return
     */
    @Override
    public TripInfo createTripInfo(TripInfo tripInfo) {
        this.tripInfoDao.createTripInfo(tripInfo);
        return tripInfo;
    }

    /**
     * 显示旅游信息列表
     * @return
     */
    @Override
    public List<TripInfo> showTripInfos(){

        return this.tripInfoDao.showTripInfos();
    }

    /**
     * 查看单个旅游信息
     * @param tripInfoId 主键
     * @return
     */
    @Override
    public TripInfo checkTripInfo(Long tripInfoId){
        return this.tripInfoDao.checkTripInfo(tripInfoId);
    }

    /**
     * 删除旅游信息
     * @param tripInfoId 主键
     * @return
     */
    @Override
    public boolean deleteTripInfo(Long tripInfoId){
        return this.tripInfoDao.deleteTripInfo(tripInfoId)>0;
    }
}
