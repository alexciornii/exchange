package com.javatest.exchange.controller;

import com.javatest.exchange.entity.ExchangeRate;
import com.javatest.exchange.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/exchangerate")
@RequiredArgsConstructor
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    @GetMapping(path = "/{currency_code}")
    public ResponseEntity<ExchangeRate> getExchangeRate(@PathVariable String currency_code) {
        Optional<ExchangeRate> exchangeRate = exchangeRateService.getExchangeRateByCurrencyCode(currency_code);
        if (exchangeRate.isPresent()) {
            return ResponseEntity.ok(exchangeRate.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createExchangeRate(@RequestBody ExchangeRate exchangeRate) {
        exchangeRateService.createExchangeRate(exchangeRate);
    }

}
