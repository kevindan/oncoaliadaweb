package entity;

public class Distrito {

    private String codigo_departamento;
    private String codigo_provincia;
    private String codigo_distrito;
    private String distrito;
    private String codigo_ubigeo;

    public Distrito() {

    }

    public Distrito(String codigo_departamento, String codigo_provincia, String codigo_distrito, String distrito, String codigo_ubigeo) {
        this.codigo_departamento = codigo_departamento;
        this.codigo_provincia = codigo_provincia;
        this.codigo_distrito = codigo_distrito;
        this.distrito = distrito;
        this.codigo_ubigeo = codigo_ubigeo;
    }

    public String getCodigo_departamento() {
        return codigo_departamento;
    }

    public void setCodigo_departamento(String codigo_departamento) {
        this.codigo_departamento = codigo_departamento;
    }

    public String getCodigo_provincia() {
        return codigo_provincia;
    }

    public void setCodigo_provincia(String codigo_provincia) {
        this.codigo_provincia = codigo_provincia;
    }

    public String getCodigo_distrito() {
        return codigo_distrito;
    }

    public void setCodigo_distrito(String codigo_distrito) {
        this.codigo_distrito = codigo_distrito;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getCodigo_ubigeo() {
        return codigo_ubigeo;
    }

    public void setCodigo_ubigeo(String codigo_ubigeo) {
        this.codigo_ubigeo = codigo_ubigeo;
    }

}