package dao;

import database.DataAccess;
import entity.Raza;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RazaDao implements Intermetodos<Raza> {

    @Override
    public void Grabar(Raza o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Modificar(Raza o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(Raza o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Raza> Listar() throws Exception {
        Connection cn = null;
        List<Raza> lista = new ArrayList<Raza>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select raza_id, raza from raza "
                    + " where estado = 1 order by raza_id asc ";
            // crear statement
            Statement stm = cn.createStatement();
            // ejecutar comando y obtener resultados
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Raza r = new Raza();
                //asignar valores al objeto r
                r.setRaza_id(rs.getInt("raza_id"));
                r.setRaza(rs.getString("raza"));
                lista.add(r);
            }
            // cerrar cursor
            rs.close();
            stm.close();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception ex) {
            }
        }
        return lista;
    }

    @Override
    public List<Raza> Filtrar(Raza o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Raza Buscar(Raza o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
