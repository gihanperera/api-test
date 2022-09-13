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

import com.backend.api.rest.dto.EmployeeDto;
import com.backend.api.rest.model.Employee;
import com.backend.api.rest.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Rest end point related employee details
 * Author : Mic_Gihan Perera
 * Date : 8/28/2022 - 1:46 PM
 */
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    /* Logger Factory reference  to controller*/
    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    /* inject employee Service to controller*/
    @Autowired
    EmployeeService employeeService;

    /**
     * This api allows to add employee request
     *
     * @param employeeDto
     * @param httpServletRequest
     * @return EmployeeDto
     */
    @PostMapping(value = "/add")
    public ResponseEntity<EmployeeDto> addEmployee(@Valid @RequestBody EmployeeDto employeeDto, HttpServletRequest httpServletRequest) {

        try {

            logger.info("add request receiving to controller ");
            EmployeeDto employeeDto1 = employeeService.SavingEmployee(employeeDto);
            return new ResponseEntity<EmployeeDto>(employeeDto1, HttpStatus.OK);

        } catch (Exception e) {
            logger.error("add employee error " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This api allows to get all employee details
     *
     * @return Employee List
     */
    @GetMapping(value = "/getall")
    public ResponseEntity<List<Employee>> getAllEmployee() {

        try {

            logger.info("get all details request receiving to controller ");
            List<Employee> employeeList = employeeService.findAll();
            return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);

        } catch (Exception e) {
            logger.error("get all employees details error " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * This api allows to find one employee details
     *
     * @param employeeDto
     * @param httpServletRequest
     * @return EmployeeDto
     */
    @PostMapping(value = "/findemployee")
    public ResponseEntity<EmployeeDto> findEmployee(@Valid @RequestBody EmployeeDto employeeDto, HttpServletRequest httpServletRequest) {

        try {

            logger.info("find request receiving to controller ");
            EmployeeDto employeeDto1 = employeeService.findById(employeeDto.getId());
            return new ResponseEntity<EmployeeDto>(employeeDto1, HttpStatus.OK);

        } catch (Exception e) {
            logger.error("find employee details error " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * This api allows to delete employee
     *
     * @param employeeDto
     * @param httpServletRequest
     * @return EmployeeDto
     */
    @PostMapping(value = "/delete")
    public ResponseEntity<EmployeeDto> updateDeleted(@Valid @RequestBody EmployeeDto employeeDto, HttpServletRequest httpServletRequest) {

        try {

            logger.info("delete request receiving to controller ");
            EmployeeDto employeeDto1 = employeeService.deletedById(employeeDto.getId());
            return new ResponseEntity<EmployeeDto>(employeeDto1, HttpStatus.OK);

        } catch (Exception e) {
            logger.error("delete employee details error " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
