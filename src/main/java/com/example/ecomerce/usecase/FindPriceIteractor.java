package com.example.ecomerce.usecase;

import com.example.ecomerce.common.Constants;
import com.example.ecomerce.domain.model.Price;
import com.example.ecomerce.domain.repository.PriceRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class FindPriceIteractor implements IFindPriceIteractor {

    private final PriceRepositoryPort productPriceRepositoryPort;

    @Override
    public Price findPriceByElements(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        return productPriceRepositoryPort.findPriceByElements(applicationDate, productId, brandId)
                .orElseThrow(() -> new NoSuchElementException(Constants.NO_RESULT));
    }
}
