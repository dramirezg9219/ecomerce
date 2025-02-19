package com.example.ecomerce.domain.repository;

import com.example.ecomerce.domain.modelo.ProductPrice;

import java.time.LocalDateTime;

public interface ProductPriceRepositoryPort {
    ProductPrice findProductByElements(LocalDateTime applicatioDate, Integer productId, Integer brandId);
}
