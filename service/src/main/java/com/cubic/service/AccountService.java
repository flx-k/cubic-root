package com.cubic.service;

import com.cubic.dao.AccountDAO;
import com.cubic.model.Account;
import com.curbic.base.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class AccountService {
    @Autowired
    private AccountDAO accountDAO;

    public void insertUser(Account account){
        account.setAuths("USER");
        account.setPwd(new BCryptPasswordEncoder().encode(account.getPwd()));
        account.setEnable(true);
        account.setExpired(false);
        account.setCredentialsExpired(false);
        account.setLevel(1);
        account.setLocked(false);
        account.setCreateTime(new Timestamp(System.currentTimeMillis()));
        account.setLastOnlineTime(account.getCreateTime());
        account.setId("USER_"+StringUtil.buildID());
        accountDAO.insert(account);
    }
    public Account getByName(String name){
        Account account=new Account();
        account.setName(name);
        return accountDAO.getOne(account);
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("111111"));
    }
//    public List<Test> list(){
//        return testDAO.sql_select("select * from test" );
//    }
}
