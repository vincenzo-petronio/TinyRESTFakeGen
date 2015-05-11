/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.localhost.app.web.tinyrestfakegen.dataaccess;

import it.localhost.app.web.tinyrestfakegen.Constants;
import it.localhost.app.web.tinyrestfakegen.exception.DAOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Utilities for DAO Pattern
 */
public final class DAOUtilities {

    /**
     * Legge un file e restituisce una lista di String, una per ogni riga letta
     * dal file.
     *
     * @param fileName Nome del file delle risorse da leggere.
     * @return ArrayList
     * @throws DAOException
     */
    public static List read(String fileName) throws DAOException {
        List list = new ArrayList();
        try {
            InputStream inputStream = DAOUtilities.class.getResourceAsStream(fileName);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream), Constants.BUFFEREDREADER_BUFFER_SIZE);
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException iOException) {
            throw new DAOException(iOException.getMessage());
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
        return list;
    }

    /**
     * Converte una String in un HEX con 5 digit
     *
     * @param strIn
     * @return String
     */
    public static String stringToHex(String strIn) {
        char[] chars = strIn.toCharArray();
        StringBuilder hexOut = new StringBuilder();
        
        for (int i = 0; i < chars.length; i++) {
            hexOut.append(Integer.toHexString((int) chars[i]));
        }
        
        try {
            return hexOut.toString().substring(0, 5).toUpperCase();
        } catch (StringIndexOutOfBoundsException siobe) {
            // TODO log exception
            return hexOut.toString().toUpperCase();
        }
    }
}
