package com.cqu.travelsystem.service.impl;

import com.cqu.travelsystem.entity.User;
import com.cqu.travelsystem.dao.UserDao;
import com.cqu.travelsystem.service.UserService;
import com.cqu.travelsystem.Vo.UserVo;
import com.cqu.travelsystem.Vo.visiterVo;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2022-06-25 09:53:54
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long userId) {
        return this.userDao.queryById(userId);
    }

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<User> queryByPage(User user, PageRequest pageRequest) {
        long total = this.userDao.count(user);
        return new PageImpl<>(this.userDao.queryAllByLimit(user, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long userId) {
        return this.userDao.deleteById(userId) > 0;
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @Override
    public UserVo loginSystem(UserVo userVo) {
        return this.userDao.loginSystem(userVo);
    }

    /**
     * 查看所有游客信息
     * @return
     */
    @Override
    public List<visiterVo> searchForAllVisitors() {
        return this.userDao.searchForAllVisitors();
    }

    /**
     * 电话号码查看买票
     * @param visitervo
     * @return
     */
    @Override
    public List<visiterVo> searchByPhone(visiterVo visitervo) {
        return this.userDao.searchByPhone(visitervo);
    }

    /**
     * 景区名称查看买票
     * @param visitervo
     * @return
     */
    @Override
    public List<visiterVo> searchByScenic(visiterVo visitervo) {
        return this.userDao.searchByScenic(visitervo);
    }

    /**
     * 使用时间查看买票
     * @param visitervo
     * @return
     */
    @Override
    public List<visiterVo> searchByUseTime(visiterVo visitervo) {
        return this.userDao.searchByUseTime(visitervo);
    }

    /**
     * 工作人员查看所有游客信息
     * @return
     */
    @Override
    public List<visiterVo> staffsearchForAllVisitors(visiterVo visitervo) {
        return this.userDao.staffsearchForAllVisitors(visitervo);
    }

    /**
     * 员工人员通过电话号码查看买票
     * @param visitervo
     * @return
     */
    @Override
    public List<visiterVo> staffsearchByPhone(visiterVo visitervo) {
        return this.userDao.staffsearchByPhone(visitervo);
    }

    /**
     * 工作人员通过景区名称查看买票
     * @param visitervo
     * @return
     */
    @Override
    public List<visiterVo> staffsearchByScenic(visiterVo visitervo) {
        return this.userDao.staffsearchByScenic(visitervo);
    }

    /**
     * 工作人员通过使用时间查看买票
     * @param visitervo
     * @return
     */
    @Override
    public List<visiterVo> staffsearchByUseTime(visiterVo visitervo) {
        return this.userDao.staffsearchByUseTime(visitervo);
    }

    @Override
    public User searchForUser(User user) {
        return this.userDao.searchForUser(user);
    }


    @Override
    public boolean editInfo(User user){
        return this.userDao.editInfo(user);
    }

    @Override
    public boolean editPwd(Long userId,String newPwd){
        return this.userDao.editPwd(userId,newPwd);
    }
    @Override
    public  User searchPwd(Long userId){
        return this.userDao.searchPwd(userId);
    }

    /**
     * 查看所有员工信息
     * @return
     */
    @Override
    public List<UserVo> getStaffList() {
        return this.userDao.getStaffList();
    }

    /**
     * 删除员工信息
     * @param userId
     * @return
     */
    @Override
    public boolean deleteStaff(Long userId) {
        return this.userDao.deleteStaff(userId) ;
    }

    /**
     * 修改员工信息
     * @param user
     * @return
     */
    @Override
    public boolean editStaffInfo(User user) {
        return this.userDao.editStaffInfo(user);
    }
}
