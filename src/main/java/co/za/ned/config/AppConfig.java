package co.za.ned.config;

import co.za.ned.rest.CurrencyResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.*;

//host:9080/RestExample/api/v1/resource

@ApplicationPath("api/v1")
public class AppConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        System.out.println("AppConfig obj intialized");
        // register root resource
        classes.add(CurrencyResource.class);
        System.out.println("rest controller added ");
        return classes;
    }
}