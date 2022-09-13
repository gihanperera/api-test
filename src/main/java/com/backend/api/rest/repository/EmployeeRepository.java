/* PRODUCT : api.rest
 * PROJECT : api.rest
 * PACKAGE : com.backend.api.rest.repository
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
 * Date : 8/28/2022 - 4:07 PM
 * Since : version 1.0
 * Description :
 * ****************** */
package com.backend.api.rest.repository;

import com.backend.api.rest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Employee Details
 * Author : Mic_Gihan Perera
 * Date : 8/28/2022 - 4:07 PM
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}
