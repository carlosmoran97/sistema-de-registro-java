/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.LineaDeCompra;
/**
 *
 * @author Carlos
 */
public class LineaDeCompraTableModel extends AbstractTableModel{
    public final int NUM_COLUMNS = 4;
    List<LineaDeCompra> lineasDeCompra = new ArrayList<>();
    
    @Override
    public int getRowCount() {
        return lineasDeCompra.size();
    }

    @Override
    public int getColumnCount() {
        return NUM_COLUMNS;
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        Object value = null;
        LineaDeCompra ldc = lineasDeCompra.get(rowIndex);
        switch(colIndex)
        {
            case 0:
                value = ldc.getCantidad();
                break;
            case 1:
                value = ldc.getProducto().getNombre();
                break;
            case 2:
                value = ldc.getPrecioUnitario();
                break;
            case 3:
                value = ldc.subtotal();
                break;
        }
        return value;
    }
    
}
