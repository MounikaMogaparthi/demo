package co.za.ned.controller;

import co.za.ned.dto.RequestQuote;
import co.za.ned.dto.ResponseQuote;
import co.za.ned.model.Currency;
import co.za.ned.service.CurrencyConversionService;
import co.za.ned.service.CurrencyService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/currency/")
@Produces(MediaType.APPLICATION_JSON)
public class CurrencyConversionController {

    private CurrencyService currencyService=new CurrencyService();

   /* public static void main(String[] args) {
        getCurrencyCodes();
    }

    @GET
    @Path("/codes")
    public static String getCurrencyCodes() {
        // h2 cache store all cureency code info for one hour
        return currencyService.getSymbols();
    }*/


    @Path("/quote/{iid}/{from}/{to}/{fromAmount}")
    @GET
    public ResponseQuote getExchnageQuote(@PathParam("id") String clientId,
                                          @PathParam("from") String fromCurrency,
                                          @PathParam("to") String toCurrency,
                                          @PathParam("fromAmount") double sourceAmount) {
        CurrencyConversionService currencyConversionService = new CurrencyConversionService();
        RequestQuote requestQuote = new RequestQuote(clientId,fromCurrency, toCurrency, sourceAmount);
        ResponseQuote responseQuote = currencyConversionService.getCurrencyConversion(requestQuote);
        return responseQuote;
    }

}
