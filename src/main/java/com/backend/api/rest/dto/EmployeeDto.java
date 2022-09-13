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
 * Date : 8/29/2022 - 8:52 AM
 * Since : version 1.0
 * Description :
 * ****************** */
package com.backend.api.rest.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Dto class for related Employee
 * Author : Mic_Gihan Perera
 * Date : 8/29/2022 - 8:52 AM
 */
@Getter
@Setter
public class EmployeeDto {

    /*specify the Employee id*/
    private int id;

    /*specify the Employee Number*/
    private String empNo;

    /*specify the Employee first Name*/
    private String firstName;

    /*specify the Employee  last Name*/
    private String lastName;

    /*specify the Employee  date Of Birth*/
    private String dateOfBirth;

    /*specify the Employee  designation*/
    private String designation;

    /*specify the Employee  date Of Joined*/
    private String joinedDate;

    /*specify the Employee salary*/
    private double salary;

    /*specify the Employee deleted status*/
    private boolean deleted;

}
