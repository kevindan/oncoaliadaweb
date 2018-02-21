package entity;

public class CategoriaCieo {

    private String categoria;
    private int activo;
    private String categoria_id;

    public CategoriaCieo() {

    }

    public CategoriaCieo(String categoria, int activo, String categoria_id) {
        this.categoria = categoria;
        this.activo = activo;
        this.categoria_id = categoria_id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(String categoria_id) {
        this.categoria_id = categoria_id;
    }

}
