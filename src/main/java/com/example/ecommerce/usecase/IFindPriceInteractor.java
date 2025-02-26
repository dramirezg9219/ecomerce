package com.example.ecommerce.usecase;

import com.example.ecommerce.domain.model.Price;

import java.time.LocalDateTime;

public interface IFindPriceInteractor {

    Price findPriceByElements(LocalDateTime applicationDate, Integer productId, Integer brandId);
}
