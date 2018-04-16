package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLite {

    protected Connection connection;
    public Connection open(){

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:projeto_database");
            return connection;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void close(){

            try {
                if(connection!=null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

}
