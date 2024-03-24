package com.pe.relari.employee.util;

import com.pe.relari.employee.model.api.AddressRequest;
import com.pe.relari.employee.model.api.EmployeeRequest;
import com.pe.relari.employee.model.domain.Address;
import com.pe.relari.employee.model.domain.Employee;
import com.pe.relari.employee.model.entity.EmployeeEntity;
import com.pe.relari.employee.util.GenderEnum;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestUtil {

    public static Employee buildEmployee() {
        return Employee.builder()
                .idEmployee(1)
                .firstName("Name")
                .fatherLastName("Father Last Name")
                .motherLastName("Mother Last Name")
                .sex(GenderEnum.M)
                .position(PositionEnum.DEVELOPER)
                .salary(2500.00)
                .address(new Address("email@mail.com", "999000999"))
                .isActive(Boolean.TRUE)
                .build();
    }

    public static EmployeeRequest buildEmployeeRequest() {
        return EmployeeRequest.builder()
                .firstName("Name")
                .fatherLastName("Father Last Name")
                .motherLastName("Mother Last Name")
                .sex("M")
                .position("DEVELOPER")
                .salary(2500.00)
                .address(new AddressRequest("email@mail.com", "999000999"))
                .build();
    }

    public static EmployeeEntity buildEmployeeEntity() {
        return EmployeeEntity.builder()
                .id(1)
                .firstName("Name")
                .fatherLastName("Father Last Name")
                .motherLastName("Mother Last Name")
                .sex(GenderEnum.M)
                .position(PositionEnum.DEVELOPER)
                .salary(2500.00)
                .isActive(Boolean.TRUE)
                .build();
    }
}
