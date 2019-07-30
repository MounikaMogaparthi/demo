package co.za.ned.rest;

import co.za.ned.model.Customer;

import javax.ws.rs.*;

public class CustomerResource {
    @POST
    @Path("/client/{id}/{name}")
    public boolean addClient(@PathParam("id") String id, @PathParam("name")String name)
  {
      //insert
        return true;
    }

     @GET
     @Path("/client/{id}")
   public Customer getClient(@PathParam("id") Integer id)
   {
       Customer customer=new Customer();
        //select command
        return customer;
    }

  @PUT
  @Path("/client/update/{id}/{name}")
    public boolean updateClient(@PathParam("id") String id,@PathParam("name")String name)
    {
        return true;
    }

}
