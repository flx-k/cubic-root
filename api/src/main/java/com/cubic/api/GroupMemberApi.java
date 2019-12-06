package com.cubic.api;

import com.cubic.service.GroupMemberService;
import com.cubic.util.base.Result;
import com.cubic.util.exception.ExistException;
import com.cubic.util.exception.NotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 成员 增 删 改
 */
@RestController
public class GroupMemberApi {
    @Autowired
    private GroupMemberService groupMemberService;
    @RequestMapping("/group/bind/{groupName}/{userName}")
    public Map bind(@PathVariable("groupName") String gname, @PathVariable("userName") String uname){
        try {
            return new Result( groupMemberService.bind(gname, uname)).toMap();
        } catch (NotExistException e) {
            return new Result(e.getMessage()).toMap();
        } catch (ExistException e) {
            return new Result(e.getMessage()).toMap();
        }
    }


}
