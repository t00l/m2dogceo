package com.breed.dogceo.domain;

public class InvalidDogCeoException extends RuntimeException {
    public InvalidDogCeoException(String message) {
        super(message);
    }
}
