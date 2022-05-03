package com.bitswilp.cpad.webapp.services.hospitalscache;

import com.bitswilp.cpad.commonlibrary.communicationmodels.Hospital;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class HospitalsCache {
    private boolean isCacheInitialised;
    private final Logger logger = LoggerFactory.getLogger(HospitalsCache.class);
    private final List<Hospital> allHospitals;
    private final Map<String, Hospital> hospitalIdToHospital;
    private final Map<String, Hospital> hospitalNameToHospital;

    @Autowired
    public HospitalsCache() {
        this.hospitalIdToHospital = new HashMap<>();
        this.hospitalNameToHospital = new HashMap<>();
        this.allHospitals = new ArrayList<>();
        isCacheInitialised = false;
    }

    public void initialiseCache(List<Hospital> hospitals) {
        if (isCacheInitialised) {
            logger.info("HospitalCache was already initialised. Clearing and reinitialising...");
        }

        this.allHospitals.clear();
        this.hospitalIdToHospital.clear();
        this.hospitalNameToHospital.clear();
        this.allHospitals.addAll(hospitals);
        this.hospitalIdToHospital.putAll(hospitals.stream().collect(Collectors.toMap(Hospital::getId, hospital -> hospital)));
        this.hospitalNameToHospital.putAll(hospitals.stream().collect(Collectors.toMap(Hospital::getName, hospital -> hospital)));

        logger.info("HospitalCache initialised");

        isCacheInitialised = true;
    }

    public Hospital getHospitalById(String id) {
        assert isCacheInitialised;
        return hospitalIdToHospital.get(id);
    }

    public Hospital getHospitalByName(String name) {
        assert isCacheInitialised;
        return hospitalNameToHospital.get(name);
    }

    public List<Hospital> getAllHospitals() {
        assert isCacheInitialised;
        return allHospitals;
    }

    public List<String> getAllHospitalIds() {
        assert isCacheInitialised;
        return new ArrayList<>(hospitalIdToHospital.keySet());
    }

    public List<String> getAllHospitalName() {
        assert isCacheInitialised;
        return new ArrayList<>(hospitalNameToHospital.keySet());
    }

    public String getIdFromName(String name) {
        assert isCacheInitialised;
        return hospitalNameToHospital.get(name).getId();
    }
}
