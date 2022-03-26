package com.example.demoapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Class: Demo.
 * @version 1.0.0
 * @author Relari
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Demo {

    private Integer id;

    @NotBlank
    @Size(min = 2, max = 50)
    @Pattern(regexp = "[A-Z][a-z]*")
    private String description;

}
