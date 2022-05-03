package com.bitswilp.cpad.bedavailabiltyquery.service;

import com.bitswilp.cpad.bedavailabiltyquery.persistence.BedsAvailabilityDBEntity;
import com.bitswilp.cpad.bedavailabiltyquery.persistence.BedsAvailabilityRepository;
import com.bitswilp.cpad.commonlibrary.communicationmodels.BedsAvailability;
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

    public BedsAvailability getStats(String hospitalId) {
        BedsAvailabilityDBEntity availabilityInfo = bedsAvailabilityRepository.findByHospitalId(hospitalId).get(0);
        return new BedsAvailability(availabilityInfo.getGeneralBeds(), availabilityInfo.getIcuRegularBeds(), availabilityInfo.getIcuVentilatorBeds());
    }
}
