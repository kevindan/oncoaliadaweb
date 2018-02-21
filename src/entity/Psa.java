package entity;

public class Psa {

    private int psa_id;
    private int paciente_id;
    private int psa_valor;
    private String descripcion;
    private String observacion;
    private String fecha_resultado;
    private int activo;

    public Psa() {
    }

    public Psa(int psa_id, int paciente_id, int psa_valor, String descripcion, String observcion, String fecha_resultado, int activo) {
        this.psa_id = psa_id;
        this.paciente_id = paciente_id;
        this.psa_valor = psa_valor;
        this.descripcion = descripcion;
        this.observacion = observcion;
        this.fecha_resultado = fecha_resultado;
        this.activo = activo;
    }

    public int getPsa_id() {
        return psa_id;
    }

    public void setPsa_id(int psa_id) {
        this.psa_id = psa_id;
    }

    public int getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(int paciente_id) {
        this.paciente_id = paciente_id;
    }

    public int getPsa_valor() {
        return psa_valor;
    }

    public void setPsa_valor(int psa_valor) {
        this.psa_valor = psa_valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getFecha_resultado() {
        return fecha_resultado;
    }

    public void setFecha_resultado(String fecha_resultado) {
        this.fecha_resultado = fecha_resultado;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

}
