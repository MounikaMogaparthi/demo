package co.za.ned.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CURRENCY")
public class Currency {

    @Id
    @Column(name = "CURRENCY_CODE")
    private String currencyCode;

    @Column(name = "CURRENCY_NAME")
    private String currencyName;

    public Currency() {
    }

    public Currency(String currencyCode, String currencyName) {
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

    @Override
    public String toString() {
        return "Currency{" +
                "currencyCode='" + currencyCode + '\'' +
                ", currencyName='" + currencyName + '\'' +
                '}';
    }

    public static void main(String[] args) {

    }
}