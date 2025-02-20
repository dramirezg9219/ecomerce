package com.example.ecomerce.domain.repository;

import com.example.ecomerce.domain.modelo.Price;

import java.time.LocalDateTime;

public interface PriceRepositoryPort {
    Price findProductByElements(LocalDateTime applicatioDate, Integer productId, Integer brandId);
}
