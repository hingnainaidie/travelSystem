package com.cqu.travelsystem.service;

import com.cqu.travelsystem.entity.Emergency;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Emergency)表服务接口
 *
 * @author makejava
 * @since 2022-06-25 09:43:02
 */
public interface EmergencyService {

    /**
     * 通过ID查询单条数据
     *
     * @param emergencyId 主键
     * @return 实例对象
     */
    Emergency queryById(Long emergencyId);

    /**
     * 分页查询
     *
     * @param emergency 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Emergency> queryByPage(Emergency emergency, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param emergency 实例对象
     * @return 实例对象
     */
    Emergency insert(Emergency emergency);

    /**
     * 修改数据
     *
     * @param emergency 实例对象
     * @return 实例对象
     */
    Emergency update(Emergency emergency);

    /**
     * 通过主键删除数据
     *
     * @param emergencyId 主键
     * @return 是否成功
     */
    boolean deleteById(Long emergencyId);


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
