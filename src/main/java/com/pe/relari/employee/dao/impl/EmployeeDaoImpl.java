package com.pe.relari.employee.dao.impl;

import com.pe.relari.employee.dao.EmployeeDao;
import com.pe.relari.employee.dao.repository.EmployeeRepository;
import com.pe.relari.employee.exception.ApiException;
import com.pe.relari.employee.exception.ErrorCategory;
import com.pe.relari.employee.model.domain.Employee;
import com.pe.relari.employee.model.entity.EmployeeEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Interface: EmployeeDao.
 * @author Relari
 */

@Component
@AllArgsConstructor
public class EmployeeDaoImpl implements EmployeeDao {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(Employee::to)
                .collect(Collectors.toList());
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(
                EmployeeEntity.to(employee)
        );
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id)
                .map(Employee::to)
                .orElseThrow(() -> ApiException.of(ErrorCategory.EMPLOYEE_NOT_FOUND));
    }
}
