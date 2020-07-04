package com.breed.dogceo.infrastructure.rest_client;

import com.breed.dogceo.domain.InvalidDogCeoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class DogCeoRestClient {

    private static final String URL_LIST = "https://dog.ceo/api/breeds/list/all";
    private static final String URL_DETAIL = "https://dog.ceo/api/breed/{breed_name}/images";

    @Autowired
    private RestTemplate restTemplate;

    public String getBreedList() {
        try {
            String restResponse =  restTemplate.getForObject(URL_LIST, String.class);
            log.info("Lista obtenida");
            return restResponse;
        } catch (Exception e) {
            log.error("No se pudo obtener la lista", e);
            throw new InvalidDogCeoException("No se pudo obtener la lista");
        }
    }

    public String getBreedImages(String breedName) {
        try {
            String restResponse =  restTemplate.getForObject(URL_DETAIL, String.class, breedName);
            log.info("Detalle obtenido de [{}]", breedName);
            return restResponse;
        } catch (Exception e) {
            log.error("No se pudo obtener la lista de sub breeds", e);
            throw new InvalidDogCeoException("No se pudo obtener la lista de sub breeds");
        }
    }
}
