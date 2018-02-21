package entity;

public class BaseDiagnostico {

    private int base_diagnostico_id;
    private String base_diagnostico;
    private int eliminado;

    public BaseDiagnostico() {

    }

    public BaseDiagnostico(int base_diagnostico_id, String base_diagnostico, int eliminado) {
        this.base_diagnostico_id = base_diagnostico_id;
        this.base_diagnostico = base_diagnostico;
        this.eliminado = eliminado;
    }

    public int getBase_diagnostico_id() {
        return base_diagnostico_id;
    }

    public void setBase_diagnostico_id(int base_diagnostico_id) {
        this.base_diagnostico_id = base_diagnostico_id;
    }

    public String getBase_diagnostico() {
        return base_diagnostico;
    }

    public void setBase_diagnostico(String base_diagnostico) {
        this.base_diagnostico = base_diagnostico;
    }

    public int getEliminado() {
        return eliminado;
    }

    public void setEliminado(int eliminado) {
        this.eliminado = eliminado;
    }

    
}
