package com.pe.relari.employee.model.domain;

import com.pe.relari.employee.model.entity.EmployeeEntity;
import com.pe.relari.employee.util.GenderEnum;
import com.pe.relari.employee.util.PositionEnum;
import lombok.*;

/**
 * Class: Employee.
 * @author Relari
 */

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Integer idEmployee;
    private String fatherLastName;
    private String motherLastName;
    private String firstName;
    private PositionEnum position;
    private GenderEnum sex;
    private Double salary;
    private Address address;
    private Boolean isActive;

    public static Employee to(EmployeeEntity employeeEntity) {
        return builder()
                .idEmployee(employeeEntity.getId())
                .firstName(employeeEntity.getFirstName())
                .fatherLastName(employeeEntity.getFatherLastName())
                .motherLastName(employeeEntity.getMotherLastName())
                .sex(employeeEntity.getSex())
                .position(employeeEntity.getPosition())
                .salary(employeeEntity.getSalary())
                .isActive(employeeEntity.getIsActive())
                .build();
    }

}