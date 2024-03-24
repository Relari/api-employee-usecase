package com.pe.relari.employee.service.impl;

import com.pe.relari.employee.dao.EmployeeDao;
import com.pe.relari.employee.service.EmployeeDeleteUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Class: EmployeeFindUseCaseImpl.
 * @author Relari
 */

@Service
@AllArgsConstructor
public class EmployeeDeleteUseCaseImpl implements EmployeeDeleteUseCase {

    private final EmployeeDao employeeDao;

    @Override
    public void deleteById(Integer id) {
        employeeDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        employeeDao.deleteAll();
    }

}
