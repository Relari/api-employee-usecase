package com.pe.relari.employee.service.impl;

import com.pe.relari.employee.dao.EmployeeDao;
import com.pe.relari.employee.util.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class EmployeeCreateUseCaseImplTest {

    @Mock
    private EmployeeDao employeeDao;

    @InjectMocks
    private EmployeeCreateUseCaseImpl employeeService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save() {
        employeeDao.save(Mockito.any());

        var employee = TestUtil.buildEmployee();
        employeeService.save(employee);

        assertNotNull(employee);
    }

}