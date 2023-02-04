package com.cqu.travelsystem.dao;

import com.cqu.travelsystem.entity.User;
import com.cqu.travelsystem.Vo.UserVo;
import com.cqu.travelsystem.Vo.visiterVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-25 09:53:54
 */
public interface UserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(Long userId);

    /**
     * 查询指定行数据
     *
     * @param user 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<User> queryAllByLimit(User user, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param user 查询条件
     * @return 总行数
     */
    long count(User user);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<User> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<User> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<User> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<User> entities);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(User user);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(Long userId);

    /**
     * 登录
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
     * @param visitervo
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
     * 删除员工信息
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

