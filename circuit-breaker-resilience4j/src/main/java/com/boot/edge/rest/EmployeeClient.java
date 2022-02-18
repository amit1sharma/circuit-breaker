package com.boot.edge.rest;

import com.boot.edge.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeClient {

    private final RestTemplate restTemplate;

    @Value("${employee-service-name}")
    private String employeeServiceUrl;

    public Employee[] getEmployees(){
        Employee[] lst = restTemplate.getForObject(employeeServiceUrl+"/employees",Employee[].class);
        return lst;
    }

}
