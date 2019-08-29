package com.cubic.service;

import com.cubic.dao.AccountDAO;
import com.cubic.dao.ProjectDAO;
import com.cubic.model.Account;
import com.cubic.model.Project;
import com.curbic.base.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ProjectService {
    @Autowired
    private ProjectDAO projectDAO;

    public void insertProject(Project project){
        projectDAO.insert(project);
    }

}
