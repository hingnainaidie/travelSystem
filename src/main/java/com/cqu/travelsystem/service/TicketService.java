package com.cqu.travelsystem.service;

import com.cqu.travelsystem.Vo.TicketScenic;
import com.cqu.travelsystem.entity.Ticket;
import com.cqu.travelsystem.Vo.InOutNum;
import com.cqu.travelsystem.Vo.TicketMoney;
import com.cqu.travelsystem.Vo.visiterVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Ticket)表服务接口
 *
 * @author makejava
 * @since 2022-06-25 09:59:55
 */
public interface TicketService {

    /**
     * 通过ID查询单条数据
     *
     * @param ticketId 主键
     * @return 实例对象
     */
    Ticket queryById(Long ticketId);

    /**
     * 分页查询
     *
     * @param ticket 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Ticket> queryByPage(Ticket ticket, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param ticket 实例对象
     * @return 实例对象
     */
    Ticket insert(Ticket ticket);

    /**
     * 修改数据
     *
     * @param ticket 实例对象
     * @return 实例对象
     */
    Ticket update(Ticket ticket);

    /**
     * 通过主键删除数据
     *
     * @param ticketId 主键
     * @return 是否成功
     */
    boolean deleteById(Long ticketId);

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

    /**
     * 游客使用票
     * @param ticketId
     * @return
     */
    boolean useTicket(Long ticketId);


    int updateStatus();
}
