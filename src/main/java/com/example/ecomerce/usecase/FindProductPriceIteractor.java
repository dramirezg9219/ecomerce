package com.example.ecomerce.usecase;

import com.example.ecomerce.domain.modelo.ProductPrice;
import com.example.ecomerce.domain.repository.ProductPriceRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class FindProductPriceIteractor implements IFindProductPriceIteractor {

    private final ProductPriceRepositoryPort productPriceRepositoryPort;

    @Override
    public ProductPrice findProductByElements(LocalDateTime applicatioDate, Integer productId, Integer brandId) {
        return productPriceRepositoryPort.findProductByElements(applicatioDate, productId, brandId);
    }
}
