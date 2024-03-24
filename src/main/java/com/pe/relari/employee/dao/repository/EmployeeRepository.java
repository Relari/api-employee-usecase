package com.pe.relari.employee.dao.repository;

import com.pe.relari.employee.model.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface: EmployeeRepository.
 * @version 1.0.0
 * @author Relari
 */

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

}
