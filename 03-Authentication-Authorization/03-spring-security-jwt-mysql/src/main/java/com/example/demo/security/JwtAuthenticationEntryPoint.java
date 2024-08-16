package com.example.demo.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * AuthenticationEntryPoint 由 ExceptionTranslationFilter 用来启动身份认证方案。
 * 它是一个入口点，用于检查用户是否已通过身份认证，如果用户已经认证，则登录该用户，否则抛出异常（unauthorized）。
 * 通常情况下，在简单的应用程序中可以直接使用该类，但当在 REST、JWT 等中使用 Spring Security 时，
 * 就必须对其进行继承，以提供更好的 Spring Security 过滤器链（filter chain）管理。
 * @author wangxingang
 * @since 2024/8/8
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    }
}
