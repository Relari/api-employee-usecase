package com.example.demoapi.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ErrorModel (

    @JsonProperty("app-name")
    String applicationName,

    @JsonProperty("status")
    int status,

    @JsonProperty("error-message")
    String message

) {}
