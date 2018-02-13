/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;
/**
 *
 * @author Carlos
 */
public class Venta {
    private Date fecha;
    private int id;
    private boolean finalizada;
    private List<LineaDeVenta> lineasDeVenta = new ArrayList<LineaDeVenta>();
    
    public Venta()
    {
        finalizada = false;
    }
    
    public boolean getFinalizada()
    {
        return finalizada;
    }
    public void finalizarVenta()
    {
        finalizada = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public void agregarLineaDeVenta(Producto producto, int cantidad)
    {
        LineaDeVenta ldv = new LineaDeVenta();
        ldv.setProducto(producto);
        ldv.setCantidad(cantidad);
        lineasDeVenta.add(ldv);
    }
    
    public float obtenerTotal()
    {
        Iterator iter = lineasDeVenta.iterator();
        LineaDeVenta ldv = new LineaDeVenta();
        float total = 0;
        while(iter.hasNext())
        {
            ldv = (LineaDeVenta)iter.next();
            total += ldv.obtenerSubtotal();
        }
        return total;
    }
    
    @Override
    public String toString()
    {
        String salida = new String();
        Iterator iter = lineasDeVenta.iterator();
        salida += "Fecha: " + fecha.toString() + "\n\n";
        while(iter.hasNext())
        {
            LineaDeVenta ldv = (LineaDeVenta)iter.next();
            salida += ldv.getCantidad() + "\t" + ldv.getProducto().getNombre() + "\n";
        }
        salida +="\n" + "Total: " +  String.format("$%.2f", obtenerTotal());
        return salida;
    }
}
