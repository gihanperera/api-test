/* PRODUCT : api.rest
 * PROJECT : api.rest
 * PACKAGE : com.backend.api.rest.dto.response
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
 * Date : 8/28/2022 - 4:20 PM
 * Since : version 1.0
 * Description :
 * ****************** */
package com.backend.api.rest.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Dto class for Http response
 * Author : Mic_Gihan Perera
 * Date : 8/28/2022 - 4:20 PM
 */
@Getter
@Setter
public class EmployeeResponseDto {

    /*specify the http Status response*/
    private HttpStatus httpStatus;

    /*specify the http message response*/
    private String message;

    /*specify the http reference response*/
    private String reference;

}
