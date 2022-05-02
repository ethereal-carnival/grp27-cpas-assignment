package com.bitswilp.cpad.nearbyhospitalfinder.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalsRepository extends JpaRepository<HospitalsDBEntity, String> {
    HospitalsDBEntity findByName(String name);
    List<HospitalsDBEntity> findAllByGpsCoordinates(String gpsCoordinates);
}
