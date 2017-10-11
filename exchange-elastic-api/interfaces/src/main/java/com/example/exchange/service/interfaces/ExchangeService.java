package com.example.exchange.service.interfaces;

import com.example.exchange.pojo.Currency;
import com.example.exchange.service.pojo.ConvertIn;
import com.example.exchange.service.pojo.ConvertOut;

import java.math.BigDecimal;
import java.util.List;

public interface ExchangeService {
    List<ConvertOut> convertROA(ConvertIn in);
    List<ConvertOut> convertRMC(BigDecimal value, Currency currency);
}