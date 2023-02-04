package com.cqu.travelsystem.dao;

import com.cqu.travelsystem.Vo.TicketScenic;
import com.cqu.travelsystem.entity.Ticket;
import com.cqu.travelsystem.Vo.InOutNum;
import com.cqu.travelsystem.Vo.TicketMoney;
import com.cqu.travelsystem.Vo.visiterVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Ticket)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-25 09:59:53
 */
public interface TicketDao {

    /**
     * 通过ID查询单条数据
     *
     * @param ticketId 主键
     * @return 实例对象
     */
    Ticket queryById(Long ticketId);

    /**
     * 查询指定行数据
     *
     * @param ticket 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Ticket> queryAllByLimit(Ticket ticket, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param ticket 查询条件
     * @return 总行数
     */
    long count(Ticket ticket);

    /**
     * 新增数据
     *
     * @param ticket 实例对象
     * @return 影响行数
     */
    int insert(Ticket ticket);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Ticket> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Ticket> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Ticket> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Ticket> entities);

    /**
     * 修改数据
     *
     * @param ticket 实例对象
     * @return 影响行数
     */
    int update(Ticket ticket);

    /**
     * 通过主键删除数据
     *
     * @param ticketId 主键
     * @return 影响行数
     */
    int deleteById(Long ticketId);


    /**
     * 获取某天的已销售票数
     * @param ticket
     * @return
     */
    int CountTicketNumByDay(Ticket ticket);

    /**
     * 获取某景区今年每天的票务统计情况（全部）
     * @param ticket
     * @return
     */
    List<TicketMoney> GetAllTicketInfoByDay(Ticket ticket);


    /**
     * 当年每月的销售
     * @param ticket
     * @return
     */
    List<TicketMoney> GetTicketInfoByMonth(Ticket ticket);

    /**
     * 返回最近五年的票务销售信息
     * @param ticket
     * @return
     */
    List<TicketMoney> GetTicketInfoFiveYear(Ticket ticket);

    /**
     * 按买票游客名字查询
     * @param visitervo
     * @return
     */
    List<visiterVo> searchByName(visiterVo visitervo);

    /**
     * 工作人员按买票游客名字查询
     * @param visitervo
     * @return
     */
    List<visiterVo> staffsearchByName(visiterVo visitervo);

    /**
     * 景区入区人数计数
     * @param ticket
     * @return
     */
    InOutNum countScenicIn(Ticket ticket);

    /**
     * 景区离区人数计数
     * @param ticket
     * @return
     */
    InOutNum countScenicOut(Ticket ticket);

    List<TicketScenic> showTickets(Long userId);


    void changeStatus(int s, int s1, int s2);
    /**
     * 游客使用票
     * @param ticketId
     * @return
     */
    boolean useTicket(Long ticketId);

}

