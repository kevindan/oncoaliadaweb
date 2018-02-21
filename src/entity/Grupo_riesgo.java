package entity;

public class Grupo_riesgo {

    private int grupo_riesgo_id;
    private String grupo_riesgo;
    private int tipo_diagnostico_id;
    private String eliminado;
	
    public Grupo_riesgo() {

	}
	public Grupo_riesgo(int grupo_riesgo_id, String grupo_riesgo, int tipo_diagnostico_id, String eliminado) {
		
		this.grupo_riesgo_id = grupo_riesgo_id;
		this.grupo_riesgo = grupo_riesgo;
		this.tipo_diagnostico_id = tipo_diagnostico_id;
		this.eliminado = eliminado;
	}
	
	public int getGrupo_riesgo_id() {
		return grupo_riesgo_id;
	}
	public void setGrupo_riesgo_id(int grupo_riesgo_id) {
		this.grupo_riesgo_id = grupo_riesgo_id;
	}
	public String getGrupo_riesgo() {
		return grupo_riesgo;
	}
	public void setGrupo_riesgo(String grupo_riesgo) {
		this.grupo_riesgo = grupo_riesgo;
	}
	public int getTipo_diagnostico_id() {
		return tipo_diagnostico_id;
	}
	public void setTipo_diagnostico_id(int tipo_diagnostico_id) {
		this.tipo_diagnostico_id = tipo_diagnostico_id;
	}
	public String getEliminado() {
		return eliminado;
	}
	public void setEliminado(String eliminado) {
		this.eliminado = eliminado;
	}
    
}
