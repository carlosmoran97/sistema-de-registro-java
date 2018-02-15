/*
 * Copyright (C) 2018 Carlos Morán
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package bd;
import modelo.Venta;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author CARLOS CAMPOS
 */
public class VentaBd {
    public static List<Venta> ventas = new ArrayList<>();
    
    public static void obtenerVentas()
    throws SQLException
    {
        ventas.clear();
        String sql = "SELECT * FROM venta";
        Statement statement = Conexion.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){
            Venta venta = new Venta(
                    rs.getInt("id_venta")
            );
        }
    }
}
