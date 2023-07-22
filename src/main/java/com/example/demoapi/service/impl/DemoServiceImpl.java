package com.example.demoapi.service.impl;

import com.example.demoapi.exception.DemoNotFoundException;
import com.example.demoapi.model.domain.DemoRequest;
import com.example.demoapi.model.domain.DemoResponse;
import com.example.demoapi.model.entity.DemoEntity;
import com.example.demoapi.repository.DemoRepository;
import com.example.demoapi.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class: DemoServiceImpl.
 * @version 1.0.0
 * @author Relari
 */

@Slf4j
@Service
public record DemoServiceImpl(DemoRepository demoRepository) implements DemoService {

    public void save(DemoRequest demoRequest) {
        log.debug("Save DemoRequest");
        demoRepository.save(
                new DemoEntity(null, demoRequest.getDescription())
        );
    }

    public List<DemoResponse> getDemos() {
        log.debug("Get Demos");
        return demoRepository.findAll()
                .stream()
                .map(this::mapDemoResponse)
                .toList();
    }

    private DemoResponse mapDemoResponse(DemoEntity demoEntity) {
        return new DemoResponse(demoEntity.getId(), demoEntity.getDescription());
    }

    public DemoResponse findDemo(Integer id) {
        log.debug("Find DemoRequest By Id = {}", id);
        return demoRepository.findById(id)
                .map(this::mapDemoResponse)
                .orElseThrow(() -> new DemoNotFoundException("DemoRequest Not Found"));
    }

    public void deleteDemo(Integer id) {
        log.debug("Delete DemoRequest By Id = {}", id);

        DemoResponse demoRequest = findDemo(id);

        demoRepository.deleteById(demoRequest.id());

    }
}
