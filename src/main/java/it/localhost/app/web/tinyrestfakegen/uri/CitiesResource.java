/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.localhost.app.web.tinyrestfakegen.uri;

import com.google.gson.Gson;
import it.localhost.app.web.tinyrestfakegen.dataaccess.CitiesDAOImpl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service for Cities
 */
@Path("cities")
public class CitiesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CitiesResource
     */
    public CitiesResource() {
    }

    /**
     * Retrieves representation of an instance of it.localhost.app.web.tinyrestfakegen.uri.CitiesResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        
        CitiesDAOImpl dao = new CitiesDAOImpl();
//        Iterator<Cities> itr = dao.getAllCitiesName().iterator();
//        StringBuilder sb = new StringBuilder();
//        sb.append("{\"array\":[");
//        while(itr.hasNext()){
//            sb.append("\"").append(itr.next().getName());
//            if(itr.hasNext()){
//                sb.append("\",");
//            }
//        }
//        sb.append("\"]}");
//        return sb.toString();
        Gson gson = new Gson();
        
        return gson.toJson(dao.getAllCitiesName());
    }

    /**
     * PUT method for updating or creating an instance of CitiesResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
