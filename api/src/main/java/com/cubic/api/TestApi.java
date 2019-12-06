package com.cubic.api;

import com.cubic.model.Account;
import com.cubic.service.AccountService;
import com.cubic.service.TestService;
import com.cubic.util.base.StringUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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





}
