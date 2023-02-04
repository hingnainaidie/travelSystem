package com.cqu.travelsystem.dao;

import com.cqu.travelsystem.entity.TripInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TripInfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-25 09:53:44
 */
public interface TripInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param tripInfoId 主键
     * @return 实例对象
     */
    TripInfo queryById(Long tripInfoId);

    /**
     * 查询指定行数据
     *
     * @param tripInfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TripInfo> queryAllByLimit(TripInfo tripInfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tripInfo 查询条件
     * @return 总行数
     */
    long count(TripInfo tripInfo);

    /**
     * 新增数据
     *
     * @param tripInfo 实例对象
     * @return 影响行数
     */
    int insert(TripInfo tripInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TripInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TripInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TripInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TripInfo> entities);

    /**
     * 修改数据
     *
     * @param tripInfo 实例对象
     * @return 影响行数
     */
    int update(TripInfo tripInfo);

    /**
     * 通过主键删除数据
     *
     * @param tripInfoId 主键
     * @return 影响行数
     */
    int deleteById(Long tripInfoId);

    /**
     * 添加旅游信息
     * @param tripInfo
     * @return
     */
    int createTripInfo(TripInfo tripInfo);

    /**
     * 显示旅游信息列表
     * @return
     */
    List<TripInfo> showTripInfos();

    /**
     * 查看单个旅游信息
     * @param tripInfoId
     * @return
     */
    TripInfo checkTripInfo(Long tripInfoId);

    /**
     * 删除旅游信息
     * @param tripInfoId
     * @return
     */
    int deleteTripInfo(Long tripInfoId);

}

