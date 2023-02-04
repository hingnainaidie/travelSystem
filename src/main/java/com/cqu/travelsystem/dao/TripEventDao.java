package com.cqu.travelsystem.dao;

import com.cqu.travelsystem.Vo.TripEventVo;
import com.cqu.travelsystem.entity.TripEvent;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TripEvent)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-25 09:53:27
 */
public interface TripEventDao {

    /**
     * 通过ID查询单条数据
     *
     * @param tripEventId 主键
     * @return 实例对象
     */
    TripEvent queryById(Long tripEventId);

    /**
     * 查询指定行数据
     *
     * @param tripEvent 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TripEvent> queryAllByLimit(TripEvent tripEvent, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tripEvent 查询条件
     * @return 总行数
     */
    long count(TripEvent tripEvent);

    /**
     * 新增数据
     *
     * @param tripEvent 实例对象
     * @return 影响行数
     */
    int insert(TripEvent tripEvent);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TripEvent> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TripEvent> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TripEvent> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TripEvent> entities);

    /**
     * 修改数据
     *
     * @param tripEvent 实例对象
     * @return 影响行数
     */
    int update(TripEvent tripEvent);

    /**
     * 通过主键删除数据
     *
     * @param tripEventId 主键
     * @return 影响行数
     */
    int deleteById(Long tripEventId);

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
    int changeCaseToTripEvent(TripEvent tripEvent);

    /**
     * 获取未处理的预警消息
     * @param tripEvent
     * @return
     */
    List<TripEvent> queryEmergencyByuserId(TripEvent tripEvent);

    /**
     *添加旅游信息
     * @param tripEvent
     * @return
     */
    int createTripEvent(TripEvent tripEvent);

    /**
     *显示旅游信息列表
     * @return
     */
    List<TripEvent> showTripEvent();

    /**
     *查看单个旅游信息
     * @param tripEventId
     * @return
     */
    TripEvent checkTripEvent(Long tripEventId);


}

