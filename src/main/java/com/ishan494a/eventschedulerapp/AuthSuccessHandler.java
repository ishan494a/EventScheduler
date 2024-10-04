package com.ishan494a.eventschedulerapp;

import com.ishan494a.eventschedulerapp.Service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class AuthSuccessHandler implements AuthenticationSuccessHandler {
    private final UserService userService;
    @Autowired
    public AuthSuccessHandler(UserService userService){
        this.userService = userService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;

        String username = oAuth2AuthenticationToken.getPrincipal().getAttribute("login");
        if(userService.loadUserByUsername(username) == null){
            userService.saveUser(username);
        }
        response.sendRedirect("/logout");
    }
}
