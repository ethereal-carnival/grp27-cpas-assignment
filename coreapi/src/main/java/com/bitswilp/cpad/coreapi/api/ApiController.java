package com.bitswilp.cpad.coreapi.api;

import com.bitswilp.cpad.coreapi.service.HospitalsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("api")
public class ApiController {

    private final HospitalsService hospitalsService;

    public ApiController(HospitalsService hospitalsService) {
        this.hospitalsService = hospitalsService;
    }

    @PostMapping("stats")
    public String getStats(@RequestParam String hospital) {
        return hospitalsService.getStats(hospital);
    }

    @PostMapping("beds")
    public String getBedsAvailability(@RequestParam String hospital) {
        return hospitalsService.getBedsAvailability(hospital);
    }

    @PostMapping("nearby")
    public String getNearbyHospitals(@RequestParam String coordinates) {
        return hospitalsService.getNearbyHospitals(coordinates);
    }
}
