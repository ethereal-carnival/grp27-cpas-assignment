package com.bitswilp.cpad.statistics.api;

import com.bitswilp.cpad.commonlibrary.communicationmodels.Statistics;
import com.bitswilp.cpad.statistics.persistence.StatisticsDBEntity;
import com.bitswilp.cpad.statistics.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.bitswilp.cpad.commonlibrary.constants.URLs.STATS;
import static com.bitswilp.cpad.commonlibrary.constants.URLs.URL_COMPONENT_ADD;
import static com.bitswilp.cpad.commonlibrary.constants.URLs.URL_COMPONENT_GET;

@RestController
public class StatsController {

    private final StatisticsService statisticsService;

    @Autowired
    public StatsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @PostMapping(URL_COMPONENT_ADD + STATS)
    public void addData(@RequestParam StatisticsDBEntity statisticsDBEntity) {
        statisticsService.addData(statisticsDBEntity);
    }

    @PostMapping(URL_COMPONENT_GET + STATS)
    public Statistics getStats(@RequestParam String hospitalId) {
        return statisticsService.getStats(hospitalId);
    }
}
