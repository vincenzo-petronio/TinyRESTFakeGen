/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.localhost.app.web.tinyrestfakegen.dataaccess;

import it.localhost.app.web.tinyrestfakegen.exception.DAOException;
import it.localhost.app.web.tinyrestfakegen.model.City;
import java.util.List;

/**
 * DAO interface for City
 */
public interface CitiesDAO {

    /**
     *
     * @return List of City
     * @throws DAOException data access error
     */
    public List<City> getAllCities() throws DAOException;
}
