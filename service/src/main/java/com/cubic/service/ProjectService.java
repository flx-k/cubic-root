package com.cubic.service;

import com.cubic.dao.ProjectDAO;
import com.cubic.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class ProjectService{
    @Autowired
    private ProjectDAO projectDAO;

    public void insertProject(Project project){
        projectDAO.insert(project);
    }

}
