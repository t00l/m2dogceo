package com.breed.dogceo.domain.service;

import com.breed.dogceo.infrastructure.rest_client.DogCeoRestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DogCeoService {

    @Autowired
    private DogCeoRestClient dogCeoRestClient;

    public String getBreedList() {
        log.info("entramos a obtener datos ");
        return dogCeoRestClient.getBreedList();
    }

    public String getBreedImages(String breedName) {
        log.info("entramos a obtener datos de: [{}]", breedName);
        return dogCeoRestClient.getBreedImages(breedName);
    }
}
