package com.cqu.travelsystem.dao;

import com.cqu.travelsystem.entity.Scenic;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Scenic)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-25 09:52:48
 */
public interface ScenicDao {

    /**
     * 通过ID查询单条数据
     *
     * @param scenicId 主键
     * @return 实例对象
     */
    Scenic queryById(Long scenicId);

    /**
     * 查询指定行数据
     *
     * @param scenic 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Scenic> queryAllByLimit(Scenic scenic, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param scenic 查询条件
     * @return 总行数
     */
    long count(Scenic scenic);

    /**
     * 新增数据
     *
     * @param scenic 实例对象
     * @return 影响行数
     */
    int insert(Scenic scenic);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Scenic> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Scenic> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Scenic> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Scenic> entities);

    /**
     * 修改数据
     *
     * @param scenic 实例对象
     * @return 影响行数
     */
    int update(Scenic scenic);

    /**
     * 通过主键删除数据
     *
     * @param scenicId 主键
     * @return 影响行数
     */
    int deleteById(Long scenicId);

    /**
     * 查询基本旅游信息
     * @return
     */
    List<Scenic> queryAllScenic();

    /**
     * 值班人员查看景区基本信息
     */
    Scenic queryByName(Scenic scenic);

    /**
     * 根据景区名称找到id
     * @param scenic
     * @return
     */
    Scenic FindscenicIdByName(Scenic scenic);


}

