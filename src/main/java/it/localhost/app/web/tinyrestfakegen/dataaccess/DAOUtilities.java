/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.localhost.app.web.tinyrestfakegen.dataaccess;

import it.localhost.app.web.tinyrestfakegen.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public final class DAOUtilities {
    
    /**
     * Legge un file e restituisce una lista di String, una per ogni riga letta dal file.
     * 
     * @param fileName Nome del file delle risorse da leggere.
     * @return ArrayList 
     */
    public static List read(String fileName) {
        List list = new ArrayList();
        try {
            InputStream inputStream = DAOUtilities.class.getResourceAsStream(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream), Constants.BUFFEREDREADER_BUFFER_SIZE);
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException iOException) {
            // TODO gestire eccezione!
            System.out.println("IOException\n" + iOException.getMessage());
        } catch (Exception e) {
            System.out.println("Exception\n" + e.getMessage());
        }
        return list;
    }
}
