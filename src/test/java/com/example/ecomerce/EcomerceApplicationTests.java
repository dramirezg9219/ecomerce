package com.example.ecomerce;

import com.example.ecomerce.common.dto.PriceDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EcomerceApplicationTests {

    private final TestRestTemplate restTemplate = new TestRestTemplate();
    private String url;
    @LocalServerPort
    private int port;

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

    private void comunTest(Integer productId, Integer brandId, String applicationDate, Integer priceListId) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).path("/").path(String.valueOf(productId))
                                                                            .path("/").path(String.valueOf(brandId))
                                                                            .queryParam("applicationDate", applicationDate);
        String urlPrice = builder.toUriString();

        ResponseEntity<PriceDto> responseString = restTemplate.exchange(urlPrice, HttpMethod.GET, null, PriceDto.class);

        assertAll("Assertions of Price",
                () -> assertEquals(200, responseString.getStatusCode().value(), "HTTP Status Code 200 OK"),
                () -> assertEquals(priceListId, Objects.requireNonNull(responseString.getBody()).getPriceListId(), "OK to priceListId")
        );


    }

}
