package com.pe.relari.employee.model.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * Class: EmployeeDetailResponse.
 * @author Relari
 */

@Getter
@AllArgsConstructor(staticName = "of")
public class EmployeeDetailResponse {

    private List<EmployeeResponse> employees;

}
