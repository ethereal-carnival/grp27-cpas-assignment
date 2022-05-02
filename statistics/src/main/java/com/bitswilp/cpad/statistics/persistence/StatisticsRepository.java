package com.bitswilp.cpad.statistics.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticsRepository extends JpaRepository<StatisticsDBEntity, String> {
    List<StatisticsDBEntity> findAllByHospitalId(String hospitalID);
}
