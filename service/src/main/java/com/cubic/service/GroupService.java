package com.cubic.service;

import com.cubic.dao.GroupDAO;
import com.cubic.model.Groups;
import com.cubic.util.base.SimpleParam;
import com.cubic.util.base.StringUtil;
import com.cubic.util.exception.ExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public final class GroupService {
    @Autowired
    private GroupDAO groupDAO;


    public boolean create(Groups group) throws ExistException {
        group=groupDAO.getByName(group);
        if(null!=group)
            throw new ExistException("团队");
        group.setId("GROUP_"+StringUtil.buildID());
        groupDAO.insert(group);
        return true;
    }
    public boolean create(String name) throws ExistException {
        Groups group= Groups.buidByName(name);
        if(null!=groupDAO.getByName(group))
            throw new ExistException("团队");
        group.setId("GROUP_"+StringUtil.buildID());
        group.setCreateTime(new Timestamp(new Date().getTime()));
        groupDAO.insert(group);
        return true;
    }
    public void delete(Groups group){
        groupDAO.delete(group);
    }
    public Groups getByName(String name){
        return groupDAO.getByName(Groups.buidByName(name));
    }
    public Groups getById(String name){
        return groupDAO.getById(Groups.buidById(name));
    }
    public List<Groups> list(SimpleParam simpleParam){
        return groupDAO.select(simpleParam);
    }

}
