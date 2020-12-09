package com.javatest.exchange.controller;

import com.javatest.exchange.dto.CashDto;
import com.javatest.exchange.service.CashService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cash")
@RequiredArgsConstructor
public class CashController {

    private final CashService cashService;

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateCash(@RequestBody CashDto cash) {
        cashService.updateCash(cash);
    }
}
