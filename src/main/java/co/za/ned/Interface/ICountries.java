package co.za.ned.Interface;

import co.za.ned.model.Country;
import feign.RequestLine;

import java.util.List;

public interface ICountries {
    @RequestLine("GET /rest/v2/all")
    List<Country> getAll();
}
