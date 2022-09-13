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
 * Date : 8/28/2022 - 3:51 PM
 * Since : version 1.0
 * Description :
 * ****************** */
package com.backend.api.rest.mapper;

import com.backend.api.rest.dto.EmployeeDto;
import com.backend.api.rest.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * This related to mapstruct mapper class
 * This not working issue coming with lombok dependency
 * Author : Mic_Gihan Perera
 * Date : 8/28/2022 - 3:51 PM
 */
@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper( EmployeeMapper.class );

    //@Mapping(target="id", source="employee.id")
    //@Mapping(target="empNo", source="employee.empNo")
    EmployeeDto employeeToEmployeeDto(Employee employee);

    //@Mapping(target="id", source="employeeDto.id")
    //@Mapping(target="empNo", source="employeeDto.empNo")
    Employee employeeDtoToEmployee(EmployeeDto employeeDto);
}
