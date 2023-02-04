package com.cqu.travelsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.cqu.travelsystem.entity.User;
import com.cqu.travelsystem.service.UserService;
import com.cqu.travelsystem.utils.result.DataResult;
import com.cqu.travelsystem.Vo.UserVo;
import com.cqu.travelsystem.Vo.visiterVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static com.cqu.travelsystem.utils.result.code.Code.ACCOUNT_ERROR;
import static com.cqu.travelsystem.utils.result.code.Code.ACCOUNT_REPET;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2022-06-25 09:53:54
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<User>> queryByPage(User user, PageRequest pageRequest) {
        return ResponseEntity.ok(this.userService.queryByPage(user, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public DataResult queryById(@PathVariable("id") Long id) {
        return DataResult.successByData(this.userService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<User> add(User user) {
        return ResponseEntity.ok(this.userService.insert(user));
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<User> edit(User user) {
        return ResponseEntity.ok(this.userService.update(user));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.userService.deleteById(id));
    }

    /**
     * 登录系统
     */
    @PostMapping("loginSystem")
    public DataResult loginSystem(@RequestBody UserVo UserVo)  {

        System.out.println(UserVo.toString());
        UserVo loginUser = this.userService.loginSystem(UserVo);
        System.out.println(loginUser);
        if(loginUser != null){
            return DataResult.successByData(loginUser);
        }
        else
        {
            return DataResult.errByErrCode(ACCOUNT_ERROR);
        }

    }

    /**
     * 注册
     */
    @PostMapping("register")
    public DataResult register(@RequestBody User user)  {

        User dataBaseUser = this.userService.searchForUser(user);
        System.out.println(dataBaseUser);
        if(dataBaseUser == null)
        {
            System.out.println(user.toString());
            return DataResult.successByData(this.userService.insert(user));
        }
        else
        {
            return DataResult.errByErrCode(ACCOUNT_REPET);
        }




    }

    /**
     * 查看所有游客信息
     */
    @GetMapping("searchForAllVisitors")
    public DataResult searchForAllVisitors(){
        List<visiterVo> visitorVoList = this.userService.searchForAllVisitors();

        for(int i = 0; i < visitorVoList.size(); i++)
        {
            visitorVoList.get(i).setUsetime();
        }
        System.out.println(visitorVoList.toString());
        return DataResult.successByDataArray(visitorVoList);
    }

    /**
     * 员工查看所有游客信息
     */
    @PostMapping("staffsearchForAllVisitors")
    public DataResult staffsearchForAllVisitors(@RequestBody visiterVo visitervo){
        List<visiterVo> visitorVoList = this.userService.staffsearchForAllVisitors(visitervo);

        for(int i = 0; i < visitorVoList.size(); i++)
        {
            visitorVoList.get(i).setUsetime();
        }
        System.out.println(visitorVoList.toString());
        return DataResult.successByDataArray(visitorVoList);
    }

    /**
     * 电话号码查看买票
     * @param visitervo
     * @return
     */
    @PostMapping("searchByPhone")
    public DataResult searchByPhone(@RequestBody visiterVo visitervo){
        List<visiterVo> visitorVoList = this.userService.searchByPhone(visitervo);

        for(int i = 0; i < visitorVoList.size(); i++)
        {
            visitorVoList.get(i).setUsetime();
        }
        return DataResult.successByDataArray(visitorVoList);
    }

    /**
     * 员工人员通过电话号码查看买票
     * @param visitervo
     * @return
     */
    @PostMapping("staffsearchByPhone")
    public DataResult staffsearchByPhone(@RequestBody visiterVo visitervo){
        List<visiterVo> visitorVoList = this.userService.staffsearchByPhone(visitervo);

        for(int i = 0; i < visitorVoList.size(); i++)
        {
            visitorVoList.get(i).setUsetime();
        }
        return DataResult.successByDataArray(visitorVoList);
    }

    /**
     * 景区名称查看买票
     * @param visitervo
     * @return
     */
    @PostMapping("searchByScenic")
    public DataResult searchByScenic(@RequestBody visiterVo visitervo){
        List<visiterVo> visitorVoList = this.userService.searchByScenic(visitervo);

        for(int i = 0; i < visitorVoList.size(); i++)
        {
            visitorVoList.get(i).setUsetime();
        }
        return DataResult.successByDataArray(visitorVoList);
    }

    /**
     * 工作人员通过景区名称查看买票
     * @param visitervo
     * @return
     */
    @PostMapping("staffsearchByScenic")
    public DataResult staffsearchByScenic(@RequestBody visiterVo visitervo){
        List<visiterVo> visitorVoList = this.userService.staffsearchByScenic(visitervo);

        for(int i = 0; i < visitorVoList.size(); i++)
        {
            visitorVoList.get(i).setUsetime();
        }
        return DataResult.successByDataArray(visitorVoList);
    }

    /**
     * 使用时间查看买票
     * @param visitervo
     * @return
     */
    @PostMapping("searchByUseTime")
    public DataResult searchByUseTime(@RequestBody visiterVo visitervo){
        List<visiterVo> visitorVoList = this.userService.searchByUseTime(visitervo);

        for(int i = 0; i < visitorVoList.size(); i++)
        {
            visitorVoList.get(i).setUsetime();
        }
        return DataResult.successByDataArray(visitorVoList);
    }

    /**
     * 工作人员通过使用时间查看买票
     * @param visitervo
     * @return
     */
    @PostMapping("staffsearchByUseTime")
    public DataResult staffsearchByUseTime(@RequestBody visiterVo visitervo){
        List<visiterVo> visitorVoList = this.userService.staffsearchByUseTime(visitervo);

        for(int i = 0; i < visitorVoList.size(); i++)
        {
            visitorVoList.get(i).setUsetime();
        }
        return DataResult.successByDataArray(visitorVoList);
    }


    @PostMapping(value = "editInfo")
    public DataResult editInfo(@RequestBody User user){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isSuccess", this.userService.editInfo(user));
        return DataResult.successByData(jsonObject);
    }

    @PostMapping(value = "editPwd")
    public DataResult editPwd(@RequestBody Map<String,Object> param){
        String userPwd=param.get("userPwd").toString();
        String newPwd=param.get("newPwd").toString();
        long userId=Integer.parseInt(param.get("userId").toString());
        JSONObject jsonObject = new JSONObject();
        User user=this.userService.searchPwd(userId);
        System.out.println(user.getUserPassword());
        System.out.println(userPwd);
        if(user.getUserPassword().equals(userPwd)){
            jsonObject.put("isSuccess", this.userService.editPwd(userId,newPwd));
            jsonObject.put("error", "修改失败");
        }else{
            jsonObject.put("isSuccess", false);
            jsonObject.put("error", "旧密码错误");
        }
        return DataResult.successByData(jsonObject);
    }

    /**
     * 查看所有员工信息
     * @return
     */
    @GetMapping("getStaffList")
    public DataResult getStaffList(){
        return DataResult.successByDataArray(this.userService.getStaffList());

    }


    /**
     * 删除员工信息
     * @param user
     * @return
     */
    @PostMapping("deleteStaff")
    public DataResult deleteStaff(@RequestBody User user){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isSuccess", this.userService.deleteStaff(user.getUserId()));
        return DataResult.successByData(jsonObject);
    }

    /**
     * 修改员工信息
     * @param user
     * @return
     */
    @PostMapping("editStaffInfo")
    public DataResult editStaffInfo(@RequestBody User user){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isSuccess", this.userService.editStaffInfo(user));
        return DataResult.successByData(jsonObject);
    }


}

