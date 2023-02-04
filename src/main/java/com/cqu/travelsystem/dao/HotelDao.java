package com.cqu.travelsystem.dao;

import com.cqu.travelsystem.entity.Hotel;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Hotel)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-25 09:43:20
 */
public interface HotelDao {

    /**
     * 通过ID查询单条数据
     *
     * @param hotelId 主键
     * @return 实例对象
     */
    Hotel queryById(Long hotelId);

    /**
     * 查询指定行数据
     *
     * @param hotel 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Hotel> queryAllByLimit(Hotel hotel, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param hotel 查询条件
     * @return 总行数
     */
    long count(Hotel hotel);

    /**
     * 新增数据
     *
     * @param hotel 实例对象
     * @return 影响行数
     */
    int insert(Hotel hotel);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Hotel> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Hotel> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Hotel> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Hotel> entities);

    /**
     * 修改数据
     *
     * @param hotel 实例对象
     * @return 影响行数
     */
    int update(Hotel hotel);

    /**
     * 通过主键删除数据
     *
     * @param hotelId 主键
     * @return 影响行数
     */
    int deleteById(Long hotelId);

    /**
     * 查询停车场基本信息
     * @return
     */
    List<Hotel> queryAllHotel();

    /**
     * 根据选择字段查询酒店信息
     * @param hotel
     * @return
     */
    List<Hotel> HqueryByLocation(Hotel hotel);
}

