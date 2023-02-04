package com.cqu.travelsystem.service.impl;

import com.cqu.travelsystem.Vo.TripEventVo;
import com.cqu.travelsystem.entity.TripEvent;
import com.cqu.travelsystem.dao.TripEventDao;
import com.cqu.travelsystem.service.TripEventService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TripEvent)表服务实现类
 *
 * @author makejava
 * @since 2022-06-25 09:53:28
 */
@Service("tripEventService")
@Transactional
public class TripEventServiceImpl implements TripEventService {
    @Resource
    private TripEventDao tripEventDao;

    /**
     * 通过ID查询单条数据
     *
     * @param tripEventId 主键
     * @return 实例对象
     */
    @Override
    public TripEvent queryById(Long tripEventId) {
        return this.tripEventDao.queryById(tripEventId);
    }

    /**
     * 分页查询
     *
     * @param tripEvent 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TripEvent> queryByPage(TripEvent tripEvent, PageRequest pageRequest) {
        long total = this.tripEventDao.count(tripEvent);
        return new PageImpl<>(this.tripEventDao.queryAllByLimit(tripEvent, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tripEvent 实例对象
     * @return 实例对象
     */
    @Override
    public TripEvent insert(TripEvent tripEvent) {
        this.tripEventDao.insert(tripEvent);
        return tripEvent;
    }

    /**
     * 修改数据
     *
     * @param tripEvent 实例对象
     * @return 实例对象
     */
    @Override
    public TripEvent update(TripEvent tripEvent) {
        this.tripEventDao.update(tripEvent);
        return this.queryById(tripEvent.getTripEventId());
    }

    /**
     * 通过主键删除数据
     *
     * @param tripEventId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long tripEventId) {
        return this.tripEventDao.deleteById(tripEventId) > 0;
    }

    @Override
    public List<TripEvent> getUnTEs(){
        return this.tripEventDao.getUnTEs();
    }

    /**
     * 查看预警消息列表
     * @param
     * @return
     */
    @Override
    public List<TripEvent> getEmergency(){
        return this.tripEventDao.getEmergency();
    };

    /**
     * 查看历史已处理旅游事件
     * @return
     */
    @Override
    public List<TripEvent> getChTEs(){
        return this.tripEventDao.getChTEs();
    };

    /**
     * 查看旅游事件详情
     * @param tripEvent
     * @return
     */
    @Override
    public TripEventVo getDetailChecked(TripEvent tripEvent){
        return this.tripEventDao.getDetailChecked(tripEvent);
    };

    /**
     * 已处理旅游事件地删除
     * @param
     * @return
     */
    public boolean deleteTripEvent(Long id){
        return this.tripEventDao.deleteTripEvent(id);
    };

    @Override
    public boolean saveEmergency(TripEvent tripEvent){
        return this.tripEventDao.saveEmergency(tripEvent);
    }

    /**
     * 插入转换后的旅游事件
     * @param tripEvent
     * @return
     */
    @Override
    public TripEvent changeCaEvent(TripEvent tripEvent){
        this.tripEventDao.changeCaseToTripEvent(tripEvent);
        return this.queryById(tripEvent.getTripEventId());
    }

    /**
     * 获取预警消息
     * @param tripEvent
     * @return
     */
    @Override
    public List<TripEvent> showEmergency(TripEvent tripEvent){
        return this.tripEventDao.queryEmergencyByuserId(tripEvent);
    }

    /**
     * 添加旅游信息
     * @param tripEvent
     * @return
     */
    @Override
    public TripEvent createTripEvent(TripEvent tripEvent) {
        this.tripEventDao.createTripEvent(tripEvent);
        return tripEvent;
    }

    /**
     * 显示旅游信息列表
     * @return
     */
    @Override
    public List<TripEvent> showTripEvent(){

        return this.tripEventDao.showTripEvent();
    }

    /**
     * 查看单个旅游信息
     * @param tripEventId
     * @return
     */
    @Override
    public TripEvent checkTripEvent(Long tripEventId){
        return this.tripEventDao.checkTripEvent(tripEventId);
    }
}
