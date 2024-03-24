package com.pe.relari.employee.model.entity;

import com.pe.relari.employee.model.domain.Employee;
import com.pe.relari.employee.util.GenderEnum;
import com.pe.relari.employee.util.PositionEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * <b>Class:</b> EmployeeEntity.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Entity
@Table(name = "EMPLOYEE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fatherLastName", length = 50, nullable = false)
    private String fatherLastName;

    @Column(name = "motherLastName", length = 50, nullable = false)
    private String motherLastName;

    @Column(name = "firstName", length = 50, nullable = false)
    private String firstName;

    @Enumerated(EnumType.STRING)
    @Column(name = "position", length = 50, nullable = false)
    private PositionEnum position;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex", length = 1, nullable = false)
    private GenderEnum sex;

    @Column(name = "salary", nullable = false)
    private Double salary;

    @Column(name = "isActive", nullable = false)
    private Boolean isActive;

    public static EmployeeEntity to(Employee employee) {
        return builder()
                .firstName(employee.getFirstName())
                .fatherLastName(employee.getFatherLastName())
                .motherLastName(employee.getMotherLastName())
                .sex(employee.getSex())
                .position(employee.getPosition())
                .salary(employee.getSalary())
                .isActive(Boolean.TRUE)
                .build();
    }
}
