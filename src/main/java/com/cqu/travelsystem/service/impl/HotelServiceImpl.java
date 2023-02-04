package com.cqu.travelsystem.service.impl;

import com.cqu.travelsystem.entity.Hotel;
import com.cqu.travelsystem.dao.HotelDao;
import com.cqu.travelsystem.service.HotelService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Hotel)表服务实现类
 *
 * @author makejava
 * @since 2022-06-25 09:43:20
 */
@Service("hotelService")
@Transactional
public class HotelServiceImpl implements HotelService {
    @Resource
    private HotelDao hotelDao;

    /**
     * 通过ID查询单条数据
     *
     * @param hotelId 主键
     * @return 实例对象
     */
    @Override
    public Hotel queryById(Long hotelId) {
        return this.hotelDao.queryById(hotelId);
    }

    /**
     * 分页查询
     *
     * @param hotel 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Hotel> queryByPage(Hotel hotel, PageRequest pageRequest) {
        long total = this.hotelDao.count(hotel);
        return new PageImpl<>(this.hotelDao.queryAllByLimit(hotel, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param hotel 实例对象
     * @return 实例对象
     */
    @Override
    public Hotel insert(Hotel hotel) {
        this.hotelDao.insert(hotel);
        return hotel;
    }

    /**
     * 修改数据
     *
     * @param hotel 实例对象
     * @return 实例对象
     */
    @Override
    public Hotel update(Hotel hotel) {
        this.hotelDao.update(hotel);
        return this.queryById(hotel.getHotelId());
    }

    /**
     * 通过主键删除数据
     *
     * @param hotelId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long hotelId) {
        return this.hotelDao.deleteById(hotelId) > 0;
    }


    /**
     * 查询酒店信息
     * @return
     */
    @Override
    public List<Hotel> queryAllHotel(){
        return this.hotelDao.queryAllHotel();
    }

    /**
     * 根据选择字段查询酒店信息
     * @param hotel
     * @return
     */
    @Override
    public List<Hotel> HqueryByLocation(Hotel hotel) {
        return this.hotelDao.HqueryByLocation(hotel);
    }

}
