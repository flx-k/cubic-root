package com.cubic.api;

import com.cubic.base.ExceptionHandle;
import com.cubic.base.JARChange;
import com.cubic.service.AccountService;
import com.cubic.service.PlugService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PlugApi {
    Logger logger= LogManager.getLogger(PlugApi.class);
    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/plug/add/{plugName}")
    public String plugAdd(@PathVariable("plugName") String plugName, @RequestParam String name) throws Exception {
        logger.info("testPlug");
        return plugName+"::"+name;
    }
    @RequestMapping("/plug/delete/{plugName}")
    public String plugDelete(@PathVariable("plugName") String plugName, @RequestParam String name) throws Exception {
        logger.info("testPlug");
        return plugName+"::"+name;
    }
    @RequestMapping("/plug/update/{plugName}")
    public String plugUpdate(@PathVariable("plugName") String plugName, @RequestParam String name) throws Exception {
        logger.info("testPlug");
        return plugName+"::"+name;
    }
    @RequestMapping("/plug/get/{plugName}")
    public String plugGet(@PathVariable("plugName") String plugName, @RequestParam String name) throws Exception {
        logger.info("testPlug");
        return plugName+"::"+name;
    }
    @RequestMapping("/plug/list/{plugName}")
    public Map<String, Object> plugList(@PathVariable("plugName") String plugName, @RequestParam String name) throws Exception {
        logger.info("testPlug");
        Map<String,Object> map=new HashMap<>();
        try {
            String classname;
            try{
                classname = JARChange.getClassName(plugName);
            }catch (Exception e){
                classname = "accountService";
            }
            PlugService testImp= (PlugService) applicationContext.getBean(classname);
            map.put("datas", testImp.sql_select("admin"));
            return map;
        } catch (Exception e) {
            return ExceptionHandle.buildExceptMsg(e);
        }
    }
    @RequestMapping("/test/{plugName}")
    public Map<String, Object> testPlug(@PathVariable("plugName") String plugName) {
        logger.info("testPlug");
        Map<String,Object> map=new HashMap<>();
        try {
            String classname;
            try{
                classname = JARChange.getClassName(plugName);
            }catch (Exception e){
                classname = "accountService";
            }
            AccountService testImp= (AccountService) applicationContext.getBean(classname);
            map.put("datas", testImp.getByName("admin"));
            return map;
        } catch (Exception e) {
            return ExceptionHandle.buildExceptMsg(e);
        }


    }
}
