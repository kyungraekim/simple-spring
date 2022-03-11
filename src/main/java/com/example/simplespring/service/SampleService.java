package com.example.simplespring.service;

import com.example.simplespring.client.ExternalClient;
import com.example.simplespring.dto.ResponseDto;
import com.example.simplespring.dto.RequestBodyDto;
import com.example.simplespring.dto.IntermediateDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SampleService {
    private final ExternalClient client;

    public SampleService(ExternalClient client) {
        this.client = client;
    }

    public ResponseDto serve(RequestBodyDto config) {
        IntermediateDto intermediateDto = client.get(config.getIntInput(), config.getDoubleInput());
        ResponseDto outputDto = new ResponseDto();
        outputDto.setIntOutput(intermediateDto.getIntValue());
        outputDto.setDoubleOutput(intermediateDto.getDoubleValue());

        String outputUri = serveInside(intermediateDto);
        outputDto.setStringOutput(outputUri);
        return outputDto;
    }

    private String serveInside(IntermediateDto intermediateDto) {
        return String.format(Arrays.toString(intermediateDto.getIntArray()));
    }
}
