/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.localhost.app.web.tinyrestfakegen.dataaccess;

import it.localhost.app.web.tinyrestfakegen.Constants;
import it.localhost.app.web.tinyrestfakegen.model.Cities;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * DAO implementation for Cities
 */
public class CitiesDAOImpl implements CitiesDAO {

    @Override
    public List<Cities> getAllCitiesName() {
        List<Cities> listCities = new ArrayList<>();
        List<String> listString = DAOUtilities.read(Constants.RES_CITIES);
        Iterator<String> itr = listString.iterator();
        while(itr.hasNext()) {
            Cities c = new Cities();
            c.setName(itr.next());
            listCities.add(c);
        }
        return listCities;
    }
    
}
