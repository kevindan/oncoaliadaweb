package entity;

public class TipoProfesional {

    private String tipo_profesional_id;
    private String descripcion;
    private int eliminado;

    public TipoProfesional() {

    }

    public TipoProfesional(String tipo_profesional_id, String descripcion, int eliminado) {
        this.tipo_profesional_id = tipo_profesional_id;
        this.descripcion = descripcion;
        this.eliminado = eliminado;
    }

    public String getTipo_profesional_id() {
        return tipo_profesional_id;
    }

    public void setTipo_profesional_id(String tipo_profesional_id) {
        this.tipo_profesional_id = tipo_profesional_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEliminado() {
        return eliminado;
    }

    public void setEliminado(int eliminado) {
        this.eliminado = eliminado;
    }

}
