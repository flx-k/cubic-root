package com.cubic.dao;

import com.cubic.dao.base.BaseDAO;
import com.cubic.model.Account;
import com.cubic.model.Groups;

import java.util.List;

public interface AccountGroupDAO{

    List<Account> selectAccount();

    List<Groups> selectGroups();
}
