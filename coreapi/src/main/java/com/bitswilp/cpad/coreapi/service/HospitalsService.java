package com.bitswilp.cpad.coreapi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HospitalsService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String STATISTICS_URL = "http://localhost:8081/get-stats";
    private static final String BED_AVAILABILITY_QUERY_SYSTEM_URL = "http://localhost:8082/get-availability";
    private static final String NEARYBY_HOSPITAL_FINDER_SYSTEM_URL = "http://localhost:8083/get-nearby";

    public String getStats(String hospital) {
        String url = STATISTICS_URL + "/" + hospital;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }

    public String getBedsAvailability(String hospital) {
        String url = BED_AVAILABILITY_QUERY_SYSTEM_URL + "/" + hospital;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }

    public String getNearbyHospitals(String coordinates) {
        String url = NEARYBY_HOSPITAL_FINDER_SYSTEM_URL + "/" + coordinates;
        ResponseEntity<String> response = restTemplate.postForEntity(url, coordinates, String.class);
        return response.getBody();
    }
}
