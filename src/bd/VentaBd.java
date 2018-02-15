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
import java.sql.Date;
import modelo.Venta;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import modelo.Cliente;
/**
 *
 * @author CARLOS CAMPOS
 */
public class VentaBd {
    public static List<Venta> ventas = new ArrayList<>();
    
    public static void obtenerVentas() throws SQLException
    {
        ventas.clear();
        String sql = "SELECT * FROM venta";
        Statement statement = Conexion.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){
            Venta venta = new Venta(
                    rs.getInt("id_venta"),
                    rs.getDate("fecha"),
                    rs.getString("numero_de_documento"),
                    ClienteBd.obtenerCliente(rs.getInt("id_cliente"))
            );
            
            ventas.add(venta);
        }
    }
    
    public static Venta obtenerVenta(int id) throws SQLException
    {
        String sql = "SELECT * FROM venta WHERE id_venta = ?;";
        Venta venta = null;
        PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            venta = new Venta(
                    rs.getInt("id_venta"),
                    rs.getDate("fecha"),
                    rs.getString("numero_de_documento"),
                    ClienteBd.obtenerCliente(rs.getInt("id_cliente"))
            );
        }
        return venta;
    }
    
    public static Venta obtenerUltimaVenta() throws SQLException
    {
        String sql = "SELECT * FROM venta ORDER BY id_venta DESC LIMIT 1;";
        Venta venta = null;
        Statement statement = Conexion.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sql);
        if(rs.next())
        {
            venta = new Venta(
                    rs.getInt("id_venta"),
                    rs.getDate("fecha"),
                    rs.getString("numero_de_documento"),
                    ClienteBd.obtenerCliente(rs.getInt("id_cliente"))
            );
        }
        return venta;
    }
    
    public static void insertarVenta(Date fecha, String numeroDeDocumento, Cliente cliente) throws SQLException
    {
        Venta venta = new Venta(0, fecha, numeroDeDocumento, cliente);
        String sql = "INSERT INTO venta (fecha, numero_de_documento, id_cliente) VALUES (?, ?, ?);";
        PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
        ps.setDate(1, venta.getFecha());
        ps.setString(2, venta.getNumeroDeDocumento());
        ps.setInt(3, venta.getCliente().getId());
        
        ps.execute();
    }
    
    public static void actualizarVenta(int id, Date fecha, String numeroDeDocumento, Cliente cliente) throws SQLException
    {
        Venta venta = new Venta(id, fecha, numeroDeDocumento, cliente);
        String sql = "UPDATE venta SET fecha = ?, numero_de_documento = ?, id_cliente = ? WHERE id_venta = ?;";
        PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
        ps.setDate(1, venta.getFecha());
        ps.setString(2, venta.getNumeroDeDocumento());
        ps.setInt(3, venta.getCliente().getId());
        ps.setInt(4, id);
        
        ps.executeUpdate();
    }
    
    public static void eliminarVenta(int id) throws SQLException
    {
        String sql = "DELETE FROM venta WHERE id_venta = ?;";
        PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        
        ps.executeUpdate();
    }
}
