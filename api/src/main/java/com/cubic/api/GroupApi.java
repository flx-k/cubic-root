package com.cubic.api;

import com.cubic.model.Groups;
import com.cubic.service.GroupService;
import com.cubic.util.base.Result;
import com.cubic.util.exception.ExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 组 增 删 改
 */
@RestController
public class GroupApi {
    @Autowired
    private GroupService groupService;

    @RequestMapping("/group/create")
    public Map create(@RequestParam Groups group) {
        try {
            return new Result(groupService.create(group)).toMap();
        } catch (ExistException e) {
            return new Result(e.getMessage()).toMap();
        }
    }
    @RequestMapping("/group/create/{name}")
    public Map create(@PathVariable("name") String name) {
        try {
            return new Result(groupService.create(name)).toMap();
        } catch (ExistException e) {
            return new Result(e.getMessage()).toMap();
        }
    }

    /**
     * 查询
     * @param name
     * @return
     */
    @RequestMapping("/group/name/{name}")
    public Map getByName(@PathVariable("name") String name) {
        return new Result(groupService.getByName(name)).toMap();
    }

    @RequestMapping("/group/id/{id}")
    public Map getById(@PathVariable("id") String id) {
        return new Result(groupService.getByName(id)).toMap();
    }



}
