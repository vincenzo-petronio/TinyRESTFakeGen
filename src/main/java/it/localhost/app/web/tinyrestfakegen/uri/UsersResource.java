package it.localhost.app.web.tinyrestfakegen.uri;

import com.google.gson.Gson;
import it.localhost.app.web.tinyrestfakegen.dataaccess.UsersDAO;
import it.localhost.app.web.tinyrestfakegen.dataaccess.UsersDAOImplFF;
import it.localhost.app.web.tinyrestfakegen.exception.DAOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * REST Web Service
 *
 */
@Path("users")
public class UsersResource {

    @Context
    private UriInfo context;
    private static Logger logger = LogManager.getRootLogger();

    /**
     * Creates a new instance of UsersResource
     */
    public UsersResource() {
    }

    /**
     * Retrieves representation of an instance of it.localhost.app.web.tinyrestfakegen.uri.UsersResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        UsersDAO dao = new UsersDAOImplFF();
        Gson gson = new Gson();
        String json = null;

        try {
            json = gson.toJson(dao.getAllUsers());
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
     * PUT method for updating or creating an instance of UsersResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
