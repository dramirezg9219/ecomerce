package com.example.ecomerce.usecase;

import com.example.ecomerce.domain.modelo.Price;
import com.example.ecomerce.domain.repository.PriceRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class FindPriceIteractor implements IFindPriceIteractor {

    private final PriceRepositoryPort productPriceRepositoryPort;

    @Override
    public Price findProductByElements(LocalDateTime applicatioDate, Integer productId, Integer brandId) {
        return productPriceRepositoryPort.findProductByElements(applicatioDate, productId, brandId);
    }
}
