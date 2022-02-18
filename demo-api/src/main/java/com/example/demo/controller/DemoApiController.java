package com.example.demo.controller;

import com.example.demo.dto.Department;
import com.example.demo.dto.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class DemoApiController {
    int count = 0;
    @GetMapping("/employees")
    public List<Employee> getData() throws InterruptedException {
        count ++;
        Employee c1  = Employee.builder().name("amit").dept(Department.JAVA).build();
        Employee c2  = Employee.builder().name("amita").dept(Department.MS).build();
        Employee c3  = Employee.builder().name("amits").dept(Department.ETL).build();
        Employee c4  = Employee.builder().name("c").dept(Department.ETL).build();
        Employee c5  = Employee.builder().name("f").dept(Department.JAVA).build();
        Employee c6  = Employee.builder().name("df").dept(Department.ETL).build();
        Employee c7  = Employee.builder().name("hg").dept(Department.MS).build();
        Employee c8  = Employee.builder().name("ds").dept(Department.ETL).build();
        Employee c9  = Employee.builder().name("t").dept(Department.ETL).build();
//        Thread.sleep(1500);
        System.out.println("returning records : " + count);
        return Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9);
//        return new ArrayList<>();
    }
}
