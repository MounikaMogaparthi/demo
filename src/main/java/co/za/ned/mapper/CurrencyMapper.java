package co.za.ned.mapper;

import co.za.ned.model.Currency;
import co.za.ned.model.CurrencyDetail;

import java.util.ArrayList;
import java.util.List;

public class CurrencyMapper {
    public static List<Currency> mapRequest(List<CurrencyDetail> currencyDetails) {
        List<Currency> currencyList = new ArrayList<>();
        for (CurrencyDetail curr : currencyDetails) {
            currencyList.add(new Currency(curr.getCurrencyCode(), curr.getCurrencyName()));
        }
        return currencyList;
    }
/*
    public static List<CurrencyDetail> mapResponse(List<Currency> currencyList) {
        List<CurrencyDetail> currencyDetailList = new ArrayList<>();
        for (Currency curr: currencyList) {
            currencyDetailList.add(new CurrencyDetail(curr.getCurrencyCode(), curr.getCurrencyName()));
        }
        return currencyDetailList;
    }*/
}

