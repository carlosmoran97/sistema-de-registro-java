/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import javax.swing.table.AbstractTableModel;
import modelo.Proveedor;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author carlos
 */
public class ProveedorTableModel extends AbstractTableModel{
    List<Proveedor> proveedores = new ArrayList<>();
    private final int NUM_COLUMNS = 3;     
    @Override
    public int getRowCount() {
        return proveedores.size();
    }

    @Override
    public int getColumnCount() {
        return NUM_COLUMNS;
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        Proveedor prov = proveedores.get(rowIndex);
        Object valor = null;
        switch(colIndex){
            case 0:
                valor = prov.getId();
                break;
            case 1:
                valor = prov.getNombre();
                break;
            case 2:
                valor = prov.getNit();
                break;
        }
        return valor;
    }
    
}
