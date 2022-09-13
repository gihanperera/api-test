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
 * Date : 8/29/2022 - 1:11 PM
 * Since : version 1.0
 * Description :
 * ****************** */
package com.backend.api.rest.dto;

import lombok.Data;

/**
 * Dto class for related application user details
 * Author : Mic_Gihan Perera
 * Date : 8/29/2022 - 1:11 PM
 */
@Data
public class EmpUserDto {

    /*specify the employee number for employee*/
    private String userName;

    /*specify the employee number for employee*/
    private String passWord;
}
