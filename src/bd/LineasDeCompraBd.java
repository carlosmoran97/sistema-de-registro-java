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
import java.util.List;
import modelo.LineaDeCompra;
import modelo.Producto;
import modelo.Compra;
/**
 *
 * @author Carlos
 */
public class LineasDeCompraBd {
    public List<LineaDeCompra> lineasDeCompra = new ArrayList<>();
    private ProductoBd productoBd = new ProductoBd();
    private CompraBd compraBd = new CompraBd();
    
    public void obtenerLineasDeCompra() throws SQLException
    {
        lineasDeCompra.clear();
        String sql = "SELECT * FROM linea_de_compra";
        Statement st = Conexion.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next())
        {
            LineaDeCompra ldc = new LineaDeCompra(
                    rs.getInt("id_linea_de_compra"),
                    productoBd.obtenerProducto(rs.getInt("id_producto")),
                    rs.getInt("cantidad"),
                    rs.getFloat("precio_unitario"),
                    rs.getInt("id_compra")
            );
            lineasDeCompra.add(ldc);
        }
    }
    
    public void insertarLineaDeCompra(Producto producto, int cantidad, float precioUnitario, Compra compra) throws SQLException
    {
        String sql = "INSERT INTO linea_de_compra (id_producto, cantidad, precio_unitario, id_compra) VALUES (?,?,?,?);";
        PreparedStatement ps = Conexion.getConnection().prepareStatement(sql);
        ps.setInt(1, producto.getId());
        ps.setInt(2, cantidad);
        ps.setFloat(3, precioUnitario);
        ps.setInt(4, compra.getId());
        
        ps.execute();
    }
}
