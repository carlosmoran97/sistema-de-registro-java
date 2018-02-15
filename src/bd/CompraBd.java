/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import modelo.Compra;
import modelo.Proveedor;
/**
 *
 * @author Carlos
 */
public class CompraBd {
    public List<Compra> compras = new ArrayList<>();
    private ProveedorBd proveedorBd = new ProveedorBd();
    public void obtenerCompras() throws SQLException
    {
        compras.clear();
        String sql = "SELECT * FROM compra";
        Statement st = Conexion.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next())
        {
            Compra compra = new Compra
            (
                    rs.getInt("id_compra"),
                    rs.getDate("fecha"),
                    rs.getString("numero_de_documento"),
                    proveedorBd.obtenerProveedor(rs.getInt("id_proveedor"))
            );
            compras.add( compra );
        }
    }
    public Compra obtenerCompra(int id) throws SQLException
    {
        Compra compra = null;
        String sql = "SELECT * FROM compra WHERE id_compra = ?";
        PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            compra = new Compra
            (
                rs.getInt("id_compra"),
                rs.getDate("fecha"),
                rs.getString("numero_de_documento"),
                proveedorBd.obtenerProveedor(rs.getInt("id_proveedor"))  
            );
        }
        return compra;
    }
    public Compra obtenerUltimaCompra() throws SQLException
    {
        Compra compra = null;
        String sql = "SELECT * FROM compra ORDER BY id_compra DESC LIMIT 1";
        Statement st = Conexion.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        if(rs.next())
        {
            compra = new Compra
            (
                rs.getInt("id_compra"),
                rs.getDate("fecha"),
                rs.getString("numero_de_documento"),
                proveedorBd.obtenerProveedor(rs.getInt("id_proveedor"))  
            );
        }
        return compra;
    }
    
    public void insertarCompra(Date fecha, String numeroDeDocumento, Proveedor proveedor) throws SQLException
    {
        String sql = "INSERT INTO compra (fecha, numero_de_documento, id_proveedor) VALUES (?,?,?);";
        PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
        ps.setDate(1, fecha);
        ps.setString(2, numeroDeDocumento);
        ps.setInt(3, proveedor.getId());
        
        ps.execute();
    }
    
    public void actualizarCompra(int id, Date fecha, String numeroDeDocumento, Proveedor proveedor) throws SQLException
    {
        String sql = "UPDATE compra SET fecha = ?, numero_de_documento = ?, id_proveedor = ? WHERE id_compra = ?";
        PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
        ps.setDate(1, fecha);
        ps.setString(2, numeroDeDocumento);
        ps.setInt(3, proveedor.getId());
        ps.setInt(4, id);
        
        ps.executeUpdate();
    }
    public void eliminarCompra(int id) throws SQLException
    {
        String sql = "DELETE FROM compra WHERE id_compra = ?";
        PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        
        ps.executeUpdate();
    }
}
