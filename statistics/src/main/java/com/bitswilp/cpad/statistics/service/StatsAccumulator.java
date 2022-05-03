package com.bitswilp.cpad.statistics.service;

import com.bitswilp.cpad.commonlibrary.communicationmodels.Statistics;
import com.bitswilp.cpad.statistics.persistence.StatisticsDBEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class StatsAccumulator {

    public Statistics accumulateCount(List<StatisticsDBEntity> allByHospitalId) {
        AtomicInteger activeCases = new AtomicInteger();
        AtomicInteger totalCases = new AtomicInteger();
        AtomicInteger numRecovered = new AtomicInteger();
        allByHospitalId.forEach(statisticsDBEntity -> {
            activeCases.addAndGet(statisticsDBEntity.getActiveCases());
            totalCases.addAndGet(statisticsDBEntity.getTotalCases());
            numRecovered.addAndGet(statisticsDBEntity.getNumRecovered());
        });
        return new Statistics(activeCases.get(), totalCases.get(), numRecovered.get());
    }
}
