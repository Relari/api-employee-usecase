package com.example.demoapi.repository;

import com.example.demoapi.model.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoRepository extends JpaRepository<DemoEntity, Integer> {


}
