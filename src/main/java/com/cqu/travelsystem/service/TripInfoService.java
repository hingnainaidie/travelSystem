package com.cqu.travelsystem.service;

import com.cqu.travelsystem.entity.TripInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (TripInfo)表服务接口
 *
 * @author makejava
 * @since 2022-06-25 09:53:44
 */
public interface TripInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param tripInfoId 主键
     * @return 实例对象
     */
    TripInfo queryById(Long tripInfoId);

    /**
     * 分页查询
     *
     * @param tripInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TripInfo> queryByPage(TripInfo tripInfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tripInfo 实例对象
     * @return 实例对象
     */
    TripInfo insert(TripInfo tripInfo);

    /**
     * 修改数据
     *
     * @param tripInfo 实例对象
     * @return 实例对象
     */
    TripInfo update(TripInfo tripInfo);

    /**
     * 通过主键删除数据
     *
     * @param tripInfoId 主键
     * @return 是否成功
     */
    boolean deleteById(Long tripInfoId);

    /**
     * 添加旅游信息
     * @param tripInfo 实例对象
     * @return 实例对象
     */
    TripInfo createTripInfo(TripInfo tripInfo);

    /**
     * 显示旅游信息列表
     * @return 全部旅游信息列表 列表List 旅游信息实体
     */
    List<TripInfo> showTripInfos();

    /**
     * 查看单个旅游信息
     * @param tripInfoId 主键
     * @return 实例对象
     */
    TripInfo checkTripInfo(Long tripInfoId);

    /**
     * 删除旅游信息
     * @param tripInfoId 主键
     * @return 是否成功
     */
    boolean deleteTripInfo(Long tripInfoId);

}
