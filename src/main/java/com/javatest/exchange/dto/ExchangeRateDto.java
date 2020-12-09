package com.javatest.exchange.dto;

import lombok.Data;

@Data
public class ExchangeRateDto {

    private String currency;

    private Integer rate;

    private Float course;

    private Long courseDate;
}
