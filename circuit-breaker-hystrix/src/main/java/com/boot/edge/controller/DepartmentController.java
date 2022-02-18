package com.boot.edge.controller;

import com.boot.edge.enums.Department;
import com.boot.edge.model.Employee;
import com.boot.edge.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;


    @GetMapping("/java-employees")
    @CrossOrigin("*")
    public Collection<Employee> getJavaEmployee() throws Exception {
        Collection<Employee> ct = departmentService.getEmployeesByCriteria(c -> c.getDept() == Department.JAVA);
//        System.out.println(ct.isEmpty());
        return ct;
    }


    @GetMapping("/ms-employees")
    @CrossOrigin("*")
    public Collection<Employee> getMSEmployee() throws Exception {
        return departmentService.getEmployeesByCriteria(c -> c.getDept() == Department.MS);
    }


    @GetMapping("/etl-employees")
    @CrossOrigin("*")
    public Collection<Employee> getETLEmployee() throws Exception {
        return departmentService.getEmployeesByCriteria(c -> c.getDept() == Department.ETL);
    }

}
