package com.example.ecomerce.infrastructure.rest.controller;

import com.example.ecomerce.common.dto.PriceDto;
import com.example.ecomerce.domain.modelo.Price;
import com.example.ecomerce.usecase.IFindPriceIteractor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/price", produces = MediaType.APPLICATION_JSON_VALUE)
public class PriceRestController {

    private final IFindPriceIteractor iFindPriceIteractor;
    private final ModelMapper modelMapper;

    @GetMapping(path = "/{productId}/{brandId}")
    public PriceDto getPrice(@PathVariable("productId") Integer productId,
                             @PathVariable("brandId") Integer brandId,
                             @RequestParam(name = "applicationDate") LocalDateTime applicationDate) {
        Price price = iFindPriceIteractor.findProductByElements(applicationDate,productId, brandId);
        return modelMapper.map(price, PriceDto.class);
    }
}
