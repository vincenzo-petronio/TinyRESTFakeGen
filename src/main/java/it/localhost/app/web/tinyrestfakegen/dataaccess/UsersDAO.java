package it.localhost.app.web.tinyrestfakegen.dataaccess;

import it.localhost.app.web.tinyrestfakegen.exception.DAOException;
import it.localhost.app.web.tinyrestfakegen.model.User;
import java.util.List;

/**
 * DAO interface for User
 */
public interface UsersDAO {
    
    public List<User> getAllUsers() throws DAOException;
}
