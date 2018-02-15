/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author carlos
 */
public class Compra extends Comprobante{
    private Proveedor proveedor;
    private boolean finalizada;
    public List<LineaDeCompra> lineasDeCompra = new ArrayList<>();
    public Compra()
    {
        setFinalizada(finalizada);
    }
    
    public Compra(int id, Date fecha, String numeroDeDocumento, Proveedor proveedor)
    {
        super(id, fecha, numeroDeDocumento);
        setProveedor(proveedor);
        setId(id);
        setFecha(fecha);
        setNumeroDeDocumento(numeroDeDocumento);
        setFinalizada(false);
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    public float total()
    {
        float total = 0;
        for(LineaDeCompra l:lineasDeCompra){
            total += l.subtotal();
        }
        return total;
    }
    public boolean validarLineaDeCompra(LineaDeCompra lineaDeCompra)
    {
        boolean valida = true;
        for(LineaDeCompra l:lineasDeCompra){
            if(l.getProducto().getCodigo().equals(lineaDeCompra.getProducto().getCodigo()))
            {
                valida = false;
            }
        }
        if(valida){
            lineasDeCompra.add( lineaDeCompra );
        }
        return valida;
    }
}
