package com.example.ecomerce;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EcomerceApplicationTests {

    private TestRestTemplate restTemplate = new TestRestTemplate();
    private String url;
    @LocalServerPort
    private int port;

    void contextLoads() {
    }

    @BeforeEach
    public void setUp() {
        url = String.format("http://localhost:%d/ecomerce/price", port);
    }

    @Test
    void getPriceTest1() {
        comunTest(35455, 1, "2020-06-14T10:00:00",  1);
    }

    @Test
    void getPriceTest2() {
        comunTest(35455, 1, "2020-06-14T16:00:00",  2);
    }

    @Test
    void getPriceTest3() {
        comunTest(35455, 1, "2020-06-14T21:00:00",  1);
    }

    @Test
    void getPriceTest4() {
        comunTest(35455, 1, "2020-06-15T10:00:00",  3);
    }

    @Test
    void getPriceTest5() {
        comunTest(35455, 1, "2020-06-16T21:00:00",  4);
    }

    private void comunTest(Integer productId, Integer brandId, String applicatioDate, Integer priceListId) {

        //Query Params
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).path("/").path(String.valueOf(productId))
                                                                            .path("/").path(String.valueOf(brandId))
                                                                            .queryParam("applicationDate", applicatioDate);
        String urlPrice = builder.toUriString();

        ResponseEntity<String> responseString = restTemplate.exchange(urlPrice, HttpMethod.GET, null, String.class);
        assertEquals(200, responseString.getStatusCode().value(), "HTTP Status Code 200 OK");


    }

}
