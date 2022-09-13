/* PRODUCT : api.rest
 * PROJECT : api.rest
 * PACKAGE : com.backend.api.rest.service.impl
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
 * Date : 8/29/2022 - 1:14 PM
 * Since : version 1.0
 * Description :
 * ****************** */
package com.backend.api.rest.service.impl;

import com.backend.api.rest.dto.ApplicationUserDTO;
import com.backend.api.rest.model.EmpUser;
import com.backend.api.rest.repository.EmpUserRepository;
import com.backend.api.rest.service.EmpUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * This is service implementation function adding application service
 * Author : Mic_Gihan Perera
 * Date : 8/29/2022 - 1:14 PM
 */
@Service
public class EmpUserServiceImpl implements UserDetailsService {

    /* inject application user repository for implementation*/
    @Autowired
    private EmpUserRepository userRepository;

    /**
     * This is service implementation function loading application username
     * @param username
     * @return UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EmpUser user = userRepository.findByUserName(username);

        ApplicationUserDTO userDTO = new ApplicationUserDTO(user.getUserName(), user.getPassWord(), new ArrayList<>());
        userDTO.setUserId(user.getId());
        return userDTO;
    }

}
