/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author KIADY
 */
public class DBConnect {
    Connection connection;
    Statement statement;
    
    public DBConnect(){
        
    }
    
    public Connection getConnection(){
        return this.connection;
    }
    
    public void connect() throws Exception{
        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","meteo","meteo");
        statement = connection.createStatement();
        statement.executeQuery("alter session set nls_timestamp_format =\"YYYY-MM-DD\"");
                  
 
    }
    
     public void commit() throws Exception
    {
        connection.commit();
    }
    
    
     public void disconnect() throws Exception{
        try{ 
            System.out.println("deconnection reussie");
        }
        finally{
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }
        
    }
     
     
        
    
    
    
}
