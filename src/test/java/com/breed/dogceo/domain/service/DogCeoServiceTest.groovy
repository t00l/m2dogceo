package com.breed.dogceo.domain.service

import com.breed.dogceo.domain.InvalidDogCeoException
import com.breed.dogceo.infrastructure.rest_client.DogCeoRestClient
import spock.lang.Specification

class DogCeoServiceTest extends Specification {

    DogCeoRestClient dogCeoRestClient = Mock(DogCeoRestClient)

    DogCeoService dogCeoService = new DogCeoService()

    void setup() {
        dogCeoService.dogCeoRestClient = dogCeoRestClient
    }

    void "return a list of breeds if response is ok"() {
        given: "happy path"
        dogCeoRestClient.getBreedList() >> { return responseBreedList }
        when: "try to retrieve a list"
        String response = dogCeoService.getBreedList()
        then:
        noExceptionThrown()
        response.equals(responseBreedList)
    }

    void "return a exception when the endpoint try to get a list"() {
        given:
        dogCeoRestClient.getBreedList() >> { throw new InvalidDogCeoException("No se pudo obtener la lista"
        ) }
        when: "try to retrieve a list"
        String response = dogCeoService.getBreedList()
        then:
        def error = thrown(InvalidDogCeoException)
        error.getMessage() == "No se pudo obtener la lista"
    }

    void "return a detail of sub breeds if response is ok"() {
        given: "happy path"
        String breedName = "hound"
        dogCeoRestClient.getBreedImages(breedName) >> { return responseSunBreedList }
        when: "try to retrieve a sub breed list"
        String response = dogCeoService.getBreedImages(breedName)
        then:
        noExceptionThrown()
        response.equals(responseSunBreedList)
    }

    void "return a exception when the endpoint try to get a sub breed list"() {
        given:
        String breedName = "hound"
        dogCeoRestClient.getBreedList() >> { throw new InvalidDogCeoException("No se pudo obtener la lista de " +
                "sub breeds"
        ) }
        when: "try to retrieve a list"
        String response = dogCeoService.getBreedImages(breedName)
        then:
        def error = thrown(InvalidDogCeoException)
        error.getMessage() == "No se pudo obtener la lista de sub breeds"
    }

    private final String responseBreedList = "{\n" +
            "    \"message\": {\n" +
            "        \"affenpinscher\": [],\n" +
            "        \"african\": [],\n" +
            "        \"airedale\": [],\n" +
            "        \"akita\": [],\n" +
            "        \"appenzeller\": [],\n" +
            "        \"australian\": [\n" +
            "            \"shepherd\"\n" +
            "        ],\n" +
            "        \"basenji\": [],\n" +
            "        \"beagle\": [],\n" +
            "        \"bluetick\": [],\n" +
            "        \"borzoi\": [],\n" +
            "        \"bouvier\": [],\n" +
            "        \"boxer\": [],\n" +
            "        \"brabancon\": [],\n" +
            "        \"briard\": [],\n" +
            "        \"buhund\": [\n" +
            "            \"norwegian\"\n" +
            "        ],\n" +
            "        \"bulldog\": [\n" +
            "            \"boston\",\n" +
            "            \"english\",\n" +
            "            \"french\"\n" +
            "        ],\n" +
            "        \"bullterrier\": [\n" +
            "            \"staffordshire\"\n" +
            "        ],\n" +
            "        \"cairn\": [],\n" +
            "        \"cattledog\": [\n" +
            "            \"australian\"\n" +
            "        ],\n" +
            "        \"chihuahua\": [],\n" +
            "        \"chow\": [],\n" +
            "        \"clumber\": [],\n" +
            "        \"cockapoo\": [],\n" +
            "        \"collie\": [\n" +
            "            \"border\"\n" +
            "        ],\n" +
            "        \"coonhound\": [],\n" +
            "        \"corgi\": [\n" +
            "            \"cardigan\"\n" +
            "        ],\n" +
            "        \"cotondetulear\": [],\n" +
            "        \"dachshund\": [],\n" +
            "        \"dalmatian\": [],\n" +
            "        \"dane\": [\n" +
            "            \"great\"\n" +
            "        ],\n" +
            "        \"deerhound\": [\n" +
            "            \"scottish\"\n" +
            "        ],\n" +
            "        \"dhole\": [],\n" +
            "        \"dingo\": [],\n" +
            "        \"doberman\": [],\n" +
            "        \"elkhound\": [\n" +
            "            \"norwegian\"\n" +
            "        ],\n" +
            "        \"entlebucher\": [],\n" +
            "        \"eskimo\": [],\n" +
            "        \"finnish\": [\n" +
            "            \"lapphund\"\n" +
            "        ],\n" +
            "        \"frise\": [\n" +
            "            \"bichon\"\n" +
            "        ],\n" +
            "        \"germanshepherd\": [],\n" +
            "        \"greyhound\": [\n" +
            "            \"italian\"\n" +
            "        ],\n" +
            "        \"groenendael\": [],\n" +
            "        \"havanese\": [],\n" +
            "        \"hound\": [\n" +
            "            \"afghan\",\n" +
            "            \"basset\",\n" +
            "            \"blood\",\n" +
            "            \"english\",\n" +
            "            \"ibizan\",\n" +
            "            \"plott\",\n" +
            "            \"walker\"\n" +
            "        ],\n" +
            "        \"husky\": [],\n" +
            "        \"keeshond\": [],\n" +
            "        \"kelpie\": [],\n" +
            "        \"komondor\": [],\n" +
            "        \"kuvasz\": [],\n" +
            "        \"labrador\": [],\n" +
            "        \"leonberg\": [],\n" +
            "        \"lhasa\": [],\n" +
            "        \"malamute\": [],\n" +
            "        \"malinois\": [],\n" +
            "        \"maltese\": [],\n" +
            "        \"mastiff\": [\n" +
            "            \"bull\",\n" +
            "            \"english\",\n" +
            "            \"tibetan\"\n" +
            "        ],\n" +
            "        \"mexicanhairless\": [],\n" +
            "        \"mix\": [],\n" +
            "        \"mountain\": [\n" +
            "            \"bernese\",\n" +
            "            \"swiss\"\n" +
            "        ],\n" +
            "        \"newfoundland\": [],\n" +
            "        \"otterhound\": [],\n" +
            "        \"ovcharka\": [\n" +
            "            \"caucasian\"\n" +
            "        ],\n" +
            "        \"papillon\": [],\n" +
            "        \"pekinese\": [],\n" +
            "        \"pembroke\": [],\n" +
            "        \"pinscher\": [\n" +
            "            \"miniature\"\n" +
            "        ],\n" +
            "        \"pitbull\": [],\n" +
            "        \"pointer\": [\n" +
            "            \"german\",\n" +
            "            \"germanlonghair\"\n" +
            "        ],\n" +
            "        \"pomeranian\": [],\n" +
            "        \"poodle\": [\n" +
            "            \"miniature\",\n" +
            "            \"standard\",\n" +
            "            \"toy\"\n" +
            "        ],\n" +
            "        \"pug\": [],\n" +
            "        \"puggle\": [],\n" +
            "        \"pyrenees\": [],\n" +
            "        \"redbone\": [],\n" +
            "        \"retriever\": [\n" +
            "            \"chesapeake\",\n" +
            "            \"curly\",\n" +
            "            \"flatcoated\",\n" +
            "            \"golden\"\n" +
            "        ],\n" +
            "        \"ridgeback\": [\n" +
            "            \"rhodesian\"\n" +
            "        ],\n" +
            "        \"rottweiler\": [],\n" +
            "        \"saluki\": [],\n" +
            "        \"samoyed\": [],\n" +
            "        \"schipperke\": [],\n" +
            "        \"schnauzer\": [\n" +
            "            \"giant\",\n" +
            "            \"miniature\"\n" +
            "        ],\n" +
            "        \"setter\": [\n" +
            "            \"english\",\n" +
            "            \"gordon\",\n" +
            "            \"irish\"\n" +
            "        ],\n" +
            "        \"sheepdog\": [\n" +
            "            \"english\",\n" +
            "            \"shetland\"\n" +
            "        ],\n" +
            "        \"shiba\": [],\n" +
            "        \"shihtzu\": [],\n" +
            "        \"spaniel\": [\n" +
            "            \"blenheim\",\n" +
            "            \"brittany\",\n" +
            "            \"cocker\",\n" +
            "            \"irish\",\n" +
            "            \"japanese\",\n" +
            "            \"sussex\",\n" +
            "            \"welsh\"\n" +
            "        ],\n" +
            "        \"springer\": [\n" +
            "            \"english\"\n" +
            "        ],\n" +
            "        \"stbernard\": [],\n" +
            "        \"terrier\": [\n" +
            "            \"american\",\n" +
            "            \"australian\",\n" +
            "            \"bedlington\",\n" +
            "            \"border\",\n" +
            "            \"dandie\",\n" +
            "            \"fox\",\n" +
            "            \"irish\",\n" +
            "            \"kerryblue\",\n" +
            "            \"lakeland\",\n" +
            "            \"norfolk\",\n" +
            "            \"norwich\",\n" +
            "            \"patterdale\",\n" +
            "            \"russell\",\n" +
            "            \"scottish\",\n" +
            "            \"sealyham\",\n" +
            "            \"silky\",\n" +
            "            \"tibetan\",\n" +
            "            \"toy\",\n" +
            "            \"westhighland\",\n" +
            "            \"wheaten\",\n" +
            "            \"yorkshire\"\n" +
            "        ],\n" +
            "        \"vizsla\": [],\n" +
            "        \"waterdog\": [\n" +
            "            \"spanish\"\n" +
            "        ],\n" +
            "        \"weimaraner\": [],\n" +
            "        \"whippet\": [],\n" +
            "        \"wolfhound\": [\n" +
            "            \"irish\"\n" +
            "        ]\n" +
            "    },\n" +
            "    \"status\": \"success\"\n" +
            "}"

    private final String responseSunBreedList = "{\n" +
            "    \"message\": [\n" +
            "        \"afghan\",\n" +
            "        \"basset\",\n" +
            "        \"blood\",\n" +
            "        \"english\",\n" +
            "        \"ibizan\",\n" +
            "        \"plott\",\n" +
            "        \"walker\"\n" +
            "    ],\n" +
            "    \"status\": \"success\"\n" +
            "}"
}