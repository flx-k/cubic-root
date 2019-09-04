package com.cubic.api;

import com.cubic.base.ClassUtil;
import com.cubic.base.ExceptionHandle;
import com.cubic.base.JARChange;
import com.cubic.dao.AccountDAO;
import com.cubic.exception.NoPlugException;
import com.cubic.imp.TestImp;
import com.cubic.model.Account;
import com.cubic.service.AccountService;
import com.cubic.service.TestService;
import com.cubic.base.StringUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.spring5.context.SpringContextUtils;

import javax.rmi.CORBA.Util;
import java.util.HashMap;
import java.util.Map;


@RestController
public class TestApi{
    Logger logger= LogManager.getLogger(TestApi.class);
    @Autowired
    private TestService testService;
    @Autowired
    private AccountService accountService;

    @RequestMapping("/add")
    public String home(@RequestParam String name)
    {
        logger.info("add");
        testService.insert(name,StringUtil.buildID());
        return "true";
    }
    @RequestMapping("/update")
    public String update(@RequestParam String name)
    {
        logger.info("update");
        testService.update(name);
        return "true";
    }
    @RequestMapping("/list")
    public String list()
    {
        logger.info("list");

        Account account=accountService.getByName("admin");

        System.out.println(account.getAuths());
        accountService.testSQL("SELECT idError querying database. Cause: java.lang.UnsupportedOperationException \r\n" +
                "FROM account");
        return "true";
    }




}
