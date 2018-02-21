package entity;

public class TipoDocumento {

    private int tipo_documento_id;
    private String tipo_documento;
    private int eliminado;

    public TipoDocumento() {

    }

    public TipoDocumento(int tipo_documento_id, String tipo_documento, int eliminado) {
        this.tipo_documento_id = tipo_documento_id;
        this.tipo_documento = tipo_documento;
        this.eliminado = eliminado;
    }

    public int getTipo_documento_id() {
        return tipo_documento_id;
    }

    public void setTipo_documento_id(int tipo_documento_id) {
        this.tipo_documento_id = tipo_documento_id;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public int getEliminado() {
        return eliminado;
    }

    public void setEliminado(int eliminado) {
        this.eliminado = eliminado;
    }

}
