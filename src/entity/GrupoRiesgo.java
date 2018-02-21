package entity;

public class GrupoRiesgo {

    private int grupo_riesgo_id;
    private String grupo_riesgo;
    private int eliminado;

    public GrupoRiesgo() {
    }

    public GrupoRiesgo(int grupo_riesgo_id, String grupo_riesgo, int eliminado) {
        this.grupo_riesgo_id = grupo_riesgo_id;
        this.grupo_riesgo = grupo_riesgo;
        this.eliminado = eliminado;
    }

    public int getGrupo_riesgo_id() {
        return grupo_riesgo_id;
    }

    public void setGrupo_riesgo_id(int grupo_riesgo_id) {
        this.grupo_riesgo_id = grupo_riesgo_id;
    }

    public String getGrupo_riesgo() {
        return grupo_riesgo;
    }

    public void setGrupo_riesgo(String grupo_riesgo) {
        this.grupo_riesgo = grupo_riesgo;
    }

    public int getEliminado() {
        return eliminado;
    }

    public void setEliminado(int eliminado) {
        this.eliminado = eliminado;
    }

}
