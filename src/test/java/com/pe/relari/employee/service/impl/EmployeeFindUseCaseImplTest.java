package com.pe.relari.employee.service.impl;

import com.pe.relari.employee.dao.EmployeeDao;
import com.pe.relari.employee.util.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static com.pe.relari.employee.util.TestUtil.buildEmployee;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EmployeeFindUseCaseImplTest {

    @Mock
    private EmployeeDao employeeDao;

    @InjectMocks
    private EmployeeFindUseCaseImpl employeeService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById() {

        var employee = buildEmployee();

        Mockito.when(employeeDao.findById(Mockito.anyInt()))
                .thenReturn(employee);

        var employeeDomain = employeeService.findById(1);
        assertEquals(employee.getIdEmployee(), employeeDomain.getIdEmployee());
        assertEquals(employee.getFirstName(), employeeDomain.getFirstName());
//        assertEquals(employee.getLastName(), employees.get(0).getLastName());
        assertEquals(employee.getSex(), employeeDomain.getSex());
        assertEquals(employee.getAddress().getEmail(), employeeDomain.getAddress().getEmail());
        assertEquals(employee.getAddress().getPhoneNumber(), employeeDomain.getAddress().getPhoneNumber());


    }

}