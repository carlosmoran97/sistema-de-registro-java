/*
 * Copyright (C) 2018 CARLOS CAMPOS
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
package modelo;

/**
 *
 * @author Carlos
 */
public class LineaDeVenta {
    private int id;
    private Producto producto;
    private int cantidad;
    private float precioUnitario;
    private int id_venta;

    public LineaDeVenta()
    {
        
    }
    
    public LineaDeVenta(int id, Producto producto, int cantidad, float precioUnitario, int id_venta)
    {
        setId(id);
        setProducto(producto);
        setCantidad(cantidad);
        setPrecioUnitario(precioUnitario);
        setId_venta(id_venta);
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    
    public float subtotal()
    {
        return precioUnitario * cantidad;
    }
}
