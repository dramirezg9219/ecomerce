package com.example.ecommerce.usecase;

import com.example.ecommerce.common.Constants;
import com.example.ecommerce.domain.model.Price;
import com.example.ecommerce.domain.repository.PriceRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class FindPriceInteractor implements IFindPriceInteractor {

    private final PriceRepositoryPort priceRepository;

    @Override
    public Price findPriceByElements(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        return priceRepository.findPriceByElements(applicationDate, productId, brandId)
                .orElseThrow(() -> new NoSuchElementException(Constants.NO_RESULT));
    }
}
