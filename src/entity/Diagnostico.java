package entity;

public class Diagnostico {

    private String descripcion;
    private String codigo_cieo;
    private String categoria_id;
    private int eliminado;

    public Diagnostico() {

    }

    public Diagnostico(String descripcion, String codigo_cieo, String categoria_id, int eliminado) {
        this.descripcion = descripcion;
        this.codigo_cieo = codigo_cieo;
        this.categoria_id = categoria_id;
        this.eliminado = eliminado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo_cieo() {
        return codigo_cieo;
    }

    public void setCodigo_cieo(String codigo_cieo) {
        this.codigo_cieo = codigo_cieo;
    }

    public String getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(String categoria_id) {
        this.categoria_id = categoria_id;
    }

    public int getEliminado() {
        return eliminado;
    }

    public void setEliminado(int eliminado) {
        this.eliminado = eliminado;
    }

}
