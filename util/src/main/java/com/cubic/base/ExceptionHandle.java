package com.cubic.base;

import com.cubic.exception.NoPlugException;

import java.util.HashMap;
import java.util.Map;

public class ExceptionHandle {
    public static Map<String,Object> buildExceptMsg(Exception exception){
        Map<String,Object> map=new HashMap<>();
        map.put("status",false);
        if(NoPlugException.class==exception.getClass()){
            map.put("error","插件不存在");
        }else{
            map.put("error","未知错误");
        }
        return map;
    }
}
