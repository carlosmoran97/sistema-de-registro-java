/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author carlos
 */
public class LineaDeCompra {
    private int id;
    private Producto producto;
    private int cantidad;
    private float precioUnitario;
    private int id_compra;
    
    public LineaDeCompra()
    {
        
    }
    
    public LineaDeCompra(int id, Producto producto, int cantidad, float precioUnitario, int id_compra)
    {
        setId(id);
        setProducto(producto);
        setCantidad(cantidad);
        setPrecioUnitario(precioUnitario);
        setId_compra(id_compra);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public float subtotal()
    {
        return getCantidad() * getPrecioUnitario();
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }
    
}
