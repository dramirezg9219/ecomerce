package com.example.ecomerce.domain.repository;

import com.example.ecomerce.domain.modelo.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepositoryPort {
    Optional<Price> findProductByElements(LocalDateTime applicatioDate, Integer productId, Integer brandId);
}
