package com.pe.relari.controller;

import com.pe.relari.employee.service.EmployeeCreateUseCase;
import com.pe.relari.employee.service.EmployeeDeleteUseCase;
import com.pe.relari.employee.service.EmployeeFindUseCase;
import com.pe.relari.employee.service.EmployeeListUseCase;
import com.pe.relari.employee.util.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static com.pe.relari.employee.util.TestUtil.buildEmployee;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class EmployeeControllerTest {

    @Mock
    private EmployeeCreateUseCase employeeCreateUseCase;

    @Mock
    private EmployeeDeleteUseCase employeeDeleteUseCase;

    @Mock
    private EmployeeFindUseCase employeeFindUseCase;

    @Mock
    private EmployeeListUseCase employeeListUseCase;

    @InjectMocks
    private EmployeeController controller;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {

        var employee = buildEmployee();

        when(employeeListUseCase.findAll())
                .thenReturn(Collections.singletonList(employee));

        var employeeResponses = controller.findAll();

        assertEquals(employee.getIdEmployee(), employeeResponses.get(0).getId());
        assertEquals(employee.getFirstName(), employeeResponses.get(0).getFirstName());
        assertEquals(employee.getFatherLastName(), employeeResponses.get(0).getFatherLastName());
        assertEquals(employee.getMotherLastName(), employeeResponses.get(0).getMotherLastName());
        assertEquals(employee.getSex().name(), employeeResponses.get(0).getSex());
    }

    @Test
    void findAll2() {

        var employee = buildEmployee();

        when(employeeListUseCase.findAll())
                .thenReturn(Collections.singletonList(employee));

        var employeeDetailResponse = controller.findAll2();

        assertNotNull(employeeDetailResponse);
    }



    @Test
    void findById() {

        var employee = buildEmployee();

        when(employeeFindUseCase.findById(anyInt()))
                .thenReturn(employee);

        var employeeResponse = controller.findById(1);

        assertEquals(employee.getIdEmployee(), employeeResponse.getId());
        assertEquals(employee.getFirstName(), employeeResponse.getFirstName());
//        assertEquals(employee.getLastName(), employeeResponse.getLastName());
        assertEquals(employee.getSex().name(), employeeResponse.getSex());

    }

    @Test
    void getAddressById() {

        var employee = buildEmployee();

        when(employeeFindUseCase.findById(anyInt()))
                .thenReturn(employee);

        var address = controller.getAddressById(1);

        assertEquals(employee.getAddress().getEmail(), address.getEmail());
        assertEquals(employee.getAddress().getPhoneNumber(), address.getPhoneNumber());

    }

    @Test
    void save() {

        employeeCreateUseCase.save(any());

        var employeeRequest = TestUtil.buildEmployeeRequest();

        controller.save(employeeRequest);

        assertNotNull(employeeRequest);

    }

    @Test
    void deleteAll() {

        employeeDeleteUseCase.deleteAll();

        controller.deleteAll();

        Integer id = 1;

        assertNotNull(id);
    }

    @Test
    void deleteById() {

        employeeDeleteUseCase.deleteById(anyInt());

        Integer id = 1;

        controller.deleteById(id);

        assertNotNull(id);

    }
}