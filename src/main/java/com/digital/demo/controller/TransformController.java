package com.digital.demo.controller;

import com.digital.demo.dto.TransformedData;
import com.digital.demo.service.TransformService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransformController {

    private final TransformService transformService;

    public TransformController(TransformService transformService) {
        this.transformService = transformService;
    }

    @GetMapping("/transformed-data")
    public TransformedData getTransformedData() {
        return transformService.fetchAndTransformData();
    }
}
