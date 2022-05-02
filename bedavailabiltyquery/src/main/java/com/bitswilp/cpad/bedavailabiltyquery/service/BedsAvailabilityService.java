package com.bitswilp.cpad.bedavailabiltyquery.service;

import com.bitswilp.cpad.bedavailabiltyquery.persistence.BedsAvailabilityDBEntity;
import com.bitswilp.cpad.bedavailabiltyquery.persistence.BedsAvailabilityRepository;
import com.bitswilp.cpad.businessconstants.AvailabilityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BedsAvailabilityService {

    private final BedsAvailabilityRepository bedsAvailabilityRepository;

    @Autowired
    public BedsAvailabilityService(BedsAvailabilityRepository bedsAvailabilityRepository) {
        this.bedsAvailabilityRepository = bedsAvailabilityRepository;
    }

    public void addData(BedsAvailabilityDBEntity bedsAvailabilityDBEntity) {
        bedsAvailabilityRepository.save(bedsAvailabilityDBEntity);
    }

    public AvailabilityResponse getStats(String hospitalId) {
        BedsAvailabilityDBEntity availabilityInfo = bedsAvailabilityRepository.findByHospitalId(hospitalId).get(0);
        return new AvailabilityResponse(availabilityInfo.getGeneralBeds(), availabilityInfo.getIcuRegularBeds(), availabilityInfo.getIcuVentilatorBeds());
    }
}
