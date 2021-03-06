package com.cubic.service;

import com.cubic.dao.AccountDAO;
import com.cubic.dao.AccountPasswordDAO;
import com.cubic.dao.plug.PlugDAO;
import com.cubic.model.Account;
import com.cubic.model.AccountPassword;
import com.cubic.util.base.StringUtil;
import com.cubic.util.exception.ExistException;
import com.cubic.util.exception.NotExistException;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public final class AccountService {
    @Autowired
    private AccountDAO accountDAO;
    @Autowired
    private AccountPasswordDAO accountPasswordDAO;

    public boolean insertUser(Account account) throws ExistException {
        Account account1=accountDAO.getByName(account);
        if(null!=account1)
            throw new ExistException("帐号");
        account.setId("USER_"+StringUtil.buildID());
        account.setAuths("USER");
        account.setPwd(new BCryptPasswordEncoder().encode(account.getPwd()));
        accountPasswordDAO.insert(new AccountPassword(account));
        account.setEnable(true);
        account.setExpired(false);
        account.setCredentialsExpired(false);
        account.setLevel(1);
        account.setLocked(false);
        account.setCreateTime(new Timestamp(System.currentTimeMillis()));
        account.setLastOnlineTime(account.getCreateTime());
        account.setPwd(null);
        accountDAO.insert(account);
        return true;
    }
    public Account getByName(String name) throws NotExistException {
        Account account=accountDAO.getByName(Account.buildByName(name));
        if(null==account){
            throw new NotExistException("帐号");
        }
        return account;
    }
    public void testSQL(String sql){
        Gson g=new Gson();
//        List<Object> ls=accountDAO.sql_select("select id from account");
//        for(Object str:ls){
//            System.out.println((String)str);
//        }
        List ls2=accountDAO.sql_select("select * from test");
        for(Object str:ls2){

            Account a=g.fromJson(g.toJson(str),Account.class);
            System.out.println(a.getId());
        }
//        System.out.println(ls.size());
    }


    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("111111"));
    }
//    public List<Test> list(){
//        return testDAO.sql_select("select * from test" );
//    }
}
