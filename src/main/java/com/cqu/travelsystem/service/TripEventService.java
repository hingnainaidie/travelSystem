package com.cqu.travelsystem.service;

import com.cqu.travelsystem.Vo.TripEventVo;
import com.cqu.travelsystem.entity.TripEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (TripEvent)表服务接口
 *
 * @author makejava
 * @since 2022-06-25 09:53:28
 */
public interface TripEventService {

    /**
     * 通过ID查询单条数据
     *
     * @param tripEventId 主键
     * @return 实例对象
     */
    TripEvent queryById(Long tripEventId);

    /**
     * 分页查询
     *
     * @param tripEvent 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TripEvent> queryByPage(TripEvent tripEvent, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tripEvent 实例对象
     * @return 实例对象
     */
    TripEvent insert(TripEvent tripEvent);

    /**
     * 修改数据
     *
     * @param tripEvent 实例对象
     * @return 实例对象
     */
    TripEvent update(TripEvent tripEvent);

    /**
     * 通过主键删除数据
     *
     * @param tripEventId 主键
     * @return 是否成功
     */
    boolean deleteById(Long tripEventId);


    List<TripEvent> getUnTEs();

    /**
     * 查看预警消息列表
     * @param
     * @return
     */
    List<TripEvent> getEmergency();

    /**
     * 查看历史已处理旅游事件
     * @return
     */
    List<TripEvent> getChTEs();

    /**
     * 查看旅游事件详情
     * @param tripEvent
     * @return
     */
    TripEventVo getDetailChecked(TripEvent tripEvent);

    /**
     * 已处理旅游事件地删除
     * @param
     * @return
     */
    boolean deleteTripEvent(Long id);

    boolean saveEmergency(TripEvent tripEvent);

    /**
     * 转换
     * @param tripEvent
     * @return
     */
    TripEvent changeCaEvent(TripEvent tripEvent);

    /**
     * 获取预警消息
     * @param tripEvent
     * @return
     */
    List<TripEvent> showEmergency(TripEvent tripEvent);

    /**
     * 添加旅游信息
     * @param tripEvent
     * @return
     */
    TripEvent createTripEvent(TripEvent tripEvent);

    /**
     * 显示旅游信息列表
     * @return
     */
    List<TripEvent> showTripEvent();

    /**
     * 查看单个旅游信息
     * @param tripEventId
     * @return
     */
    TripEvent checkTripEvent(Long tripEventId);
}
