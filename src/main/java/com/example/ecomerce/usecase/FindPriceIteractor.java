package com.example.ecomerce.usecase;

import com.example.ecomerce.common.Constants;
import com.example.ecomerce.domain.modelo.Price;
import com.example.ecomerce.domain.repository.PriceRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class FindPriceIteractor implements IFindPriceIteractor {

    private final PriceRepositoryPort productPriceRepositoryPort;

    @Override
    public Price findProductByElements(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        return productPriceRepositoryPort.findProductByElements(applicationDate, productId, brandId)
                .orElseThrow(() -> new IllegalArgumentException(Constants.NO_RESULT));
    }
}
