package entity;

public class Tipo_tumor {

    private int tipo_tumor_id;
    private String tipo_tumor;
    private int grupo_tumor_id;
    private int estado;

    public Tipo_tumor() {
    }

    public Tipo_tumor(int tipo_tumor_id, String tipo_tumor, int grupo_tumor_id, int estado) {
        this.tipo_tumor_id = tipo_tumor_id;
        this.tipo_tumor = tipo_tumor;
        this.grupo_tumor_id = grupo_tumor_id;
        this.estado = estado;
    }

    public int getTipo_tumor_id() {
        return tipo_tumor_id;
    }

    public void setTipo_tumor_id(int tipo_tumor_id) {
        this.tipo_tumor_id = tipo_tumor_id;
    }

    public String getTipo_tumor() {
        return tipo_tumor;
    }

    public void setTipo_tumor(String tipo_tumor) {
        this.tipo_tumor = tipo_tumor;
    }

    public int getGrupo_tumor_id() {
        return grupo_tumor_id;
    }

    public void setGrupo_tumor_id(int grupo_tumor_id) {
        this.grupo_tumor_id = grupo_tumor_id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
