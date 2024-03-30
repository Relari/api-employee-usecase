package com.pe.relari.employee.exception.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pe.relari.employee.exception.StatusCategory;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    @Schema(
            description = "Representa el codigo del error.",
            name = "code",
            implementation = String.class,
            example = "ERR-400")
    private String code;

    @Schema(
            description = "Representa la descripcion del error.",
            name = "description",
            implementation = String.class,
            example = "Solicitud incorrecta o inválida.")
    private String description;
    private List<ErrorDetail> errorDetails;

    public ErrorResponse(StatusCategory statusCategory, ErrorDetail errorDetail) {
        this.code = statusCategory.getErrorCode();
        this.description = statusCategory.getDescription();
        this.errorDetails = Collections.singletonList(errorDetail);
    }

}
