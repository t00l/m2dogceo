package com.breed.dogceo.infrastructure.controllers;

import com.breed.dogceo.domain.service.DogCeoService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/dogceo/")
@AllArgsConstructor
public class DogCeoController {

    private DogCeoService dogCeoService;

    @GetMapping(value = "/list/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getBreedList() {
        return dogCeoService.getBreedList();
    }

    @GetMapping(value = "/{breed_name}/images", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getBreedImages(@PathVariable("breed_name") String breedName) {
        return dogCeoService.getBreedImages(breedName);
    }
}
