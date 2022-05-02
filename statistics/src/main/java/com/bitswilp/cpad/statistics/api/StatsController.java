package com.bitswilp.cpad.statistics.api;

import com.bitswilp.cpad.businessconstants.StatisticsResponse;
import com.bitswilp.cpad.statistics.persistence.StatisticsDBEntity;
import com.bitswilp.cpad.statistics.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatsController {

    private final StatisticsService statisticsService;

    @Autowired
    public StatsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @PostMapping("add-stats")
    public void addData(@RequestParam StatisticsDBEntity statisticsDBEntity) {
        statisticsService.addData(statisticsDBEntity);
    }

    @PostMapping("get-stats")
    public StatisticsResponse getStats(@RequestParam String hospitalId) {
        return statisticsService.getStats(hospitalId);
    }
}
