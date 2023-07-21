package com.example.demoapi.controller;

import com.example.demoapi.model.domain.DemoRequest;
import com.example.demoapi.model.domain.DemoResponse;
import com.example.demoapi.service.DemoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

/**
 * Class: DemoController.
 * @version 1.0.0
 * @author Relari
 */

@RestController
@RequestMapping(path = "${application.api.path}")
public record DemoController(DemoService demoService) {

    /**
     * getDemos.
     * @return {@link DemoResponse[]}
     */
    @GetMapping
    public List<DemoResponse> getDemos() {
        return demoService.getDemos();
    }

    /**
     * saveDemo.
     * @param demoRequest {@link DemoRequest}
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveDemo(@RequestBody @Valid DemoRequest demoRequest) {
        demoService.save(demoRequest);
    }

    /**
     * findDemoById.
     * @param id {@link Integer}
     * @return {@link DemoResponse}
     */
    @GetMapping(path = "/{id}")
    public DemoResponse findDemoById(@PathVariable("id") Integer id) {
        return demoService.findDemo(id);
    }

    /**
     * deleteDemoById.
     * @param id {@link Integer}
     */
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDemoById(@PathVariable("id") Integer id) {
        demoService.deleteDemo(id);
    }
}
