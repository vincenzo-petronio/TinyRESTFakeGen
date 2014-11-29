/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.localhost.app.web.tinyrestfakegen.dataaccess;

import it.localhost.app.web.tinyrestfakegen.Constants;
import it.localhost.app.web.tinyrestfakegen.exception.DAOException;
import it.localhost.app.web.tinyrestfakegen.model.Cities;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implement the Data Access logic to Flat File.
 */
public class CitiesDAOImplFF implements CitiesDAO {

    @Override
    public List<Cities> getAllCitiesName() throws DAOException {

        List<String> listString = DAOUtilities.read(Constants.RES_CITIES);
        List<Cities> listCities = listString.stream().map(s -> {
            Cities c = new Cities();
            c.setName(s);
            return c;
        }).collect(Collectors.toList());

        return listCities;
    }

}
