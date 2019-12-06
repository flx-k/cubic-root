package com.cubic.service;

import com.cubic.dao.TestDAO;
import com.cubic.model.Test;
import com.cubic.util.base.SimpleParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public final class TestService {
    @Autowired
    private TestDAO testDAO;

    public void insert(String name,String id){
        Test test=new Test();
        test.setId(id);
        test.setName(name);
        testDAO.insert(test);
    }
    public void update(String name){
        SimpleParam simpleParam=new SimpleParam();
        simpleParam.setClassName("Test");
        Map<String,Object> map=new HashMap<>(),map1=new HashMap<>();
        map.put("id",name);
        map1.put("name",name);
        simpleParam.setSet(map1);
        simpleParam.setWhere(map);
        testDAO.update(simpleParam);
    }
//    public List<Test> list(){
//        return testDAO.sql_select("select * from test" );
//    }
}
