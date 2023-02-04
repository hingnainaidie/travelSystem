package com.cqu.travelsystem.service.impl;

import com.cqu.travelsystem.Vo.TicketScenic;
import com.cqu.travelsystem.entity.Ticket;
import com.cqu.travelsystem.dao.TicketDao;
import com.cqu.travelsystem.service.TicketService;
import com.cqu.travelsystem.utils.DateUtil;
import com.cqu.travelsystem.Vo.InOutNum;
import com.cqu.travelsystem.Vo.TicketMoney;
import com.cqu.travelsystem.Vo.visiterVo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Ticket)表服务实现类
 *
 * @author makejava
 * @since 2022-06-25 09:59:56
 */
@Service("ticketService")
@Transactional
public class TicketServiceImpl implements TicketService {
    @Resource
    private TicketDao ticketDao;

    /**
     * 通过ID查询单条数据
     *
     * @param ticketId 主键
     * @return 实例对象
     */
    @Override
    public Ticket queryById(Long ticketId) {
        return this.ticketDao.queryById(ticketId);
    }

    /**
     * 分页查询
     *
     * @param ticket 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Ticket> queryByPage(Ticket ticket, PageRequest pageRequest) {
        long total = this.ticketDao.count(ticket);
        return new PageImpl<>(this.ticketDao.queryAllByLimit(ticket, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param ticket 实例对象
     * @return 实例对象
     */
    @Override
    public Ticket insert(Ticket ticket) {
        this.ticketDao.insert(ticket);
        return ticket;
    }

    /**
     * 修改数据
     *
     * @param ticket 实例对象
     * @return 实例对象
     */
    @Override
    public Ticket update(Ticket ticket) {
        this.ticketDao.update(ticket);
        return this.queryById(ticket.getTicketId());
    }

    /**
     * 通过主键删除数据
     *
     * @param ticketId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long ticketId) {
        return this.ticketDao.deleteById(ticketId) > 0;
    }

    /**
     * 获取某天的已销售票数
     * @param ticket
     * @return
     */
    @Override
    public int CountTicketNumByDay(Ticket ticket) {
        return this.ticketDao.CountTicketNumByDay(ticket);
    }

    /**
     * 获取某景区今年每天的票务统计情况（全部）
     * @param ticket
     * @return
     */
    @Override
    public List<TicketMoney> GetAllTicketInfoByDay(Ticket ticket) {
        return this.ticketDao.GetAllTicketInfoByDay(ticket);
    }

    /**
     * 当年每月的销售
     * @param ticket
     * @return
     */
    @Override
    public List<TicketMoney> GetTicketInfoByMonth(Ticket ticket) {
        return this.ticketDao.GetTicketInfoByMonth(ticket);
    }


    /**
     * 返回最近五年的票务销售信息
     * @param ticket
     * @return
     */
    @Override
    public List<TicketMoney> GetTicketInfoFiveYear(Ticket ticket) {
        return this.ticketDao.GetTicketInfoFiveYear(ticket);
    }

    /**
     * 按买票游客名字查询
     * @param visitervo
     * @return
     */
    @Override
    public List<visiterVo> searchByName(visiterVo visitervo) {
        return this.ticketDao.searchByName(visitervo);
    }

    /**
     * 工作人员按买票游客名字查询
     * @param visitervo
     * @return
     */
    @Override
    public List<visiterVo> staffsearchByName(visiterVo visitervo) {
        return this.ticketDao.staffsearchByName(visitervo);
    }

    /**
     * 景区入区人数计数
     * @param ticket
     * @return
     */
    @Override
    public InOutNum countScenicIn(Ticket ticket) {
        return this.ticketDao.countScenicIn(ticket);
    }

    /**
     * 景区离区人数计数
     * @param ticket
     * @return
     */
    @Override
    public InOutNum countScenicOut(Ticket ticket) {
        return this.ticketDao.countScenicOut(ticket);
    }

    @Override
    public List<TicketScenic> showTickets(Long userId) {
        return this.ticketDao.showTickets(userId);
    }



    /**
     * 更新票的状态
     */

    //@Scheduled(cron = "*/5 * * * * ?")
    @Scheduled(cron = "0 59 23 * * ?") //每天23：59执行一次
    @Override
    public int updateStatus(){
        String dateString = DateUtil.getStringDateShort(); //yyyy-mm-dd
        String[] dateStringTemp = dateString.split("-",3);
        System.out.println(Integer.valueOf(dateStringTemp[0]).intValue());
        System.out.println(Integer.valueOf(dateStringTemp[1]).intValue());
        System.out.println(Integer.valueOf(dateStringTemp[2]).intValue());
        ticketDao.changeStatus(Integer.valueOf(dateStringTemp[0]).intValue(),Integer.valueOf(dateStringTemp[1]).intValue(),Integer.valueOf(dateStringTemp[2]).intValue());
        return 1;

    }

    /**
     * 游客使用票
     * @param ticketId
     * @return
     */
    @Override
    public boolean useTicket(Long ticketId){
        return this.ticketDao.useTicket(ticketId);
    };

}
