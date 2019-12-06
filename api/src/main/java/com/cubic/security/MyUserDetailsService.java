package com.cubic.security;

import com.cubic.dao.AccountDAO;
import com.cubic.dao.AccountPasswordDAO;
import com.cubic.model.Account;
import com.cubic.model.AccountPassword;
import com.cubic.service.AccountService;
import com.cubic.util.exception.NotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountPasswordDAO accountPasswordDAO;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        try {
            AccountPassword accountPassword=accountPasswordDAO.getByName(AccountPassword.buildByName(userName));
            Account userDetails=accountService.getByName(userName);
            userDetails.setPwd(accountPassword.getPwd());
            return userDetails;
        } catch (NotExistException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}
