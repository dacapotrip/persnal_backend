package com.persnal.persnal_backend.borad.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.persnal.persnal_backend.borad.domain.Brewery.BreweryDTO;
import com.persnal.persnal_backend.borad.domain.Brewery.RegionResponse;

@Service
public class BreweryService {

    @Value("${openApi.servicekey}")
    private String serviceKey;

    @Value("${openApi.callBackUrl}")
    private String callBackUrl;

    @Value("${openApi.dataType}")
    private String dataType;

    public List<BreweryDTO> getRegionData(String region) {
        
        String url = callBackUrl + "?serviceKey=" + serviceKey + "&returnType=" + dataType;

        RestTemplate restTemplate = new RestTemplate();
        RegionResponse response = restTemplate.getForObject(url, RegionResponse.class);

        if (response == null || response.getData() == null) {
            return Collections.emptyList();
        }

        return response.getData().stream()
                       .filter(data -> data.get주소().contains(region))
                       .collect(Collectors.toList());
    }
}
