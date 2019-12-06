package com.cubic.service;

import com.cubic.dao.AccountDAO;
import com.cubic.dao.GroupDAO;
import com.cubic.dao.GroupMemberDAO;
import com.cubic.model.Account;
import com.cubic.model.Groups;
import com.cubic.model.GroupMember;
import com.cubic.util.base.StringUtil;
import com.cubic.util.exception.ExistException;
import com.cubic.util.exception.NotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public final class GroupMemberService {
    @Autowired
    private GroupMemberDAO groupMemberDAO;
    @Autowired
    private AccountDAO accountDAO;
    @Autowired
    private GroupDAO groupDAO;


    public boolean insert(String accountId,String groupId) throws NotExistException, ExistException {
        Account account=accountDAO.getOne(Account.buildById(accountId));
        if(null==account)
            throw new NotExistException("账户");
        Groups group=groupDAO.getOne(Groups.buidById(groupId));
        if(null==group)
            throw new NotExistException("团队");
        GroupMember groupMember=new GroupMember();
        groupMember.setGroupId(groupId);
        groupMember.setMemberId(accountId);
        groupMember=groupMemberDAO.getOne(groupMember);
        if(null!=groupMember)
            throw new ExistException("关系");
        groupMember.setId("GROUPMEMBER_"+StringUtil.buildID());
        groupMemberDAO.insert(groupMember);
        return true;
    }
    public boolean bind(String groupName,String userName) throws NotExistException, ExistException {
        Account account=accountDAO.getByName(Account.buildByName(userName));
        if(null==account)
            throw new NotExistException("账户");
        Groups group=groupDAO.getByName(Groups.buidByName(groupName));
        if(null==group)
            throw new NotExistException("团队");
        GroupMember groupMember=new GroupMember();
        groupMember.setMemberId(account.getId());
        groupMember.setGroupId(group.getId());
        if(null!=groupMemberDAO.getOne(groupMember))
            throw new ExistException("关系");
        groupMember.setId("GROUPMEMBER_"+StringUtil.buildID());
        groupMember.setJoinTime(new Timestamp(new Date().getTime()));
        groupMemberDAO.insert(groupMember);
        return true;
    }

    public void delete(GroupMember groupMember){
        GroupMember g2=groupMemberDAO.getOne(groupMember);
        if(null!=g2){
            groupMemberDAO.delete(groupMember);
        }
    }
}
