package com.cubic.api;

import com.cubic.service.AccountGroupService;
import com.cubic.util.base.Result;
import com.cubic.util.exception.ExistException;
import com.cubic.util.exception.NotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AccountGroupApi {

    @Autowired
    private AccountGroupService accountGroupService;

    @RequestMapping("/user/desc/list")
    public Map listAccounts() {
        return new Result(accountGroupService.getAccount(null)).toMap();

    }

    @RequestMapping("/user/{name}/desc")
    public Map getAccount(@PathVariable("name") String name) {
        List list = accountGroupService.getAccount(name);
        if (list.size() > 0)
            return new Result(list.get(0)).toMap();
        else
            return new Result("未找到:" + name).toMap();
    }

    @RequestMapping("/group/desc/list")
    public Map descGroups() {
        return new Result(accountGroupService.getGroups(null)).toMap();
    }

    @RequestMapping("/group/{name}/desc")
    public Map getGroup(@PathVariable("name") String name) {
        List list = accountGroupService.getGroups(name);
        if (list.size() > 0)
            return new Result(list.get(0)).toMap();
        else
            return new Result("未找到:" + name).toMap();
    }

}
