package com.bitswilp.cpad.statistics.service;

import com.bitswilp.cpad.commonlibrary.communicationmodels.Statistics;
import com.bitswilp.cpad.statistics.persistence.StatisticsDBEntity;
import com.bitswilp.cpad.statistics.persistence.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService {

    private final StatisticsRepository statisticsRepository;
    private final StatsAccumulator statsAccumulator;

    @Autowired
    public StatisticsService(StatisticsRepository statisticsRepository, StatsAccumulator statsAccumulator) {
        this.statisticsRepository = statisticsRepository;
        this.statsAccumulator = statsAccumulator;
    }

    public void addData(StatisticsDBEntity statisticsDBEntity) {
        // Each data addition is statistics for one day
        statisticsRepository.save(statisticsDBEntity);
    }

    public Statistics getStats(String hospitalId) {
        List<StatisticsDBEntity> allStatisticsSubmittedByHospital = statisticsRepository.findAllByHospitalId(hospitalId);
        return statsAccumulator.accumulateCount(allStatisticsSubmittedByHospital);
    }
}
