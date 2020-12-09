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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "cash")
@NoArgsConstructor
@AllArgsConstructor
public class Cash {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "currency_code", referencedColumnName = "code")
    private Currency currency;

    private Float amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "operator_username", referencedColumnName = "username")
    private Employee operator;

    @Column(name = "created_date")
    private Long createdDate;
}
