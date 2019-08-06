package co.za.ned.rest;

import co.za.ned.dao.CurrencyDao;
import co.za.ned.dto.RequestQuote;
import co.za.ned.dto.ResponseQuote;
import co.za.ned.model.Currency;
import co.za.ned.model.GetCurrenciesResponse;
import co.za.ned.service.CurrencyConversionService;
import co.za.ned.service.CurrencyService;

import javax.ejb.EJB;
import javax.inject.Inject;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;


@Path("/resource")

public class CurrencyResource {

    public CurrencyResource() {
    }

    @Inject
    private CurrencyDao currencyDao;
    @Inject
    private CurrencyConversionService currencyConversionService;

    CurrencyService currencyService = new CurrencyService();


    @GET
    @Path("/hello")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHello() {
        return "Hello";
    }

    @GET
    @Path("/currencyList")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Currency> currencies() {
        return currencyDao.getAll();
    }

    @GET
    @Path("/currency/{currencyCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Currency getOne(@PathParam("currencyCode") String currencyCode) {
        return currencyDao.find(currencyCode);
    }

    @GET
    @Path("/currencydetail")
    @Produces(MediaType.APPLICATION_JSON)
    public GetCurrenciesResponse listCurrencies() {
        return currencyConversionService.findAllCurrencies();
    }


    @Path("/quote/{id}/{from}/{to}/{fromAmount}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseQuote getExchnageQuote(@PathParam("id") String clientId,
                                          @PathParam("from") String fromCurrency,
                                          @PathParam("to") String toCurrency,
                                          @PathParam("fromAmount") double sourceAmount) {
        // CurrencyConversionService currencyConversionService = new CurrencyConversionService();
        RequestQuote requestQuote = new RequestQuote(clientId, fromCurrency, toCurrency, sourceAmount);

        try {
            return currencyConversionService.getCurrencyConversion(requestQuote);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseQuote(500, "Failed", e.getMessage(), null, null, 0, 0);
        }
    }

    @GET
    @Path("/latestex")
    @Produces(MediaType.APPLICATION_JSON)

    public String getlatestEx() {
        String latestex = currencyService.getLatestRate();
        return latestex;
    }

    @GET
    @Path("/currencyCode")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCurrencyCode() {
        CurrencyService currencyService = new CurrencyService();
        String code = currencyService.getSymbols();
        return code;
    }

    public static void main(String[] args) {
        CurrencyResource currencyResource = new CurrencyResource();
        currencyResource.getlatestEx();
    }

}
