package entity;

public class Paciente {

    private int paciente_id;
    private int tipo_documento_id;
    private String numero_documento;
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;
    private String sexo;
    private String fecha_nacimiento;
    private String direccion;
    private String telefono;
    private String fecha_registro;
    private int tipo_paciente;
    private int fallecido;   
    private int base_diagnostico_id;  
    private String codigo_cieo;
    private String codigo_ubigeo;
    private String fecha_diagnostico;
    private String observacion;
    private int eliminado;

    public Paciente() {

    }

	public Paciente(int paciente_id, int tipo_documento_id, String numero_documento, String nombres,
			String apellido_paterno, String apellido_materno, String sexo, String fecha_nacimiento, String direccion,
			String telefono, String fecha_registro, int tipo_paciente, int fallecido, int base_diagnostico_id,
			String codigo_cieo, String codigo_ubigeo, String fecha_diagnostico, String observacion, int eliminado) {
		super();
		this.paciente_id = paciente_id;
		this.tipo_documento_id = tipo_documento_id;
		this.numero_documento = numero_documento;
		this.nombres = nombres;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		this.sexo = sexo;
		this.fecha_nacimiento = fecha_nacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fecha_registro = fecha_registro;
		this.tipo_paciente = tipo_paciente;
		this.fallecido = fallecido;
		this.base_diagnostico_id = base_diagnostico_id;
		this.codigo_cieo = codigo_cieo;
		this.codigo_ubigeo = codigo_ubigeo;
		this.fecha_diagnostico = fecha_diagnostico;
		this.observacion = observacion;
		this.eliminado = eliminado;
	}

	public int getPaciente_id() {
		return paciente_id;
	}

	public void setPaciente_id(int paciente_id) {
		this.paciente_id = paciente_id;
	}

	public int getTipo_documento_id() {
		return tipo_documento_id;
	}

	public void setTipo_documento_id(int tipo_documento_id) {
		this.tipo_documento_id = tipo_documento_id;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public int getTipo_paciente() {
		return tipo_paciente;
	}

	public void setTipo_paciente(int tipo_paciente) {
		this.tipo_paciente = tipo_paciente;
	}

	public int getFallecido() {
		return fallecido;
	}

	public void setFallecido(int fallecido) {
		this.fallecido = fallecido;
	}

	public int getBase_diagnostico_id() {
		return base_diagnostico_id;
	}

	public void setBase_diagnostico_id(int base_diagnostico_id) {
		this.base_diagnostico_id = base_diagnostico_id;
	}

	public String getCodigo_cieo() {
		return codigo_cieo;
	}

	public void setCodigo_cieo(String codigo_cieo) {
		this.codigo_cieo = codigo_cieo;
	}

	public String getCodigo_ubigeo() {
		return codigo_ubigeo;
	}

	public void setCodigo_ubigeo(String codigo_ubigeo) {
		this.codigo_ubigeo = codigo_ubigeo;
	}

	public String getFecha_diagnostico() {
		return fecha_diagnostico;
	}

	public void setFecha_diagnostico(String fecha_diagnostico) {
		this.fecha_diagnostico = fecha_diagnostico;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public int getEliminado() {
		return eliminado;
	}

	public void setEliminado(int eliminado) {
		this.eliminado = eliminado;
	}

	
   

}
