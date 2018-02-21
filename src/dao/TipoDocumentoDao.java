package dao;

import database.DataAccess;
import entity.TipoDocumento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TipoDocumentoDao implements Intermetodos<TipoDocumento> {

    @Override
    public void Grabar(TipoDocumento o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Modificar(TipoDocumento o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(TipoDocumento o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoDocumento> Listar() throws Exception {
        Connection cn = null;
        List<TipoDocumento> lista = new ArrayList<TipoDocumento>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select tipo_documento_id, tipo_documento from tipo_documento "
                    + " where eliminado = 0 order by tipo_documento_id asc ";
            // crear statement
            Statement stm = cn.createStatement();
            // ejecutar comando y obtener resultados
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                TipoDocumento t = new TipoDocumento();
                t.setTipo_documento_id(rs.getInt("tipo_documento_id"));
                t.setTipo_documento(rs.getString("tipo_documento"));
                lista.add(t);
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
    public List<TipoDocumento> Filtrar(TipoDocumento o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoDocumento Buscar(TipoDocumento o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
