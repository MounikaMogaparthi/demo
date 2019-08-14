package co.za.ned.model;

import java.util.List;

public class GetCurrenciesResponse {
    private List<Currency> currencies;

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }
}
