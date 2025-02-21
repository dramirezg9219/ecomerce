package com.example.ecomerce.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PriceDto {

    private Integer productId;
    private Integer brandId;
    private Integer priceListId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal salePrice;
    private String curr;
}
