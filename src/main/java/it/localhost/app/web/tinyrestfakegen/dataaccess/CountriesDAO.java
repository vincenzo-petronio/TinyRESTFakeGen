package it.localhost.app.web.tinyrestfakegen.dataaccess;

import it.localhost.app.web.tinyrestfakegen.exception.DAOException;
import it.localhost.app.web.tinyrestfakegen.model.Country;
import java.util.List;

/**
 * DAO interface for Country
 */
public interface CountriesDAO {

    /**
     *
     * @return List<Country>
     * @throws DAOException
     */
    public List<Country> getAllCountries() throws DAOException;
}
