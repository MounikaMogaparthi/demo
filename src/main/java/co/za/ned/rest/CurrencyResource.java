package co.za.ned.rest;

import co.za.ned.dao.CurrencyDao;
import co.za.ned.dto.RequestQuote;
import co.za.ned.dto.ResponseQuote;
import co.za.ned.model.Currency;
import co.za.ned.service.CurrencyConversionService;
import co.za.ned.service.CurrencyService;

import javax.inject.Inject;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;


@Path("/resource")

public class CurrencyResource {

    public CurrencyResource() {
    }

    CurrencyConversionService currencyConversionService = new CurrencyConversionService();


    CurrencyService currencyService = new CurrencyService();

    CurrencyDao currencyDao = new CurrencyDao();

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        CurrencyDao cd= new CurrencyDao();
        cd.connection();
        return "Hello";
    }


    @Path("/quote/{id}/{from}/{to}/{fromAmount}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseQuote getExchnageQuote(@PathParam("id") String clientId,
                                          @PathParam("from") String fromCurrency,
                                          @PathParam("to") String toCurrency,
                                          @PathParam("fromAmount") double sourceAmount) {
        CurrencyConversionService currencyConversionService = new CurrencyConversionService();
        RequestQuote requestQuote = new RequestQuote(clientId, fromCurrency, toCurrency, sourceAmount);

        try {
            return currencyConversionService.getCurrencyConversion(requestQuote);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseQuote(500, "Failed", e.getMessage(), null, null, 0, 0);
        }
    }

    /*@Path("/one/{code}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Currency getOne(@PathParam("code") String currencyCode) {
        Currency currency = new Currency();
        return currencyDao.find(currencyCode);

    }


    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray getAll() {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (Currency currency : currencyDao.findAll()) {
            builder.add(Json.createObjectBuilder().add("currencyCode", currency.getCurrencyCode()));
            builder.add(Json.createObjectBuilder().add("currencyName", currency.getCurrencyName()));
        }
        return builder.build();
    }*/

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

    }

}
