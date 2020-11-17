package com.barals.ppmt.ppmttool.services;

import com.barals.ppmt.ppmttool.domain.Project;
import com.barals.ppmt.ppmttool.exceptions.ProjectIDException;
import com.barals.ppmt.ppmttool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdate(Project project){
        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch(Exception ex){
            throw new ProjectIDException("project Id :"+project.getProjectIdentifier().toUpperCase()+"already exits ");
        }

    }
}
