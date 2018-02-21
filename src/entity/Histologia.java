package entity;

public class Histologia {

    private int histologia_id;
    private String descripcion;
    private int eliminado;

    public Histologia() {
    }

    public Histologia(int histologia_id, String descripcion, int eliminado) {
        this.histologia_id = histologia_id;
        this.descripcion = descripcion;
        this.eliminado = eliminado;
    }

    public int getHistologia_id() {
        return histologia_id;
    }

    public void setHistologia_id(int histologia_id) {
        this.histologia_id = histologia_id;
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
