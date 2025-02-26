package com.example.ecommerce.domain.repository;

import com.example.ecommerce.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepositoryPort {
    Optional<Price> findPriceByElements(LocalDateTime applicationDate, Integer productId, Integer brandId);
}
