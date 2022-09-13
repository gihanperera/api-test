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
 * Date : 8/28/2022 - 2:28 PM
 * Since : version 1.0
 * Description :
 * ****************** */
package com.backend.api.rest.model;

import com.backend.api.rest.constant.EmployeeStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity class for employee
 * Author : Mic_Gihan Perera
 * Date : 8/28/2022 - 2:28 PM
 */
@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {


    /*specify the id for employee Entity*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*specify the employee number for employee Entity*/
    private String empNo;

    /*specify the first Name for employee Entity*/
    private String firstName;

    /*specify the last Name for employee Entity*/
    private String lastName;

    /*specify the date Of Birth for employee Entity*/
    private Date dateOfBirth;

    /*specify the designation for employee Entity*/
    private String designation;

    /*specify the joined Date for employee Entity*/
    private Date joinedDate;

    /*specify the salary for employee Entity*/
    private double salary;

    /*specify the status of the employee*/
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    /*specify the deleted status for employee Entity*/
    private boolean deleted;

}
