package entity;

public class Raza {

    private int raza_id;
    private String raza;
    private int estado;

    public Raza() {

    }

    public Raza(int raza_id, String raza, int estado) {
        this.raza_id = raza_id;
        this.raza = raza;
        this.estado = estado;
    }

    public int getRaza_id() {
        return raza_id;
    }

    public void setRaza_id(int raza_id) {
        this.raza_id = raza_id;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
