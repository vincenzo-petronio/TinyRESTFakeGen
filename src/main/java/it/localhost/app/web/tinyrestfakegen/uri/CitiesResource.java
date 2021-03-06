package it.localhost.app.web.tinyrestfakegen.uri;

import com.google.gson.Gson;
import it.localhost.app.web.tinyrestfakegen.dataaccess.CitiesDAO;
import it.localhost.app.web.tinyrestfakegen.dataaccess.CitiesDAOImplFF;
import it.localhost.app.web.tinyrestfakegen.exception.DAOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * REST Web Service for Cities
 */
@Path("countries/{country: [a-fA-F0-9]{5,}+}/cities")
public class CitiesResource {

    @Context
    private UriInfo context;
    private static Logger logger = LogManager.getRootLogger();

    /**
     * Creates a new instance of CitiesResource
     */
    public CitiesResource() {
    }

    /**
     * Retrieves representation of an instance of
     * it.localhost.app.web.tinyrestfakegen.uri.CitiesResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        CitiesDAO dao = new CitiesDAOImplFF();
        Gson gson = new Gson();
        String json = null;

        try {
            json = gson.toJson(dao.getAllCities());
            if (null == json || "".equalsIgnoreCase(json)) {
                logger.error(Response.Status.NOT_FOUND);
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            } 
        } catch (DAOException dAOException) {
            logger.error(dAOException.getMessage());
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
        
        return json;
    }

    /**
     * PUT method for updating or creating an instance of CitiesResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
