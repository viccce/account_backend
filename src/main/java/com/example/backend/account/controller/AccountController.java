package com.example.backend.account.controller;

import com.example.backend.account.service.AccountService;
import com.example.backend.account.vo.AccountLineVo;
import com.example.backend.account.vo.AccountUserRelationVo;
import com.example.backend.account.vo.AccountVo;
import com.example.backend.constant.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Result<List<AccountVo>> findList(@RequestBody AccountVo account){
        List<AccountVo> list = accountService.findList(account);
        Result<List<AccountVo>> result = new Result<>();
        result.setMessage("success");
        result.setResultCode("0");
        result.setResult(list);
        return result;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Result<AccountVo> doSave(@RequestBody AccountVo account){
        accountService.doSave(account);
        Result<AccountVo> result = new Result<>();
        result.setMessage("success");
        result.setResultCode("0");
        return result;
    }

    @RequestMapping(value = "/saveline", method = RequestMethod.POST)
    @ResponseBody
    public Result<AccountLineVo> doSaveDetail(@RequestBody AccountLineVo line){
        accountService.doSaveDetail(line);
        Result<AccountLineVo> result = new Result<>();
        result.setMessage("success");
        result.setResultCode("0");
        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result<AccountVo> deDelete(@RequestBody AccountVo account){
        accountService.doDelete(account);
        Result<AccountVo> result = new Result<>();
        result.setMessage("success");
        result.setResultCode("0");
        return result;
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    @ResponseBody
    public Result<AccountVo> deDetail(@RequestBody AccountVo account){
        AccountVo accountVo = accountService.doDetail(account);
        Result<AccountVo> result = new Result<>();
        result.setMessage("success");
        result.setResultCode("0");
        result.setResult(accountVo);
        return result;
    }

    @RequestMapping(value = "/changeuser", method = RequestMethod.POST)
    @ResponseBody
    public Result<AccountVo> changeUser(@RequestBody AccountUserRelationVo account){
        accountService.changeUser(account);
        Result<AccountVo> result = new Result<>();
        result.setMessage("success");
        result.setResultCode("0");
        return result;
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.POST)
    @ResponseBody
    public Result<List<AccountUserRelationVo>> findUserList(@RequestBody AccountUserRelationVo account){
        List<AccountUserRelationVo> list = accountService.getAccountUserList(account);
        Result<List<AccountUserRelationVo>> result = new Result<>();
        result.setMessage("success");
        result.setResultCode("0");
        result.setResult(list);
        return result;
    }
}
