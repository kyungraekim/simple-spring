package com.example.simplespring.controller;

import com.example.simplespring.dto.RequestBodyDto;
import com.example.simplespring.dto.ResponseDto;
import com.example.simplespring.service.SampleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("root")
public class SampleRestApi {
    private final SampleService service;

    public SampleRestApi(SampleService service) {
        this.service = service;
    }

    @PostMapping("/path")
    public ResponseEntity<ResponseDto> createSimulatorWithSector(@RequestBody RequestBodyDto config) {
        ResponseDto output = service.serve(config);
        return ResponseEntity.ok(output);
    }
}
