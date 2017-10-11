package com.example.exchange.service.impl;

import com.example.exchange.pojo.Currency;
import com.example.exchange.service.interfaces.ExchangeRatesService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service("exchangeRatesService")
public class ExchangeRatesServiceImpl implements ExchangeRatesService {
    private Map<Pair, BigDecimal> rates;

    public ExchangeRatesServiceImpl() {
        rates = new HashMap<>();
        initRates();
    }

    private void initRates() {
        rates.put(new Pair(Currency.USD, Currency.EUR), BigDecimal.valueOf(0.89389));
        rates.put(new Pair(Currency.EUR, Currency.USD), BigDecimal.valueOf(1.11871));
        rates.put(new Pair(Currency.USD, Currency.GBP), BigDecimal.valueOf(0.78139));
        rates.put(new Pair(Currency.GBP, Currency.USD), BigDecimal.valueOf(1.27978));
        rates.put(new Pair(Currency.EUR, Currency.GBP), BigDecimal.valueOf(0.87416));
        rates.put(new Pair(Currency.GBP, Currency.EUR), BigDecimal.valueOf(1.14396));
    }

    @Override
    public BigDecimal getRate(Currency from, Currency to) {
        return rates.get(new Pair(from, to));
    }

    private class Pair {
        private Currency from;
        private Currency to;

        Pair(Currency from, Currency to) {
            this.from = from;
            this.to = to;
        }

        public Currency getFrom() {
            return from;
        }

        public Currency getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            if (from != pair.from) return false;
            return to == pair.to;
        }

        @Override
        public int hashCode() {
            int result = from.hashCode();
            result = 31 * result + to.hashCode();
            return result;
        }
    }
}