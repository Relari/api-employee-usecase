package com.example.demoapi.service;

import com.example.demoapi.model.domain.DemoRequest;
import com.example.demoapi.model.domain.DemoResponse;

import java.util.List;

/**
 * Interface: DemoService.
 * @version 1.0.0
 * @author Relari
 */

public interface DemoService {

    void save(DemoRequest demoRequest);
    List<DemoResponse> getDemos();
    DemoResponse findDemo(Integer id);
    void deleteDemo(Integer id);

}
