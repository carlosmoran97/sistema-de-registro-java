/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Carlos
 */
public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private String unidadDeMedida;
    private String codigo;
    private float precioSugerido;
    
    public Producto()
    {
        
    }
    
    public Producto(int id, String nombre, String descripcion, String unidadDeMedida, String codigo, float precioSugerido)
    {
        setId(id);
        setNombre(nombre);
        setDescripcion(descripcion);
        setUnidadDeMedida(unidadDeMedida);
        setCodigo(codigo);
        setPrecioSugerido(precioSugerido);
    }

    public float getPrecioSugerido() {
        return precioSugerido;
    }

    public void setPrecioSugerido(float precioSugerido) {
        this.precioSugerido = precioSugerido;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getUnidadDeMedida() {
        return unidadDeMedida;
    }

    public void setUnidadDeMedida(String unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
    @Override
    public String toString()
    {
        return nombre;
    }
}
