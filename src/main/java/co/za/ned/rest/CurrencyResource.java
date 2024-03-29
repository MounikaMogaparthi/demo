package co.za.ned.rest;

import co.za.ned.dao.CurrencyDao;
import co.za.ned.dto.RequestQuote;
import co.za.ned.dto.ResponseQuote;
import co.za.ned.model.Currency;
import co.za.ned.model.ResponseMessage;
import co.za.ned.service.CurrencyConversionService;
import co.za.ned.service.CurrencyService;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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

    @Path("/currencyList")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseMessage saveCurrencies() {
        try {
            return currencyConversionService.saveCurrencyDetails();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseMessage(500, "Failed", e.getMessage());
        }
    }

    @GET
    @Path("/currency/{currencyCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Currency getOne(@PathParam("currencyCode") String currencyCode) {
        return currencyDao.find(currencyCode);
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

    @Path("/exchange-rate")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_JSON)
    public ResponseQuote convertCurrency(@NotNull RequestQuote requestQuote) {
        try {
            return currencyConversionService.convertCurrency(requestQuote);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseQuote(500, "Failed", e.getMessage(), null, null, 0, 0);
        }
    }

    @GET
    @Path("/latestEx")
    @Produces(MediaType.APPLICATION_JSON)
    private String getlatestEx() {
        return currencyService.getLatestRate();

    }

    @GET
    @Path("/currencyCode")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCurrencyCode() {
        return currencyService.getSymbols();
    }

    @GET
    @Path("/currencyDetails")
    public  String getCurrencyDetails(){
        return currencyService.getSymbols2();
    }

    public static void main(String[] args) {
        CurrencyResource currencyResource = new CurrencyResource();
        currencyResource.getlatestEx();
    }

}
