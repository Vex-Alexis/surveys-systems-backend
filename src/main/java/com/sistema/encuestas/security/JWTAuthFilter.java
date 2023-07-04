package com.sistema.encuestas.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;


public class JWTAuthFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        AppUserCredentials appUserCredentials = new AppUserCredentials();

        try{
            appUserCredentials = new ObjectMapper().readValue(request.getReader(), AppUserCredentials.class);
        }catch (IOException e){

        }

        UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
                appUserCredentials.getEmail(),
                appUserCredentials.getPass(),
                Collections.emptyList()
        );
        return getAuthenticationManager().authenticate(usernamePAT);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        UserDetailsImpl userDetails= (UserDetailsImpl) authResult.getPrincipal();

        String loginToken = TokenMaker.createToken(userDetails.getUsername(), userDetails.getEmail());

        response.addHeader("Authorization","Bearer " + loginToken);
        response.getWriter().flush();
        super.successfulAuthentication(request, response, chain, authResult);
    }
}
