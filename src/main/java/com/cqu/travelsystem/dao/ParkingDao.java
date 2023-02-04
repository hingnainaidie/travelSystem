package com.cqu.travelsystem.dao;

import com.cqu.travelsystem.entity.Parking;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Parking)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-25 09:43:45
 */
public interface ParkingDao {

    /**
     * 通过ID查询单条数据
     *
     * @param parkingId 主键
     * @return 实例对象
     */
    Parking queryById(Long parkingId);

    /**
     * 查询指定行数据
     *
     * @param parking 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Parking> queryAllByLimit(Parking parking, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param parking 查询条件
     * @return 总行数
     */
    long count(Parking parking);

    /**
     * 新增数据
     *
     * @param parking 实例对象
     * @return 影响行数
     */
    int insert(Parking parking);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Parking> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Parking> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Parking> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Parking> entities);

    /**
     * 修改数据
     *
     * @param parking 实例对象
     * @return 影响行数
     */
    int update(Parking parking);

    /**
     * 通过主键删除数据
     *
     * @param parkingId 主键
     * @return 影响行数
     */
    int deleteById(Long parkingId);

    /**
     * 查询停车场基本信息
     * @return
     */
    List<Parking> queryAllParking();

    /**
     * 根据选择字段查询停车场信息
     * @return
     */
    List<Parking> queryByLocation(Parking parking);
}

