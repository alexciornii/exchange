package com.javatest.exchange.controller;

import com.javatest.exchange.dto.ExchangeDto;
import com.javatest.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/exchange")
@RequiredArgsConstructor
public class ExchangeController {

    private final ExchangeService exchangeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createExchange(@RequestBody ExchangeDto exchange) {
        exchangeService.createExchange(exchange);
    }
}
