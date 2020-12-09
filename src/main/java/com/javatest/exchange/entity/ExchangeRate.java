package com.javatest.exchange.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "curs_valutar")
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "currency_code", referencedColumnName = "code")
    private Currency currency;

    private Integer rate;

    @Column(precision = 10, scale = 2)
    private Float course;

    @Column(name = "course_date")
    private Long courseDate;

    public ExchangeRate(Currency currency, Integer rate, Float course) {
        this.currency = currency;
        this.rate = rate;
        this.course = course;
        this.courseDate = new Date().getTime();
    }
}
