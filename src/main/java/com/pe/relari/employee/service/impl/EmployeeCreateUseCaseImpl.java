package com.pe.relari.employee.service.impl;

import com.pe.relari.employee.dao.EmployeeDao;
import com.pe.relari.employee.model.domain.Employee;
import com.pe.relari.employee.service.EmployeeCreateUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeCreateUseCaseImpl implements EmployeeCreateUseCase {

    private final EmployeeDao employeeDao;

    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

}
