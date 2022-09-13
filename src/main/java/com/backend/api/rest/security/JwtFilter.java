/* PRODUCT : api.rest
 * PROJECT : api.rest
 * PACKAGE : com.backend.api.rest.security
 * ***********************************************************************************
 *
 * Copyright(C) 2021
 *
 *
 *
 * **************************************************************************************
 *
 * REVISIONS:
 * Author : Mic_Gihan Perera
 * Date : 8/29/2022 - 12:04 PM
 * Since : version 1.0
 * Description :
 * ****************** */
package com.backend.api.rest.security;

import com.backend.api.rest.repository.EmpUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * jwt filtering class
 * Author : Mic_Gihan Perera
 * Date : 8/29/2022 - 12:04 PM
 */
@CrossOrigin
@Component
public class JwtFilter extends OncePerRequestFilter {

    /* inject token utils details */
    @Autowired
    private JwtUtil jwtUtil;

    /* inject application user service */
    @Autowired
    private UserDetailsService empUserService;

    /* inject application user repository */
    @Autowired
    private EmpUserRepository userRepository;

    /**
     * user token filtering
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param filterChain
     * @return @void
     */
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String token = null;
        token = httpServletRequest.getHeader("authToken");
        String userName = null;

        if(token!=null)
            userName = jwtUtil.extractUsername(token);

        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = empUserService.loadUserByUsername(userName);

            if (jwtUtil.validateToken(token, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        String requestURI = httpServletRequest.getRequestURI();

        if (requestURI != null && !requestURI.equals("/users/verify/")) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }

    }

}
