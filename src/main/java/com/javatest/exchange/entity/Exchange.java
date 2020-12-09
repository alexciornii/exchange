package com.javatest.exchange.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "schimb_valutar")
@NoArgsConstructor
@AllArgsConstructor
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

    public Exchange(Currency currency, Float course, Float amountReceived, Float amountReleased) {
        this.currency = currency;
        this.course = course;
        this.amountReceived = amountReceived;
        this.amountReleased = amountReleased;
        this.exchangeDate = new Date().getTime();
    }
}
