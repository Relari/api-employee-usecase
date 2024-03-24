package com.pe.relari.employee.service.impl;

import com.pe.relari.employee.dao.EmployeeDao;
import com.pe.relari.employee.model.domain.Employee;
import com.pe.relari.employee.service.EmployeeListUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class: EmployeeServiceImpl.
 * @author Relari
 */

@Service
@AllArgsConstructor
public class EmployeeListUseCaseImpl implements EmployeeListUseCase {

    private final EmployeeDao employeeDao;

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

}
