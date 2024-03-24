package com.pe.relari.employee.service.impl;

import com.pe.relari.employee.dao.EmployeeDao;
import com.pe.relari.employee.model.domain.Employee;
import com.pe.relari.employee.service.EmployeeFindUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Class: EmployeeFindUseCaseImpl.
 * @author Relari
 */

@Service
@AllArgsConstructor
public class EmployeeFindUseCaseImpl implements EmployeeFindUseCase {

    private final EmployeeDao employeeDao;

    @Override
    public Employee findById(Integer id) {
        return employeeDao.findById(id);
    }

}
