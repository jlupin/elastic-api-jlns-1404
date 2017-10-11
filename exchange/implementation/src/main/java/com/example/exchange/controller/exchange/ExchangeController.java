package com.example.exchange.controller.exchange;

import com.example.exchange.controller.exchange.in.ConvertIn;
import com.example.exchange.controller.exchange.out.ConvertOut;
import com.example.exchange.pojo.Currency;
import com.example.exchange.service.interfaces.CurrencyConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class ExchangeController {
    @Autowired
    private CurrencyConverterService currencyConverterService;

    @CrossOrigin
    @PostMapping("/exchange/convert")
    public List<ConvertOut> convert(@RequestBody ConvertIn in) {
        List<ConvertOut> result = new LinkedList<ConvertOut>();

        for (final Currency currency : Currency.values()) {
            final ConvertOut out = new ConvertOut();
            out.setCurrency(currency);
            if (currency.equals(in.getCurrency())) {
                out.setValue(in.getValue());
            } else {
                out.setValue(currencyConverterService.convert(in.getValue(), in.getCurrency(), currency));
            }
            result.add(out);
        }

        return result;
    }
}