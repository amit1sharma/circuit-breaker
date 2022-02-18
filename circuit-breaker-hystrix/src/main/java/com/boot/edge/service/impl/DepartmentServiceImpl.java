package com.boot.edge.service.impl;

import com.boot.edge.model.Employee;
import com.boot.edge.rest.EmployeeClient;
import com.boot.edge.service.DepartmentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    /*Predicate<Customer> java = c -> c.getDept() == Department.JAVA;

    Predicate<Customer> ms = c -> c.getDept()== Department.MS;

    Predicate<Customer> etl = c -> c.getDept()== Department.ETL;*/

    private final EmployeeClient employeeClient;

    int count = 0;

    long startTime= 0l;

    @Override
    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "1000"),

            @HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD, value="5"),
            @HystrixProperty(name=HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE, value="30")
    })

    public List<Employee> getEmployeesByCriteria(Predicate<Employee> p) throws Exception {
        startTime = System.currentTimeMillis();
        Employee[] employees = employeeClient.getEmployees();
        if(employees.length >0) {
            return Arrays.stream(employees)
                    .filter(p)
                    .collect(Collectors.toList());
        } else{
            throw new Exception("No records found");
        }
    }

    public List<Employee> fallback(Predicate<Employee> p, Throwable e){
        long endTime = System.currentTimeMillis();
//        e.printStackTrace();
        System.out.println(e.getClass().getName());
        System.out.println(e.getMessage());
        System.out.println(endTime-startTime);
        return new ArrayList<>();
    }


}
