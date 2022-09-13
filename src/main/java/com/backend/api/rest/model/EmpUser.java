/* PRODUCT : api.rest
 * PROJECT : api.rest
 * PACKAGE : com.backend.api.rest.model
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
 * Date : 8/29/2022 - 1:09 PM
 * Since : version 1.0
 * Description :
 * ****************** */
package com.backend.api.rest.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity class for application user - empuser
 * Author : Mic_Gihan Perera
 * Date : 8/29/2022 - 1:09 PM
 */
@Data
@Entity(name = "empuser")
public class EmpUser {

    /*specify the id for empuser Entity*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*specify the user name for empuser Entity*/
    private String userName;

    /*specify the password for empuser Entity*/
    private String passWord;
}
