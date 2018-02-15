/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;
import java.util.List;
import java.util.ArrayList;
import modelo.Proveedor;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
/**
 *
 * @author Carlos
 */
public class ProveedorBd {
    public List<Proveedor> proveedores = new ArrayList<>();
    public void obtenerProveedores()
    {
        proveedores.clear();
        try
        {
            Proveedor p;
            String sql = "SELECT * FROM proveedor";
            Statement st = Conexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                p = new Proveedor();
                p.setId(rs.getInt("id_proveedor"));
                p.setNombre(rs.getString("nombre"));
                p.setNit(rs.getString("nit"));
                proveedores.add(p);
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    public Proveedor  obtenerProveedor(int id)
    {
        Proveedor prov = null;
        try
        {
            String sql = "SELECT * FROM proveedor WHERE id_proveedor = ?";
            PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                prov = new Proveedor();
                prov.setId(rs.getInt("id_proveedor"));
                prov.setNombre(rs.getString("nombre"));
                prov.setNit(rs.getString("nit"));
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return prov;
    }
    
    public List<Proveedor>  obtenerProveedor(String nit) throws SQLException
    {
        List<Proveedor> proveedoresPorNit = new ArrayList<>();
            String sql = "SELECT * FROM proveedor WHERE nit LIKE ?";
            PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
            ps.setString(1, "%" + nit + "%");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Proveedor prov = new Proveedor();
                prov.setId(rs.getInt("id_proveedor"));
                prov.setNombre(rs.getString("nombre"));
                prov.setNit(rs.getString("nit"));
                proveedoresPorNit.add(prov);
            }
        return proveedoresPorNit;
    }
    public Proveedor obtenerUnProveedor(String nit) throws SQLException
    {
        Proveedor prov = null;
            String sql = "SELECT * FROM proveedor WHERE nit = ?";
            PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
            ps.setString(1,nit );
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                prov = new Proveedor();
                prov.setId(rs.getInt("id_proveedor"));
                prov.setNombre(rs.getString("nombre"));
                prov.setNit(rs.getString("nit"));
            }
        return prov;
    }
    public void eliminarProveedor(int id) throws SQLException{
        String sql = "DELETE FROM proveedor WHERE id_proveedor = ?";
        PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
    
    public void insertarProveedor(String nombre, String nit) throws SQLException
    {
        Proveedor prov = new Proveedor(
                0,
                nombre,
                nit
        );
        String sql = "INSERT INTO proveedor (nombre, nit) VALUES (?,?)";
        PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
        
        ps.setString(1, prov.getNombre());
        ps.setString(2, prov.getNit());
        
        ps.execute();
    }
    
    public void actualizarProveedor(int id, String nombre, String nit)throws SQLException{
        String sql = "UPDATE proveedor SET nombre= ?, nit = ? WHERE id_proveedor = ?";
        PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
        
        ps.setString(1,nombre);
        ps.setString(2, nit);
        ps.setInt(3, id);
        
        ps.executeUpdate();
    }
}
