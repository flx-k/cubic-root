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
        return "true";
    }
    @Autowired
    private ApplicationContext applicationContext;
    @RequestMapping("/test/{plugName}")
    public Map testPlug(@PathVariable("plugName") String plugName) {
        logger.info("testPlug");
        Map<String,Object> map=new HashMap<>();
        try {
            String classname = JARChange.getClassName(plugName);
            for(String str:applicationContext.getBeanDefinitionNames()){
                System.out.println(str);
            }
            System.out.println(applicationContext.getBeanDefinitionNames());
            AccountService testImp= (AccountService) applicationContext.getBean(plugName.toUpperCase());
//            AccountService testImp= (AccountService) ClassUtil.getPlugClass(classname);
//            Account account=new Account();
//            account.setName("admin");
//            map.put("status",true);
            map.put("datas", testImp.getByName("admin"));
            return map;
        } catch (Exception e) {
            return ExceptionHandle.buildExceptMsg(e);
        }


    }

    @RequestMapping("/plug/{plugName}/add")
    public String plugAdd(@PathVariable("plugName") String plugName, @RequestParam String name) throws Exception {
        logger.info("testPlug");
        return plugName+"::"+name;
    }
    @RequestMapping("/plug/{plugName}/delete")
    public String plugDelete(@PathVariable("plugName") String plugName, @RequestParam String name) throws Exception {
        logger.info("testPlug");
        return plugName+"::"+name;
    }
    @RequestMapping("/plug/{plugName}/update")
    public String plugUpdate(@PathVariable("plugName") String plugName, @RequestParam String name) throws Exception {
        logger.info("testPlug");
        return plugName+"::"+name;
    }
    @RequestMapping("/plug/{plugName}/get")
    public String plugGet(@PathVariable("plugName") String plugName, @RequestParam String name) throws Exception {
        logger.info("testPlug");
        return plugName+"::"+name;
    }
    @RequestMapping("/plug/{plugName}/list")
    public String plugList(@PathVariable("plugName") String plugName, @RequestParam String name) throws Exception {
        logger.info("testPlug");
        return plugName+"::"+name;
    }
}
