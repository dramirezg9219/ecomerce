package com.example.ecomerce.usecase;

import com.example.ecomerce.domain.model.Price;

import java.time.LocalDateTime;

public interface IFindPriceIteractor {

    Price findProductByElements(LocalDateTime applicatioDate, Integer productId, Integer brandId);
}
