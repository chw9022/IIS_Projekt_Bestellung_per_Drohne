package stoll.quirin.restservice;
//Author: Quirin Stoll
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import stoll.quirin.restserivce.resource.OrderEndpoint;

@ApplicationPath("/")
public class AccountRestApplication extends Application {
    @Override   
    public Set<Class<?>> getClasses() {     
        Set<Class<?>> resources = new HashSet<>();
        resources.add(OrderEndpoint.class); 
        return resources;   }
}
