package com.bitswilp.cpad.nearbyhospitalfinder.service;

import com.bitswilp.cpad.commonlibrary.communicationmodels.GPSCoordinates;
import com.bitswilp.cpad.commonlibrary.communicationmodels.Hospital;
import com.bitswilp.cpad.nearbyhospitalfinder.persistence.HospitalsDBEntity;
import com.bitswilp.cpad.nearbyhospitalfinder.persistence.HospitalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HospitalsService {

    private final HospitalsRepository hospitalsRepository;

    @Autowired
    public HospitalsService(HospitalsRepository hospitalsRepository) {
        this.hospitalsRepository = hospitalsRepository;
    }

    public void addData(HospitalsDBEntity hospitalsDBEntity) {
        hospitalsRepository.save(hospitalsDBEntity);
    }

    public String getHospitalIdByName(String name) {
        return hospitalsRepository.findByName(name).getHospitalId();
    }

    public List<Hospital> getNearbyHospital(String coordinates) {
        return hospitalsRepository.findAllByGpsCoordinates(coordinates).stream().map(hospitalsDBEntity -> {
            String[] split = hospitalsDBEntity.getGpsCoordinates().split(",");
            GPSCoordinates gpsCoordinates = new GPSCoordinates(Float.parseFloat(split[0].trim()), Float.parseFloat(split[1].trim()));
            return new Hospital(hospitalsDBEntity.getHospitalId(), hospitalsDBEntity.getName(), hospitalsDBEntity.getAddress(), gpsCoordinates);
        }).collect(Collectors.toList());
    }
}
