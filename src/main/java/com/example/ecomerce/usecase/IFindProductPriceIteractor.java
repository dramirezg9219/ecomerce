package com.example.ecomerce.usecase;

import com.example.ecomerce.domain.modelo.ProductPrice;

import java.time.LocalDateTime;

public interface IFindProductPriceIteractor {

    ProductPrice findProductByElements(LocalDateTime applicatioDate, Integer productId, Integer brandId);
}
