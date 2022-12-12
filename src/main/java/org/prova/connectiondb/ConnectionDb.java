package org.prova.connectiondb;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {

    private static ConnectionDb connectionDb;

    private static Connection con = null;

    private ConnectionDb(){}


    public static ConnectionDb getInstance(){
        if(connectionDb == null) {
            connectionDb = new ConnectionDb();
            con = connectionDb.onConnect();
            return connectionDb;
        }
        return connectionDb;
    }

    private Connection onConnect() {
        Connection con = null;
        try{
            Class.forName("org.sqlite.JDBC");

            con = DriverManager.getConnection("jdbc:sqlite:"+System.getProperty("user.dir")+"/data/base.db");
            System.out.println("Conexão concluida com sucesso");
        }
        catch(SQLException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return con;
    }

    public Connection getConnection(){
        return con;
    }

}
