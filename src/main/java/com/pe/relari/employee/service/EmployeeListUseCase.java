package com.pe.relari.employee.service;

import com.pe.relari.employee.model.domain.Employee;

import java.util.List;

public interface EmployeeListUseCase {

    List<Employee> findAll();

}
