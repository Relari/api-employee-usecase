package com.pe.relari.employee.model.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * Class: AddressRequest.
 * @author Relari
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {

  @Schema(
          description = "Correo Electronico del Empleado",
          name = "email",
          type = "String",
          example = "email@mail.com",
          required = true)
  @NotBlank
  @Email
  private String email;

  @Schema(
          description = "Correo Electronico del Empleado",
          name = "email",
          type = "String",
          example = "999999999",
          required = true)
  @NotBlank
  @Pattern(regexp = "\\d{9}")
  private String phoneNumber;

}
