package com.example.ecomerce.domain.repository;

import com.example.ecomerce.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepositoryPort {
    Optional<Price> findProductByElements(LocalDateTime applicationDate, Integer productId, Integer brandId);
}
