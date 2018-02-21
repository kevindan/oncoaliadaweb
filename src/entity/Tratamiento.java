package entity;

public class Tratamiento {

    private int tratamiento_id;
    private String tratamiento;
    private int estado;

    public Tratamiento() {
    }

    public Tratamiento(int tratamiento_id, String tratamiento, int estado) {
        this.tratamiento_id = tratamiento_id;
        this.tratamiento = tratamiento;
        this.estado = estado;
    }

    public int getTratamiento_id() {
        return tratamiento_id;
    }

    public void setTratamiento_id(int tratamiento_id) {
        this.tratamiento_id = tratamiento_id;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
