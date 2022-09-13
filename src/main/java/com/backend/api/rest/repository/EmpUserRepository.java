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
 * Date : 8/29/2022 - 1:16 PM
 * Since : version 1.0
 * Description :
 * ****************** */
package com.backend.api.rest.repository;

import com.backend.api.rest.model.EmpUser;
import com.backend.api.rest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for application user Details
 * Author : Mic_Gihan Perera
 * Date : 8/29/2022 - 1:16 PM
 */
@Repository
public interface EmpUserRepository extends JpaRepository<EmpUser, Integer> {

    /**
     * This using find username in entity
     *
     * @param username
     * @return @EmpUser
     */
    EmpUser findByUserName(String username);
}
