package com.bitswilp.cpad.webapp.controller;

import com.bitswilp.cpad.commonlibrary.communicationmodels.BedsAvailability;
import com.bitswilp.cpad.commonlibrary.communicationmodels.Hospital;
import com.bitswilp.cpad.commonlibrary.communicationmodels.Statistics;
import com.bitswilp.cpad.webapp.services.CoreAPICallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WebAppController {

    private final CoreAPICallerService coreAPICallerService;

    @Autowired
    public WebAppController(CoreAPICallerService coreAPICallerService) {
        this.coreAPICallerService = coreAPICallerService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<String> hospitalsList = coreAPICallerService.getNearbyHospitalNames("0, 0");
        model.addAttribute("hospitalsList", hospitalsList);
        return "index";
    }

    @GetMapping("/stats")
    public String stats(@RequestParam String hospitalNameForStats, Model model) {
        Statistics statisticsForHospital = coreAPICallerService.getStatisticsForHospital(hospitalNameForStats);
        model.addAttribute("hospitalName", hospitalNameForStats);
        model.addAttribute("statisticsForHospital", statisticsForHospital);
        return "stats";
    }

    @GetMapping("/beds")
    public String beds(@RequestParam String hospitalNameForBeds, Model model) {
        BedsAvailability bedsInHospital = coreAPICallerService.getBedsInHospital(hospitalNameForBeds);
        model.addAttribute("hospitalName", hospitalNameForBeds);
        model.addAttribute("bedsInHospital", bedsInHospital);
        return "beds";
    }

    @GetMapping("/nearby")
    public String nearby(@RequestParam String gpsCoordinates, Model model) {
        List<Hospital> nearbyHospitals = coreAPICallerService.getNearbyHospitals(gpsCoordinates);
        model.addAttribute("nearbyHospitals", nearbyHospitals);
        return "nearby";
    }
}
