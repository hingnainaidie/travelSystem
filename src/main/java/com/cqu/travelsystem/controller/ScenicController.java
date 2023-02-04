package com.cqu.travelsystem.controller;

import com.cqu.travelsystem.entity.Scenic;
import com.cqu.travelsystem.entity.Ticket;
import com.cqu.travelsystem.service.ScenicService;
import com.cqu.travelsystem.service.TicketService;
import com.cqu.travelsystem.utils.DateUtil;
import com.cqu.travelsystem.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Scenic)表控制层
 *
 * @author makejava
 * @since 2022-06-25 09:52:48
 */
@RestController
@RequestMapping("scenic")
public class ScenicController {
    /**
     * 服务对象
     */
    @Resource
    private ScenicService scenicService;

    @Resource
    private TicketService ticketService;

    /**
     * 分页查询
     *
     * @param scenic 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Scenic>> queryByPage(Scenic scenic, PageRequest pageRequest) {
        return ResponseEntity.ok(this.scenicService.queryByPage(scenic, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Scenic> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.scenicService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param scenic 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Scenic> add(Scenic scenic) {
        return ResponseEntity.ok(this.scenicService.insert(scenic));
    }

    /**
     * 编辑数据
     *
     * @param scenic 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Scenic> edit(Scenic scenic) {
        return ResponseEntity.ok(this.scenicService.update(scenic));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.scenicService.deleteById(id));
    }

    /**
     * 游客获取景区基本信息
     * @return
     */
    @GetMapping("tGetScenicInfo")
    public DataResult getScenicBasicInfo() {
        List<Scenic> result = this.scenicService.queryAllScenic();
        String dateString = DateUtil.getStringDateShort(); //yyyy-mm-dd
        String[] dateStringTemp = dateString.split("-",3);
        Integer year=Integer.valueOf(dateStringTemp[0]).intValue();
        Integer month=Integer.valueOf(dateStringTemp[1]).intValue();
        Integer day=Integer.valueOf(dateStringTemp[2]).intValue();
        for(int i = 0; i<result.size(); i++)
        {
            Ticket ticket = new Ticket(null,null,result.get(i).getScenicId(),null,year,month,day,null,null);
            int ticketCnt = ticketService.CountTicketNumByDay(ticket);
            System.out.println(ticketCnt);
            Scenic scenic = result.get(i);
            scenic.setScenicCurrentNumber(new Long((long)ticketCnt));
            System.out.println("cnt1:"+scenic.getScenicCurrentNumber());
            result.set(i,scenic);

            System.out.println("count2:"+result.get(i).getScenicCurrentNumber());
        }
        return DataResult.successByDataArray(result);
    }

    /**
     * 值班人员查看景区基本信息
     */
    @PostMapping("queryByName")
    public DataResult queryByName(@RequestBody Scenic scenic) {
        System.out.println("景区名字"+scenic.toString());
        System.out.println("查询结果");
        System.out.println(this.scenicService.queryByName(scenic));
        return DataResult.successByData(this.scenicService.queryByName(scenic));
    }

    /**
     * 根据景区名称找到id
     * @param scenic
     * @return
     */
    @PostMapping("FindscenicIdByName")
    public DataResult FindscenicIdByName(@RequestBody Scenic scenic){
        return DataResult.successByData(this.scenicService.FindscenicIdByName(scenic));
    }
}

