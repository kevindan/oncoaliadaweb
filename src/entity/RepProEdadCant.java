package entity;

public class RepProEdadCant {

    private String grupoetareo;
    private int cantidad;

    public RepProEdadCant() {
    }

    public RepProEdadCant(String grupoetareo, int cantidad) {
        this.grupoetareo = grupoetareo;
        this.cantidad = cantidad;
    }

    public String getGrupoetareo() {
        return grupoetareo;
    }

    public void setGrupoetareo(String grupoetareo) {
        this.grupoetareo = grupoetareo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
