/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author Carlos
 */
public class Conexion {
    private static Connection conn;
    private static void conectar()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            conn = DriverManager.getConnection("jdbc:mysql://localhost/sistema_registro","root","honeywell8470p");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/sistema_registro","root","facela987");
//            conn = DriverManager.getConnection("jdbc:mysql://localhost/sistema_registro","root","");
        }
        catch(ClassNotFoundException|InstantiationException|IllegalAccessException|SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return;
    }
    public static Connection getConnection()
    {
        if(conn==null)
            conectar();
        return conn;
    }
}
