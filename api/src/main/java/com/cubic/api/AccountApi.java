package com.cubic.api;

import com.cubic.model.Account;
import com.cubic.model.AccountPassword;
import com.cubic.service.AccountGroupService;
import com.cubic.service.AccountPasswordService;
import com.cubic.service.AccountService;
import com.cubic.util.base.Result;
import com.cubic.util.base.StringUtil;
import com.cubic.util.exception.CantDoException;
import com.cubic.util.exception.ExistException;
import com.cubic.util.exception.NotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 成员 增 删 改  简单查
 */
@RestController
public class AccountApi {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountPasswordService accountPasswordService;
    @RequestMapping("/user/create")
    public Map register(@RequestParam Account account){

        try {
            return new Result(accountService.insertUser(account)).toMap();
        } catch (ExistException e) {
            return new Result(e.getMessage()).toMap();
        }

    }
    @RequestMapping("/user/register/{name}")
    public Map register(@PathVariable("name") String name,@RequestParam String password){
        Account account=new Account();
        account.setName(name);
        account.setPwd(password);
        try {
            return new Result(accountService.insertUser(account)).toMap();
        } catch (ExistException e) {
            return new Result(e.getMessage()).toMap();
        }
    }
    @RequestMapping("/user/name/{name}")
    public Map getByName(@PathVariable("name") String name){
        try {
            return new Result(accountService.getByName(name)).toMap();
        } catch (NotExistException e) {
            return new Result(e.getMessage()).toMap();
        }
    }
    @RequestMapping("/user/change_password/{name}")
    public Map changePassword(@PathVariable("name") String name, @RequestParam AccountPassword.ChangePassword changePassword){
        try {
            return new Result(accountPasswordService.update(name,changePassword)).toMap();
        } catch (CantDoException e) {
            return new Result(e.getMessage()).toMap();
        } catch (NotExistException e) {
            return new Result(e.getMessage()).toMap();
        }
    }



}
