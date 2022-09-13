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
 * Date : 8/28/2022 - 4:23 PM
 * Since : version 1.0
 * Description :
 * ****************** */
package com.backend.api.rest.service.impl;

import com.backend.api.rest.controller.EmployeeController;
import com.backend.api.rest.dto.EmployeeDto;
import com.backend.api.rest.mapper.EmployeeDetailsMapping;
import com.backend.api.rest.mapper.EmployeeMapper;
import com.backend.api.rest.model.Employee;
import com.backend.api.rest.repository.EmployeeRepository;
import com.backend.api.rest.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service implementation class for employee details
 * Author : Mic_Gihan Perera
 * Date : 8/28/2022 - 4:23 PM
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

    /* Logger Factory reference  to controller*/
    Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    /* inject employee repository for implementation */
    @Autowired
    EmployeeRepository employeeRepository;

    /* inject manually model mapping for implementation */
    @Autowired
    EmployeeDetailsMapping employeeDetailsMapping;

    /**
     * This is service implementation function adding employee
     *
     * @param employeeDto
     * @return EmployeeDto
     */
    @Override
    public EmployeeDto SavingEmployee(EmployeeDto employeeDto) {

        Employee employee = employeeDetailsMapping.setEmployee(employeeDto);
        return employeeDetailsMapping.setEmployeeById(employeeRepository.save(employee));
    }

    /**
     * This is service implementation function find all employee
     *
     * @return List<Employee>
     */
    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    /**
     * This is service implementation function employee id
     *
     * @param id
     * @return EmployeeDto
     */
    @Override
    public EmployeeDto findById(int id) {

        Employee employee = employeeRepository.findById(id).get();
        EmployeeDto employeeDto = employeeDetailsMapping.setEmployeeById(employee);
        return employeeDto;
    }

    /**
     * This is service implementation function delete employee
     *
     * @param id
     * @return EmployeeDto
     */
    @Override
    public EmployeeDto deletedById(int id) {

        Employee employee = employeeRepository.findById(id).get();
        employee.setDeleted(true);
        employeeRepository.save(employee);
        EmployeeDto employeeDto = employeeDetailsMapping.updateEmployeeDeleted(employee);

        return employeeDto;
    }
}
