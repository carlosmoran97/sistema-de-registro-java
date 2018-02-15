/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author carlos
 */
public abstract class Comprobante {
    private int id;
    private String numeroDeDocumento;
    private Date fecha;
    
    public Comprobante(){
    
    }
    
    public Comprobante(int id, Date fecha, String numeroDeDocumento)
    {
        setId(id);
        setFecha(fecha);
        setNumeroDeDocumento(numeroDeDocumento);
    }
    
    public String getNumeroDeDocumento() {
        return numeroDeDocumento;
    }

    public void setNumeroDeDocumento(String numeroDeDocumento) {
        this.numeroDeDocumento = numeroDeDocumento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
