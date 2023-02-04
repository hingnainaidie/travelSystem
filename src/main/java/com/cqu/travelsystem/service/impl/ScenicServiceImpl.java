package com.cqu.travelsystem.service.impl;

import com.cqu.travelsystem.entity.Scenic;
import com.cqu.travelsystem.dao.ScenicDao;
import com.cqu.travelsystem.service.ScenicService;
import com.cqu.travelsystem.utils.result.DataResult;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Scenic)表服务实现类
 *
 * @author makejava
 * @since 2022-06-25 09:52:48
 */
@Service("scenicService")
@Transactional
public class ScenicServiceImpl implements ScenicService {
    @Resource
    private ScenicDao scenicDao;

    /**
     * 通过ID查询单条数据
     *
     * @param scenicId 主键
     * @return 实例对象
     */
    @Override
    public Scenic queryById(Long scenicId) {
        return this.scenicDao.queryById(scenicId);
    }

    /**
     * 分页查询
     *
     * @param scenic 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Scenic> queryByPage(Scenic scenic, PageRequest pageRequest) {
        long total = this.scenicDao.count(scenic);
        return new PageImpl<>(this.scenicDao.queryAllByLimit(scenic, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param scenic 实例对象
     * @return 实例对象
     */
    @Override
    public Scenic insert(Scenic scenic) {
        this.scenicDao.insert(scenic);
        return scenic;
    }

    /**
     * 修改数据
     *
     * @param scenic 实例对象
     * @return 实例对象
     */
    @Override
    public Scenic update(Scenic scenic) {
        this.scenicDao.update(scenic);
        return this.queryById(scenic.getScenicId());
    }

    /**
     * 通过主键删除数据
     *
     * @param scenicId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long scenicId) {
        return this.scenicDao.deleteById(scenicId) > 0;
    }

    /**
     * 查询景区基本信息
     */
    @Override
    public List<Scenic> queryAllScenic() {
        return this.scenicDao.queryAllScenic();
    };

    /**
     * 值班人员查看景区信息
     */
    @Override
    public Scenic queryByName(Scenic scenic){
        return this.scenicDao.queryByName(scenic);
    }

    /**
     * 根据景区名称找到id
     * @param scenic
     * @return
     */
    @Override
    public Scenic FindscenicIdByName(Scenic scenic) {
        return this.scenicDao.FindscenicIdByName(scenic);
    }


}
