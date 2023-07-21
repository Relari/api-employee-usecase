package com.example.demoapi.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Class: DemoRequest.
 * @version 1.0.0
 * @author Relari
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DemoRequest {

    @NotBlank
    @Size(min = 2, max = 50)
    @Pattern(regexp = "[A-Z][a-z]*")
    private String description;

}
