package it.localhost.app.web.tinyrestfakegen.dataaccess;

import it.localhost.app.web.tinyrestfakegen.Constants;
import it.localhost.app.web.tinyrestfakegen.DateUtils;
import it.localhost.app.web.tinyrestfakegen.exception.DAOException;
import it.localhost.app.web.tinyrestfakegen.model.User;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Implement the Data Access logic to Flat File.
 */
public class UsersDAOImplFF implements UsersDAO {
    
    @Override
    public List<User> getAllUsers() throws DAOException {
        List<String> listStringNames = DAOUtilities.read(Constants.RES_NAMES);
        List<String> listStringSurnames = DAOUtilities.read(Constants.RES_SURNAMES);
        List<String> listStringAddresses = DAOUtilities.read(Constants.RES_ADDRESSES);
        List<String> listStringCities = DAOUtilities.read(Constants.RES_CITIES);
        List<String> listStringTelephoneNumbers = DAOUtilities.read(Constants.RES_TELEPHONENUMBERS);
        List<String> listStringCountries = DAOUtilities.read(Constants.RES_COUNTRIES);
        List<String> listStringHexadecimals = DAOUtilities.read(Constants.RES_HEXADECIMALS);
        List<User> listUsers;
        List<LocalDate> listLocalDate = new ArrayList<>();
        for(int i = 0; i<20; i++) {
            listLocalDate.add(DateUtils.getRandomDate());
        }
        
        listUsers = listStringNames.stream().map(n -> {
            User u = new User();
            u.setName(n);
            u.setSurname(listStringSurnames.get(new Random().nextInt(listStringSurnames.size())));
            u.setAddress(listStringAddresses.get(new Random().nextInt(listStringAddresses.size())));
            u.setBirthday(Date.from(listLocalDate.get(new Random().nextInt(listLocalDate.size())).atStartOfDay(ZoneId.systemDefault()).toInstant()));
            u.setCity(listStringCities.get(new Random().nextInt(listStringCities.size())));
            u.setCountry(listStringCountries.get(new Random().nextInt(listStringCountries.size())));
            u.setId(listStringHexadecimals.get(new Random().nextInt(listStringHexadecimals.size())));
            u.setReputation(new Random().nextFloat()*10);
            u.setSex("MFO".charAt(new Random().nextInt("MFO".length())));
            u.setTelephone(listStringTelephoneNumbers.get(new Random().nextInt(listStringTelephoneNumbers.size())));
            u.setZipcode(Integer.toString(new Random().nextInt((99999-11111) + 1 ) + 11111));
            u.setEmail(u.getName().toLowerCase() + "." + u.getSurname().toLowerCase() + "@fakeemail.eu");
            return u;
        }).collect(Collectors.toList());

        return listUsers;
    }

}
