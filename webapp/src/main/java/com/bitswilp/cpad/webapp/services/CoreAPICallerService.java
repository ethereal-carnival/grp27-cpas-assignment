package com.bitswilp.cpad.webapp.services;

import com.bitswilp.cpad.commonlibrary.communicationmodels.BedsAvailability;
import com.bitswilp.cpad.commonlibrary.communicationmodels.Hospital;
import com.bitswilp.cpad.commonlibrary.communicationmodels.Statistics;
import com.bitswilp.cpad.webapp.services.hospitalscache.HospitalsCache;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.bitswilp.cpad.commonlibrary.constants.URLs.BED_AVAILABILITY;
import static com.bitswilp.cpad.commonlibrary.constants.URLs.STATS;
import static com.bitswilp.cpad.commonlibrary.constants.URLs.getCoreApiUrl;

@Service
public class CoreAPICallerService {

    private final RestTemplate restTemplate = new RestTemplate();

    private final HospitalsCache hospitalsCache;

    public CoreAPICallerService(HospitalsCache hospitalsCache) {
        this.hospitalsCache = hospitalsCache;
    }

    public Statistics getStatisticsForHospital(String hospitalName) {
        String getStatsURL = getCoreApiUrl() + STATS;
        return restTemplate.postForEntity(getStatsURL, hospitalsCache.getIdFromName(hospitalName), Statistics.class).getBody();
    }

    public BedsAvailability getBedsInHospital(String hospitalName) {
        String getBedsAvailabilityURL = getCoreApiUrl() + BED_AVAILABILITY;
        return restTemplate.postForEntity(getBedsAvailabilityURL, hospitalsCache.getIdFromName(hospitalName), BedsAvailability.class).getBody();
    }

    public List<Hospital> getNearbyHospitals(String gpsCoordinatesString) {
        return hospitalsCache.getAllHospitals();
    }

    public List<String> getNearbyHospitalNames(String gpsCoordinatesString) {
        return hospitalsCache.getAllHospitalName();
    }
}
