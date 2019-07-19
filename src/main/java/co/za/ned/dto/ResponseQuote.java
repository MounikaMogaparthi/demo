package co.za.ned.dto;


import co.za.ned.model.ResponseMessage;

import java.sql.Timestamp;

public class ResponseQuote extends ResponseMessage {
    private String fromCurrency;
    private String toCurrency;
    private double sourceAmount;
    private Timestamp timestamp;
    private double exchangedAmount;
    private double conversionRate;

    public ResponseQuote() {
    }

    public ResponseQuote(String fromCurrency, String toCurrency, double sourceAmount, double conversionRate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.sourceAmount = sourceAmount;
        this.conversionRate = conversionRate;
    }

    public ResponseQuote(int statusCode, String statusMessage, String responseMessage, String fromCurrency, String toCurrency, double sourceAmount, double conversionRate) {
        super(statusCode, statusMessage, responseMessage);
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.sourceAmount = sourceAmount;
        this.conversionRate = conversionRate;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public double getSourceAmount() {
        return sourceAmount;
    }

    public void setSourceAmount(double sourceAmount) {
        this.sourceAmount = sourceAmount;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public double getExchangedAmount() {
        return exchangedAmount;
    }

    public void setExchangedAmount(double exchangedAmount) {
        this.exchangedAmount = exchangedAmount;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    @Override
    public String toString() {
        return "ResponseQuote{" +
                "fromCurrency='" + fromCurrency + '\'' +
                ", toCurrency='" + toCurrency + '\'' +
                ", sourceAmount=" + sourceAmount +
                ", timestamp=" + timestamp +
                ", exchangedAmount=" + exchangedAmount +
                ", conversionRate=" + conversionRate +
                '}';
    }
}
