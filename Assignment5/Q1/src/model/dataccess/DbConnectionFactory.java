package model.dataccess;

import model.business.LoginBusiness;

import java.util.Objects;

public class DbConnectionFactory {
    private static volatile DbConnectionFactory instance;
    private DbConnectionFactory(){}
    public static DbConnectionFactory getConnectionFactory() {
        if (instance == null) {
            synchronized (DbConnectionFactory.class) {
                if (instance == null) {
                    instance = new DbConnectionFactory();
                }
            }
        }
        return instance;
    }
    public DbConnection getConnection(String database){
        if(Objects.equals(database, "mysql")){
            return new MySqlConnection();
        }
        if(Objects.equals(database, "postgres")){
            return new PostgresConnection();
        }
        return null;
    }
}
