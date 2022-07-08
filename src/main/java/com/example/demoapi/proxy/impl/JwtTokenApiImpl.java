package com.example.demoapi.proxy.impl;

import com.example.demoapi.model.external.ValidResponse;
import com.example.demoapi.proxy.JwtTokenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class JwtTokenApiImpl implements JwtTokenApi {

    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    @Value("${application.http-client.jwt-token.base-url}")
    private String jwtTokenBaseUrl;

    @Override
    public Boolean isValidToken(String token) {

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, token);

        HttpEntity<String> request = new HttpEntity<>(null, headers);

        ValidResponse response = REST_TEMPLATE.postForObject(
                jwtTokenBaseUrl.concat("token/validate"),
                request, ValidResponse.class
        );

        assert response != null;
        return response.getIsValidToken();

    }
}
