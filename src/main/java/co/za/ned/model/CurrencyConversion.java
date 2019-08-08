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

    @Column(name = "From_To_Currency")
    private String fromToCurrency;

    @Column(name = "Conversion_Rate")
    private Double conversionRate;

    @Column(name = "UpdatedDate")
    private Timestamp updatedDate;

    public CurrencyConversion() {
    }

    public CurrencyConversion(String fromToCurrency, Double conversionRate, Timestamp updatedDate) {

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
