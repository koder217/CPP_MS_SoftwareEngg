package model.business;

import model.dataccess.LoginDataAccess;
import model.entities.User;
import model.exceptions.ValidationException;

import java.sql.SQLException;
import java.util.Objects;

public class LoginBusiness {
    private static volatile LoginBusiness instance;
    private LoginBusiness(){}
    public Boolean verifyUser(User user) throws ValidationException, SQLException, ClassNotFoundException {
        if (user == null){
            throw new RuntimeException("user parameter is required");
        }
        if (user.getUserName() == null || Objects.equals(user.getUserName(), "")){
            throw new ValidationException("username","username cannot be empty");
        }
        if (user.getPassword() == null || Objects.equals(user.getPassword(), "")){
            throw new ValidationException("password","password cannot be empty");
        }
        if (user.getUserName().contains(" ")){
            throw new ValidationException("username","username cannot contain spaces");
        }
        if (user.getUserName().length() <= 3 || user.getUserName().length() > 30){
            throw new ValidationException("username","username must be between 3 and 30 characters in length");
        }
        var dataAccess = LoginDataAccess.getInstance();
        return dataAccess.verifyCredentials(user);
    }
    //static instances must always be handled with thread safety in mind.
    public static LoginBusiness getInstance() {
        if (instance == null) {
            synchronized (LoginBusiness.class) {
                if (instance == null) {
                    instance = new LoginBusiness();
                }
            }
        }
        return instance;
    }
}
