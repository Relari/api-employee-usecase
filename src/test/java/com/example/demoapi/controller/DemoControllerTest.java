package com.example.demoapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import com.example.demoapi.model.domain.DemoRequest;
import com.example.demoapi.model.domain.DemoResponse;
import com.example.demoapi.service.DemoService;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Class: DemoControllerTest.
 * @version 1.0.0
 * @author Relari
 */

class DemoControllerTest {

    @Mock
    private DemoService demoService;

    @InjectMocks
    private DemoController demoController;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getDemos() {

        var demo = new DemoResponse(1, "Demo 1");

        when(demoService.getDemos())
                .thenReturn(Collections.singletonList(demo));

        var demos = demoController.getDemos();

        assertEquals(demo.id(), demos.get(0).id());
        assertEquals(demo.description(), demos.get(0).description());

    }

    @Test
    void saveDemo() {

        demoService.save(any());

        var demo = new DemoRequest("Demo 1");

        demoController.saveDemo(demo);

        assertNotNull(demo);
    }

    @Test
    void findDemoById() {

        var demo = new DemoResponse(1, "Demo 1");

        when(demoService.findDemo(anyInt()))
                .thenReturn(demo);

        var demoResponse = demoController.findDemoById(1);

        assertEquals(demo.id(), demoResponse.id());
        assertEquals(demo.description(), demoResponse.description());

    }

    @Test
    void deleteDemoById() {

        demoService.deleteDemo(anyInt());

        var demo = new DemoResponse(1, "Demo 1");

        demoController.deleteDemoById(demo.id());

        assertNotNull(demo);

    }
}