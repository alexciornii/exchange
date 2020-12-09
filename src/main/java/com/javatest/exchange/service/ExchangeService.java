package com.javatest.exchange.service;

import com.javatest.exchange.dto.ExchangeDto;
import com.javatest.exchange.entity.Currency;
import com.javatest.exchange.entity.Exchange;
import com.javatest.exchange.repository.CurrencyRepository;
import com.javatest.exchange.repository.ExchangeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final ExchangeRepository exchangeRepository;

    private final CurrencyRepository currencyRepository;

    public void createExchange(ExchangeDto exchangeDto) {
        Optional<Currency> optionalCurrency = currencyRepository.findByCode(exchangeDto.getCurrency());
        exchangeRepository.save(new Exchange(
                optionalCurrency.get(),
                exchangeDto.getCourse(),
                exchangeDto.getAmountReceived(),
                exchangeDto.getAmountReleased())
        );
    }
}
