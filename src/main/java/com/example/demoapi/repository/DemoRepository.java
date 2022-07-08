package com.example.demoapi.repository;

import com.example.demoapi.model.entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface: DemoRepository.
 * @version 1.0.0
 * @author Relari
 */

public interface DemoRepository extends JpaRepository<DemoEntity, Integer> {


}
