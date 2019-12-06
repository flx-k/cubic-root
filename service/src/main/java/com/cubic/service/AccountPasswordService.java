package com.cubic.service;

import com.cubic.dao.AccountDAO;
import com.cubic.dao.AccountPasswordDAO;
import com.cubic.model.Account;
import com.cubic.model.AccountPassword;
import com.cubic.util.base.SimpleParam;
import com.cubic.util.base.StringUtil;
import com.cubic.util.exception.CantDoException;
import com.cubic.util.exception.ExistException;
import com.cubic.util.exception.NotExistException;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public final class AccountPasswordService {
    @Autowired
    private AccountDAO accountDAO;
    @Autowired
    private AccountPasswordDAO accountPasswordDAO;

    public boolean update(String account, AccountPassword.ChangePassword changePassword) throws CantDoException, NotExistException {
        String oldPassword=changePassword.oldPassword;
        String newPassword=changePassword.newPassword;
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        AccountPassword accountPassword=accountPasswordDAO.getByName(new AccountPassword(account,oldPassword));
        if(null==accountPassword)
            throw new NotExistException("帐号");
        if(!bCryptPasswordEncoder.matches(oldPassword,accountPassword.getPwd()))
            throw new CantDoException("密码错误");
        newPassword=bCryptPasswordEncoder.encode(newPassword);
        SimpleParam simpleParam=new SimpleParam();
        simpleParam.setClassName(AccountPassword.class.getSimpleName());
        Map where=new HashMap<>();
        where.put("name",account);
        Map set=new HashMap<>();
        set.put("pwd",newPassword);
        set.put("update_time",new Timestamp(new Date().getTime()));
        simpleParam.setWhere(where);
        simpleParam.setSet(set);
        accountPasswordDAO.update(simpleParam);
        return true;
    }


}
