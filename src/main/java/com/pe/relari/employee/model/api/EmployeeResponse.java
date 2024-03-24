package com.pe.relari.employee.model.api;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Class: EmployeeResponse.
 * @author Relari
 */

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {

    @Schema(
            description = "Id del Empleado",
            name = "firstName",
            type = "Integer",
            example = "1")
    private Integer id;

    @Schema(
            description = "Nombre del Empleado",
            name = "name",
            type = "String",
            example = "Renzo")
    private String firstName;

    @Schema(
            description = "Apellido del Empleado",
            name = "fatherLastName",
            type = "String",
            example = "Lavado")
    private String fatherLastName;

    @Schema(
            description = "Apellido del Empleado",
            name = "motherLastName",
            type = "String",
            example = "Lavado")
    private String motherLastName;

    @Schema(
            description = "Sexo del Empleado",
            name = "sex",
            type = "String",
            example = "M o F")
    private String sex;

    @Schema(
            description = "Cargo del Empleado",
            name = "position",
            type = "String",
            example = "Developer")
    private String position;

    @Schema(
            description = "Salario del Empleado",
            name = "salary",
            type = "Double",
            example = "1000.00")
    private Double salary;

    @Schema(
            description = "Estado del Empleado",
            name = "status",
            type = "Double",
            example = "true")
    private Boolean status;

}