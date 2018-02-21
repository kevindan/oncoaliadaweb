package entity;

public class Seguimiento_paciente {

    private int seguimiento_paciente_id;
    private int paciente_id;
    private int tratamiento_id;
    private String fecha;
    private int respuesta_tratamiento_id;
    private String observacion;
    private int activo;

    public Seguimiento_paciente() {
    }

    public Seguimiento_paciente(int seguimiento_paciente_id, int paciente_id, int tratamiento_id, String fecha, int respuesta_tratamiento_id, String observacion, int activo) {
        this.seguimiento_paciente_id = seguimiento_paciente_id;
        this.paciente_id = paciente_id;
        this.tratamiento_id = tratamiento_id;
        this.fecha = fecha;
        this.respuesta_tratamiento_id = respuesta_tratamiento_id;
        this.observacion = observacion;
        this.activo = activo;
    }

    public int getSeguimiento_paciente_id() {
        return seguimiento_paciente_id;
    }

    public void setSeguimiento_paciente_id(int seguimiento_paciente_id) {
        this.seguimiento_paciente_id = seguimiento_paciente_id;
    }

    public int getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(int paciente_id) {
        this.paciente_id = paciente_id;
    }

    public int getTratamiento_id() {
        return tratamiento_id;
    }

    public void setTratamiento_id(int tratamiento_id) {
        this.tratamiento_id = tratamiento_id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getRespuesta_tratamiento_id() {
        return respuesta_tratamiento_id;
    }

    public void setRespuesta_tratamiento_id(int respuesta_tratamiento_id) {
        this.respuesta_tratamiento_id = respuesta_tratamiento_id;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

}
