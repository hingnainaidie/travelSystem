package com.cqu.travelsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.cqu.travelsystem.Vo.InOutNum;
import com.cqu.travelsystem.entity.Ticket;
import com.cqu.travelsystem.entity.User;
import com.cqu.travelsystem.service.ScenicService;
import com.cqu.travelsystem.service.TicketService;
import com.cqu.travelsystem.utils.DateUtil;
import com.cqu.travelsystem.utils.result.DataResult;
import com.cqu.travelsystem.Vo.CountVo;
import com.cqu.travelsystem.Vo.visiterVo;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (Ticket)表控制层
 *
 * @author makejava
 * @since 2022-06-25 09:59:33
 */
@RestController
@RequestMapping("ticket")
public class TicketController {
    /**
     * 服务对象
     */
    @Resource
    private TicketService ticketService;

    @Resource
    private ScenicService scenicService;


    private CountVo countVo;
    /**
     * 分页查询
     *
     * @param ticket 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Ticket>> queryByPage(Ticket ticket, PageRequest pageRequest) {
        return ResponseEntity.ok(this.ticketService.queryByPage(ticket, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Ticket> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.ticketService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param ticket 实体
     * @return 新增结果
     */
    @PostMapping("BuyTicket")
    public DataResult add(@RequestBody Ticket ticket) {
        System.out.println(ticket.toString());
        Ticket result = this.ticketService.insert(ticket);

        return DataResult.successByData(result);
    }

    /**
     * 编辑数据
     *
     * @param ticket 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Ticket> edit(Ticket ticket) {
        return ResponseEntity.ok(this.ticketService.update(ticket));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.ticketService.deleteById(id));
    }


    /**
     * 获取某天的已销售票数
     * @param ticket
     * @return
     */
    @PostMapping("CountTicketNumByDay")
    public DataResult CountTicketNumByDay(@RequestBody Ticket ticket){
        System.out.println(ticket.toString());
        System.out.println("查询结果");
//        System.out.println("查询结果："+this.ticketService.CountTicketNumByDay(ticket));
        countVo = new CountVo(this.ticketService.CountTicketNumByDay(ticket));
        System.out.println(countVo);
        return DataResult.successByData(countVo);
        //return ResponseEntity.ok(new TicketCount(this.ticketService.CountTicketNumByDay(ticket)));
    }

    /**
     * 获取某景区当月每天的票务统计情况
     * @param ticket
     * @return
     */
    @PostMapping("GetAllTicketInfoByDay")
    public DataResult GetAllTicketInfoByDay(@RequestBody Ticket ticket){
        return DataResult.successByDataArray(this.ticketService.GetAllTicketInfoByDay(ticket));
    }

    /**
     * 当年每月的销售
     * @param ticket
     * @return
     */
    @PostMapping("GetTicketInfoByMonth")
    public DataResult GetTicketInfoByMonth(@RequestBody Ticket ticket){
        System.out.println(ticket);
        return DataResult.successByDataArray(this.ticketService.GetTicketInfoByMonth(ticket));
    }

    /**
     * 返回最近五年的票务销售信息
     * @param ticket
     * @return
     */
    @PostMapping("GetTicketInfoFiveYear")
    public DataResult GetTicketInfoFiveYear(@RequestBody Ticket ticket){
        return DataResult.successByDataArray(this.ticketService.GetTicketInfoFiveYear(ticket));
    }

    /**
     * 按买票游客名字查询
     */
    @PostMapping("searchByName")
    public DataResult searchByName(@RequestBody visiterVo visitervo) {
        List<visiterVo> visitorVoList = this.ticketService.searchByName(visitervo);

        for(int i = 0; i < visitorVoList.size(); i++)
        {
            visitorVoList.get(i).setUsetime();
        }
        return DataResult.successByDataArray(visitorVoList);
    }

    /**
     * 工作人员按买票游客名字查询
     */
    @PostMapping("staffsearchByName")
    public DataResult staffsearchByName(@RequestBody visiterVo visitervo) {
        List<visiterVo> visitorVoList = this.ticketService.staffsearchByName(visitervo);

        for(int i = 0; i < visitorVoList.size(); i++)
        {
            visitorVoList.get(i).setUsetime();
        }
        return DataResult.successByDataArray(visitorVoList);
    }

    /**
     * 景区入区人数计数
     * @param ticket
     * @return
     */
    @PostMapping("countScenicIn")
    public DataResult countScenicIn(@RequestBody Ticket ticket){
        System.out.println("ticket.toString()");
        System.out.println(ticket.toString());
        InOutNum inOutNum = this.ticketService.countScenicIn(ticket);
        System.out.println("inOutNum:"+inOutNum.toString());
        return DataResult.successByData(inOutNum);
    }

    /**
     * 景区离区人数计数
     * @param ticket
     * @return
     */
    @PostMapping("countScenicOut")
    public DataResult countScenicOut(@RequestBody Ticket ticket){
        return DataResult.successByData(this.ticketService.countScenicOut(ticket));
    }

    @PostMapping(value = "showTickets")
    public DataResult showTickets(@RequestBody User user) {
        return DataResult.successByDataArray(this.ticketService.showTickets(user.getUserId()));
    }


    @PostMapping("useTicket")
    public DataResult useTicket(@RequestBody Ticket ticket){
        String dateString = DateUtil.getStringDateShort(); //yyyy-mm-dd
        String[] dateStringTemp = dateString.split("-",3);
        Integer year=Integer.valueOf(dateStringTemp[0]).intValue();
        Integer month=Integer.valueOf(dateStringTemp[1]).intValue();
        Integer day=Integer.valueOf(dateStringTemp[2]).intValue();
        JSONObject jsonObject = new JSONObject();
        if(year.equals(ticket.getTicketUsetimeYear())&&month.equals(ticket.getTicketUsetimeMonth())&&day.equals(ticket.getTicketUsetimeDay())){
            jsonObject.put("isSuccess", this.ticketService.useTicket(ticket.getTicketId()));
            jsonObject.put("error", "使用失败");
        }else{
            jsonObject.put("isSuccess",false);
            jsonObject.put("error", "使用日期不对");
        }
        return DataResult.successByData(jsonObject);
    }



}

