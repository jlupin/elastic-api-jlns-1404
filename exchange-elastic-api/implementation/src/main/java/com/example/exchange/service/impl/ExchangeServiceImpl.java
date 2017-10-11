package com.example.exchange.service.impl;

import com.example.exchange.pojo.Currency;
import com.example.exchange.service.interfaces.CurrencyConverterService;
import com.example.exchange.service.interfaces.ExchangeService;
import com.example.exchange.service.pojo.ConvertIn;
import com.example.exchange.service.pojo.ConvertOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Service("exchangeService")
public class ExchangeServiceImpl implements ExchangeService {
    @Autowired
    private CurrencyConverterService currencyConverterService;

    @Override
    public List<ConvertOut> convertROA(ConvertIn in) {
        return convertRMC(in.getValue(), in.getCurrency());
    }

    @Override
    public List<ConvertOut> convertRMC(BigDecimal value, Currency currency) {
        List<ConvertOut> result = new LinkedList<>();

        for (final Currency curr : Currency.values()) {
            final ConvertOut out = new ConvertOut();
            out.setCurrency(curr);
            if (curr.equals(currency)) {
                out.setValue(value);
            } else {
                out.setValue(currencyConverterService.convert(value, currency, curr));
            }
            result.add(out);
        }

        return result;
    }
}