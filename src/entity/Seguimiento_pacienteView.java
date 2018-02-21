package entity;

public class Seguimiento_pacienteView {

    private int seguimiento_id;
    private String tratamiento;
    private String respuesta_tratamiento;
    private String fecha;
    private String observacion;

    public Seguimiento_pacienteView() {
    }

    public Seguimiento_pacienteView(int seguimiento_id, String tratamiento, String respuesta_tratamiento, String fecha, String observacion) {
        this.seguimiento_id = seguimiento_id;
        this.tratamiento = tratamiento;
        this.respuesta_tratamiento = respuesta_tratamiento;
        this.fecha = fecha;
        this.observacion = observacion;
    }

    public int getSeguimiento_id() {
        return seguimiento_id;
    }

    public void setSeguimiento_id(int seguimiento_id) {
        this.seguimiento_id = seguimiento_id;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getRespuesta_tratamiento() {
        return respuesta_tratamiento;
    }

    public void setRespuesta_tratamiento(String respuesta_tratamiento) {
        this.respuesta_tratamiento = respuesta_tratamiento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

}
