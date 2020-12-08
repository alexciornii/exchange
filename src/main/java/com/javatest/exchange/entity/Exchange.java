package com.javatest.exchange.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "schimb_valutar")
public class Exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "currency_code", referencedColumnName = "code")
    private Currency currency;

    @Column(precision = 10, scale = 2)
    private Float course;

    @Column(name = "amount_received", precision = 10, scale = 2)
    private Float amountReceived;

    @Column(name = "amount_released", precision = 10, scale = 2)
    private Float amountReleased;

    @Column(name = "exchange_date")
    private Long exchangeDate;
}
