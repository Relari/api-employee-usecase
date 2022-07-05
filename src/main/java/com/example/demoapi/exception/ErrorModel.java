package com.example.demoapi.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorModel {

    @JsonProperty("app-name")
    private String applicationName;

    @JsonProperty("error-message")
    private String message;

}
