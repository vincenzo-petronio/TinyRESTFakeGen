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
import javax.ws.rs.core.MediaType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * REST Web Service for Cities
 */
@Path("cities")
public class CitiesResource {

    @Context
    private UriInfo context;
    Logger logger = LogManager.getRootLogger();

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
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        CitiesDAOImpl dao = new CitiesDAOImpl();
        Gson gson = new Gson();
        logger.debug("Collection size=" + Integer.toString(dao.getAllCitiesName().size()));
        return gson.toJson(dao.getAllCitiesName());
    }

    /**
     * PUT method for updating or creating an instance of CitiesResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
