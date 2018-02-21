package entity;

public class Departamento {

    private String codigo_departamento;
    private String departamento;
    private String codigo_ubigeo;

    public Departamento() {

    }

    public Departamento(String codigo_departamento, String departamento, String codigo_ubigeo) {
        this.codigo_departamento = codigo_departamento;
        this.departamento = departamento;
        this.codigo_ubigeo = codigo_ubigeo;
    }

    public String getCodigo_departamento() {
        return codigo_departamento;
    }

    public void setCodigo_departamento(String codigo_departamento) {
        this.codigo_departamento = codigo_departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCodigo_ubigeo() {
        return codigo_ubigeo;
    }

    public void setCodigo_ubigeo(String codigo_ubigeo) {
        this.codigo_ubigeo = codigo_ubigeo;
    }

}
