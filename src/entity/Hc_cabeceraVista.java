package entity;

public class Hc_cabeceraVista {

    private int hc_cabecera_id;
    private int paciente_id;
    private String numero_documento;
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;
    private String codigo_cieo;
    private String descripcion;
    private String fecha_ultimo_control;

    public Hc_cabeceraVista() {

    }

	public Hc_cabeceraVista(int hc_cabecera_id, int paciente_id, String numero_documento, String nombres,
			String apellido_paterno, String apellido_materno, String codigo_cieo, String descripcion,
			String fecha_ultimo_control) {
		
		this.hc_cabecera_id = hc_cabecera_id;
		this.paciente_id = paciente_id;
		this.numero_documento = numero_documento;
		this.nombres = nombres;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		this.codigo_cieo = codigo_cieo;
		this.descripcion = descripcion;
		this.fecha_ultimo_control = fecha_ultimo_control;
	}

	public int getHc_cabecera_id() {
		return hc_cabecera_id;
	}

	public void setHc_cabecera_id(int hc_cabecera_id) {
		this.hc_cabecera_id = hc_cabecera_id;
	}

	public int getPaciente_id() {
		return paciente_id;
	}

	public void setPaciente_id(int paciente_id) {
		this.paciente_id = paciente_id;
	}

	public String getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	public String getApellido_materno() {
		return apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	public String getCodigo_cieo() {
		return codigo_cieo;
	}

	public void setCodigo_cieo(String codigo_cieo) {
		this.codigo_cieo = codigo_cieo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha_ultimo_control() {
		return fecha_ultimo_control;
	}

	public void setFecha_ultimo_control(String fecha_ultimo_control) {
		this.fecha_ultimo_control = fecha_ultimo_control;
	}
    
	
}
