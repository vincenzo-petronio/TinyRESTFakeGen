/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.localhost.app.web.tinyrestfakegen.dataaccess;

import it.localhost.app.web.tinyrestfakegen.Constants;
import it.localhost.app.web.tinyrestfakegen.exception.DAOException;
import it.localhost.app.web.tinyrestfakegen.model.City;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Implement the Data Access logic to Flat File.
 */
public class CitiesDAOImplFF implements CitiesDAO {

    @Override
    public List<City> getAllCities() throws DAOException {

        List<String> listStringCities = DAOUtilities.read(Constants.RES_CITIES);
        List<String> listStringCoordinates = DAOUtilities.read(Constants.RES_COORDINATES);
        List<City> listCities = listStringCities.stream().map(s -> {
            String latlon = listStringCoordinates.get(
                    new Random().nextInt(
                            listStringCoordinates.size()
                    )
            );
            City c = new City();
            c.setId(DAOUtilities.stringToHex(s));
            c.setName(s);
            c.setPopulation(new Random().nextInt(0x1312d00));
            c.setLatitude(
                    Double.parseDouble(
                            latlon.split(",")[0]
                    )
            );
            c.setLongitude(
                    Double.parseDouble(
                            latlon.split(",")[1]
                    )
            );
            return c;
        }).collect(Collectors.toList());

        return listCities;
    }

}
