/*
 * Copyright (C) 2018 carlos
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
import modelo.LineaDeVenta;
import modelo.Producto;
import modelo.Venta;
/**
 *
 * @author carlos
 */
public class LineaDeVentaBd {
    
    public static List<LineaDeVenta> lineasDeVenta = new ArrayList<>();
    private static final ProductoBd PRODUCTOBD = new ProductoBd();
    
    public static void obtenerVenta() throws SQLException
    {
        lineasDeVenta.clear();
        String sql = "SELECT * FROM linea_de_venta;";
        Statement st = Conexion.getConnection().createStatement();
        ResultSet rs  = st.executeQuery(sql);
        while(rs.next())
        {
            LineaDeVenta lineaDeVenta = new LineaDeVenta(
                    rs.getInt("id_linea_de_venta"),
                    PRODUCTOBD.obtenerProducto(rs.getInt("id_producto")),
                    rs.getInt("cantidad"),
                    rs.getFloat("precio_unitario"),
                    rs.getInt("id_venta")
            );
            
            lineasDeVenta.add(lineaDeVenta);
        }
    }
    
    public static LineaDeVenta obtenerLineaDeVenta(int id) throws SQLException
    {
        String sql = "SELECT * FROM linea_de_venta WHERE id_linea_de_venta = ?;";
        LineaDeVenta lineaDeVenta = null;
        PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            lineaDeVenta = new LineaDeVenta(
                    rs.getInt("id_linea_de_venta"),
                    PRODUCTOBD.obtenerProducto(rs.getInt("id_producto")),
                    rs.getInt("cantidad"),
                    rs.getFloat("precio_unitario"),
                    rs.getInt("id_venta")
            );
        }
        return lineaDeVenta;
    }
    
    public static void insertarLineaDeVenta(Producto producto, int cantidad, float precioUnitario, Venta venta) throws SQLException
    {
        LineaDeVenta lineaDeVenta = new LineaDeVenta(0, producto, cantidad, precioUnitario, venta.getId());
        String sql = "INSERT INTO linea_de_venta (id_producto, cantidad, precio_unitario, id_venta) VALUES (?,?,?,?);";
        PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
        ps.setInt(1, lineaDeVenta.getProducto().getId());
        ps.setInt(2, lineaDeVenta.getCantidad());
        ps.setFloat(3, lineaDeVenta.getPrecioUnitario());
        ps.setInt(4, venta.getId());
        ps.execute();
    }
    
    public static void actualizarLineaDeVenta(int id, Producto producto, int cantidad, float precioUnitario, Venta venta) throws SQLException
    {
        LineaDeVenta lineaDeVenta = new LineaDeVenta(id, producto, cantidad, precioUnitario, venta.getId());
        String sql = "UPDATE linea_de_venta SET id_producto = ?, cantidad = ?, precio_unitario = ?, id_venta = ? WHERE id_linea_de_venta = ?;";
        PreparedStatement ps  = Conexion.getConnection().prepareStatement(sql);
        ps.setInt(1, lineaDeVenta.getProducto().getId());
        ps.setInt(2, lineaDeVenta.getCantidad());
        ps.setFloat(3, lineaDeVenta.getPrecioUnitario());
        ps.setInt(4, venta.getId());
        ps.setInt(5, lineaDeVenta.getId());
        
        ps.executeUpdate();
    }
    
    public static void eliminarLineaDeVenta(int id) throws SQLException
    {
        String sql = "DELETE FROM linea_de_venta WHERE id_linea_de_venta = ?";
        PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        
        ps.executeUpdate();
    }
}
