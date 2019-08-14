package co.za.ned.model;

public class CurrencyDetail {
    private String currencyCode;
    private String currencyName;

    public CurrencyDetail() {
    }

    public CurrencyDetail(String currencyCode, String currencyName) {
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }
}
