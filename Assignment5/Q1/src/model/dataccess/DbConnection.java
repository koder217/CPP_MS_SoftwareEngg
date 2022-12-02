package model.dataccess;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbConnection {
    Connection getDataBaseConnection() throws ClassNotFoundException, SQLException;
}
