package com.cubic.service;

import com.cubic.dao.GroupMemberDAO;
import com.cubic.dao.plug.PlugDAO;
import com.cubic.model.GroupMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class AccountGroupService {
    @Autowired
    private GroupMemberDAO groupMemberDAO;
    @Autowired
    private PlugDAO plugDAO;

    public void insertUser(GroupMember groupMember){



    }

}
