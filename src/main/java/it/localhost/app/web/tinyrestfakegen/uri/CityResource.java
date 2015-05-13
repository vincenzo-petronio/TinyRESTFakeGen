package it.localhost.app.web.tinyrestfakegen.uri;

import com.google.gson.Gson;
import it.localhost.app.web.tinyrestfakegen.dataaccess.CitiesDAO;
import it.localhost.app.web.tinyrestfakegen.dataaccess.CitiesDAOImplFF;
import it.localhost.app.web.tinyrestfakegen.exception.DAOException;
import it.localhost.app.web.tinyrestfakegen.model.City;
import it.localhost.app.web.tinyrestfakegen.model.Country;
import java.util.NoSuchElementException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * REST Web Service
 */
@Path("countries/{country: [a-fA-F0-9]{5,}+}/cities/{city: [a-fA-F0-9]{5,}$}")
public class CityResource {

    @Context
    private UriInfo context;
    private static Logger logger = LogManager.getRootLogger();

    /**
     * Creates a new instance of CityResource
     */
    public CityResource() {
    }

    /**
     * Retrieves representation of an instance of it.localhost.app.web.tinyrestfakegen.uri.CityResource
     * 
     * @param city
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson(@PathParam("city") String city) {
        CitiesDAO dao = new CitiesDAOImplFF();
        Gson gson = new Gson();
        String json = null;
        
        try {
            City c = dao.getAllCities().stream()/*.filter(c -> c.getId().equalsIgnoreCase(city))*/.findFirst().get();
            json = gson.toJson(c);
            if (null == json || "".equalsIgnoreCase(json)) {
                logger.error(Response.Status.NOT_FOUND);
                throw new WebApplicationException(Response.Status.NOT_FOUND);
            }
        } catch (DAOException dAOException) {
            logger.error(dAOException.getMessage());
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        } catch (NoSuchElementException nsee) {
            logger.error(nsee.getMessage());
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        
        return json;
    }

    /**
     * PUT method for updating or creating an instance of CityResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
