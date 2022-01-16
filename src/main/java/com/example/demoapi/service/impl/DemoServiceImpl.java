package com.example.demoapi.service.impl;

import com.example.demoapi.model.Demo;
import com.example.demoapi.model.DemoEntity;
import com.example.demoapi.repository.DemoRepository;
import com.example.demoapi.service.DemoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class DemoServiceImpl implements DemoService {

    private final DemoRepository demoRepository;

    public void save(Demo demo) {
        log.debug("Save Demo");
        demoRepository.save(
                new DemoEntity(null, demo.getDescription())
        );
    }

    public List<Demo> getDemos() {
        log.debug("Get Demos");
        return demoRepository.findAll()
                .stream()
                .map(this::mapDemo)
                .collect(Collectors.toList());
    }

    private Demo mapDemo(DemoEntity demoEntity) {
        return new Demo(demoEntity.getId(), demoEntity.getDescription());
    }

    public Demo findDemo(Integer id) {
        log.debug("Find Demo By Id = {}", id);
        return demoRepository.findById(id)
                .map(this::mapDemo)
                .orElseThrow(() -> new RuntimeException("Demo Not Found"));
    }

    public void deleteDemo(Integer id) {
        log.debug("Delete Demo By Id = {}", id);
        demoRepository.deleteById(id);
    }
}
