package com.example.backend.user.controller;

import com.example.backend.constant.Result;
import com.example.backend.user.service.UserService;
import com.example.backend.user.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 登录
     * @param user 用户信息
     * @return 登录结果
     */
    @RequestMapping(value = "login/mobile={mobile}&password={password}", method = RequestMethod.GET)
    @ResponseBody
    public Result<UserVo> login(@PathVariable String mobile, @PathVariable String password){
        UserVo user = new UserVo();
        user.setMobile(mobile);
        user.setPassword(password);
        Result<UserVo> result = new Result<>();
        UserVo loginResult = userService.login(user);
        if(loginResult != null){
            result.setResultCode("0");
            result.setMessage("success");
            result.setResult(loginResult);
        }else{
            result.setMessage("登录失败");
        }
        return result;
    }

    /**
     * 获取用户详情
     * @param user 用户参数
     * @return 用户信息
     */
    @RequestMapping(value = "detail", method = RequestMethod.POST)
    @ResponseBody
    public Result<UserVo> doDetail(@RequestBody UserVo user) {
        Result<UserVo> result = new Result<>();
        UserVo userVo = userService.doDetail(user);
        result.setResultCode("0");
        result.setMessage("success");
        result.setResult(userVo);
        return result;
    }

    /**
     * 保存用户
     * @param user 用户参数
     * @return 保存结果
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public Result<UserVo> doSave(@RequestBody UserVo user) {
        Result<UserVo> result = new Result<>();
        userService.save(user);
        result.setResultCode("0");
        result.setMessage("success");
        return result;
    }


}
