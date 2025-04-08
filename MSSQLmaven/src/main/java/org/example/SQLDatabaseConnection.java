package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabaseConnection {
    String connectionString =
            "Data Source=DESKTOP-0TCDSR6\\SQLEXPRESS;" +
                    "Initial Catalog=PV_319_Import;" +
                    "Integrated Security=True;" +
                    "Connect Timeout=30;Encrypt=True;" +
                    "TrustServerCertificate=True;" +
                    "ApplicationIntent=ReadWrite;" +
                    "MultiSubnetFailover=False";
    Connection connection;
    public SQLDatabaseConnection()
    {
        try(Connection connection = DriverManager.getConnection(connectionString))
        {
            this.connection = connection;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}
