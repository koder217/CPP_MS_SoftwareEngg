package model.dataccess;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.entities.User;

public class LoginDataAccess {
	private static volatile LoginDataAccess instance;
	private LoginDataAccess(){}
	public Boolean verifyCredentials(User user) throws ClassNotFoundException, SQLException {

		var factory = DbConnectionFactory.getConnectionFactory();
		var dbConnection= factory.getConnection("postgres");
		var conection = dbConnection.getDataBaseConnection();
		final PreparedStatement stmt = conection.prepareStatement("SELECT * FROM users WHERE username=? and password=?");

		stmt.setString(1, user.getUserName());
		stmt.setString(2, user.getPassword());

		ResultSet rs = stmt.executeQuery();

		return rs.next();
	}

	//static instances must always be handled with thread safety in mind.
	public static LoginDataAccess getInstance() {
		if (instance == null) {
			synchronized (LoginDataAccess.class) {
				if (instance == null) {
					instance = new LoginDataAccess();
				}
			}
		}
		return instance;
	}

}

