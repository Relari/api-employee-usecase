package com.example.demoapi.interceptor;

import com.example.demoapi.proxy.JwtTokenApi;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

@Lazy
@Configuration
@AllArgsConstructor
public class InterceptorHandler implements HandlerInterceptor {

    private final JwtTokenApi jwtTokenApi;

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {

        boolean isValidated;

        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (Objects.nonNull(authorization)) {
            try {
                var isValidToken = jwtTokenApi.isValidToken(authorization);
                isValidated = Boolean.TRUE.equals(isValidToken);
            } catch (Exception e) {
                isValidated = false;
                response.setStatus(HttpStatus.FORBIDDEN.value());
            }
        } else {
            isValidated = false;
            response.sendError(HttpStatus.UNAUTHORIZED.value());
        }

        return isValidated;
    }

}
