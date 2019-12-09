package com.cubic.api;

import com.cubic.service.AccountGroupService;
import com.cubic.util.base.Result;
import com.cubic.util.exception.ExistException;
import com.cubic.util.exception.NotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AccountGroupApi {

    @Autowired
    private AccountGroupService accountGroupService;

    @RequestMapping("/user/desc/list")
    public Map listAccount(){
        return new Result(accountGroupService.getAccount()).toMap();

    }
    @RequestMapping("/group/desc/list")
    public Map descGroup() {
        return new Result(accountGroupService.getGroups()).toMap();
    }

}
