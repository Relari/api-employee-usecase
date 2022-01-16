package com.example.demoapi.service;

import com.example.demoapi.model.Demo;

import java.util.List;

public interface DemoService {

    void save(Demo demo);
    List<Demo> getDemos();
    Demo findDemo(Integer id);
    void deleteDemo(Integer id);

}
