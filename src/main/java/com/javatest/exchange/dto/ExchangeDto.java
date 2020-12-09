package com.javatest.exchange.dto;

import lombok.Data;

@Data
public class ExchangeDto {

    private String currency;

    private Float course;

    private Float amountReceived;

    private Float amountReleased;

    private Long exchangeDate;
}
