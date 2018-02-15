/*
 * Copyright (C) 2018 Carlos Morán
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
/**
 *
 * @author Carlos Morán
 */
public class ClienteBd {
    public static List<Cliente> clientes = new ArrayList<>();
    public static void obtenerClientes() throws SQLException
    {
        clientes.clear();
        String sql = "SELECT * FROM cliente";
        Statement st = Conexion.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next())
        {
            Cliente cliente = new Cliente(
                    rs.getInt("id_cliente"),
                    rs.getString("nombre"),
                    rs.getString("nit")
            );
            
            clientes.add(cliente);
        }
    }
    public static Cliente obtenerCliente(int id) throws SQLException
    {
        String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
        Cliente cliente = null;
        PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            cliente = new Cliente(
                    rs.getInt("id_cliente"),
                    rs.getString("nombre"),
                    rs.getString("nit")
            );
        }
        return cliente;
    }
    
    public static Cliente obtenerClientePorNit(String nit) throws SQLException
    {
        String sql = "SELECT * FROM cliente WHERE nit = ?";
        Cliente cliente = null;
        PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
        ps.setString(1, nit);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            cliente = new Cliente(
                    rs.getInt("id_cliente"),
                    rs.getString("nombre"),
                    rs.getString("nit")
            );
        }
        return cliente;
    }
    
    public static void insertarCliente(String nombre, String nit) throws SQLException
    {
        String sql = "INSERT INTO cliente (nombre, nit) VALUES (?,?)";
        PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
        ps.setString(1, nombre);
        ps.setString(2, nit);
        
        ps.execute();
    }
    
    public static void actualizarCliente(int id, String nombre, String nit) throws SQLException
    {
        String sql = "UPDATE cliente SET nombre = ?, nit = ? WHERE id_cliente = ?";
        PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
        
        ps.setString(1, nombre);
        ps.setString(2, nit);
        ps.setInt(3, id);
        
        ps.executeUpdate();
    }
    
    public static void eliminarCliente(int id) throws SQLException
    {
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";
        PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        
        ps.executeUpdate();
    }
}
