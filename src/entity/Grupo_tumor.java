package entity;

public class Grupo_tumor {

    private int grupo_tumor_id;
    private String grupo_tumor;
    private int estado;

    public Grupo_tumor() {
    }

    public Grupo_tumor(int grupo_tumor_id, String grupo_tumor, int estado) {
        this.grupo_tumor_id = grupo_tumor_id;
        this.grupo_tumor = grupo_tumor;
        this.estado = estado;
    }

    public int getGrupo_tumor_id() {
        return grupo_tumor_id;
    }

    public void setGrupo_tumor_id(int grupo_tumor_id) {
        this.grupo_tumor_id = grupo_tumor_id;
    }

    public String getGrupo_tumor() {
        return grupo_tumor;
    }

    public void setGrupo_tumor(String grupo_tumor) {
        this.grupo_tumor = grupo_tumor;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
