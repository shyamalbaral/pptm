package com.barals.ppmt.ppmttool.web;

import com.barals.ppmt.ppmttool.domain.Project;
import com.barals.ppmt.ppmttool.services.MapValidationErrorService;
import com.barals.ppmt.ppmttool.services.ProjectService;
//import net.bytebuddy.implementation.FieldAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService  projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid  @RequestBody Project project , BindingResult result){
        ResponseEntity<?> errormap= mapValidationErrorService.mapValidationError(result);
        if(null !=errormap) return errormap;
        Project project1=projectService.saveOrUpdate(project);
        return new ResponseEntity<Project>(project1 , HttpStatus.CREATED);
    }




}
