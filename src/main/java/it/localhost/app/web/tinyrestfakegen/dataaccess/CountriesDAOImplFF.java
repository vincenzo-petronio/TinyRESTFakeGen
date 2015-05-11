/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.localhost.app.web.tinyrestfakegen.dataaccess;

import it.localhost.app.web.tinyrestfakegen.Constants;
import it.localhost.app.web.tinyrestfakegen.exception.DAOException;
import it.localhost.app.web.tinyrestfakegen.model.Country;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Implement the Data Access logic to Flat File.
 */
public class CountriesDAOImplFF implements CountriesDAO {

    @Override
    public List<Country> getAllCountries() throws DAOException {
        List<String> listStringCountries = DAOUtilities.read(Constants.RES_COUNTRIES);
        List<String> listStringCities = DAOUtilities.read(Constants.RES_CITIES);
        List<String> listStringExchanges = DAOUtilities.read(Constants.RES_EXCHANGES);
        List<Country> listCountries;
        listCountries = listStringCountries.stream().map(s -> {
            Country c = new Country();
            c.setId(DAOUtilities.stringToHex(s));
            c.setCapitalCity(listStringCities.get(new Random().nextInt(listStringCities.size())));
            c.setExchange(listStringExchanges.get(new Random().nextInt(listStringExchanges.size())));
            c.setName(s);
            c.setPopulation(new Random().nextInt(0x1312d00)); //20.000.000
            return c;
        }).collect(Collectors.toList());
        return listCountries;
    }

}
