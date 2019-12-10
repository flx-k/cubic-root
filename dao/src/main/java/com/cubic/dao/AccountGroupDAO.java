package com.cubic.dao;

import com.cubic.dao.base.BaseDAO;
import com.cubic.model.Account;
import com.cubic.model.Groups;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountGroupDAO{

    List<Account> selectAccount(@Param("name") String name);

    List<Groups> selectGroups(@Param("name") String name);

}
