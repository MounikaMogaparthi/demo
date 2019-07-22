package co.za.ned.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "CURRENCY_CONVERSION")
public class CurrencyConversion {

    @Id

    @Column(name="from_to_currency")
    private String fromToCurrency;

    @Column(name="conversion_rate")
    private Double conversionRate;

    @Column(name="updateddate")
    private Timestamp updatedDate;

    public CurrencyConversion() {
    }

    public CurrencyConversion( String fromToCurrency, Double conversionRate, Timestamp updatedDate) {

        this.fromToCurrency = fromToCurrency;
        this.conversionRate = conversionRate;
        this.updatedDate = updatedDate;
    }

    public String getFromToCurrency() {
        return fromToCurrency;
    }

    public void setFromToCurrency(String fromToCurrency) {
        this.fromToCurrency = fromToCurrency;
    }

    public Double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }
}
