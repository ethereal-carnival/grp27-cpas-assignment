package com.bitswilp.cpad.nearbyhospitalfinder.api;

import com.bitswilp.cpad.commonlibrary.communicationmodels.Hospital;
import com.bitswilp.cpad.nearbyhospitalfinder.persistence.HospitalsDBEntity;
import com.bitswilp.cpad.nearbyhospitalfinder.service.HospitalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.bitswilp.cpad.commonlibrary.constants.URLs.NEARBY_HOSPITALS;
import static com.bitswilp.cpad.commonlibrary.constants.URLs.URL_COMPONENT_ADD;
import static com.bitswilp.cpad.commonlibrary.constants.URLs.URL_COMPONENT_GET;

@RestController
public class HospitalsController {

    private final HospitalsService hospitalsService;

    @Autowired
    public HospitalsController(HospitalsService hospitalsService) {
        this.hospitalsService = hospitalsService;
    }

    @PostMapping(URL_COMPONENT_ADD + NEARBY_HOSPITALS)
    public void addData(@RequestParam HospitalsDBEntity hospitalsDBEntity) {
        hospitalsService.addData(hospitalsDBEntity);
    }

    @PostMapping(URL_COMPONENT_GET + NEARBY_HOSPITALS)
    public List<Hospital> getNearbyHospital(@RequestParam String coordinates) {
        return hospitalsService.getNearbyHospital(coordinates);
    }
}
