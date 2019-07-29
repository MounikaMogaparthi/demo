package co.za.ned.rest;

import co.za.ned.dto.RequestQuote;
import co.za.ned.dto.ResponseQuote;
import co.za.ned.service.CurrencyConversionService;
import co.za.ned.service.CurrencyService;

import javax.inject.Inject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;



@Path("/resource")

public class CurrencyResource {

    public CurrencyResource() {
    }

    CurrencyConversionService currencyConversionService = new CurrencyConversionService();


    CurrencyService currencyService=new CurrencyService();



    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello(){

        return "Hello";
    }


    @Path("/quote/{id}/{from}/{to}/{fromAmount}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public  ResponseQuote getExchnageQuote(@PathParam("id") String clientId,
                                          @PathParam("from") String fromCurrency,
                                          @PathParam("to") String toCurrency,
                                          @PathParam("fromAmount") double sourceAmount) {
        CurrencyConversionService currencyConversionService = new CurrencyConversionService();
        RequestQuote requestQuote = new RequestQuote(clientId,fromCurrency, toCurrency, sourceAmount);

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

    public String getlatestEx(){
       String latestex= currencyService.getLatestRate();
            return latestex;
    }

    @GET
    @Path("/currencyCode")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCurrencyCode(){
        CurrencyService currencyService=new CurrencyService();
        String code= currencyService.getSymbols();
        return code;
    }

    public static void main(String[] args) {

    }

}
