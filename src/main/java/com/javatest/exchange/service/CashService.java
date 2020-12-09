package com.javatest.exchange.service;

import com.javatest.exchange.dto.CashDto;
import com.javatest.exchange.entity.Cash;
import com.javatest.exchange.entity.Currency;
import com.javatest.exchange.entity.Employee;
import com.javatest.exchange.repository.CashRepository;
import com.javatest.exchange.repository.CurrencyRepository;
import com.javatest.exchange.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CashService {

    private final CashRepository cashRepository;

    private final CurrencyRepository currencyRepository;

    private final EmployeeRepository employeeRepository;

    public void updateCash(CashDto cash) {
        try {
            Optional<Currency> currency = currencyRepository.findByCode(cash.getCurrency());
            Optional<Employee> employee = employeeRepository.findByUsername(cash.getUser());
            if (currency.isPresent() && employee.isPresent()) {
                Optional<Cash> existentCash = cashRepository.findByCurrencyAndOperatorAndCreatedDate(
                        currency.get(),
                        employee.get(),
                        cash.getDate()
                );
                if (existentCash != null) {
                    Cash result = existentCash.get();
                    result.setAmount(cash.getSum());
                    cashRepository.save(result);
                }
            }
        } catch (Exception e) {
            log.error("An error occurred during update {}; {}", cash, e.getMessage(), e);
        }
    }
}
