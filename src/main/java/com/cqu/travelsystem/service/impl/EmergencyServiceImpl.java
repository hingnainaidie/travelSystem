package com.cqu.travelsystem.service.impl;

import com.cqu.travelsystem.entity.Emergency;
import com.cqu.travelsystem.dao.EmergencyDao;
import com.cqu.travelsystem.entity.User;
import com.cqu.travelsystem.service.EmergencyService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Emergency)表服务实现类
 *
 * @author makejava
 * @since 2022-06-25 09:43:02
 */
@Service("emergencyService")
@Transactional
public class EmergencyServiceImpl implements EmergencyService {
    @Resource
    private EmergencyDao emergencyDao;

    /**
     * 通过ID查询单条数据
     *
     * @param emergencyId 主键
     * @return 实例对象
     */
    @Override
    public Emergency queryById(Long emergencyId) {
        return this.emergencyDao.queryById(emergencyId);
    }

    /**
     * 分页查询
     *
     * @param emergency 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Emergency> queryByPage(Emergency emergency, PageRequest pageRequest) {
        long total = this.emergencyDao.count(emergency);
        return new PageImpl<>(this.emergencyDao.queryAllByLimit(emergency, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param emergency 实例对象
     * @return 实例对象
     */
    @Override
    public Emergency insert(Emergency emergency) {
        this.emergencyDao.insert(emergency);
        return emergency;
    }

    /**
     * 修改数据
     *
     * @param emergency 实例对象
     * @return 实例对象
     */
    @Override
    public Emergency update(Emergency emergency) {
        this.emergencyDao.update(emergency);
        return this.queryById(emergency.getEmergencyId());
    }

    /**
     * 通过主键删除数据
     *
     * @param emergencyId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long emergencyId) {
        return this.emergencyDao.deleteById(emergencyId) > 0;
    }

    /**
     * 根据类别返回预案列表
     * @return
     */
    @Override
    public List<Emergency> showEmergesByType(String emergencyClassification){
        return this.emergencyDao.showEmergesByType(emergencyClassification);
    }
    /**
     * 查询所有预案
     * @return
     */
    @Override
    public List<Emergency> showEmerges(){
        return this.emergencyDao.showEmerges();
    };

    /**
     * 通过ID查询单条数据
     *
     * @param
     * @return 实例对象
     */
    @Override
    public Emergency emergeDetail(Emergency emergency) {
        return this.emergencyDao.emergeDetail(emergency);
    }


    /**
     * 删除对应应急预案
     * @param
     * @return
     */
    @Override
    public boolean deleteEmerge(Long id){
        return this.emergencyDao.deleteEmerge(id) ;
    };

    /**
     * 添加紧急预案
     * @param emergency
     * @return
     */
    @Override
    public boolean addEmerge(Emergency emergency){
        return this.emergencyDao.addEmerge(emergency);
    };

    /**
     * 修改紧急预案
     * @param emergency
     * @return
     */
    @Override
    public boolean editEmerge(Emergency emergency){
        return this.emergencyDao.editEmerge(emergency);
    };

}
