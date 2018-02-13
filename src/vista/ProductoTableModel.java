/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import javax.swing.table.AbstractTableModel;
import modelo.Producto;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author carlos
 */
public class ProductoTableModel extends AbstractTableModel{
    private final int NUM_COLUMNS = 6;
    List<Producto> productos = new ArrayList<>();

    @Override
    public int getRowCount() {
        return productos.size();
    }

    @Override
    public int getColumnCount() {
        return NUM_COLUMNS;
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        Object value = null;
        Producto prod = productos.get(rowIndex);
        switch(colIndex)
        {
            case 0:
                value = prod.getId();
                break;
            case 1:
                value = prod.getNombre();
                break;
            case 2:
                value = prod.getDescripcion();
                break;
            case 3:
                value = prod.getUnidadDeMedida();
                break;
            case 4:
                value = prod.getCodigo();
                break;
            case 5:
                value = prod.getPrecioSugerido();
                break;
        }
        return value;
    }
}
