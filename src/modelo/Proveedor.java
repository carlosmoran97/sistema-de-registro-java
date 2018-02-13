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
public class Proveedor {
    private int id;
    private String nombre;
    private String nit;
    
    public Proveedor()
    {
    }
    
    public Proveedor(int id, String nombre, String nit)
    {
        setId(id);
        setNombre(nombre);
        setNit(nit);
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

    public String getNit() {
        return nit;
    }
    // validacion para el nit
    private boolean isNit(String nit)
    {
        boolean isNit = true;
        if(nit.length() != 14)
        {
            isNit = false;
        }
        else
        {
            for (int i = 0; i < nit.length(); i++) {
                if(!Character.isDigit(nit.charAt(i)))
                {
                    isNit = false;
                }
            }
        }
        return isNit;
    }

    public void setNit(String nit) {
        if(!isNit(nit))
        {
            throw new IllegalArgumentException("Error: el dato proporcionado no corresponde a un NIT");
        }
        else
        {
            this.nit = nit;
        }
    }
    
    @Override
    public String toString()
    {
        return nombre;
    }
}
