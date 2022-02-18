package com.boot.edge.service;

import com.boot.edge.model.Employee;

import java.util.Collection;
import java.util.function.Predicate;

public interface DepartmentService {
    Collection<Employee> getEmployeesByCriteria(Predicate<Employee> p) throws Exception;
}
