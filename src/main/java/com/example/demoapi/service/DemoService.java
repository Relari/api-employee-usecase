package com.example.demoapi.service;

import com.example.demoapi.model.domain.Demo;

import java.util.List;

/**
 * Interface: DemoService.
 * @version 1.0.0
 * @author Relari
 */

public interface DemoService {

    void save(Demo demo);
    List<Demo> getDemos();
    Demo findDemo(Integer id);
    void deleteDemo(Integer id);

}
