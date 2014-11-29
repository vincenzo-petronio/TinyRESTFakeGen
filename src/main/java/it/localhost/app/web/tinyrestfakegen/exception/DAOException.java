/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.localhost.app.web.tinyrestfakegen.exception;

/**
 * Exception wrapper.
 */
public class DAOException extends Exception {

    /**
     * No args constructor
     */
    public DAOException() {
    }

    /**
     * Constructs a DAOException with an error message
     *
     * @param message The detail message of the exception.
     */
    public DAOException(String message) {
        super(message);
    }
}
