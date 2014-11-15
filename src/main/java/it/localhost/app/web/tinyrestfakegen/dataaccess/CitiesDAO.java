/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.localhost.app.web.tinyrestfakegen.dataaccess;

import it.localhost.app.web.tinyrestfakegen.model.Cities;
import java.util.List;

/**
 * DAO interface for Cities
 */
public interface CitiesDAO {
    
    /**
     * 
     * @return List of Cities
     */
    public List<Cities> getAllCitiesName();
}
