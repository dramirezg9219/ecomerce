package com.example.ecomerce.infrastructure.database.h2.jparepository;

import com.example.ecomerce.infrastructure.database.h2.entity.PriceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {

    Page<PriceEntity> findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(Integer productId, Integer brandId, LocalDateTime applicationDate, LocalDateTime applicationDate1, Pageable pageable);
}
