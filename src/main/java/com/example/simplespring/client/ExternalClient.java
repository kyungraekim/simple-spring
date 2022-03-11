package com.example.simplespring.client;

import com.example.simplespring.config.ClientConfig;
import com.example.simplespring.dto.IntermediateDto;
import org.springframework.stereotype.Service;

@Service
public class ExternalClient {
    private String host;
    private int port;

    public ExternalClient(ClientConfig config) {
        this.host = config.getHost();
        this.port = config.getPort();
        checkInjection();
    }

    public IntermediateDto get(int siteId, double sectorId) {
        IntermediateDto sectorParameters = new IntermediateDto();
        sectorParameters.setIntValue(siteId);
        sectorParameters.setDoubleValue(sectorId);
        sectorParameters.setIntArray(new int[]{1, 2, 3, 4});
        return sectorParameters;
    }

    private void checkInjection() {
        System.out.println("External Client - " + host + ':' + port);
    }
}
