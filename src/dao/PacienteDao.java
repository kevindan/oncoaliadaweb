package dao;

import database.DataAccess;
import entity.Paciente;
import entity.PacienteDiag;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PacienteDao implements Intermetodos<Paciente> {

    @Override
    public void Grabar(Paciente o) throws Exception {
        Connection cn = null;
        try {
            cn = DataAccess.getConnection();
            cn.setAutoCommit(false);
            String sql = " insert into paciente(tipo_documento_id,numero_documento, "
                    + " nombres,apellido_paterno,apellido_materno,sexo,fecha_nacimiento, "
                    + " direccion,telefono,fecha_registro, "
                    + " tipo_paciente,fallecido, "
                    + " base_diagnostico_id,codigo_cieo,codigo_ubigeo,fecha_diagnostico,"
                    + " observacion,usuario,eliminado) "
                    + " values(?,?,?,?,?,?,?,?,?,sysdate(),?,0,?,?,?,?,?,?,0) ";

            PreparedStatement pstm = cn.prepareStatement(sql);

            pstm.setInt(1, o.getTipo_documento_id());
            pstm.setString(2, o.getNumero_documento());
            pstm.setString(3, o.getNombres());
            pstm.setString(4, o.getApellido_paterno());
            pstm.setString(5, o.getApellido_materno());
            pstm.setString(6, o.getSexo());
            pstm.setString(7, o.getFecha_nacimiento());
            pstm.setString(8, o.getDireccion());
            pstm.setString(9, o.getTelefono());           
            pstm.setInt(10, o.getTipo_paciente());
            pstm.setInt(11, o.getBase_diagnostico_id());
            pstm.setString(12, o.getCodigo_cieo());
            pstm.setString(13, o.getCodigo_ubigeo());
            pstm.setString(14, o.getFecha_diagnostico());
            pstm.setString(15, o.getObservacion());
            pstm.setString(16, o.getUsuario());
            
   
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
    public void Modificar(Paciente o) throws Exception {
        Connection cn = null;
        try {
            cn = DataAccess.getConnection();
            cn.setAutoCommit(false);
            String sql = " update paciente set numero_documento = ?, nombres = ?, apellido_paterno = ?, "
                    + " apellido_materno = ?,sexo = ?,fecha_nacimiento = ?, "
                    + " direccion = ?,telefono = ?, "
                    + " tipo_paciente = ?, "
                    + " base_diagnostico_id = ?, "
                    + " codigo_cieo = ?,codigo_ubigeo = ?,fecha_diagnostico = ?,observacion = ?, "
                    + " usuario =?,fecha_ultima_modificacion = sysdate() "
                    + " where paciente_id = ? and eliminado = 0 ";

            PreparedStatement pstm = cn.prepareStatement(sql);
            
            pstm.setString(1, o.getNumero_documento());
            pstm.setString(2, o.getNombres());
            pstm.setString(3, o.getApellido_paterno());
            pstm.setString(4, o.getApellido_materno());
            pstm.setString(5, o.getSexo());
            pstm.setString(6, o.getFecha_nacimiento());
            pstm.setString(7, o.getDireccion());
            pstm.setString(8, o.getTelefono());  
            pstm.setInt(9, o.getTipo_paciente());
            pstm.setInt(10, o.getBase_diagnostico_id());
            pstm.setString(11, o.getCodigo_cieo());
            pstm.setString(12, o.getCodigo_ubigeo());
            pstm.setString(13, o.getFecha_diagnostico());
            pstm.setString(14, o.getObservacion());
            pstm.setString(15, o.getUsuario());
           

            pstm.setInt(16, o.getPaciente_id());

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
    public void Eliminar(Paciente o) throws Exception {
        Connection cn = null;
        try {
            cn = DataAccess.getConnection();

            String sql = " update paciente set eliminado = 1, usuario = ?, fecha_ultima_modificacion = sysdate() "
                    + " where paciente_id = ? ";

            PreparedStatement pstm = cn.prepareStatement(sql);
            
            pstm.setString(1, o.getUsuario());
            pstm.setInt(2, o.getPaciente_id());
            
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
    public List<Paciente> Listar() throws Exception {

        Connection cn = null;
        List<Paciente> lista = new ArrayList<Paciente>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select paciente_id,numero_documento,nombres,"
                    + " apellido_paterno,apellido_materno,fecha_nacimiento,usuario "
                    + " from paciente where eliminado = 0 order by nombres asc ";
            // crear statement
            Statement stm = cn.createStatement();
            // ejecutar comando y obtener resultados
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Paciente p = new Paciente();
                //asignar valores al objeto r
                p.setPaciente_id(rs.getInt("paciente_id"));
                p.setNumero_documento(rs.getString("numero_documento"));
                p.setNombres(rs.getString("nombres"));
                p.setApellido_paterno(rs.getString("apellido_paterno"));
                p.setApellido_materno(rs.getString("apellido_materno"));
                p.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                p.setUsuario(rs.getString("usuario"));

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

    public List<Paciente> ListarSinHc() throws Exception {

        Connection cn = null;
        List<Paciente> lista = new ArrayList<Paciente>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select paciente.paciente_id,paciente.numero_documento,nombres,"
                    + " paciente.apellido_paterno,paciente.apellido_materno,paciente.fecha_nacimiento "
                    + " from paciente where paciente.eliminado = 0 "
                    + "  order by paciente.nombres asc ";
            // crear statement
            Statement stm = cn.createStatement();
            // ejecutar comando y obtener resultados
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Paciente p = new Paciente();
                //asignar valores al objeto r
                p.setPaciente_id(rs.getInt("paciente_id"));
                p.setNumero_documento(rs.getString("numero_documento"));
                p.setNombres(rs.getString("nombres"));
                p.setApellido_paterno(rs.getString("apellido_paterno"));
                p.setApellido_materno(rs.getString("apellido_materno"));
                p.setFecha_nacimiento(rs.getString("fecha_nacimiento"));

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
    public List<Paciente> Filtrar(Paciente o) throws Exception {
        Connection cn = null;
        List<Paciente> lista = new ArrayList<Paciente>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select paciente_id,numero_documento,nombres, "
                    + " apellido_paterno,apellido_materno,fecha_nacimiento "
                    + " from paciente where nombres like ? and eliminado = 0 order by nombres asc ";
            // crear statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            // crear parametro y asignar valor
            pstm.setString(1, "%" + o.getNombres() + "%");

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                Paciente p = new Paciente();
                //asignar valores al objeto r
                p.setPaciente_id(rs.getInt("paciente_id"));
                p.setNumero_documento(rs.getString("numero_documento"));
                p.setNombres(rs.getString("nombres"));
                p.setApellido_paterno(rs.getString("apellido_paterno"));
                p.setApellido_materno(rs.getString("apellido_materno"));
                p.setFecha_nacimiento(rs.getString("fecha_nacimiento"));

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

    public List<Paciente> FiltrarPacientesPro(Paciente o) throws Exception {
        Connection cn = null;
        List<Paciente> lista = new ArrayList<Paciente>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select paciente_id,numero_documento,nombres, "
                    + " apellido_paterno,apellido_materno,fecha_nacimiento "
                    + " from paciente where codigo_cieo in ('C61.X','C67.2','C67.3','C67.4','C67.5',"
                    + " 'C67.8','C67.9','C79.1','D09.0','D30.3','D41.4') and nombres like ? and eliminado = 0 order by nombres asc ";
            // crear statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            // crear parametro y asignar valor
            pstm.setString(1, "%" + o.getNombres() + "%");

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                Paciente p = new Paciente();
                //asignar valores al objeto r
                p.setPaciente_id(rs.getInt("paciente_id"));
                p.setNumero_documento(rs.getString("numero_documento"));
                p.setNombres(rs.getString("nombres"));
                p.setApellido_paterno(rs.getString("apellido_paterno"));
                p.setApellido_materno(rs.getString("apellido_materno"));
                p.setFecha_nacimiento(rs.getString("fecha_nacimiento"));

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
    public Paciente Buscar(Paciente o) throws Exception {
        Connection cn = null;
        Paciente p = new Paciente();
        try {
            cn = DataAccess.getConnection();

            String sql = " select paciente_id,tipo_documento_id,numero_documento, "
                    + " nombres,apellido_paterno,apellido_materno,sexo,date_format(fecha_nacimiento, '%m/%d/%Y') as fecha_nacimiento, "
                    + " direccion,telefono, "
                    + " tipo_paciente, "
                    + " base_diagnostico_id, "
                    + " codigo_cieo,codigo_ubigeo,date_format(fecha_diagnostico,'%m/%d/%Y') as fecha_diagnostico,observacion from paciente "
                    + " where paciente_id = ? and eliminado = 0 and fallecido = 0 ";

            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, o.getPaciente_id());
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                p.setPaciente_id(rs.getInt("paciente_id"));
                p.setTipo_documento_id(rs.getInt("tipo_documento_id"));
                p.setNumero_documento(rs.getString("numero_documento"));
                p.setNombres(rs.getString("nombres"));
                p.setApellido_paterno(rs.getString("apellido_paterno"));
                p.setApellido_materno(rs.getString("apellido_materno"));
                p.setSexo(rs.getString("sexo"));
                p.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                p.setDireccion(rs.getString("direccion"));
                p.setTelefono(rs.getString("telefono"));
                p.setTipo_paciente(rs.getInt("tipo_paciente"));               
                p.setBase_diagnostico_id(rs.getInt("base_diagnostico_id"));                
                p.setCodigo_cieo(rs.getString("codigo_cieo"));
                p.setCodigo_ubigeo(rs.getString("codigo_ubigeo"));
                p.setFecha_diagnostico(rs.getString("fecha_diagnostico"));
                p.setObservacion(rs.getString("observacion"));
              

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
    
    public Paciente ValidaDocumento(Paciente o) throws Exception {
    	
        Connection cn = null;
        Paciente p = new Paciente();
        
        try {
            cn = DataAccess.getConnection();

            String sql = " select paciente_id,tipo_documento_id,numero_documento, "
                    + " nombres,apellido_paterno,apellido_materno,sexo,fecha_nacimiento, "
                    + " direccion,telefono, "
                    + " tipo_paciente, "
                    + " base_diagnostico_id, "
                    + " codigo_cieo,codigo_ubigeo,fecha_diagnostico,observacion from paciente "
                    + " where numero_documento = ? and eliminado = 0 ";

            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, o.getNumero_documento());
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                p.setPaciente_id(rs.getInt("paciente_id"));
                p.setTipo_documento_id(rs.getInt("tipo_documento_id"));
                p.setNumero_documento(rs.getString("numero_documento"));
                p.setNombres(rs.getString("nombres"));
                p.setApellido_paterno(rs.getString("apellido_paterno"));
                p.setApellido_materno(rs.getString("apellido_materno"));
                p.setSexo(rs.getString("sexo"));
                p.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                p.setDireccion(rs.getString("direccion"));
                p.setTelefono(rs.getString("telefono"));
                p.setTipo_paciente(rs.getInt("tipo_paciente"));               
                p.setBase_diagnostico_id(rs.getInt("base_diagnostico_id"));                
                p.setCodigo_cieo(rs.getString("codigo_cieo"));
                p.setCodigo_ubigeo(rs.getString("codigo_ubigeo"));
                p.setFecha_diagnostico(rs.getString("fecha_diagnostico"));
                p.setObservacion(rs.getString("observacion"));
              

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
    
    public PacienteDiag BuscarPacienteDiag(Paciente o) throws Exception {
        Connection cn = null;
        PacienteDiag p = new PacienteDiag();
        try {
            cn = DataAccess.getConnection();

            String sql = " select paciente.paciente_id,paciente.tipo_documento_id,paciente.numero_documento, "
                    + " paciente.nombres,paciente.apellido_paterno,paciente.apellido_materno,paciente.sexo, date_format(paciente.fecha_nacimiento, '%m/%d/%Y') as fecha_nacimiento, "
                    + " paciente.direccion,paciente.telefono, "
                    + " paciente.tipo_paciente, "
                    + " paciente.base_diagnostico_id, "
                    + " paciente.codigo_cieo,diagnostico.descripcion,paciente.codigo_ubigeo,paciente.fecha_diagnostico,paciente.observacion from paciente, diagnostico "
                    + " where paciente.codigo_cieo = diagnostico.codigo_cieo and paciente.paciente_id = ? and paciente.eliminado = 0 and paciente.fallecido = 0";

            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, o.getPaciente_id());
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                p.setPaciente_id(rs.getInt("paciente_id"));
                p.setTipo_documento_id(rs.getInt("tipo_documento_id"));
                p.setNumero_documento(rs.getString("numero_documento"));
                p.setNombres(rs.getString("nombres"));
                p.setApellido_paterno(rs.getString("apellido_paterno"));
                p.setApellido_materno(rs.getString("apellido_materno"));
                p.setSexo(rs.getString("sexo"));
                p.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                p.setDireccion(rs.getString("direccion"));
                p.setTelefono(rs.getString("telefono"));
                p.setTipo_paciente(rs.getInt("tipo_paciente"));               
                p.setBase_diagnostico_id(rs.getInt("base_diagnostico_id"));                
                p.setCodigo_cieo(rs.getString("codigo_cieo"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setCodigo_ubigeo(rs.getString("codigo_ubigeo"));
                p.setFecha_diagnostico(rs.getString("fecha_diagnostico"));
                p.setObservacion(rs.getString("observacion"));
              

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
    
    public void RegistraFallecido(Paciente o) throws Exception {
    	
        Connection cn = null;
        
        try {
        	
            cn = DataAccess.getConnection();
            cn.setAutoCommit(false);
            String sql = " update paciente set fallecido = 1, fecha_fallecimiento = ?, fallecido_neoplasia = ?, "
                    + " otras_causas = ?,usuario = ?,fecha_ultima_modificacion = sysdate() "
                    + " where paciente_id = ? and eliminado = 0 ";

            PreparedStatement pstm = cn.prepareStatement(sql);
            
            pstm.setString(1, o.getFecha_fallecimiento());
            pstm.setInt(2, o.getFallecido_neoplasia());
            pstm.setString(3, o.getOtras_causas());
            pstm.setString(4, o.getUsuario());
        
            pstm.setInt(5, o.getPaciente_id());

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
    
    public List<Paciente> ListarFallecidos() throws Exception {

        Connection cn = null;
        List<Paciente> lista = new ArrayList<Paciente>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select paciente_id,numero_documento,nombres,"
                    + " apellido_paterno,apellido_materno,fecha_fallecimiento,usuario "
                    + " from paciente where eliminado = 0 and fallecido = 1 order by nombres asc ";
            // crear statement
            Statement stm = cn.createStatement();
            // ejecutar comando y obtener resultados
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Paciente p = new Paciente();
                //asignar valores al objeto r
                p.setPaciente_id(rs.getInt("paciente_id"));
                p.setNumero_documento(rs.getString("numero_documento"));
                p.setNombres(rs.getString("nombres"));
                p.setApellido_paterno(rs.getString("apellido_paterno"));
                p.setApellido_materno(rs.getString("apellido_materno"));
                p.setFecha_fallecimiento(rs.getString("fecha_fallecimiento"));
                p.setUsuario(rs.getString("usuario"));

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

    public Paciente BuscarFallecido(Paciente o) throws Exception {
        Connection cn = null;
        Paciente p = new Paciente();
        try {
            cn = DataAccess.getConnection();

            String sql = " select paciente_id,tipo_documento_id,numero_documento, "
                    + " nombres,apellido_paterno,apellido_materno,sexo,date_format(fecha_nacimiento, '%m/%d/%Y') as fecha_nacimiento, "
                    + " direccion,telefono, "
                    + " tipo_paciente, "
                    + " base_diagnostico_id, "
                    + " codigo_cieo,codigo_ubigeo,date_format(fecha_diagnostico,'%m/%d/%Y') as fecha_diagnostico,observacion, "
                    + " fecha_fallecimiento,fallecido_neoplasia,otras_causas "
                    + " from paciente "
                    + " where paciente_id = ? and eliminado = 0 and fallecido = 1 ";

            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, o.getPaciente_id());
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                p.setPaciente_id(rs.getInt("paciente_id"));
                p.setTipo_documento_id(rs.getInt("tipo_documento_id"));
                p.setNumero_documento(rs.getString("numero_documento"));
                p.setNombres(rs.getString("nombres"));
                p.setApellido_paterno(rs.getString("apellido_paterno"));
                p.setApellido_materno(rs.getString("apellido_materno"));
                p.setSexo(rs.getString("sexo"));
                p.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                p.setDireccion(rs.getString("direccion"));
                p.setTelefono(rs.getString("telefono"));
                p.setTipo_paciente(rs.getInt("tipo_paciente"));               
                p.setBase_diagnostico_id(rs.getInt("base_diagnostico_id"));                
                p.setCodigo_cieo(rs.getString("codigo_cieo"));
                p.setCodigo_ubigeo(rs.getString("codigo_ubigeo"));
                p.setFecha_diagnostico(rs.getString("fecha_diagnostico"));
                p.setObservacion(rs.getString("observacion"));
              

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
}
