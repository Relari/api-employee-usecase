package com.example.demoapi.controller;

import com.example.demoapi.model.domain.Demo;
import com.example.demoapi.service.DemoService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Class: DemoController.
 * @version 1.0.0
 * @author Relari
 */

@RestController
@AllArgsConstructor
@RequestMapping(path = "${application.api.path}")
public class DemoController {

    private DemoService demoService;

    /**
     * getDemos.
     * @return {@link Demo[]}
     */
    @GetMapping
    public List<Demo> getDemos() {
        return demoService.getDemos();
    }

    /**
     * saveDemo.
     * @param demo {@link Demo}
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveDemo(@RequestBody @Valid Demo demo) {
        demoService.save(demo);
    }

    /**
     * findDemoById.
     * @param id {@link Integer}
     * @return {@link Demo}
     */
    @GetMapping(path = "/{id}")
    public Demo findDemoById(@PathVariable("id") Integer id) {
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
