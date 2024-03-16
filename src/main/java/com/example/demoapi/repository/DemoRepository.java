package com.example.demoapi.repository;

import com.example.demoapi.model.entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface: DemoRepository.
 * @version 1.0.0
 * @author Relari
 */

@Repository
public interface DemoRepository extends JpaRepository<DemoEntity, Integer> {


}
