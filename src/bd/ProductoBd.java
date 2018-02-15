/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;
import modelo.Producto;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author carlos
 */
public class ProductoBd {
    public List<Producto> productos = new ArrayList<>();
    public void obtenerProductos() throws SQLException{
        productos.clear();
        String sql = "SELECT * FROM producto";
        Statement st = Conexion.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next())
        {
            Producto prod = new Producto(
                    rs.getInt("id_producto"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getString("unidad_de_medida"),
                    rs.getString("codigo"),
                    rs.getFloat("precio_sugerido")
            );
            productos.add(prod);
        }
    }
    public Producto obtenerProducto(int id) throws SQLException
    {
        Producto prod = null;
        String sql = "SELECT * FROM producto WHERE id = ?";
        PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            prod = new Producto(
                    rs.getInt("id_producto"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getString("unidad_de_medida"),
                    rs.getString("codigo"),
                    rs.getFloat("precio_sugerido")
            );
        }
        return prod;
    }
    public Producto obtenerProductoPorCodigo(String codigo) throws SQLException
    {
        Producto prod = null;
        String sql = "SELECT * FROM producto WHERE codigo = ?";
        PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
        ps.setString(1, codigo);
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            prod = new Producto(
                    rs.getInt("id_producto"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getString("unidad_de_medida"),
                    rs.getString("codigo"),
                    rs.getFloat("precio_sugerido")
            );
        }
        return prod;
    }
    public void insertarProducto(String nombre, String descripcion, String unidadDeMedida, String codigo, float precioSugerido) throws SQLException
    {
        Producto prod = new Producto(0,nombre,descripcion, unidadDeMedida, codigo, precioSugerido);
        String sql = "INSERT INTO producto (nombre,descripcion,unidad_de_medida,codigo,precio_sugerido) VALUES(?,?,?,?,?)";
        PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
        ps.setString(1, prod.getNombre());
        ps.setString(2, prod.getDescripcion());
        ps.setString(3, prod.getUnidadDeMedida());
        ps.setString(4, prod.getCodigo());
        ps.setFloat(5, prod.getPrecioSugerido());
        ps.execute();
    }
    public void eliminarProducto(int id) throws SQLException
    {
        String sql = "DELETE FROM producto WHERE id_producto = ?";
        PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        
        ps.executeUpdate();
    }
}
