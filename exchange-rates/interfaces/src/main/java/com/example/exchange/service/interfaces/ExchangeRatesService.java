package com.example.exchange.service.interfaces;

import com.example.exchange.pojo.Currency;

import java.math.BigDecimal;

public interface ExchangeRatesService {
    BigDecimal getRate(Currency from, Currency to);
}