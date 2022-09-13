/* PRODUCT : api.rest
 * PROJECT : api.rest
 * PACKAGE : com.backend.api.rest.dto
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
 * Date : 8/29/2022 - 1:21 PM
 * Since : version 1.0
 * Description :
 * ****************** */
package com.backend.api.rest.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Dto class for releted application user
 * Author : Mic_Gihan Perera
 * Date : 8/29/2022 - 1:21 PM
 */
public class ApplicationUserDTO extends User {

    /*specify the property related to application user*/
    private static final long serialVersionUID = 1L;

    /*specify application user id*/
    private int userId;

    public int getUserId() {
        return userId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ApplicationUserDTO(String username, String password,
                              Collection<? extends GrantedAuthority> authorities) {
        super(username, password, true, true, true, true, authorities);
        // TODO Auto-generated constructor stub
    }

}
