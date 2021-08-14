/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author milanmgeorge
 */
public class MyConnection {
    public static void main(String[] args)throws Exception{
    getConnection();
    }    
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/compresso","root","mmg@3698");
        System.out.println("Connected");
        return con;
        } catch(Exception ex)
        {
        System.out.println(ex.getMessage());
        }
        return null;
    }
}