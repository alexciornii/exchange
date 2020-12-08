package com.javatest.exchange.service;

import com.javatest.exchange.entity.Currency;
import com.javatest.exchange.entity.ExchangeRate;
import com.javatest.exchange.repository.CurrencyRepository;
import com.javatest.exchange.repository.ExchangeRateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExchangeRateService {

    private final CurrencyRepository currencyRepository;

    private final ExchangeRateRepository exchangeRateRepository;

    public Optional<ExchangeRate> getExchangeRateByCurrencyCode(String currency_code) {
        Optional<Currency> optionalCurrency = currencyRepository.findByCode(currency_code.toUpperCase());
        if (optionalCurrency.isPresent()) {
            Optional<ExchangeRate> exchangeRate = exchangeRateRepository.findByCurrency(optionalCurrency.get());
            if (exchangeRate.isPresent()) {
                return exchangeRate;
            }
        }
        return Optional.empty();
    }

    public boolean createExchangeRate(ExchangeRate exchangeRate) {
        exchangeRate.setCourseDate(Timestamp.from(Instant.now()).getTime());
        try {
            exchangeRateRepository.save(exchangeRate);
            return true;
        } catch (Exception e) {
            log.error("Undefined error during save exchange rate {}; {}", exchangeRate, e.getMessage(), e);
        }
        return false;
    }
}
