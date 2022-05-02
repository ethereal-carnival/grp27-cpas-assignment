package com.bitswilp.cpad.dataimporter.services;

import com.bitswilp.cpad.dataimporter.model.Beds;
import com.bitswilp.cpad.dataimporter.model.Hospitals;
import com.bitswilp.cpad.dataimporter.model.Statistics;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Service
public class DataUpdaterService {
    private final RestTemplate restTemplate = new RestTemplate();

    private static final String STATISTICS_ADD_DATA_URL = "http://localhost:8081/add-stats";
    private static final String BED_AVAILABILITY_ADD_DATA_URL = "http://localhost:8082/add-availability";
    private static final String HOSPITALS_ADD_DATA_URL = "http://localhost:8083/add-nearby";

    public boolean updateStatistics(MultipartFile file) {
        return updateData(file, STATISTICS_ADD_DATA_URL, Statistics.class);
    }

    public boolean updateBedsData(MultipartFile file) {
        return updateData(file, BED_AVAILABILITY_ADD_DATA_URL, Beds.class);
    }

    public boolean updateHospitals(MultipartFile file) {
        return updateData(file, HOSPITALS_ADD_DATA_URL, Hospitals.class);
    }
    private boolean updateData(MultipartFile file, String url, Class<?> dataModel) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            // create csv bean reader
            CsvToBean<Object> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(dataModel)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            // convert `CsvToBean` object to list of users
            List<Object> objects = csvToBean.parse();

            ResponseEntity<String> response = restTemplate.postForEntity(url, objects, String.class);

            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
