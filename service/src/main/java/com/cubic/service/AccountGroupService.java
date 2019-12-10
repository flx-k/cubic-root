package com.cubic.service;

import com.cubic.dao.AccountGroupDAO;
import com.cubic.dao.GroupMemberDAO;
import com.cubic.dao.plug.PlugDAO;
import com.cubic.model.Account;
import com.cubic.model.GroupMember;
import com.cubic.model.Groups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class AccountGroupService {
    @Autowired
    private GroupMemberDAO groupMemberDAO;
    @Autowired
    private PlugDAO plugDAO;
    @Autowired
    private AccountGroupDAO accountGroupDAO;
    public List<Account> getAccount(String name){
        return accountGroupDAO.selectAccount(name);
    }
    public List<Groups> getGroups(String name){
        return accountGroupDAO.selectGroups(name);
    }

}
