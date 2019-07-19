package co.za.ned.model;
import java.util.List;
public class Country {

    private String name;
    private String alpha2Code;
    private String capital;
    private List<Currency> currencies;

    public String getName() {

        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAlpha2Code()
    {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {

        this.alpha2Code = alpha2Code;
    }

    public String getCapital() {

        return capital;
    }

    public void setCapital(String capital) {

        this.capital = capital;
    }

    public List<Currency> getCurrencies() {

        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {

        this.currencies = currencies;
    }
}
