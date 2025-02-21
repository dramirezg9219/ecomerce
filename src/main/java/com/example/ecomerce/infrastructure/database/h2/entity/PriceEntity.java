package com.example.ecomerce.infrastructure.database.h2.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "PRICE")
public class PriceEntity {

    @Id
    @Column(name = "PRICE_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long priceId;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Integer productId;

    @Column(name = "BRAND_ID", nullable = false)
    private Integer brandId;

    @Column(name = "PRICE_LIST_ID", nullable = false)
    private Integer priceListId;

    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "END_DATE", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "SALE_PRICE", nullable = false)
    private BigDecimal salePrice;

    @Column(name = "CURR", nullable = false)
    private String curr;

    @Column(name = "PRIORITY", nullable = false)
    private Integer priority;

    @Column(name = "INSERT_DATE")
    private LocalDateTime insertDate;

    @Column(name = "UPDATE_DATE")
    private LocalDateTime updateEnd;

    @Column(name = "USERNAME")
    private String username;


}
