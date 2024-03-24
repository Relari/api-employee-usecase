package com.pe.relari.employee.service.impl;

import com.pe.relari.employee.dao.EmployeeDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static com.pe.relari.employee.util.TestUtil.buildEmployee;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EmployeeDeleteUseCaseImplTest {

    @Mock
    private EmployeeDao employeeDao;

    @InjectMocks
    private EmployeeDeleteUseCaseImpl employeeService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deleteAll() {

        var employee = buildEmployee();

        employeeDao.deleteAll();

        employeeService.deleteAll();

        assertNotNull(employee);

    }

    @Test
    void deleteById() {

        Integer id = 1;

        employeeDao.deleteById(Mockito.anyInt());

        employeeService.deleteById(id);

        assertNotNull(id);
    }

}