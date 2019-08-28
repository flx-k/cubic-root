package com.cubic.api;

import com.cubic.model.Test;
import com.cubic.service.TestService;
import com.curbic.base.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestApi {
    @Autowired
    private TestService testService;

    @RequestMapping("/add")
    public String home(@RequestParam String name)
    {
        testService.insert(name,StringUtil.buildID());
        return "true";
    }
    @RequestMapping("/update")
    public String update(@RequestParam String name)
    {
        testService.update(name);
        return "true";
    }
    @RequestMapping("/list")
    public String list()
    {
        List<Test> list=testService.list();
        for(Test test:list){
            System.out.println("  id:="+test.getId());
            System.out.println("name:="+test.getName());
        }
        return "true";
    }

}
