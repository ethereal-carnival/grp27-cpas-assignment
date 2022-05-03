package com.bitswilp.cpad.webapp.services.hospitalscache;

import com.bitswilp.cpad.commonlibrary.communicationmodels.GPSCoordinates;
import com.bitswilp.cpad.commonlibrary.communicationmodels.Hospital;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

import static com.bitswilp.cpad.commonlibrary.constants.Constants.DEFAULT_GPS_COORDINATES;
import static com.bitswilp.cpad.commonlibrary.constants.URLs.NEARBY_HOSPITALS;
import static com.bitswilp.cpad.commonlibrary.constants.URLs.getCoreApiUrl;

@Service
public class HospitalsCacheBuilder {

    private final RestTemplate restTemplate = new RestTemplate();
    private final HospitalsCache hospitalsCache;

    public HospitalsCacheBuilder(HospitalsCache hospitalsCache) {
        this.hospitalsCache = hospitalsCache;
    }

    @PostConstruct
    public void buildCache() {
        String getNearbyHospitalsURL = getCoreApiUrl() + NEARBY_HOSPITALS;
        hospitalsCache.initialiseCache((List<Hospital>) restTemplate.postForEntity(getNearbyHospitalsURL, new GPSCoordinates(DEFAULT_GPS_COORDINATES), List.class));
    }
}
