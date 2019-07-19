package co.za.ned.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.ws.rs.Consumes;
import java.sql.Timestamp;
import java.util.Date;
@Entity
@Table(name="Currency_Conversion")
public class RequestQuote {

    private String clientId;
    private String fromCurrency;
    private String toCurrency;
    private double sourceAmount;
    private Timestamp timestamp;

    public RequestQuote(String clientId, String fromCurrency, String toCurrency, double sourceAmount) {
        this.clientId = clientId;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.sourceAmount = sourceAmount;
        this.timestamp=new Timestamp(new Date().getTime());
    }

    public RequestQuote() {
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
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
}
