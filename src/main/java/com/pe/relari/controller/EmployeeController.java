package com.pe.relari.controller;

import com.pe.relari.controller.mapper.EmployeeMapper;
import com.pe.relari.employee.model.api.AddressResponse;
import com.pe.relari.employee.model.api.EmployeeDetailResponse;
import com.pe.relari.employee.model.api.EmployeeRequest;
import com.pe.relari.employee.model.api.EmployeeResponse;
import com.pe.relari.employee.service.EmployeeCreateUseCase;
import com.pe.relari.employee.service.EmployeeDeleteUseCase;
import com.pe.relari.employee.service.EmployeeFindUseCase;
import com.pe.relari.employee.service.EmployeeListUseCase;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class: EmployeeController.
 * @author Relari
 */

@Tag(name = "Employee", description = "Employee Controller")
@OpenAPIDefinition(
        info = @Info(
                title = "Employee API",
                version = "${application.info.version}",
                description = "${application.info.description}")
)
@RestController
@RequestMapping(path = "${application.api.path}")
@AllArgsConstructor
public class EmployeeController {

    private static final String REGEXP_NUMBER = "\\d+"; // equivalent to [0-9]*

    private final EmployeeCreateUseCase employeeCreateUseCase;
    private final EmployeeDeleteUseCase employeeDeleteUseCase;
    private final EmployeeFindUseCase employeeFindUseCase;
    private final EmployeeListUseCase employeeListUseCase;

    @Operation(
            summary = "Listado de Empleados.",
            method = "GET",
            responses  = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna todos los Empleados",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = EmployeeResponse.class)),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    )
            })
    @GetMapping
    public List<EmployeeResponse> findAll() {
        return employeeListUseCase.findAll()
                .stream()
                .map(EmployeeMapper::mapEmployeeResponse)
                .collect(Collectors.toList());
    }

    @Operation(
            summary = "Listado de Empleados.",
            method = "GET",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Show Employee",
                            content = @Content(
                                    schema = @Schema(implementation = EmployeeDetailResponse.class),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    )
            })
    @GetMapping(path = "/all")
    public EmployeeDetailResponse findAll2() {
        return EmployeeDetailResponse.of(findAll());
    }

    @Operation(
            summary = "Obtiene la informacion de un empleado.",
            method = "GET",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Show Employee",
                            content = @Content(
                                    schema = @Schema(implementation = EmployeeResponse.class),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Error to Save",
                            content = @Content(
                                    schema = @Schema(implementation = Error.class),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    )
            })
    @GetMapping(path = "/{id}")
    public EmployeeResponse findById(
            @Parameter(
                    description = "Id del Empleado",
                    name = "Id",
                    in = ParameterIn.PATH,
                    example = "1",
                    required = true)
            @Pattern(regexp = REGEXP_NUMBER)
            @PathVariable(name = "id") Integer id) {
        return EmployeeMapper.mapEmployeeResponse(
                employeeFindUseCase.findById(id)
        );
    }

    @Operation(
            summary = "Obtiene la informacion de un empleado.",
            method = "GET",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Show Employee",
                            content = @Content(
                                    schema = @Schema(implementation = AddressResponse.class),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Error to Save",
                            content = @Content(
                                    schema = @Schema(implementation = Error.class),
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    )
            })
    @GetMapping(path = "/{id}/address")
    public AddressResponse getAddressById(
            @Parameter(
                    description = "Id del Empleado",
                    name = "Id",
                    in = ParameterIn.PATH,
                    example = "1",
                    required = true)
            @Pattern(regexp = REGEXP_NUMBER)
            @PathVariable(name = "id") Integer id) {
        return EmployeeMapper.mapAddressResponse(
                employeeFindUseCase.findById(id).getAddress()
        );
    }

    @Operation(
            summary = "Guarda al empleado",
            method = "POST",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Create Successful"
                    )
            })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody @Valid EmployeeRequest employeeRequest) {
        var employeeEntity = EmployeeMapper.mapEmployee(employeeRequest);
        employeeCreateUseCase.save(employeeEntity);
    }

    @Operation(
            summary = "Elimina todos los empleados",
            method = "DELETE",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Deleted Successful"
                    )
            })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteAll() {
        employeeDeleteUseCase.deleteAll();
    }

    @Operation(
            summary = "Elimina al empleado",
            method = "DELETE",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Deleted Successful"
                    )
            })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{id}")
    public void deleteById(
            @Parameter(
                    description = "Id del Empleado",
                    name = "Id",
                    in = ParameterIn.PATH,
                    example = "1",
                    required = true)
            @Pattern(regexp = REGEXP_NUMBER)
            @PathVariable(name = "id") Integer id) {
        employeeDeleteUseCase.deleteById(id);
    }
}
