/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;
/**
 *
 * @author Carlos
 */
public class Venta extends Comprobante {
    private Cliente cliente;
    private boolean finalizada;
    public List<LineaDeVenta> lineasDeVenta = new ArrayList<>();
    
    public Venta()
    {
        finalizada = false;
    }
    
    public Venta(int id, Date fecha, String numeroDeDocumento, Cliente cliente)
    {
        super(id, fecha, numeroDeDocumento);
        setCliente(cliente);
    }
    
    public boolean isFinalizada()
    {
        return finalizada;
    }
    public void finalizarVenta()
    {
        finalizada = true;
    }
   
    public boolean validarLineaDeVenta(LineaDeVenta lineaDeVenta)
    {
        boolean valida = true;
        for (LineaDeVenta l:lineasDeVenta) {
            if(l.getProducto().getId() == lineaDeVenta.getProducto().getId())
            {
                valida = false;
                break;
            }
        }
        if(valida)
        {
            lineasDeVenta.add(lineaDeVenta);
        }
        return valida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public float total()
    {
        float total = 0;
        for(LineaDeVenta l: lineasDeVenta)
        {
            total += l.subtotal();
        }
        return total;
    }
    
}
