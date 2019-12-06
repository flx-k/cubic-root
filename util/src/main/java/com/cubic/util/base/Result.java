package com.cubic.util.base;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by yf on 2019/11/8.
 */
public class Result implements Serializable {
    private boolean status;
    private String message;
    private Long count;
    private Object datas;

    public Result(boolean status, Long count, List datas) {
        this.status=status;
        this.count = count;
        this.datas = datas;
    }
    public Result(boolean status, String message) {
        this.status=status;
        this.message=message;
    }

    public Result(boolean status) {
        this.status = status;
        this.message="操作成功";
    }

    public Result(String message) {
        this.status=false;
        this.message = message;
    }

    public Result(Object datas) {
        this.status=true;
        this.datas = datas;
    }

    public Map toMap(){
        Gson g=new Gson();
        return g.fromJson(g.toJson(this),Map.class);
    }
}
