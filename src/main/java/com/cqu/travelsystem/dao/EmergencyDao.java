package com.cqu.travelsystem.dao;

import com.cqu.travelsystem.entity.Emergency;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Emergency)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-25 09:43:01
 */
public interface EmergencyDao {

    /**
     * 通过ID查询单条数据
     *
     * @param emergencyId 主键
     * @return 实例对象
     */
    Emergency queryById(Long emergencyId);

    /**
     * 查询指定行数据
     *
     * @param emergency 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Emergency> queryAllByLimit(Emergency emergency, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param emergency 查询条件
     * @return 总行数
     */
    long count(Emergency emergency);

    /**
     * 新增数据
     *
     * @param emergency 实例对象
     * @return 影响行数
     */
    int insert(Emergency emergency);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Emergency> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Emergency> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Emergency> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Emergency> entities);

    /**
     * 修改数据
     *
     * @param emergency 实例对象
     * @return 影响行数
     */
    int update(Emergency emergency);

    /**
     * 通过主键删除数据
     *
     * @param emergencyId 主键
     * @return 影响行数
     */
    int deleteById(Long emergencyId);


    /**
     * 根据预案返回预案列表
     * @return
     */
    List<Emergency> showEmergesByType(String emergencyClassification);

    /**
     * 查询所有预案
     * @return
     */
    List<Emergency> showEmerges();

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    Emergency emergeDetail(Emergency emergency);

    /**
     * 删除对应应急预案
     * @param
     * @return
     */
    boolean deleteEmerge(Long id);

    /**
     * 添加紧急预案
     * @param emergency
     * @return
     */
    boolean addEmerge(Emergency emergency);

    /**
     * 修改紧急预案
     * @param emergency
     * @return
     */
    boolean editEmerge(Emergency emergency);


}

