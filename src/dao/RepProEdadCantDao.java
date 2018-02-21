package dao;

import database.DataAccess;
import entity.RepProEdadCant;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RepProEdadCantDao {

    public List<RepProEdadCant> ListarProEdaCant() throws Exception {
        Connection cn = null;
        List<RepProEdadCant> lista = new ArrayList<RepProEdadCant>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select "
                    + "	(case"
                    + "	when year(paciente.fecha_registro)-year(paciente.fecha_nacimiento) between 0 and 5 then 'De 0 a 5 años' "
                    + "	when year(paciente.fecha_registro)-year(paciente.fecha_nacimiento) between 6 and 10 then 'De 6 a 10 años'  "
                    + "	when year(paciente.fecha_registro)-year(paciente.fecha_nacimiento) between 11 and 15 then 'De 11 a 15 años' "
                    + "	when year(paciente.fecha_registro)-year(paciente.fecha_nacimiento)  between 16 and 20 then 'De 16 a 20 años'  "
                    + "	when year(paciente.fecha_registro)-year(paciente.fecha_nacimiento)  between 21 and 25 then 'De 21 a 25 años'  "
                    + "	when year(paciente.fecha_registro)-year(paciente.fecha_nacimiento)  between 26 and 30 then 'De 26 a 30 años'  "
                    + "	when year(paciente.fecha_registro)-year(paciente.fecha_nacimiento)  between 31 and 35 then 'De 31 a 35 años'  "
                    + "	when year(paciente.fecha_registro)-year(paciente.fecha_nacimiento)  between 36 and 40 then 'De 36 a 40 años'  "
                    + "	when year(paciente.fecha_registro)-year(paciente.fecha_nacimiento)  between 41 and 45 then 'De 41 a 45 años'  "
                    + "	when year(paciente.fecha_registro)-year(paciente.fecha_nacimiento)  between 46 and 50 then 'De 46 a 50 años'  "
                    + "	when year(paciente.fecha_registro)-year(paciente.fecha_nacimiento)  between 51 and 55 then 'De 51 a 55 años'  "
                    + "	when year(paciente.fecha_registro)-year(paciente.fecha_nacimiento)  between 56 and 60 then 'De 56 a 60 años'  "
                    + "	when year(paciente.fecha_registro)-year(paciente.fecha_nacimiento)  between 61 and 75 then 'De 61 a 65 años'  "
                    + "	when year(paciente.fecha_registro)-year(paciente.fecha_nacimiento)  between 66 and 70 then 'De 66 a 70 años'  "
                    + "	when year(paciente.fecha_registro)-year(paciente.fecha_nacimiento)  between 71 and 75 then 'De 71 a 75 años'  "
                    + "	when year(paciente.fecha_registro)-year(paciente.fecha_nacimiento)  between 76 and 80 then 'De 76 a 80 años'  "
                    + "	when year(paciente.fecha_registro)-year(paciente.fecha_nacimiento)  between 81 and 85 then 'De 81 a 85 años'  "
                    + "	when year(paciente.fecha_registro)-year(paciente.fecha_nacimiento)  between 86 and 90 then 'De 86 a 90 años'  "
                    + "	when year(paciente.fecha_registro)-year(paciente.fecha_nacimiento)  between 91 and 95 then 'De 91 a 95 años'  "
                    + "	when year(paciente.fecha_registro)-year(paciente.fecha_nacimiento)  between 96 and 100 then 'De 96 a 100 años'  "
                    + "	else 'De mayores de 100 años' end) as grupoetareo, "
                    + "	count(*) as cantidad "
                    + "   from paciente "
                    + " where "
                    + "	paciente.eliminado = 0 "          
                    + "group by    "
                    + "	grupoetareo; ";
            // crear statement
            Statement stm = cn.createStatement();
            // ejecutar comando y obtener resultados
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                RepProEdadCant d = new RepProEdadCant();
                //asignar valores al objeto r
                d.setGrupoetareo(rs.getString("grupoetareo"));
                d.setCantidad(rs.getInt("cantidad"));
                lista.add(d);
            }
            // cerrar cursor
            rs.close();
            stm.close();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return lista;
    }

}
