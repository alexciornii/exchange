package com.javatest.exchange.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CashDto {

    @NotNull(message = "user can not be null")
    private String user;

    @NotNull(message = "currency can not be null")
    private String currency;

    @NotNull(message = "sum can not be null")
    private Float sum;

    @NotNull(message = "date can not be null")
    private Long date;
}
