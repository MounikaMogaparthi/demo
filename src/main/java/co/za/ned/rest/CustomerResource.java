package co.za.ned.rest;

import co.za.ned.dao.CustomerDao;
import co.za.ned.model.Customer;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
@Path("/client")
public class CustomerResource {
    @Inject
    CustomerDao customerDao;

    @GET
    @Path("/customerList")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> customers() {
        return customerDao.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getClient(@PathParam("id") Integer id) {
        return customerDao.get(id);
    }

    @POST
    @Path("/{id}/{name}")
    public boolean addClient(@PathParam("id") Integer id, @PathParam("name") String name) {
        //insert
        return true;
    }
    @PUT
    @Path("/update/{id}/{name}")
    public boolean updateClient(@PathParam("id") Integer id, @PathParam("name") String name) {
        return true;
    }

}
