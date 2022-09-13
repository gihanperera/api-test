/* PRODUCT : api.rest
 * PROJECT : api.rest
 * PACKAGE : com.backend.api.rest.service
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
 * Date : 8/28/2022 - 4:15 PM
 * Since : version 1.0
 * Description :
 * ****************** */
package com.backend.api.rest.service;

import com.backend.api.rest.dto.EmployeeDto;
import com.backend.api.rest.model.Employee;

import java.util.List;

/**
 * Service class for employee details
 * Author : Mic_Gihan Perera
 * Date : 8/28/2022 - 4:15 PM
 */
public interface EmployeeService {

    /**
     * This api allows to process adding employee
     * @param employeeDto
     * @return EmployeeResponseDto
     */
    public EmployeeDto SavingEmployee(EmployeeDto employeeDto);

    /**
     * This api allows fina all employee
     * @return List<Employee>
     */
    public List<Employee> findAll();

    /**
     * This api allows find by employee id
     * @param id
     * @return EmployeeDto
     */
    public EmployeeDto findById(int id);

    /**
     * This api allows deleted employee
     * @param id
     * @return EmployeeDto
     */
    public EmployeeDto deletedById(int id);


}
