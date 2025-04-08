package org.example;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        //Main.forName("C:\\Program Files\\Microsoft JDBC DRIVER 12.8 for SQL Server\\enu\\jars\\mssql-jdbc-12.10.0.jre8.jar");
        String connectionString =
                "jdbc:sqlserver://localhost:1433;" +
                        "database=PD_212;" +
                        "user=PHP;" +
                        "password=111;"+
                        "Connect Timeout=30;Encrypt=True;" +
                        "TrustServerCertificate=True;";
        try
        {
            Connection connection = DriverManager.getConnection(connectionString);  //Создает соединение

            Statement statement = connection.createStatement();     //Открывает соединение

            ResultSet results = statement.executeQuery("SELECT * FROM Directions");
            while (results.next())
            {
                byte id = results.getByte("direction_id");
                String name = results.getString("direction_name");
                System.out.println(id + "\t\t" + name);
            }

            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    }
