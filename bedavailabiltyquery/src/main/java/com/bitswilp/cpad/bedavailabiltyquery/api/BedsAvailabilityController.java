package com.bitswilp.cpad.bedavailabiltyquery.api;

import com.bitswilp.cpad.bedavailabiltyquery.persistence.BedsAvailabilityDBEntity;
import com.bitswilp.cpad.bedavailabiltyquery.service.BedsAvailabilityService;
import com.bitswilp.cpad.businessconstants.AvailabilityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BedsAvailabilityController {

    private final BedsAvailabilityService bedsAvailabilityService;

    @Autowired
    public BedsAvailabilityController(BedsAvailabilityService bedsAvailabilityService) {
        this.bedsAvailabilityService = bedsAvailabilityService;
    }

    @PostMapping("add-data")
    public void addData(@RequestParam BedsAvailabilityDBEntity bedsAvailabilityDBEntity) {
        bedsAvailabilityService.addData(bedsAvailabilityDBEntity);
    }

    @PostMapping("get-stats")
    public AvailabilityResponse getStats(@RequestParam String hospitalId) {
        return bedsAvailabilityService.getStats(hospitalId);
    }
}
