package entity;

public class Personal {

    private int personal_id;
    private String tipo_profesional_id;
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;
    private String sexo;
    private String codigo_colegio_profesional;
    private String fecha_registro;
    private int eliminado;

    public Personal() {

    }

    public Personal(int personal_id, String tipo_profesional_id, String nombres, String apellido_paterno, String apellido_materno, String sexo, String codigo_colegio_profesional, String fecha_registro, int eliminado) {
        this.personal_id = personal_id;
        this.tipo_profesional_id = tipo_profesional_id;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.sexo = sexo;
        this.codigo_colegio_profesional = codigo_colegio_profesional;
        this.fecha_registro = fecha_registro;
        this.eliminado = eliminado;
    }

    public int getPersonal_id() {
        return personal_id;
    }

    public void setPersonal_id(int personal_id) {
        this.personal_id = personal_id;
    }

    public String getTipo_profesional_id() {
        return tipo_profesional_id;
    }

    public void setTipo_profesional_id(String tipo_profesional_id) {
        this.tipo_profesional_id = tipo_profesional_id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCodigo_colegio_profesional() {
        return codigo_colegio_profesional;
    }

    public void setCodigo_colegio_profesional(String codigo_colegio_profesional) {
        this.codigo_colegio_profesional = codigo_colegio_profesional;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getEliminado() {
        return eliminado;
    }

    public void setEliminado(int eliminado) {
        this.eliminado = eliminado;
    }

}
