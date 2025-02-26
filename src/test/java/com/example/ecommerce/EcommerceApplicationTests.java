package com.example.ecommerce;

import com.example.ecommerce.common.dto.PriceDto;
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
class EcommerceApplicationTests {

    private final TestRestTemplate testRestTemplate = new TestRestTemplate();
    private String url;
    @LocalServerPort
    private int port;

    @BeforeEach
    public void setUp() {
        url = String.format("http://localhost:%d/ecommerce/price", port);
    }

    @Test
    void getPriceTest1() {
        getPriceGenericTest(35455, 1, "2020-06-14T10:00:00",  1);
    }

    @Test
    void getPriceTest2() {
        getPriceGenericTest(35455, 1, "2020-06-14T16:00:00",  2);
    }

    @Test
    void getPriceTest3() {
        getPriceGenericTest(35455, 1, "2020-06-14T21:00:00",  1);
    }

    @Test
    void getPriceTest4() {
        getPriceGenericTest(35455, 1, "2020-06-15T10:00:00",  3);
    }

    @Test
    void getPriceTest5() {
        getPriceGenericTest(35455, 1, "2020-06-16T21:00:00",  4);
    }

    private void getPriceGenericTest(Integer productId, Integer brandId, String applicationDate, Integer priceListId) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).path("/").path(String.valueOf(productId))
                                                                            .path("/").path(String.valueOf(brandId))
                                                                            .queryParam("applicationDate", applicationDate);
        String urlPrice = builder.toUriString();

        ResponseEntity<PriceDto> responseString = testRestTemplate.exchange(urlPrice, HttpMethod.GET, null, PriceDto.class);

        assertAll("Assertions of Price",
                () -> assertEquals(200, responseString.getStatusCode().value(), "HTTP Status Code 200 OK"),
                () -> assertEquals(priceListId, Objects.requireNonNull(responseString.getBody()).getPriceListId(), "OK to priceListId")
        );


    }

}
