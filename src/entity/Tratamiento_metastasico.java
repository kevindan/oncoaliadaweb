package entity;

public class Tratamiento_metastasico {

	private int tratamiento_metastasico_id; 
	private String tratamiento_metastasico; 
	private int estado;
	
	public Tratamiento_metastasico() {
		
	}

	public Tratamiento_metastasico(int tratamiento_metastasico_id, String tratamiento_metastasico, int estado) {
	
		this.tratamiento_metastasico_id = tratamiento_metastasico_id;
		this.tratamiento_metastasico = tratamiento_metastasico;
		this.estado = estado;
	}

	public int getTratamiento_metastasico_id() {
		return tratamiento_metastasico_id;
	}

	public void setTratamiento_metastasico_id(int tratamiento_metastasico_id) {
		this.tratamiento_metastasico_id = tratamiento_metastasico_id;
	}

	public String getTratamiento_metastasico() {
		return tratamiento_metastasico;
	}

	public void setTratamiento_metastasico(String tratamiento_metastasico) {
		this.tratamiento_metastasico = tratamiento_metastasico;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
