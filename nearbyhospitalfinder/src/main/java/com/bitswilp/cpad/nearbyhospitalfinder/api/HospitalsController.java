package com.bitswilp.cpad.nearbyhospitalfinder.api;

import com.bitswilp.cpad.businessconstants.HospitalsResponse;
import com.bitswilp.cpad.nearbyhospitalfinder.persistence.HospitalsDBEntity;
import com.bitswilp.cpad.nearbyhospitalfinder.service.HospitalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HospitalsController {

    private final HospitalsService hospitalsService;

    @Autowired
    public HospitalsController(HospitalsService hospitalsService) {
        this.hospitalsService = hospitalsService;
    }

    @PostMapping("add-data")
    public void addData(@RequestParam HospitalsDBEntity hospitalsDBEntity) {
        hospitalsService.addData(hospitalsDBEntity);
    }

    @PostMapping("get-stats")
    public List<HospitalsResponse> getNearbyHospital(@RequestParam String coordinates) {
        return hospitalsService.getNearbyHospital(coordinates);
    }

    @PostMapping("get-id")
    public String getHospitalIdByName(@RequestParam String name) {
        return hospitalsService.getHospitalIdByName(name);
    }
}
