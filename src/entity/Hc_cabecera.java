package entity;

public class Hc_cabecera {

	private int hc_cabecera_id;
	private int paciente_id;
	private int antecedente_raza;
	private int raza_id;
	private int antecedente_familiar;
	private String descripcion_familiar;
	private int antecedente_genes;
	private int antecedente_alimentacion;
	private int antecedente_obesidad;
	private double imc;
	private int antecedente_exposicion_trabajo;
	private int antecedente_exposicion_trabajo_detalle;
	private int antecedente_its;
	private int antecedente_sustancia;
	private String sustancia_descripcion;
	private int antecedente_prostatitis;
	private int antecedente_neoplasia;
	private String antecedente_neoplasia_cieo;
	private double psa_debut;
	private int histologia_id;
	private String histologia_especificacion;
	private String fecha_diagnostico_histologico;
	private int tipo_diagnostico_id;
	private int grupo_riesgo_id;
	private double gleason_mayor;
	private double gleason_menor;
	private double gleason_total;
	private String categoria_t;
	private String categoria_t_patologico;
	private String categoria_n;
	private String categoria_m;
	private String categoria_g;
	private int tratamiento_inicial;
	private int eco_paciente;
	private String fecha_ultimo_control;
	private String fecha_falla_bioquimica;
	private double psa_falla_bioquimica;
	private int tratamiento_falla_bioquimica;
	private String fecha_enfermedad_metastasica;
	private double psa_enfermedad_metastasica;
	private int sintomatico_enfermedad_metastasica;
	private int enfermedad_metastasica_oligometastasico;
	private int organo_enfermedad_metastasica;
	private int tratamiento_enfermedad_metastasica;
	private int tecnica_radioterapia_enfermedad_metastasica;
	private double dosis_radioterapia_enfermedad_metastasica;
	private String fecha_segunda_enfermedad_progresiva;
	private double psa_segunda_enfermedad_progresiva;
	private int sintomatico_segunda_enfermedad_progresiva;
	private int segunda_enfermedad_progresiva_oligometastasico;
	private int organo_segunda_enfermedad_progresiva;
	private int tratamiento_segunda_enfermedad_progresiva;
	private int tecnica_radioterapia_segunda_enfermedad_progresiva;
	private double dosis_radioterapia_segunda_enfermedad_progresiva;
	private String fecha_tercera_enfermedad_progresiva;
	private double psa_tercera_enfermedad_progresiva;
	private int sintomatico_tercera_enfermedad_progresiva;
	private int tercera_enfermedad_progresiva_oligometastasico;
	private int organo_tercera_enfermedad_progresiva;
	private int tratamiento_tercera_enfermedad_progresiva;
	private int tecnica_radioterapia_tercera_enfermedad_progresiva;
	private double dosis_radioterapia_tercera_enfermedad_progresiva;
	private String fecha_cuarta_enfermedad_progresiva;
	private double psa_cuarta_enfermedad_progresiva;
	private int sintomatico_cuarta_enfermedad_progresiva;
	private int cuarta_enfermedad_progresiva_oligometastasico;
	private int organo_cuarta_enfermedad_progresiva;
	private int tratamiento_cuarta_enfermedad_progresiva;
	private int tecnica_radioterapia_cuarta_enfermedad_progresiva;
	private double dosis_radioterapia_cuarta_enfermedad_progresiva;
	private String usuario;
	private String fecha_registro;
	private String fecha_ultima_modificacion;
	private int activo;
	
	public Hc_cabecera() {
		
	}

	public Hc_cabecera(int hc_cabecera_id, int paciente_id, int antecedente_raza, int raza_id, int antecedente_familiar,
			String descripcion_familiar, int antecedente_genes, int antecedente_alimentacion, int antecedente_obesidad,
			double imc, int antecedente_exposicion_trabajo, int antecedente_exposicion_trabajo_detalle,
			int antecedente_its, int antecedente_sustancia, String sustancia_descripcion, int antecedente_prostatitis,
			int antecedente_neoplasia, String antecedente_neoplasia_cieo, double psa_debut, int histologia_id,
			String histologia_especificacion, String fecha_diagnostico_histologico, int tipo_diagnostico_id,
			int grupo_riesgo_id, double gleason_mayor, double gleason_menor, double gleason_total, String categoria_t,
			String categoria_t_patologico, String categoria_n, String categoria_m, String categoria_g,
			int tratamiento_inicial, int eco_paciente, String fecha_ultimo_control, String fecha_falla_bioquimica,
			double psa_falla_bioquimica, int tratamiento_falla_bioquimica, String fecha_enfermedad_metastasica,
			double psa_enfermedad_metastasica, int sintomatico_enfermedad_metastasica,
			int enfermedad_metastasica_oligometastasico, int organo_enfermedad_metastasica,
			int tratamiento_enfermedad_metastasica, int tecnica_radioterapia_enfermedad_metastasica,
			double dosis_radioterapia_enfermedad_metastasica, String fecha_segunda_enfermedad_progresiva,
			double psa_segunda_enfermedad_progresiva, int sintomatico_segunda_enfermedad_progresiva,
			int segunda_enfermedad_progresiva_oligometastasico, int organo_segunda_enfermedad_progresiva,
			int tratamiento_segunda_enfermedad_progresiva, int tecnica_radioterapia_segunda_enfermedad_progresiva,
			double dosis_radioterapia_segunda_enfermedad_progresiva, String fecha_tercera_enfermedad_progresiva,
			double psa_tercera_enfermedad_progresiva, int sintomatico_tercera_enfermedad_progresiva,
			int tercera_enfermedad_progresiva_oligometastasico, int organo_tercera_enfermedad_progresiva,
			int tratamiento_tercera_enfermedad_progresiva, int tecnica_radioterapia_tercera_enfermedad_progresiva,
			double dosis_radioterapia_tercera_enfermedad_progresiva, String fecha_cuarta_enfermedad_progresiva,
			double psa_cuarta_enfermedad_progresiva, int sintomatico_cuarta_enfermedad_progresiva,
			int cuarta_enfermedad_progresiva_oligometastasico, int organo_cuarta_enfermedad_progresiva,
			int tratamiento_cuarta_enfermedad_progresiva, int tecnica_radioterapia_cuarta_enfermedad_progresiva,
			double dosis_radioterapia_cuarta_enfermedad_progresiva, String usuario, String fecha_registro,
			String fecha_ultima_modificacion, int activo) {
		super();
		this.hc_cabecera_id = hc_cabecera_id;
		this.paciente_id = paciente_id;
		this.antecedente_raza = antecedente_raza;
		this.raza_id = raza_id;
		this.antecedente_familiar = antecedente_familiar;
		this.descripcion_familiar = descripcion_familiar;
		this.antecedente_genes = antecedente_genes;
		this.antecedente_alimentacion = antecedente_alimentacion;
		this.antecedente_obesidad = antecedente_obesidad;
		this.imc = imc;
		this.antecedente_exposicion_trabajo = antecedente_exposicion_trabajo;
		this.antecedente_exposicion_trabajo_detalle = antecedente_exposicion_trabajo_detalle;
		this.antecedente_its = antecedente_its;
		this.antecedente_sustancia = antecedente_sustancia;
		this.sustancia_descripcion = sustancia_descripcion;
		this.antecedente_prostatitis = antecedente_prostatitis;
		this.antecedente_neoplasia = antecedente_neoplasia;
		this.antecedente_neoplasia_cieo = antecedente_neoplasia_cieo;
		this.psa_debut = psa_debut;
		this.histologia_id = histologia_id;
		this.histologia_especificacion = histologia_especificacion;
		this.fecha_diagnostico_histologico = fecha_diagnostico_histologico;
		this.tipo_diagnostico_id = tipo_diagnostico_id;
		this.grupo_riesgo_id = grupo_riesgo_id;
		this.gleason_mayor = gleason_mayor;
		this.gleason_menor = gleason_menor;
		this.gleason_total = gleason_total;
		this.categoria_t = categoria_t;
		this.categoria_t_patologico = categoria_t_patologico;
		this.categoria_n = categoria_n;
		this.categoria_m = categoria_m;
		this.categoria_g = categoria_g;
		this.tratamiento_inicial = tratamiento_inicial;
		this.eco_paciente = eco_paciente;
		this.fecha_ultimo_control = fecha_ultimo_control;
		this.fecha_falla_bioquimica = fecha_falla_bioquimica;
		this.psa_falla_bioquimica = psa_falla_bioquimica;
		this.tratamiento_falla_bioquimica = tratamiento_falla_bioquimica;
		this.fecha_enfermedad_metastasica = fecha_enfermedad_metastasica;
		this.psa_enfermedad_metastasica = psa_enfermedad_metastasica;
		this.sintomatico_enfermedad_metastasica = sintomatico_enfermedad_metastasica;
		this.enfermedad_metastasica_oligometastasico = enfermedad_metastasica_oligometastasico;
		this.organo_enfermedad_metastasica = organo_enfermedad_metastasica;
		this.tratamiento_enfermedad_metastasica = tratamiento_enfermedad_metastasica;
		this.tecnica_radioterapia_enfermedad_metastasica = tecnica_radioterapia_enfermedad_metastasica;
		this.dosis_radioterapia_enfermedad_metastasica = dosis_radioterapia_enfermedad_metastasica;
		this.fecha_segunda_enfermedad_progresiva = fecha_segunda_enfermedad_progresiva;
		this.psa_segunda_enfermedad_progresiva = psa_segunda_enfermedad_progresiva;
		this.sintomatico_segunda_enfermedad_progresiva = sintomatico_segunda_enfermedad_progresiva;
		this.segunda_enfermedad_progresiva_oligometastasico = segunda_enfermedad_progresiva_oligometastasico;
		this.organo_segunda_enfermedad_progresiva = organo_segunda_enfermedad_progresiva;
		this.tratamiento_segunda_enfermedad_progresiva = tratamiento_segunda_enfermedad_progresiva;
		this.tecnica_radioterapia_segunda_enfermedad_progresiva = tecnica_radioterapia_segunda_enfermedad_progresiva;
		this.dosis_radioterapia_segunda_enfermedad_progresiva = dosis_radioterapia_segunda_enfermedad_progresiva;
		this.fecha_tercera_enfermedad_progresiva = fecha_tercera_enfermedad_progresiva;
		this.psa_tercera_enfermedad_progresiva = psa_tercera_enfermedad_progresiva;
		this.sintomatico_tercera_enfermedad_progresiva = sintomatico_tercera_enfermedad_progresiva;
		this.tercera_enfermedad_progresiva_oligometastasico = tercera_enfermedad_progresiva_oligometastasico;
		this.organo_tercera_enfermedad_progresiva = organo_tercera_enfermedad_progresiva;
		this.tratamiento_tercera_enfermedad_progresiva = tratamiento_tercera_enfermedad_progresiva;
		this.tecnica_radioterapia_tercera_enfermedad_progresiva = tecnica_radioterapia_tercera_enfermedad_progresiva;
		this.dosis_radioterapia_tercera_enfermedad_progresiva = dosis_radioterapia_tercera_enfermedad_progresiva;
		this.fecha_cuarta_enfermedad_progresiva = fecha_cuarta_enfermedad_progresiva;
		this.psa_cuarta_enfermedad_progresiva = psa_cuarta_enfermedad_progresiva;
		this.sintomatico_cuarta_enfermedad_progresiva = sintomatico_cuarta_enfermedad_progresiva;
		this.cuarta_enfermedad_progresiva_oligometastasico = cuarta_enfermedad_progresiva_oligometastasico;
		this.organo_cuarta_enfermedad_progresiva = organo_cuarta_enfermedad_progresiva;
		this.tratamiento_cuarta_enfermedad_progresiva = tratamiento_cuarta_enfermedad_progresiva;
		this.tecnica_radioterapia_cuarta_enfermedad_progresiva = tecnica_radioterapia_cuarta_enfermedad_progresiva;
		this.dosis_radioterapia_cuarta_enfermedad_progresiva = dosis_radioterapia_cuarta_enfermedad_progresiva;
		this.usuario = usuario;
		this.fecha_registro = fecha_registro;
		this.fecha_ultima_modificacion = fecha_ultima_modificacion;
		this.activo = activo;
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

	public int getAntecedente_raza() {
		return antecedente_raza;
	}

	public void setAntecedente_raza(int antecedente_raza) {
		this.antecedente_raza = antecedente_raza;
	}

	public int getRaza_id() {
		return raza_id;
	}

	public void setRaza_id(int raza_id) {
		this.raza_id = raza_id;
	}

	public int getAntecedente_familiar() {
		return antecedente_familiar;
	}

	public void setAntecedente_familiar(int antecedente_familiar) {
		this.antecedente_familiar = antecedente_familiar;
	}

	public String getDescripcion_familiar() {
		return descripcion_familiar;
	}

	public void setDescripcion_familiar(String descripcion_familiar) {
		this.descripcion_familiar = descripcion_familiar;
	}

	public int getAntecedente_genes() {
		return antecedente_genes;
	}

	public void setAntecedente_genes(int antecedente_genes) {
		this.antecedente_genes = antecedente_genes;
	}

	public int getAntecedente_alimentacion() {
		return antecedente_alimentacion;
	}

	public void setAntecedente_alimentacion(int antecedente_alimentacion) {
		this.antecedente_alimentacion = antecedente_alimentacion;
	}

	public int getAntecedente_obesidad() {
		return antecedente_obesidad;
	}

	public void setAntecedente_obesidad(int antecedente_obesidad) {
		this.antecedente_obesidad = antecedente_obesidad;
	}

	public double getImc() {
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

	public int getAntecedente_exposicion_trabajo() {
		return antecedente_exposicion_trabajo;
	}

	public void setAntecedente_exposicion_trabajo(int antecedente_exposicion_trabajo) {
		this.antecedente_exposicion_trabajo = antecedente_exposicion_trabajo;
	}

	public int getAntecedente_exposicion_trabajo_detalle() {
		return antecedente_exposicion_trabajo_detalle;
	}

	public void setAntecedente_exposicion_trabajo_detalle(int antecedente_exposicion_trabajo_detalle) {
		this.antecedente_exposicion_trabajo_detalle = antecedente_exposicion_trabajo_detalle;
	}

	public int getAntecedente_its() {
		return antecedente_its;
	}

	public void setAntecedente_its(int antecedente_its) {
		this.antecedente_its = antecedente_its;
	}

	public int getAntecedente_sustancia() {
		return antecedente_sustancia;
	}

	public void setAntecedente_sustancia(int antecedente_sustancia) {
		this.antecedente_sustancia = antecedente_sustancia;
	}

	public String getSustancia_descripcion() {
		return sustancia_descripcion;
	}

	public void setSustancia_descripcion(String sustancia_descripcion) {
		this.sustancia_descripcion = sustancia_descripcion;
	}

	public int getAntecedente_prostatitis() {
		return antecedente_prostatitis;
	}

	public void setAntecedente_prostatitis(int antecedente_prostatitis) {
		this.antecedente_prostatitis = antecedente_prostatitis;
	}

	public int getAntecedente_neoplasia() {
		return antecedente_neoplasia;
	}

	public void setAntecedente_neoplasia(int antecedente_neoplasia) {
		this.antecedente_neoplasia = antecedente_neoplasia;
	}

	public String getAntecedente_neoplasia_cieo() {
		return antecedente_neoplasia_cieo;
	}

	public void setAntecedente_neoplasia_cieo(String antecedente_neoplasia_cieo) {
		this.antecedente_neoplasia_cieo = antecedente_neoplasia_cieo;
	}

	public double getPsa_debut() {
		return psa_debut;
	}

	public void setPsa_debut(double psa_debut) {
		this.psa_debut = psa_debut;
	}

	public int getHistologia_id() {
		return histologia_id;
	}

	public void setHistologia_id(int histologia_id) {
		this.histologia_id = histologia_id;
	}

	public String getHistologia_especificacion() {
		return histologia_especificacion;
	}

	public void setHistologia_especificacion(String histologia_especificacion) {
		this.histologia_especificacion = histologia_especificacion;
	}

	public String getFecha_diagnostico_histologico() {
		return fecha_diagnostico_histologico;
	}

	public void setFecha_diagnostico_histologico(String fecha_diagnostico_histologico) {
		this.fecha_diagnostico_histologico = fecha_diagnostico_histologico;
	}

	public int getTipo_diagnostico_id() {
		return tipo_diagnostico_id;
	}

	public void setTipo_diagnostico_id(int tipo_diagnostico_id) {
		this.tipo_diagnostico_id = tipo_diagnostico_id;
	}

	public int getGrupo_riesgo_id() {
		return grupo_riesgo_id;
	}

	public void setGrupo_riesgo_id(int grupo_riesgo_id) {
		this.grupo_riesgo_id = grupo_riesgo_id;
	}

	public double getGleason_mayor() {
		return gleason_mayor;
	}

	public void setGleason_mayor(double gleason_mayor) {
		this.gleason_mayor = gleason_mayor;
	}

	public double getGleason_menor() {
		return gleason_menor;
	}

	public void setGleason_menor(double gleason_menor) {
		this.gleason_menor = gleason_menor;
	}

	public double getGleason_total() {
		return gleason_total;
	}

	public void setGleason_total(double gleason_total) {
		this.gleason_total = gleason_total;
	}

	public String getCategoria_t() {
		return categoria_t;
	}

	public void setCategoria_t(String categoria_t) {
		this.categoria_t = categoria_t;
	}

	public String getCategoria_t_patologico() {
		return categoria_t_patologico;
	}

	public void setCategoria_t_patologico(String categoria_t_patologico) {
		this.categoria_t_patologico = categoria_t_patologico;
	}

	public String getCategoria_n() {
		return categoria_n;
	}

	public void setCategoria_n(String categoria_n) {
		this.categoria_n = categoria_n;
	}

	public String getCategoria_m() {
		return categoria_m;
	}

	public void setCategoria_m(String categoria_m) {
		this.categoria_m = categoria_m;
	}

	public String getCategoria_g() {
		return categoria_g;
	}

	public void setCategoria_g(String categoria_g) {
		this.categoria_g = categoria_g;
	}

	public int getTratamiento_inicial() {
		return tratamiento_inicial;
	}

	public void setTratamiento_inicial(int tratamiento_inicial) {
		this.tratamiento_inicial = tratamiento_inicial;
	}

	public int getEco_paciente() {
		return eco_paciente;
	}

	public void setEco_paciente(int eco_paciente) {
		this.eco_paciente = eco_paciente;
	}

	public String getFecha_ultimo_control() {
		return fecha_ultimo_control;
	}

	public void setFecha_ultimo_control(String fecha_ultimo_control) {
		this.fecha_ultimo_control = fecha_ultimo_control;
	}

	public String getFecha_falla_bioquimica() {
		return fecha_falla_bioquimica;
	}

	public void setFecha_falla_bioquimica(String fecha_falla_bioquimica) {
		this.fecha_falla_bioquimica = fecha_falla_bioquimica;
	}

	public double getPsa_falla_bioquimica() {
		return psa_falla_bioquimica;
	}

	public void setPsa_falla_bioquimica(double psa_falla_bioquimica) {
		this.psa_falla_bioquimica = psa_falla_bioquimica;
	}

	public int getTratamiento_falla_bioquimica() {
		return tratamiento_falla_bioquimica;
	}

	public void setTratamiento_falla_bioquimica(int tratamiento_falla_bioquimica) {
		this.tratamiento_falla_bioquimica = tratamiento_falla_bioquimica;
	}

	public String getFecha_enfermedad_metastasica() {
		return fecha_enfermedad_metastasica;
	}

	public void setFecha_enfermedad_metastasica(String fecha_enfermedad_metastasica) {
		this.fecha_enfermedad_metastasica = fecha_enfermedad_metastasica;
	}

	public double getPsa_enfermedad_metastasica() {
		return psa_enfermedad_metastasica;
	}

	public void setPsa_enfermedad_metastasica(double psa_enfermedad_metastasica) {
		this.psa_enfermedad_metastasica = psa_enfermedad_metastasica;
	}

	public int getSintomatico_enfermedad_metastasica() {
		return sintomatico_enfermedad_metastasica;
	}

	public void setSintomatico_enfermedad_metastasica(int sintomatico_enfermedad_metastasica) {
		this.sintomatico_enfermedad_metastasica = sintomatico_enfermedad_metastasica;
	}

	public int getEnfermedad_metastasica_oligometastasico() {
		return enfermedad_metastasica_oligometastasico;
	}

	public void setEnfermedad_metastasica_oligometastasico(int enfermedad_metastasica_oligometastasico) {
		this.enfermedad_metastasica_oligometastasico = enfermedad_metastasica_oligometastasico;
	}

	public int getOrgano_enfermedad_metastasica() {
		return organo_enfermedad_metastasica;
	}

	public void setOrgano_enfermedad_metastasica(int organo_enfermedad_metastasica) {
		this.organo_enfermedad_metastasica = organo_enfermedad_metastasica;
	}

	public int getTratamiento_enfermedad_metastasica() {
		return tratamiento_enfermedad_metastasica;
	}

	public void setTratamiento_enfermedad_metastasica(int tratamiento_enfermedad_metastasica) {
		this.tratamiento_enfermedad_metastasica = tratamiento_enfermedad_metastasica;
	}

	public int getTecnica_radioterapia_enfermedad_metastasica() {
		return tecnica_radioterapia_enfermedad_metastasica;
	}

	public void setTecnica_radioterapia_enfermedad_metastasica(int tecnica_radioterapia_enfermedad_metastasica) {
		this.tecnica_radioterapia_enfermedad_metastasica = tecnica_radioterapia_enfermedad_metastasica;
	}

	public double getDosis_radioterapia_enfermedad_metastasica() {
		return dosis_radioterapia_enfermedad_metastasica;
	}

	public void setDosis_radioterapia_enfermedad_metastasica(double dosis_radioterapia_enfermedad_metastasica) {
		this.dosis_radioterapia_enfermedad_metastasica = dosis_radioterapia_enfermedad_metastasica;
	}

	public String getFecha_segunda_enfermedad_progresiva() {
		return fecha_segunda_enfermedad_progresiva;
	}

	public void setFecha_segunda_enfermedad_progresiva(String fecha_segunda_enfermedad_progresiva) {
		this.fecha_segunda_enfermedad_progresiva = fecha_segunda_enfermedad_progresiva;
	}

	public double getPsa_segunda_enfermedad_progresiva() {
		return psa_segunda_enfermedad_progresiva;
	}

	public void setPsa_segunda_enfermedad_progresiva(double psa_segunda_enfermedad_progresiva) {
		this.psa_segunda_enfermedad_progresiva = psa_segunda_enfermedad_progresiva;
	}

	public int getSintomatico_segunda_enfermedad_progresiva() {
		return sintomatico_segunda_enfermedad_progresiva;
	}

	public void setSintomatico_segunda_enfermedad_progresiva(int sintomatico_segunda_enfermedad_progresiva) {
		this.sintomatico_segunda_enfermedad_progresiva = sintomatico_segunda_enfermedad_progresiva;
	}

	public int getSegunda_enfermedad_progresiva_oligometastasico() {
		return segunda_enfermedad_progresiva_oligometastasico;
	}

	public void setSegunda_enfermedad_progresiva_oligometastasico(int segunda_enfermedad_progresiva_oligometastasico) {
		this.segunda_enfermedad_progresiva_oligometastasico = segunda_enfermedad_progresiva_oligometastasico;
	}

	public int getOrgano_segunda_enfermedad_progresiva() {
		return organo_segunda_enfermedad_progresiva;
	}

	public void setOrgano_segunda_enfermedad_progresiva(int organo_segunda_enfermedad_progresiva) {
		this.organo_segunda_enfermedad_progresiva = organo_segunda_enfermedad_progresiva;
	}

	public int getTratamiento_segunda_enfermedad_progresiva() {
		return tratamiento_segunda_enfermedad_progresiva;
	}

	public void setTratamiento_segunda_enfermedad_progresiva(int tratamiento_segunda_enfermedad_progresiva) {
		this.tratamiento_segunda_enfermedad_progresiva = tratamiento_segunda_enfermedad_progresiva;
	}

	public int getTecnica_radioterapia_segunda_enfermedad_progresiva() {
		return tecnica_radioterapia_segunda_enfermedad_progresiva;
	}

	public void setTecnica_radioterapia_segunda_enfermedad_progresiva(
			int tecnica_radioterapia_segunda_enfermedad_progresiva) {
		this.tecnica_radioterapia_segunda_enfermedad_progresiva = tecnica_radioterapia_segunda_enfermedad_progresiva;
	}

	public double getDosis_radioterapia_segunda_enfermedad_progresiva() {
		return dosis_radioterapia_segunda_enfermedad_progresiva;
	}

	public void setDosis_radioterapia_segunda_enfermedad_progresiva(
			double dosis_radioterapia_segunda_enfermedad_progresiva) {
		this.dosis_radioterapia_segunda_enfermedad_progresiva = dosis_radioterapia_segunda_enfermedad_progresiva;
	}

	public String getFecha_tercera_enfermedad_progresiva() {
		return fecha_tercera_enfermedad_progresiva;
	}

	public void setFecha_tercera_enfermedad_progresiva(String fecha_tercera_enfermedad_progresiva) {
		this.fecha_tercera_enfermedad_progresiva = fecha_tercera_enfermedad_progresiva;
	}

	public double getPsa_tercera_enfermedad_progresiva() {
		return psa_tercera_enfermedad_progresiva;
	}

	public void setPsa_tercera_enfermedad_progresiva(double psa_tercera_enfermedad_progresiva) {
		this.psa_tercera_enfermedad_progresiva = psa_tercera_enfermedad_progresiva;
	}

	public int getSintomatico_tercera_enfermedad_progresiva() {
		return sintomatico_tercera_enfermedad_progresiva;
	}

	public void setSintomatico_tercera_enfermedad_progresiva(int sintomatico_tercera_enfermedad_progresiva) {
		this.sintomatico_tercera_enfermedad_progresiva = sintomatico_tercera_enfermedad_progresiva;
	}

	public int getTercera_enfermedad_progresiva_oligometastasico() {
		return tercera_enfermedad_progresiva_oligometastasico;
	}

	public void setTercera_enfermedad_progresiva_oligometastasico(int tercera_enfermedad_progresiva_oligometastasico) {
		this.tercera_enfermedad_progresiva_oligometastasico = tercera_enfermedad_progresiva_oligometastasico;
	}

	public int getOrgano_tercera_enfermedad_progresiva() {
		return organo_tercera_enfermedad_progresiva;
	}

	public void setOrgano_tercera_enfermedad_progresiva(int organo_tercera_enfermedad_progresiva) {
		this.organo_tercera_enfermedad_progresiva = organo_tercera_enfermedad_progresiva;
	}

	public int getTratamiento_tercera_enfermedad_progresiva() {
		return tratamiento_tercera_enfermedad_progresiva;
	}

	public void setTratamiento_tercera_enfermedad_progresiva(int tratamiento_tercera_enfermedad_progresiva) {
		this.tratamiento_tercera_enfermedad_progresiva = tratamiento_tercera_enfermedad_progresiva;
	}

	public int getTecnica_radioterapia_tercera_enfermedad_progresiva() {
		return tecnica_radioterapia_tercera_enfermedad_progresiva;
	}

	public void setTecnica_radioterapia_tercera_enfermedad_progresiva(
			int tecnica_radioterapia_tercera_enfermedad_progresiva) {
		this.tecnica_radioterapia_tercera_enfermedad_progresiva = tecnica_radioterapia_tercera_enfermedad_progresiva;
	}

	public double getDosis_radioterapia_tercera_enfermedad_progresiva() {
		return dosis_radioterapia_tercera_enfermedad_progresiva;
	}

	public void setDosis_radioterapia_tercera_enfermedad_progresiva(
			double dosis_radioterapia_tercera_enfermedad_progresiva) {
		this.dosis_radioterapia_tercera_enfermedad_progresiva = dosis_radioterapia_tercera_enfermedad_progresiva;
	}

	public String getFecha_cuarta_enfermedad_progresiva() {
		return fecha_cuarta_enfermedad_progresiva;
	}

	public void setFecha_cuarta_enfermedad_progresiva(String fecha_cuarta_enfermedad_progresiva) {
		this.fecha_cuarta_enfermedad_progresiva = fecha_cuarta_enfermedad_progresiva;
	}

	public double getPsa_cuarta_enfermedad_progresiva() {
		return psa_cuarta_enfermedad_progresiva;
	}

	public void setPsa_cuarta_enfermedad_progresiva(double psa_cuarta_enfermedad_progresiva) {
		this.psa_cuarta_enfermedad_progresiva = psa_cuarta_enfermedad_progresiva;
	}

	public int getSintomatico_cuarta_enfermedad_progresiva() {
		return sintomatico_cuarta_enfermedad_progresiva;
	}

	public void setSintomatico_cuarta_enfermedad_progresiva(int sintomatico_cuarta_enfermedad_progresiva) {
		this.sintomatico_cuarta_enfermedad_progresiva = sintomatico_cuarta_enfermedad_progresiva;
	}

	public int getCuarta_enfermedad_progresiva_oligometastasico() {
		return cuarta_enfermedad_progresiva_oligometastasico;
	}

	public void setCuarta_enfermedad_progresiva_oligometastasico(int cuarta_enfermedad_progresiva_oligometastasico) {
		this.cuarta_enfermedad_progresiva_oligometastasico = cuarta_enfermedad_progresiva_oligometastasico;
	}

	public int getOrgano_cuarta_enfermedad_progresiva() {
		return organo_cuarta_enfermedad_progresiva;
	}

	public void setOrgano_cuarta_enfermedad_progresiva(int organo_cuarta_enfermedad_progresiva) {
		this.organo_cuarta_enfermedad_progresiva = organo_cuarta_enfermedad_progresiva;
	}

	public int getTratamiento_cuarta_enfermedad_progresiva() {
		return tratamiento_cuarta_enfermedad_progresiva;
	}

	public void setTratamiento_cuarta_enfermedad_progresiva(int tratamiento_cuarta_enfermedad_progresiva) {
		this.tratamiento_cuarta_enfermedad_progresiva = tratamiento_cuarta_enfermedad_progresiva;
	}

	public int getTecnica_radioterapia_cuarta_enfermedad_progresiva() {
		return tecnica_radioterapia_cuarta_enfermedad_progresiva;
	}

	public void setTecnica_radioterapia_cuarta_enfermedad_progresiva(
			int tecnica_radioterapia_cuarta_enfermedad_progresiva) {
		this.tecnica_radioterapia_cuarta_enfermedad_progresiva = tecnica_radioterapia_cuarta_enfermedad_progresiva;
	}

	public double getDosis_radioterapia_cuarta_enfermedad_progresiva() {
		return dosis_radioterapia_cuarta_enfermedad_progresiva;
	}

	public void setDosis_radioterapia_cuarta_enfermedad_progresiva(double dosis_radioterapia_cuarta_enfermedad_progresiva) {
		this.dosis_radioterapia_cuarta_enfermedad_progresiva = dosis_radioterapia_cuarta_enfermedad_progresiva;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getFecha_ultima_modificacion() {
		return fecha_ultima_modificacion;
	}

	public void setFecha_ultima_modificacion(String fecha_ultima_modificacion) {
		this.fecha_ultima_modificacion = fecha_ultima_modificacion;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

}
