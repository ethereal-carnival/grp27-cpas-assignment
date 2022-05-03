package com.bitswilp.cpad.dataimporter.services;

import com.bitswilp.cpad.commonlibrary.communicationmodels.BedsAvailability;
import com.bitswilp.cpad.commonlibrary.communicationmodels.Hospital;
import com.bitswilp.cpad.commonlibrary.communicationmodels.Statistics;
import com.bitswilp.cpad.dataimporter.model.CSVModel;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

import static com.bitswilp.cpad.commonlibrary.constants.URLs.BED_AVAILABILITY;
import static com.bitswilp.cpad.commonlibrary.constants.URLs.NEARBY_HOSPITALS;
import static com.bitswilp.cpad.commonlibrary.constants.URLs.STATS;
import static com.bitswilp.cpad.commonlibrary.constants.URLs.URL_COMPONENT_ADD;
import static com.bitswilp.cpad.commonlibrary.constants.URLs.getBedsAvailabilityUrl;
import static com.bitswilp.cpad.commonlibrary.constants.URLs.getNearbyHospitalsUrl;
import static com.bitswilp.cpad.commonlibrary.constants.URLs.getStatsUrl;

@Service
public class DataUpdaterService {
    private final RestTemplate restTemplate = new RestTemplate();

    private final Logger logger = LoggerFactory.getLogger(DataUpdaterService.class);

    public void updateData(MultipartFile file) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            // create csv bean reader
            CsvToBean<CSVModel> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVModel.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            // convert `CsvToBean` object to list of users
            List<CSVModel> objects = csvToBean.parse();

            List<Hospital> hospitals = objects.stream()
                    .map(object -> new Hospital(object.getHospitalId(), object.getName(), object.getAddress(), object.getGpsCoordinates()))
                    .collect(Collectors.toList());
            List<BedsAvailability> bedsAvailabilities = objects.stream()
                    .map(object -> new BedsAvailability(object.getGeneralBeds(), object.getIcuRegularBeds(), object.getIcuVentilatorBeds()))
                    .collect(Collectors.toList());
            List<Statistics> statistics = objects.stream()
                    .map(object -> new Statistics(object.getActiveCases(), object.getTotalDeaths(), object.getNumRecovered()))
                    .collect(Collectors.toList());

            String hospitalsUrl = getNearbyHospitalsUrl() + URL_COMPONENT_ADD + NEARBY_HOSPITALS;
            String bedAvailabilityUrl = getBedsAvailabilityUrl() + URL_COMPONENT_ADD + BED_AVAILABILITY;
            String statsUrl = getStatsUrl() + URL_COMPONENT_ADD + STATS;

            restTemplate.postForEntity(hospitalsUrl, hospitals, String.class);
            restTemplate.postForEntity(bedAvailabilityUrl, bedsAvailabilities, String.class);
            restTemplate.postForEntity(statsUrl, statistics, String.class);

        } catch (Exception ex) {
            logger.error(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
