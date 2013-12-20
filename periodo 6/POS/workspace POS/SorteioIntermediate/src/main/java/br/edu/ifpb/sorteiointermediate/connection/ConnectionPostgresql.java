/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sorteiointermediate.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luciano
 */
public class ConnectionPostgresql {
    
    private String url;
    private String driver;
    private String user;
    private String password;
    
    public ConnectionPostgresql(){
        this.url = "jdbc:postgresql://localhost:5432/loteriapos";
        this.driver = "org.postgresql.Driver";
        this.user = "postgres";
        this.password = "luciano";
    }
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName(this.driver);
        Connection con = DriverManager.getConnection(url, user, password);
        return con;
    }
    
}
