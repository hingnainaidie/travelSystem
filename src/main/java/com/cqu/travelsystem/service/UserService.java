package com.cqu.travelsystem.service;

import com.cqu.travelsystem.entity.User;
import com.cqu.travelsystem.Vo.UserVo;
import com.cqu.travelsystem.Vo.visiterVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2022-06-25 09:53:54
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(Long userId);

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<User> queryByPage(User user, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Long userId);

    /**
     * 登录系统
     * @param user
     * @return
     */
    UserVo loginSystem(UserVo userVo);

    /**
     * 查看所有游客信息
     * @return
     */
    List<visiterVo> searchForAllVisitors();

    /**
     * 电话号码查看买票
     * @param visitervo
     * @return
     */
    List<visiterVo> searchByPhone(visiterVo visitervo);

    /**
     * 景区名称查看买票
     * @param visitervo
     * @return
     */
    List<visiterVo> searchByScenic(visiterVo visitervo);

    /**
     * 使用时间查看买票
     * @param visitervo
     * @return
     */
    List<visiterVo> searchByUseTime(visiterVo visitervo);

    /**
     * 工作人员查看所有游客信息
     * @return
     */
    List<visiterVo> staffsearchForAllVisitors(visiterVo visitervo);

    /**
     * 员工人员通过电话号码查看买票
     * @param visitervo
     * @return
     */
    List<visiterVo> staffsearchByPhone(visiterVo visitervo);

    /**
     * 工作人员通过景区名称查看买票
     * @param visitervo
     * @return
     */
    List<visiterVo> staffsearchByScenic(visiterVo visitervo);

    /**
     * 工作人员通过使用时间查看买票
     * @param visitervo
     * @return
     */
    List<visiterVo> staffsearchByUseTime(visiterVo visitervo);

    User searchForUser(User user);

    boolean editInfo(User user);

    boolean editPwd(Long userId,String newPwd);

    User searchPwd(Long userId);

    /**
     * 查看所有员工信息
     * @return
     */
    List<UserVo> getStaffList();

    /**
     * 删除对应员工信息
     * @param userId
     * @return
     */
    boolean deleteStaff(Long userId);

    /**
     * 修改员工信息
     * @param user
     * @return
     */
    boolean editStaffInfo(User user);
}
