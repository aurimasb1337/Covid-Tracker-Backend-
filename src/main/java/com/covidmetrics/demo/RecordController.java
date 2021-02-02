package com.covidmetrics.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api")
public class RecordController {
    final Logger logger = LoggerFactory.getLogger(RecordController.class);
    List<Record> records;

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        logger.info("Started getting records from url.");
        return args -> {
            ResponseEntity<List<Record>> responseEntity =
                    restTemplate.exchange(
                            "https://opendata.ecdc.europa.eu/covid19/nationalcasedeath/json/",
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<List<Record>>() {}
                    );
            records = responseEntity.getBody();
            if(records !=  null)
            logger.info("Total records obtained are " + records.size());
            else
                logger.warn("unable to get records from provided url.");
        };
    }
    @CrossOrigin
    @GetMapping("{countryName}")
    public ResponseEntity<?> getFilteredRecords(@PathVariable String countryName){
        if (records == null){
            return new ResponseEntity<>("no records available.", HttpStatus.NOT_FOUND);
        }else{
            List<Record> filteredRecords = records
                    .stream()
                    .filter(r -> r.getCountry().equals(countryName))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(filteredRecords, HttpStatus.OK);
        }
    }
}
