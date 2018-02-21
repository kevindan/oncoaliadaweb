package entity;

public class TratamientoInicial {

    private int tratamiento_inicial_id;
    private String descripcion;
    private int eliminado;

    public TratamientoInicial() {
    }

    public TratamientoInicial(int tratamiento_inicial_id, String descripcion, int eliminado) {
        this.tratamiento_inicial_id = tratamiento_inicial_id;
        this.descripcion = descripcion;
        this.eliminado = eliminado;
    }

    public int getTratamiento_inicial_id() {
        return tratamiento_inicial_id;
    }

    public void setTratamiento_inicial_id(int tratamiento_inicial_id) {
        this.tratamiento_inicial_id = tratamiento_inicial_id;
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
