package com.javatest.exchange.repository;

import com.javatest.exchange.entity.Cash;
import com.javatest.exchange.entity.Currency;
import com.javatest.exchange.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CashRepository extends JpaRepository<Cash, Long> {

    Optional<Cash> findByCurrencyAndOperatorAndCreatedDate(Currency currency, Employee operator, Long createdDate);

}
