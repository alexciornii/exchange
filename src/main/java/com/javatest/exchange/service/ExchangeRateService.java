package com.javatest.exchange.service;

import com.javatest.exchange.dto.ExchangeRateDto;
import com.javatest.exchange.entity.Currency;
import com.javatest.exchange.entity.ExchangeRate;
import com.javatest.exchange.repository.CurrencyRepository;
import com.javatest.exchange.repository.ExchangeRateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    public void createExchangeRate(ExchangeRateDto exchangeRateDto) {
        Optional<Currency> optionalCurrency = currencyRepository.findByCode(exchangeRateDto.getCurrency());
        try {
            if (optionalCurrency.isPresent()) {
                exchangeRateRepository.save(new ExchangeRate(
                        optionalCurrency.get(),
                        exchangeRateDto.getRate(),
                        exchangeRateDto.getCourse())
                );
            }
        } catch (Exception e) {
            log.error("Undefined error during save exchange rate {}; {}", exchangeRateDto, e.getMessage(), e);
        }
    }
}
