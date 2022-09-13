/* PRODUCT : api.rest
 * PROJECT : api.rest
 * PACKAGE : com.backend.api.rest.controller
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
 * Date : 8/28/2022 - 1:46 PM
 * Since : version 1.0
 * Description :
 * ****************** */
package com.backend.api.rest.controller;

import com.backend.api.rest.dto.EmpUserDto;
import com.backend.api.rest.security.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Rest end point related application user details
 * Author : Mic_Gihan Perera
 * Date : 8/28/2022 - 1:46 PM
 */
@RestController
@RequestMapping("/users")
public class EmpUserController {

    /* Logger Factory reference  to controller*/
    Logger logger = LoggerFactory.getLogger(EmpUserController.class);

    /* inject token utils details to controller*/
    @Autowired
    JwtUtil jwtUtil;

    /* inject token utils details to controller*/
    @Autowired
    AuthenticationManager authenticationManager;

    /**
     * This api allows to provide outstanding amount response
     *
     * @param empUserDto
     * @param httpServletRequest
     * @return @String
     */
    @PostMapping(value = "/verify")
    public String authEmpUser(@Valid @RequestBody EmpUserDto empUserDto, HttpServletRequest httpServletRequest) {

        try {

//            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); // Strength set as 12
//            String encodedPassword = DigestUtils.sha1Hex(password);
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(empUserDto.getUserName(), empUserDto.getPassWord()));

        } catch (Exception ex) {
            logger.error("authentication error " + ex.getMessage());
        }
        String encryptedToken = jwtUtil.generateToken(empUserDto.getUserName());

        return encryptedToken;
    }
}
