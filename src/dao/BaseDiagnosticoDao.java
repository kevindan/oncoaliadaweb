package dao;

import database.DataAccess;
import entity.BaseDiagnostico;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BaseDiagnosticoDao implements Intermetodos<BaseDiagnostico> {

    @Override
    public void Grabar(BaseDiagnostico o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Modificar(BaseDiagnostico o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(BaseDiagnostico o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BaseDiagnostico> Listar() throws Exception {
        Connection cn = null;
        List<BaseDiagnostico> lista = new ArrayList<BaseDiagnostico>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select base_diagnostico_id, base_diagnostico from base_diagnostico "
                    + " where eliminado = 0 order by base_diagnostico_id asc ";
            // crear statement
            Statement stm = cn.createStatement();
            // ejecutar comando y obtener resultados
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                BaseDiagnostico d = new BaseDiagnostico();
                //asignar valores al objeto r
                d.setBase_diagnostico_id(rs.getInt("base_diagnostico_id"));
                d.setBase_diagnostico(rs.getString("base_diagnostico"));
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

    @Override
    public List<BaseDiagnostico> Filtrar(BaseDiagnostico o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BaseDiagnostico Buscar(BaseDiagnostico o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
