package entity;

public class Provincia {

    private String codigo_departamento;
    private String codigo_provincia;
    private String provincia;
    private String codigo_ubigeo;

    public Provincia() {

    }

    public Provincia(String codigo_departamento, String codigo_provincia, String provincia, String codigo_ubigeo) {
        this.codigo_departamento = codigo_departamento;
        this.codigo_provincia = codigo_provincia;
        this.provincia = provincia;
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

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCodigo_ubigeo() {
        return codigo_ubigeo;
    }

    public void setCodigo_ubigeo(String codigo_ubigeo) {
        this.codigo_ubigeo = codigo_ubigeo;
    }

}
