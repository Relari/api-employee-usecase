package com.pe.relari.employee.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCategory {

    BAD_REQUEST(400, "ERR-400", "Solicitud incorrecta o inválida."),
    NOT_FOUND(404, "ERR-404", "Recurso no encontrado."),
    CONFLICT(409, "ERR-409", "Conflicto con el estado actual del recurso."),
    INTERNAL_ERROR(500, "ERR-500", "Error interno del servidor.");

    private final Integer statusCode;
    private final String errorCode;
    private final String description;

}
