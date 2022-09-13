/* PRODUCT : api.rest
 * PROJECT : api.rest
 * PACKAGE : com.backend.api.rest.mapper
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
 * Date : 8/29/2022 - 10:59 AM
 * Since : version 1.0
 * Description :
 * ****************** */
package com.backend.api.rest.mapper;

import com.backend.api.rest.dto.EmployeeDto;
import com.backend.api.rest.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This related to mapping employee records and employee details
 * Currently mapstruct configuration not working So,doing manually mapping this class
 * Author : Mic_Gihan Perera
 * Date : 8/29/2022 - 10:59 AM
 */
@Component
public class EmployeeDetailsMapping {

    /* Logger Factory reference  to Employee Details Mapping*/
    Logger logger = LoggerFactory.getLogger(EmployeeDetailsMapping.class);

    /**
     * This set employee Dto details to entity class
     * @param employeeDto
     * @return @Employee
     */
    public Employee setEmployee(EmployeeDto employeeDto){

        Employee employee = new Employee();
        employee.setEmpNo(employeeDto.getEmpNo());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setDesignation(employeeDto.getDesignation());
        employee.setSalary(employeeDto.getSalary());
        employee.setDeleted(false);

        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dob = dateFormat.parse(employeeDto.getDateOfBirth());
            Date joinedDate = dateFormat.parse(employeeDto.getJoinedDate());
            employee.setDateOfBirth(dob);
            employee.setJoinedDate(joinedDate);

        }catch (Exception ex){
            logger.error("issue Date of Birth or joind date"+ex.getMessage());
        }
        return employee;
    }

    /**
     * This set one employee details to Dto class
     * @param employee
     * @return @EmployeeDto
     */
    public EmployeeDto setEmployeeById(Employee employee){

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setEmpNo(employee.getEmpNo());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setDesignation(employee.getDesignation());
        employeeDto.setSalary(employeeDto.getSalary());
        employeeDto.setDeleted(employee.isDeleted());

        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dob = dateFormat.format(employee.getDateOfBirth());
            String joinedDate = dateFormat.format(employee.getJoinedDate());
            employeeDto.setDateOfBirth(dob);
            employeeDto.setJoinedDate(joinedDate);

        }catch (Exception ex){
            logger.error("issue Date of Birth or joined date"+ex.getMessage());
        }
        return employeeDto;
    }

    /**
     * set deleted record for employee
     * @param employee
     * @return @EmployeeDto
     */
    public EmployeeDto updateEmployeeDeleted(Employee employee){

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setEmpNo(employee.getEmpNo());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setDesignation(employee.getDesignation());
        employeeDto.setSalary(employeeDto.getSalary());
        employeeDto.setDeleted(employee.isDeleted());

        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dob = dateFormat.format(employee.getDateOfBirth());
            String joinedDate = dateFormat.format(employee.getJoinedDate());
            employeeDto.setDateOfBirth(dob);
            employeeDto.setJoinedDate(joinedDate);

        }catch (Exception ex){
            logger.error("issue Date of Birth or joined date"+ex.getMessage());
        }
        return employeeDto;
    }
}
