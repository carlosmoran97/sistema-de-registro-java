/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author carlos
 */
public class Compra extends Comprobante{
    private Proveedor proveedor;
    public List<LineaDeCompra> lineasDeCompra = new ArrayList<>();
    public Compra()
    {
        
    }
    public Compra(int id, Date fecha, String numeroDeDocumento, Proveedor proveedor)
    {
        super(id, fecha, numeroDeDocumento);
        setProveedor(proveedor);
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
}
