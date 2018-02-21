package entity;

public class Respuesta_tratamiento {

    private int respuesta_tratamiento_id;
    private String respuesta_tratamiento;
    private int activo;

    public Respuesta_tratamiento() {
    }

    public Respuesta_tratamiento(int respuesta_tratamiento_id, String respuesta_tratamiento, int activo) {
        this.respuesta_tratamiento_id = respuesta_tratamiento_id;
        this.respuesta_tratamiento = respuesta_tratamiento;
        this.activo = activo;
    }

    public int getRespuesta_tratamiento_id() {
        return respuesta_tratamiento_id;    
    }

    public void setRespuesta_tratamiento_id(int respuesta_tratamiento_id) {
        this.respuesta_tratamiento_id = respuesta_tratamiento_id;
    }

    public String getRespuesta_tratamiento() {
        return respuesta_tratamiento;
    }

    public void setRespuesta_tratamiento(String respuesta_tratamiento) {
        this.respuesta_tratamiento = respuesta_tratamiento;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

}
