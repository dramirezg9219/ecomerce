package com.example.ecomerce.domain.modelo;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class Price {

    private Integer productId;
    private Integer brandId;
    private Integer priceListId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price;
    private String curr;

}
