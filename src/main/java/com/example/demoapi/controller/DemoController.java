package com.example.demoapi.controller;

import com.example.demoapi.model.Demo;
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

@RestController
@AllArgsConstructor
@RequestMapping(path = "${application.api.path}")
public class DemoController {

    private DemoService demoService;

    @GetMapping
    public List<Demo> getDemos() {
        return demoService.getDemos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveDemo(@RequestBody Demo demo) {
        demoService.save(demo);
    }

    @GetMapping(path = "/{id}")
    public Demo findDemoById(@PathVariable("id") Integer id) {
        return demoService.findDemo(id);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDemo(@PathVariable("id") Integer id) {
        demoService.deleteDemo(id);
    }
}
