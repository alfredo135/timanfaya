package com.digital.demo.service;

import com.digital.demo.dto.ExternalData;
import com.digital.demo.dto.TransformedData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class TransformService {

    private final RestTemplate restTemplate;

    public TransformService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public TransformedData fetchAndTransformData() {
        String url = "https://jsonplaceholder.typicode.com/users"; // URL del servicio REST externo
        ExternalData[] externalData = restTemplate.getForObject(url, ExternalData[].class);

        // Transformar los datos (ejemplo simple)
        TransformedData transformedData = new TransformedData();
        transformedData.setTotalUsers(externalData.length);
        transformedData.setUserNames(
            Arrays.stream(externalData)
                  .map(ExternalData::getName)
                  .collect(Collectors.toList())
        );

        return transformedData;
    }
}
