package com.example.ecommerce.infrastructure.database.h2.adapter;

import com.example.ecommerce.common.Constants;
import com.example.ecommerce.domain.model.Price;
import com.example.ecommerce.domain.repository.PriceRepositoryPort;
import com.example.ecommerce.infrastructure.database.h2.entity.PriceEntity;
import com.example.ecommerce.infrastructure.database.h2.jparepository.PriceJpaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PriceRepositoryAdapter implements PriceRepositoryPort {

    private final ModelMapper modelMapper = new ModelMapper();
    private final PriceJpaRepository priceJpaRepository;

    @Override
    public Optional<Price> findPriceByElements(LocalDateTime applicationDate, Integer productId, Integer brandId) {

        Pageable pageable = PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "priority"));
        Page<PriceEntity> pricesEntity = priceJpaRepository.findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(productId, brandId, applicationDate, applicationDate, pageable);

        if (pricesEntity.isEmpty()) {
            throw new NoSuchElementException(Constants.NO_RESULT);
        }
        PriceEntity priceEntity = pricesEntity.get().findFirst().orElseThrow(() -> new NoSuchElementException(Constants.NO_RESULT));

        return Optional.of(modelMapper.map(priceEntity, Price.class));
    }
}
