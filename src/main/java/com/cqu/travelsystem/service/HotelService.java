package com.cqu.travelsystem.service;

import com.cqu.travelsystem.entity.Hotel;
import com.cqu.travelsystem.entity.Parking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Hotel)表服务接口
 *
 * @author makejava
 * @since 2022-06-25 09:43:20
 */
public interface HotelService {

    /**
     * 通过ID查询单条数据
     *
     * @param hotelId 主键
     * @return 实例对象
     */
    Hotel queryById(Long hotelId);

    /**
     * 分页查询
     *
     * @param hotel 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Hotel> queryByPage(Hotel hotel, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param hotel 实例对象
     * @return 实例对象
     */
    Hotel insert(Hotel hotel);

    /**
     * 修改数据
     *
     * @param hotel 实例对象
     * @return 实例对象
     */
    Hotel update(Hotel hotel);

    /**
     * 通过主键删除数据
     *
     * @param hotelId 主键
     * @return 是否成功
     */
    boolean deleteById(Long hotelId);

    /**
     * 查询停车场基本信息
     * @return
     */
    List<Hotel> queryAllHotel();

    /**
     * 根据选择字段查询酒店形象
     * @param hotel
     * @return
     */
    List<Hotel> HqueryByLocation(Hotel hotel);
}
