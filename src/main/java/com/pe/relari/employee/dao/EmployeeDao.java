package com.pe.relari.employee.dao;

import com.pe.relari.employee.model.domain.Employee;

import java.util.List;

/**
 * Interface: EmployeeDao.
 * @author Relari
 */
public interface EmployeeDao {

    List<Employee> findAll();

    void save(Employee employee);

    void deleteAll();

    void deleteById(Integer id);

    Employee findById(Integer id);
}
