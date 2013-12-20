/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.basicservices.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luciano
 */
public class Conexao {
    
    private String url;
    private String user;
    private String password;
    private String driver;
    
    public Conexao(){
        this.url = "jdbc:postgresql://localhost:5432/loteriapos";
        this.driver = "org.postgresql.Driver";
        this.user = "postgres";
        this.password = "luciano";
    }
    
    public Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName(this.driver);
        Connection con = DriverManager.getConnection(url, user, password);
        return con;
    }
}
