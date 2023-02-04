package com.cqu.travelsystem.service;

import com.cqu.travelsystem.entity.Scenic;
import com.cqu.travelsystem.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Scenic)表服务接口
 *
 * @author makejava
 * @since 2022-06-25 09:52:48
 */
public interface ScenicService {

    /**
     * 通过ID查询单条数据
     *
     * @param scenicId 主键
     * @return 实例对象
     */
    Scenic queryById(Long scenicId);

    /**
     * 分页查询
     *
     * @param scenic 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Scenic> queryByPage(Scenic scenic, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param scenic 实例对象
     * @return 实例对象
     */
    Scenic insert(Scenic scenic);

    /**
     * 修改数据
     *
     * @param scenic 实例对象
     * @return 实例对象
     */
    Scenic update(Scenic scenic);

    /**
     * 通过主键删除数据
     *
     * @param scenicId 主键
     * @return 是否成功
     */
    boolean deleteById(Long scenicId);

    /**
     * 返回景区基本信息
     * @return
     */
    List<Scenic> queryAllScenic();

    /**
     * 根据景区名称查询景区基本信息
     * @param scenic
     * @return
     */
    Scenic queryByName(Scenic scenic);

    /**
     * 根据景区名称找到id
     * @param scenic
     * @return
     */
    Scenic FindscenicIdByName(Scenic scenic);


}
