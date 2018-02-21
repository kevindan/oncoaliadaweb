package dao;

import database.DataAccess;
import entity.Personal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonalDao implements Intermetodos<Personal> {

    @Override
    public void Grabar(Personal o) throws Exception {
        Connection cn = null;
        try {
            cn = DataAccess.getConnection();
            cn.setAutoCommit(false);
            String sql = " insert into personal(tipo_profesional_id,nombres, "
                    + " apellido_paterno,apellido_materno,sexo,codigo_colegio_profesional, "
                    + " fecha_registro,eliminado) "
                    + " values(?,?,?,?,?,?,sysdate(),0) ";

            PreparedStatement pstm = cn.prepareStatement(sql);

            pstm.setString(1, o.getTipo_profesional_id());
            pstm.setString(2, o.getNombres());
            pstm.setString(3, o.getApellido_paterno());
            pstm.setString(4, o.getApellido_materno());
            pstm.setString(5, o.getSexo());
            pstm.setString(6, o.getCodigo_colegio_profesional());

            pstm.executeUpdate();

            pstm.close();

            cn.commit();

        } catch (Exception e) {
            try {
                cn.rollback();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void Modificar(Personal o) throws Exception {
        Connection cn = null;
        try {
            cn = DataAccess.getConnection();
            cn.setAutoCommit(false);
            String sql = " update personal set tipo_profesional_id = ?, nombres = ?, "
                    + " apellido_paterno = ?,apellido_materno = ?,sexo = ? "
                    + " where personal_id = ? and eliminado = 0 ";

            PreparedStatement pstm = cn.prepareStatement(sql);

            pstm.setString(1, o.getTipo_profesional_id());
            pstm.setString(2, o.getNombres());
            pstm.setString(3, o.getApellido_paterno());
            pstm.setString(4, o.getApellido_materno());
            pstm.setString(5, o.getSexo());

            pstm.setInt(6, o.getPersonal_id());

            pstm.executeUpdate();

            pstm.close();

            cn.commit();

        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void Eliminar(Personal o) throws Exception {
        Connection cn = null;
        try {
            cn = DataAccess.getConnection();

            String sql = " update personal set eliminado = 1 "
                    + " where personal_id = ? ";
            PreparedStatement pstm = cn.prepareStatement(sql);

            pstm.setInt(1, o.getPersonal_id());

            pstm.executeUpdate();
            pstm.close();

        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Personal> Listar() throws Exception {

        Connection cn = null;
        List<Personal> lista = new ArrayList<Personal>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select personal_id,tipo_profesional_id,nombres,apellido_paterno, "
                    + " apellido_materno,sexo,codigo_colegio_profesional "
                    + " from personal where eliminado = 0 order by nombres asc ";
            // crear statement
            Statement stm = cn.createStatement();
            // ejecutar comando y obtener resultados
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Personal p = new Personal();
                //asignar valores al objeto r
                p.setPersonal_id(rs.getInt("personal_id"));
                p.setTipo_profesional_id(rs.getString("tipo_profesional_id"));
                p.setNombres(rs.getString("nombres"));
                p.setApellido_paterno(rs.getString("apellido_paterno"));
                p.setApellido_materno(rs.getString("apellido_materno"));
                p.setSexo(rs.getString("sexo"));
                p.setCodigo_colegio_profesional(rs.getString("codigo_colegio_profesional"));

                lista.add(p);
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
                e.printStackTrace();
            }
        }
        return lista;
    }

    @Override
    public List<Personal> Filtrar(Personal o) throws Exception {
        Connection cn = null;
        List<Personal> lista = new ArrayList<Personal>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select personal_id,tipo_profesional_id,nombres,apellido_paterno, "
                    + " apellido_materno,sexo,codigo_colegio_profesional "
                    + " from personal where nombres like ? and eliminado = 0 order by nombres asc ";
            // crear statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            // crear parametro y asignar valor
            pstm.setString(1, "%" + o.getNombres() + "%");
            // ejecutar comando y obtener resultados
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Personal p = new Personal();
                //asignar valores al objeto r
                p.setPersonal_id(rs.getInt("personal_id"));
                p.setTipo_profesional_id(rs.getString("tipo_profesional_id"));
                p.setNombres(rs.getString("nombres"));
                p.setApellido_paterno(rs.getString("apellido_paterno"));
                p.setApellido_materno(rs.getString("apellido_materno"));
                p.setSexo(rs.getString("sexo"));
                p.setCodigo_colegio_profesional(rs.getString("codigo_colegio_profesional"));

                lista.add(p);
            }
            // cerrar cursor
            rs.close();
            pstm.close();

        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

    @Override
    public Personal Buscar(Personal o) throws Exception {
        Connection cn = null;
        Personal p = new Personal();
        try {
            cn = DataAccess.getConnection();

            String sql = " select personal_id,tipo_profesional_id,nombres,apellido_paterno, "
                    + " apellido_materno,sexo,codigo_colegio_profesional "
                    + " from personal where personal_id = ? and eliminado = 0 ";

            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, o.getPersonal_id());
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                p.setPersonal_id(rs.getInt("personal_id"));
                p.setTipo_profesional_id(rs.getString("tipo_profesional_id"));
                p.setNombres(rs.getString("nombres"));
                p.setApellido_paterno(rs.getString("apellido_paterno"));
                p.setApellido_materno(rs.getString("apellido_materno"));
                p.setSexo(rs.getString("sexo"));
                p.setCodigo_colegio_profesional(rs.getString("codigo_colegio_profesional"));

            }
            rs.close();
            pstm.close();

        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return p;
    }

    public boolean ValidaColegiatura(Personal o) throws Exception {
        Connection cn = null;
        boolean val;
        try {
            cn = DataAccess.getConnection();
            String query = "select codigo_colegio_profesional,tipo_profesional_id from personal "
                    + "  where codigo_colegio_profesional = ? and tipo_profesional_id = ? and eliminado = 0 ";
            PreparedStatement stm = cn.prepareStatement(query);
            stm.setString(1, o.getCodigo_colegio_profesional());
            stm.setString(2, o.getTipo_profesional_id());
            ResultSet rset = stm.executeQuery();

            if (rset.next()) {
                val = true;
            } else {
                val = false;
            }
            rset.close();
            stm.close();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return val;
    }

}
