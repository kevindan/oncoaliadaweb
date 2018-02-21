$(document).ready(function() {

	$('#tabla_cieo').dataTable();
	$('#lista_pacientes').dataTable();
	
	$('#fecha_ultimo_control').datepicker();
	$('#fecha_falla_bioquimica').datepicker();
	$('#fecha_enfermedad_metastasica').datepicker();
	$('#fecha_segunda_enfermedad_progresiva').datepicker();
	$('#fecha_tercera_enfermedad_progresiva').datepicker();
	$('#fecha_cuarta_enfermedad_progresiva').datepicker();
	$('#fecha_diagnostico_histologico').datepicker();
		
	carga_grupo_tumor(1);
	lista_pacientes_hc();
	
	//$('#antecedente_familiar').prop('checked',true);
	//$('#label_antecedente_familiar').addClass('checked');
	//$('#panel_antecedente_familiar').removeClass('hide');
	
});

$('#btn_guardar_hc').click(function(event){
	
	grabar_hc();
	
});

$('#btn_nuevo_hc').click(function(event){
	
	limpiar();
	
});

function grabar_hc(){
	
	var opcionVar = "guardar";
	
	var hc_cabecera_idVar = $('#hc_cabecera_id').val();
		
	if (hc_cabecera_idVar == '') {

		operacionVar = 'registrar';

	} else {

		operacionVar = 'actualizar';
		
	}

	var paciente_idVar = $('#paciente_id').val();
	var eco_pacienteVar = $('#eco_paciente').val();
	var fecha_ultimo_controlVar = $('#fecha_ultimo_control').val();
	var antecedente_razaVar = 0;
	
	if($('#antecedente_raza').prop('checked')){
		
		antecedente_razaVar = 1;
				
	}else{
		
		antecedente_razaVar = 0;
				
	}
	
	var raza_idVar = $('#raza_id').val();
	var antecedente_familiarVar = 0;
	
	if($('#antecedente_familiar').prop('checked')){
		
		antecedente_familiarVar = 1;
				
	}else{
		
		antecedente_familiarVar = 0;
				
	}
	
	var descripcion_familiarVar = $('#descripcion_familiar').val();
	var antecedente_genesVar = 0;
	
	if($('#antecedente_genes').prop('checked')){
		
		antecedente_genesVar = 1;
				
	}else{
		
		antecedente_genesVar = 0;
				
	}
	
	var antecedente_alimentacionVar = 0;
	
	if($('#antecedente_alimentacion').prop('checked')){
		
		antecedente_alimentacionVar = 1;
				
	}else{
		
		antecedente_alimentacionVar = 0;
				
	}
	
	var antecedente_obesidadVar = 0;

	if($('#antecedente_obesidad').prop('checked')){
		
		antecedente_obesidadVar = 1;
				
	}else{
		
		antecedente_obesidadVar = 0;
				
	}
	
	var imcVar = $('#imc').val();
	var antecedente_exposicion_trabajoVar = 0;
	
	if($('#antecedente_exposicion_trabajo').prop('checked')){
		
		antecedente_exposicion_trabajoVar = 1;
				
	}else{
		
		antecedente_exposicion_trabajoVar = 0;
				
	}
	
	var antecedente_exposicion_trabajo_detalleVar = $('#antecedente_exposicion_trabajo_detalle').val();
	var antecedente_prostatitisVar = 0;
	
	if($('#antecedente_prostatitis').prop('checked')){
		
		antecedente_prostatitisVar = 1;
				
	}else{
		
		antecedente_prostatitisVar = 0;
				
	}
	
	var antecedente_itsVar = 0;
	
	if($('#antecedente_its').prop('checked')){
		
		antecedente_itsVar = 1;
				
	}else{
		
		antecedente_itsVar = 0;
				
	}
	
	var antecedente_sustancia_quimicaVar = 0;
	
	if($('#antecedente_sustancia').prop('checked')){
		
		antecedente_sustancia_quimicaVar = 1;
				
	}else{
		
		antecedente_sustancia_quimicaVar = 0;
				
	}
	
	var sustancia_descripcionVar = $('#sustancia_descripcion').val();
	var antecedente_neoplasiaVar = 0;
	
	if($('#antecedente_neoplasia').prop('checked')){
		
		antecedente_neoplasiaVar = 1;
				
	}else{
		
		antecedente_neoplasiaVar = 0;
				
	}
	
	var antecedente_neoplasia_cieoVar = $('#antecedente_neoplasia_cieo').val();
	var psa_debutVar = $('#psa_debut').val();
	var histologia_idVar = $('#histologia_id').val();
	var histologia_especificacionVar = $('#histologia_especificacion').val();
	var fecha_diagnostico_histologicoVar = $('#fecha_diagnostico_histologico').val();
	var gleason_mayorVar = $('#gleason_mayor').val();
	var gleason_menorVar = $('#gleason_menor').val();
	var gleason_totalVar = $('#gleason_total').val();
	var categoria_tVar = $('#categoria_t').val();
	var categoria_t_patologicoVar = $('#categoria_t_patologico').val();
	var categoria_nVar = $('#categoria_n').val();
	var categoria_mVar = $('#categoria_m').val();
	var categoria_gVar = $('#categoria_g').val();
	
	var tratamiento_inicialVar = $('#tratamiento_inicial').val();
	var tipo_diagnostico_idVar = $('#tipo_diagnostico_id').val();
	var grupo_riesgo_idVar = $('#grupo_riesgo_id').val();
	
	var fecha_falla_bioquimicaVar = $('#fecha_falla_bioquimica').val();
	var psa_falla_bioquimicaVar = $('#psa_falla_bioquimica').val();
	var tratamiento_falla_bioquimicaVar = $('#tratamiento_falla_bioquimica').val();
	
	var fecha_enfermedad_metastasicaVar = $('#fecha_enfermedad_metastasica').val();
	var psa_enfermedad_metastasicaVar = $('#psa_enfermedad_metastasica').val();
	var sintomatico_enfermedad_metastasicaVar = $('#sintomatico_enfermedad_metastasica').val();
	var enfermedad_metastasica_oligometastasicoVar = $('#enfermedad_metastasica_oligometastasico').val();
	var organo_enfermedad_metastasicaVar = $('#organo_enfermedad_metastasica').val();
	var tratamiento_enfermedad_metastasicaVar = $('#tratamiento_enfermedad_metastasica').val();
	var tecnica_radioterapia_enfermedad_metastasicaVar = $('#tecnica_radioterapia_enfermedad_metastasica').val();
	var dosis_radioterapia_enfermedad_metastasicaVar = $('#dosis_radioterapia_enfermedad_metastasica').val();
	
	var fecha_segunda_enfermedad_progresivaVar= $('#fecha_segunda_enfermedad_progresiva').val();
	var psa_segunda_enfermedad_progresivaVar = $('#psa_segunda_enfermedad_progresiva').val();
	var sintomatico_segunda_enfermedad_progresivaVar = $('#sintomatico_segunda_enfermedad_progresiva').val();
	var segunda_enfermedad_progresiva_oligometastasicoVar = $('#segunda_enfermedad_progresiva_oligometastasico').val();
	var organo_segunda_enfermedad_progresivaVar = $('#organo_segunda_enfermedad_progresiva').val();
	var tratamiento_segunda_enfermedad_progresivaVar = $('#tratamiento_segunda_enfermedad_progresiva').val();
	var tecnica_radioterapia_segunda_enfermedad_progresivaVar = $('#tecnica_radioterapia_segunda_enfermedad_progresiva').val();
	var dosis_segunda_enfermedad_progresivaVar = $('#dosis_segunda_enfermedad_progresiva').val();
	
	var fecha_tercera_enfermedad_progresivaVar= $('#fecha_tercera_enfermedad_progresiva').val();
	var psa_tercera_enfermedad_progresivaVar = $('#psa_tercera_enfermedad_progresiva').val();
	var sintomatico_tercera_enfermedad_progresivaVar = $('#sintomatico_tercera_enfermedad_progresiva').val();
	var tercera_enfermedad_progresiva_oligometastasicoVar = $('#tercera_enfermedad_progresiva_oligometastasico').val();
	var organo_tercera_enfermedad_progresivaVar = $('#organo_tercera_enfermedad_progresiva').val();
	var tratamiento_tercera_enfermedad_progresivaVar = $('#tratamiento_tercera_enfermedad_progresiva').val();
	var tecnica_radioterapia_tercera_enfermedad_progresivaVar = $('#tecnica_radioterapia_tercera_enfermedad_progresiva').val();
	var dosis_tercera_enfermedad_progresivaVar = $('#dosis_tercera_enfermedad_progresiva').val();
	
	var fecha_cuarta_enfermedad_progresivaVar= $('#fecha_cuarta_enfermedad_progresiva').val();
	var psa_cuarta_enfermedad_progresivaVar = $('#psa_cuarta_enfermedad_progresiva').val();
	var sintomatico_cuarta_enfermedad_progresivaVar = $('#sintomatico_cuarta_enfermedad_progresiva').val();
	var cuarta_enfermedad_progresiva_oligometastasicoVar = $('#cuarta_enfermedad_progresiva_oligometastasico').val();
	var organo_cuarta_enfermedad_progresivaVar = $('#organo_cuarta_enfermedad_progresiva').val();
	var tratamiento_cuarta_enfermedad_progresivaVar = $('#tratamiento_cuarta_enfermedad_progresiva').val();
	var tecnica_radioterapia_cuarta_enfermedad_progresivaVar = $('#tecnica_radioterapia_cuarta_enfermedad_progresiva').val();
	var dosis_cuarta_enfermedad_progresivaVar = $('#dosis_cuarta_enfermedad_progresiva').val();
	
	$.post('Hc_cabeceraController',
					{

						opcion : opcionVar,
						operacion : operacionVar,
						
						hc_cabecera_id : hc_cabecera_idVar,
						paciente_id : paciente_idVar,
						
						eco_paciente : eco_pacienteVar,
						fecha_ultimo_control : fecha_ultimo_controlVar,
						antecedente_raza : antecedente_razaVar,
						raza_id : raza_idVar,
						antecedente_familiar : antecedente_familiarVar,
						descripcion_familiar : descripcion_familiarVar,
						antecedente_genes : antecedente_genesVar,
						antecedente_alimentacion : antecedente_alimentacionVar,
						antecedente_obesidad : antecedente_obesidadVar,
						imc : imcVar,
						antecedente_exposicion_trabajo : antecedente_exposicion_trabajoVar,						
						antecedente_exposicion_trabajo_detalle : antecedente_exposicion_trabajo_detalleVar,
						antecedente_prostatitis : antecedente_prostatitisVar,
						antecedente_its : antecedente_itsVar,
						antecedente_sustancia : antecedente_sustancia_quimicaVar,
						sustancia_descripcion : sustancia_descripcionVar,
						antecedente_neoplasia : antecedente_neoplasiaVar,
						
						antecedente_neoplasia_cieo : antecedente_neoplasia_cieoVar,
						psa_debut : psa_debutVar,
						histologia_id : histologia_idVar,
						histologia_especificacion : histologia_especificacionVar,
						fecha_diagnostico_histologico : fecha_diagnostico_histologicoVar,
						gleason_mayor : gleason_mayorVar,
						gleason_menor : gleason_menorVar,
						gleason_total : gleason_totalVar,
						categoria_t : categoria_tVar,
						categoria_t_patologico : categoria_t_patologicoVar,
						categoria_n : categoria_nVar,
						categoria_m : categoria_mVar,
						categoria_g : categoria_gVar,
						
						tratamiento_inicial : tratamiento_inicialVar,
						tipo_diagnostico_id : tipo_diagnostico_idVar,
						grupo_riesgo_id : grupo_riesgo_idVar,
						
						fecha_falla_bioquimica : fecha_falla_bioquimicaVar,
						psa_falla_bioquimica : psa_falla_bioquimicaVar,
						tratamiento_falla_bioquimica : tratamiento_falla_bioquimicaVar,
						
						fecha_enfermedad_metastasica : fecha_enfermedad_metastasicaVar,
						psa_enfermedad_metastasica : psa_enfermedad_metastasicaVar,
						sintomatico_enfermedad_metastasica : sintomatico_enfermedad_metastasicaVar,
						enfermedad_metastasica_oligometastasico : enfermedad_metastasica_oligometastasicoVar,
						organo_enfermedad_metastasica : organo_enfermedad_metastasicaVar,
						tratamiento_enfermedad_metastasica : tratamiento_enfermedad_metastasicaVar,
						tecnica_radioterapia_enfermedad_metastasica : tecnica_radioterapia_enfermedad_metastasicaVar,
						dosis_radioterapia_enfermedad_metastasica : dosis_radioterapia_enfermedad_metastasicaVar,
						
						fecha_segunda_enfermedad_progresiva : fecha_segunda_enfermedad_progresivaVar,
						psa_segunda_enfermedad_progresiva : psa_segunda_enfermedad_progresivaVar,
						sintomatico_segunda_enfermedad_progresiva : sintomatico_segunda_enfermedad_progresivaVar,
						segunda_enfermedad_progresiva_oligometastasico : segunda_enfermedad_progresiva_oligometastasicoVar,
						organo_segunda_enfermedad_progresiva : organo_segunda_enfermedad_progresivaVar,
						tratamiento_segunda_enfermedad_progresiva : tratamiento_segunda_enfermedad_progresivaVar,
						tecnica_radioterapia_segunda_enfermedad_progresiva : tecnica_radioterapia_segunda_enfermedad_progresivaVar,
						dosis_radioterapia_segunda_enfermedad_progresiva : dosis_segunda_enfermedad_progresivaVar,
						
						fecha_tercera_enfermedad_progresiva : fecha_tercera_enfermedad_progresivaVar,
						psa_tercera_enfermedad_progresiva : psa_tercera_enfermedad_progresivaVar,
						sintomatico_tercera_enfermedad_progresiva : sintomatico_tercera_enfermedad_progresivaVar,
						tercera_enfermedad_progresiva_oligometastasico : tercera_enfermedad_progresiva_oligometastasicoVar,
						organo_tercera_enfermedad_progresiva : organo_tercera_enfermedad_progresivaVar,
						tratamiento_tercera_enfermedad_progresiva : tratamiento_tercera_enfermedad_progresivaVar,
						tecnica_radioterapia_tercera_enfermedad_progresiva : tecnica_radioterapia_tercera_enfermedad_progresivaVar,
						dosis_radioterapia_tercera_enfermedad_progresiva : dosis_tercera_enfermedad_progresivaVar,
						
						fecha_cuarta_enfermedad_progresiva : fecha_cuarta_enfermedad_progresivaVar,
						psa_cuarta_enfermedad_progresiva : psa_cuarta_enfermedad_progresivaVar,
						sintomatico_cuarta_enfermedad_progresiva : sintomatico_cuarta_enfermedad_progresivaVar,
						cuarta_enfermedad_progresiva_oligometastasico : cuarta_enfermedad_progresiva_oligometastasicoVar,
						organo_cuarta_enfermedad_progresiva : organo_cuarta_enfermedad_progresivaVar,
						tratamiento_cuarta_enfermedad_progresiva : tratamiento_cuarta_enfermedad_progresivaVar,
						tecnica_radioterapia_cuarta_enfermedad_progresiva : tecnica_radioterapia_cuarta_enfermedad_progresivaVar,
						dosis_radioterapia_cuarta_enfermedad_progresiva : dosis_cuarta_enfermedad_progresivaVar
						
					},
					
					function(response) {

						if (response == 1) {
																					
							 lista_pacientes_hc();							

							$('#panel_mensaje_hc').html('<div class="alert alert-success" align="center" role="alert">Variables registradas con éxito</div>');
							$('#btn_guardar_hc').hide();
							
						} else if (response == 0) {
							$('#panel_mensaje_hc').html('<div class="alert alert-danger" align="center" role="alert">¡Error!</div>');

						} 

					});
		
}

function lista_pacientes_hc(){
	
	var opcionVar = "listar_hc";
		
	$.get('Hc_cabeceraController', {
		
		opcion : opcionVar	
				
	},function(response){
			
			$('#listado_pacientes_hc').empty();
			
			var body = "";
			
			$.each(response, function(index, paciente_hc){
				
				body += `
						<tr>					  
							<td class="text-center">${index+1}</td>
							<td>${paciente_hc.numero_documento}</td>
							<td>${paciente_hc.nombres}</td>
							<td>${paciente_hc.apellido_paterno}</td>
							<td>${paciente_hc.apellido_materno}</td>
							<td>${paciente_hc.fecha_ultimo_control}</td>																	
							<td class="text-center">
								<button type="button" id="btn_ver_hc_paciente_${index+1}" class="btn btn-primary"  onclick="ver_datos_hc_paciente(${paciente_hc.hc_cabecera_id})"><i class="glyphicon glyphicon-eye-open"></i></button> 
								<button type="button" id="btn_editar_hc_paciente_${index+1}" class="btn btn-default" onclick="editar_datos_hc_paciente(${paciente_hc.hc_cabecera_id})"><i class="glyphicon glyphicon-edit"></i></button>
								<button type="button" id="btn_elimina_hc_paciente_${index+1}" class="btn btn-danger" data-toggle="modal" data-target="#modal_confirma_eliminar_hc_paciente" onclick="carga_hc_paciente_eliminar(${paciente_hc.hc_cabecera_id},${paciente_hc.numero_documento})"><i class="glyphicon glyphicon-remove"></i></button>
							</td>
					    </tr>						
				`;
														
			});
			
			$('#listado_pacientes_hc').html(body);
			$('#lista_pacientes_hc').dataTable();
									
	});
	
}

function cargar_datos_hc_paciente(hc_cabecera_id) {

	var opcionVar = "buscar";
	var hc_cabecera_idVar = hc_cabecera_id;

	$.get('Hc_cabeceraController', {

		opcion : opcionVar,
		hc_cabecera_id : hc_cabecera_idVar

	}, function(response) {
		
		$('#hc_cabecera_id').val(response.hc_cabecera_id);
		$('#paciente_id').val(response.paciente_id);
		$('#eco_paciente').val(response.eco_paciente);
		$('#fecha_ultimo_control').val(response.fecha_ultimo_control);
						
		carga_paciente_hc(response.paciente_id);
			
		if(response.antecedente_raza == 1){
			
			$('#antecedente_raza').prop('checked',true);
			$('#label_antecedente_raza').addClass('checked');
			$('#panel_antecedente_raza').removeClass('hide');
		
		}else if(response.antecedente_raza == 0){
			
			$('#antecedente_raza').prop('checked',false);
			$('#label_antecedente_raza').removeClass('checked');
			$('#panel_antecedente_raza').addClass('hide');
					
		}
		
		$('#raza_id').val(response.raza_id);
		
		if(response.antecedente_familiar == 1){
			
			$('#antecedente_familiar').prop('checked',true);
			$('#label_antecedente_familiar').addClass('checked');
			$('#panel_antecedente_familiar').removeClass('hide');
		
		}else if(response.antecedente_familiar == 0){
			
			$('#antecedente_familiar').prop('checked',false);
			$('#label_antecedente_familiar').removeClass('checked');
			$('#panel_antecedente_familiar').addClass('hide');
					
		}	
		
		$('#descripcion_familiar').val(response.descripcion_familiar);
		
		if(response.antecedente_genes == 1){
			
			$('#antecedente_genes').prop('checked',true);
			$('#label_antecedente_genes').addClass('checked');
					
		}else if(response.antecedente_genes == 0){
			
			$('#antecedente_genes').prop('checked',false);
			$('#label_antecedente_genes').removeClass('checked');
								
		}
		
		if(response.antecedente_alimentacion == 1){
			
			$('#antecedente_alimentacion').prop('checked',true);
			$('#label_antecedente_alimentacion').addClass('checked');
					
		}else if(response.antecedente_alimentacion == 0){
			
			$('#antecedente_alimentacion').prop('checked',false);
			$('#label_antecedente_alimentacion').removeClass('checked');
								
		}
		
		if(response.antecedente_obesidad == 1){
			
			$('#antecedente_obesidad').prop('checked',true);
			$('#label_antecedente_obesidad').addClass('checked');
			$('#panel_antecedente_obesidad').removeClass('hide');
		
		}else if(response.antecedente_obesidad == 0){
			
			$('#antecedente_obesidad').prop('checked',false);
			$('#label_antecedente_obesidad').removeClass('checked');
			$('#panel_antecedente_obesidad').addClass('hide');
					
		}		
		
		$('#imc').val(response.imc);
		
		if(response.antecedente_exposicion_trabajo == 1){
			
			$('#antecedente_exposicion_trabajo').prop('checked',true);
			$('#label_antecedente_exposicion_trabajo').addClass('checked');
			$('#panel_antecedente_exposicion_trabajo').removeClass('hide');
		
		}else if(response.antecedente_exposicion_trabajo == 0){
			
			$('#antecedente_exposicion_trabajo').prop('checked',false);
			$('#label_antecedente_exposicion_trabajo').removeClass('checked');
			$('#panel_antecedente_exposicion_trabajo').addClass('hide');
					
		}		
		
		$('#antecedente_exposicion_trabajo_detalle').val(response.antecedente_exposicion_trabajo_detalle);
		
		
		if(response.antecedente_prostatitis == 1){
			
			$('#antecedente_prostatitis').prop('checked',true);
			$('#label_antecedente_prostatitis').addClass('checked');
					
		}else if(response.antecedente_prostatitis == 0){
			
			$('#antecedente_prostatitis').prop('checked',false);
			$('#label_antecedente_prostatitis').removeClass('checked');
								
		}
		
		if(response.antecedente_its == 1){
			
			$('#antecedente_its').prop('checked',true);
			$('#label_antecedente_its').addClass('checked');
					
		}else if(response.antecedente_its == 0){
			
			$('#antecedente_its').prop('checked',false);
			$('#label_antecedente_its').removeClass('checked');
								
		}
		
		if(response.antecedente_sustancia == 1){
			
			$('#antecedente_sustancia').prop('checked',true);
			$('#label_antecedente_sustancia').addClass('checked');
			$('#panel_antecedente_sustancia').removeClass('hide');
		
		}else if(response.antecedente_sustancia == 0){
			
			$('#antecedente_sustancia').prop('checked',false);
			$('#label_antecedente_sustancia').removeClass('checked');
			$('#panel_antecedente_sustancia').addClass('hide');
					
		}
		
		$('#sustancia_descripcion').val(response.sustancia_descripcion);
		
		if(response.antecedente_neoplasia == 1){
			
			$('#antecedente_neoplasia').prop('checked',true);
			$('#label_antecedente_neoplasia').addClass('checked');
			$('#panel_antecedente_neoplasia').removeClass('hide');
		
		}else if(response.antecedente_neoplasia == 0){
			
			$('#antecedente_neoplasia').prop('checked',false);
			$('#label_antecedente_neoplasia').removeClass('checked');
			$('#panel_antecedente_neoplasia').addClass('hide');
					
		}		
				
		$('#antecedente_neoplasia_cieo').val(response.antecedente_neoplasia_cieo);
		
		$('#psa_debut').val(response.psa_debut);
		$('#histologia_id').val(response.histologia_id);
		$('#histologia_especificacion').val(response.histologia_especificacion);
		$('#fecha_diagnostico_histologico').val(response.fecha_diagnostico_histologico);
		$('#gleason_mayor').val(response.gleason_mayor);
		$('#gleason_menor').val(response.gleason_menor);
		$('#gleason_total').val(response.gleason_total);
		$('#categoria_t').val(response.categoria_t);
		$('#categoria_t_patologico').val(response.categoria_t_patologico);
		$('#categoria_n').val(response.categoria_n);
		$('#categoria_m').val(response.categoria_m);
		$('#categoria_g').val(response.categoria_g);
		
		$('#tratamiento_inicial').val(response.tratamiento_inicial);
		
		$('#tipo_diagnostico_id').val(response.tipo_diagnostico_id);
			
		$('#grupo_riesgo_id').val(response.grupo_riesgo_id);
		
		$('#fecha_falla_bioquimica').val(response.fecha_falla_bioquimica);
		$('#psa_falla_bioquimica').val(response.psa_falla_bioquimica);
		$('#tratamiento_falla_bioquimica').val(response.tratamiento_falla_bioquimica);
		
		$('#fecha_enfermedad_metastasica').val(response.fecha_enfermedad_metastasica);
		$('#psa_enfermedad_metastasica').val(response.psa_enfermedad_metastasica);
		$('#sintomatico_enfermedad_metastasica').val(response.sintomatico_enfermedad_metastasica);
		$('#enfermedad_metastasica_oligometastasico').val(response.enfermedad_metastasica_oligometastasico);		
		$('#organo_enfermedad_metastasica').val(response.organo_enfermedad_metastasica);
		$('#tratamiento_enfermedad_metastasica').val(response.tratamiento_enfermedad_metastasica);
		$('#tecnica_radioterapia_enfermedad_metastasica').val(response.tecnica_radioterapia_enfermedad_metastasica);
		$('#dosis_radioterapia_enfermedad_metastasica').val(response.dosis_radioterapia_enfermedad_metastasica);
		
		$('#fecha_segunda_enfermedad_progresiva').val(response.fecha_segunda_enfermedad_progresiva);
		$('#psa_segunda_enfermedad_progresiva').val(response.psa_segunda_enfermedad_progresiva);
		$('#sintomatico_segunda_enfermedad_progresiva').val(response.sintomatico_segunda_enfermedad_progresiva);
		$('#segunda_enfermedad_progresiva_oligometastasico').val(response.segunda_enfermedad_progresiva_oligometastasico);
		$('#organo_segunda_enfermedad_progresiva').val(response.organo_segunda_enfermedad_progresiva);
		$('#tratamiento_segunda_enfermedad_progresiva').val(response.tratamiento_segunda_enfermedad_progresiva);
		$('#tecnica_radioterapia_segunda_enfermedad_progresiva').val(response.tecnica_radioterapia_segunda_enfermedad_progresiva);
		$('#dosis_segunda_enfermedad_progresiva').val(response.dosis_radioterapia_segunda_enfermedad_progresiva);
		
		$('#fecha_tercera_enfermedad_progresiva').val(response.fecha_tercera_enfermedad_progresiva);
		$('#psa_tercera_enfermedad_progresiva').val(response.psa_tercera_enfermedad_progresiva);
		$('#sintomatico_tercera_enfermedad_progresiva').val(response.sintomatico_tercera_enfermedad_progresiva);
		$('#tercera_enfermedad_progresiva_oligometastasico').val(response.tercera_enfermedad_progresiva_oligometastasico);
		$('#organo_tercera_enfermedad_progresiva').val(response.organo_tercera_enfermedad_progresiva);
		$('#tratamiento_tercera_enfermedad_progresiva').val(response.tratamiento_tercera_enfermedad_progresiva);
		$('#tecnica_radioterapia_tercera_enfermedad_progresiva').val(response.tecnica_radioterapia_tercera_enfermedad_progresiva);
		$('#dosis_tercera_enfermedad_progresiva').val(response.dosis_radioterapia_tercera_enfermedad_progresiva);
		
		$('#fecha_cuarta_enfermedad_progresiva').val(response.fecha_cuarta_enfermedad_progresiva);
		$('#psa_cuarta_enfermedad_progresiva').val(response.psa_cuarta_enfermedad_progresiva);
		$('#sintomatico_cuarta_enfermedad_progresiva').val(response.sintomatico_cuarta_enfermedad_progresiva);
		$('#cuarta_enfermedad_progresiva_oligometastasico').val(response.cuarta_enfermedad_progresiva_oligometastasico);
		$('#organo_cuarta_enfermedad_progresiva').val(response.organo_cuarta_enfermedad_progresiva);
		$('#tratamiento_cuarta_enfermedad_progresiva').val(response.tratamiento_cuarta_enfermedad_progresiva);
		$('#tecnica_radioterapia_cuarta_enfermedad_progresiva').val(response.tecnica_radioterapia_cuarta_enfermedad_progresiva);
		$('#dosis_cuarta_enfermedad_progresiva').val(response.dosis_radioterapia_cuarta_enfermedad_progresiva);
	
	
		
	});

}

function ver_datos_hc_paciente(hc_cabecera_id){
	
	limpiar();
	
	cargar_datos_hc_paciente(hc_cabecera_id);
	
	inhabilita_campos_hc_paciente();
	
	$('#btn_guardar_hc_paciente').attr('disabled',true);
	
}

function editar_datos_hc_paciente(hc_cabecera_id){
	
	limpiar();
	
	cargar_datos_hc_paciente(hc_cabecera_id);
	
	habilita_campos_hc_paciente();
	
	$('#btn_guardar_hc_paciente').attr('disabled',false);
	
}

function carga_grupo_tumor(tipo_diagnostico_id){
	
	var opcionVar = "listar_grupo_riesgo";
	
	$.get('Grupo_riesgoController', {

		opcion : opcionVar,
		tipo_diagnostico_id : tipo_diagnostico_id

	}, function(response) {

		$('#grupo_riesgo_id').empty();

		$.each(response, function(index, grupo_riesgo) {
			$('#grupo_riesgo_id').append(
					'<option value ="' + grupo_riesgo.grupo_riesgo_id
							+ '">' + grupo_riesgo.grupo_riesgo
							+ '</option>');

		});

	});
	
}


$('#tipo_diagnostico_id').on('change',function() {

	var tipo_diagnostico_id = $('#tipo_diagnostico_id').val();
	
	carga_grupo_tumor(tipo_diagnostico_id);
			
});

function carga_paciente(paciente_id) {

	var opcionVar = "buscar_paciente_diag";
	var paciente_idVar = paciente_id;

	$.post('PacienteController', {

		opcion : opcionVar,
		paciente_id : paciente_idVar

	}, function(response) {
		
		if(response == 0){
			
			limpiar();
			$('#panel_mensaje_hc').html('<div class="alert alert-info" align="center" role="alert">Paciente ya tiene registro de variables</div>');
			
		}else{
			
			limpiar();
			
			$('#paciente_id').val(response.paciente_id);
			
			$('#numero_documento').val(response.numero_documento);
			$('#nombres').val(response.nombres);
			$('#apellido_paterno').val(response.apellido_paterno);
			$('#apellido_materno').val(response.apellido_materno);
			$('#fecha_nacimiento').val(response.fecha_nacimiento);
			$('#codigo_cieo').val(response.codigo_cieo);
			$('#descripcion').val(response.descripcion);
			
		}
		
	});

}

function carga_paciente_hc(paciente_id) {

	var opcionVar = "buscar_paciente_con_hc";
	var paciente_idVar = paciente_id;

	$.post('PacienteController', {

		opcion : opcionVar,
		paciente_id : paciente_idVar

	}, function(response) {
			
			$('#paciente_id').val(response.paciente_id);
			
			$('#numero_documento').val(response.numero_documento);
			$('#nombres').val(response.nombres);
			$('#apellido_paterno').val(response.apellido_paterno);
			$('#apellido_materno').val(response.apellido_materno);
			$('#fecha_nacimiento').val(response.fecha_nacimiento);
			$('#codigo_cieo').val(response.codigo_cieo);
			$('#descripcion').val(response.descripcion);
			
	});

}


function carga_cieo(event, codigo_cieoVar) {
	event.preventDefault();

	$.post('DiagnosticoController', {
		opcion : "buscacieo",
		codigo_cieo : codigo_cieoVar
	},

	function(response) {

		$('#antecedente_neoplasia_cieo').val(response.codigo_cieo);

	});
}

function calcula_gleason() {

	$('#gleason_total').val('');

	var gleason_mayor = $('#gleason_mayor').val();
	var gleason_menor = $('#gleason_menor').val();
	var resultado = (gleason_mayor * 1) + (gleason_menor * 1);

	$('#gleason_total').val(resultado);

}

function calcula_imc() {

	var peso = $('#peso').val();
	var estatura = $('#estatura').val();
	var imc = 0.0;

	imc = peso / Math.pow(estatura, 2);

	$('#imc').val(imc.toFixed(2));

}

function carga_tipo_tumor() {

	var opcionVar = "filtratipotumor";
	var id_grupo_tumorVar = $('#id_grupo_tumor').val();

	$.post('Tipo_tumorController', {

		opcion : opcionVar,
		id_grupo_tumor : id_grupo_tumorVar

	}, function(response) {

		$('#id_tipo_tumor').empty();

		$.each(response, function(index, tipo_tumor) {
			$('#id_tipo_tumor').append('<option value ="' + tipo_tumor.id_tipo_tumor + '">'	+ tipo_tumor.tipo_tumor + '</option>');

		});

	});

}

function limpiar(){
	
	$('#formulario_hc').trigger('reset');
	
	$('#hc_cabecera_id').val('');
	$('#paciente_id').val('');
	
	$('#panel_mensaje_hc').html('');
	$('#btn_guardar_hc').show();
	
	$('#antecedente_raza').prop('checked',false);
	$('#label_antecedente_raza').removeClass('checked');
	$('#panel_antecedente_raza').addClass('hide');
	
	$('#antecedente_familiar').prop('checked',false);
	$('#label_antecedente_familiar').removeClass('checked');
	$('#panel_antecedente_familiar').addClass('hide');
	
	$('#antecedente_genes').prop('checked',false);
	$('#label_antecedente_genes').removeClass('checked');
	
	$('#antecedente_alimentacion').prop('checked',false);
	$('#label_antecedente_alimentacion').removeClass('checked');
	
	$('#antecedente_obesidad').prop('checked',false);
	$('#label_antecedente_obesidad').removeClass('checked');
	$('#panel_antecedente_obesidad').addClass('hide');
	
	$('#antecedente_exposicion_trabajo').prop('checked',false);
	$('#label_antecedente_exposicion_trabajo').removeClass('checked');
	$('#panel_antecedente_exposicion_trabajo').addClass('hide');
	
	$('#antecedente_prostatitis').prop('checked',false);
	$('#label_antecedente_prostatitis').removeClass('checked');
	
	$('#antecedente_sustancia').prop('checked',false);
	$('#label_antecedente_sustancia').removeClass('checked');
	$('#panel_antecedente_sustancia').addClass('hide');
	
	$('#antecedente_its').prop('checked',false);
	$('#label_antecedente_its').removeClass('checked');
	
	$('#antecedente_neoplasia').prop('checked',false);
	$('#label_antecedente_neoplasia').removeClass('checked');
	$('#panel_antecedente_neoplasia').addClass('hide');
	
}

function inhabilita_campos_hc_paciente(){
	
	$('#eco_paciente').attr('disabled',true);
	$('#fecha_ultimo_control').attr('disabled',true);
				
	$('#antecedente_raza').attr('disabled',true);
	$('#raza_id').attr('disabled',true);
	$('#antecedente_familiar').attr('disabled',true);
	$('#descripcion_familiar').attr('disabled',true);		
	$('#antecedente_genes').attr('disabled',true);	
	$('#antecedente_alimentacion').attr('disabled',true);	
	$('#antecedente_obesidad').attr('disabled',true);
	$('#imc').attr('disabled',true);
	$('#antecedente_exposicion_trabajo').attr('disabled',true);
	$('#antecedente_exposicion_trabajo_detalle').attr('disabled',true);
	$('#antecedente_prostatitis').attr('disabled',true);
	$('#antecedente_its').attr('disabled',true);
	$('#antecedente_sustancia').attr('disabled',true);
	$('#sustancia_descripcion').attr('disabled',true);
	$('#antecedente_neoplasia').attr('disabled',true);
	$('#antecedente_neoplasia_cieo').attr('disabled',true);	
	$('#psa_debut').attr('disabled',true);
	$('#histologia_id').attr('disabled',true);
	$('#histologia_especificacion').attr('disabled',true);
	$('#fecha_diagnostico_histologico').attr('disabled',true);
	$('#gleason_mayor').attr('disabled',true);
	$('#gleason_menor').attr('disabled',true);
	$('#gleason_total').attr('disabled',true);
	$('#categoria_t').attr('disabled',true);
	$('#categoria_t_patologico').attr('disabled',true);
	$('#categoria_n').attr('disabled',true);
	$('#categoria_m').attr('disabled',true);
	$('#categoria_g').attr('disabled',true);	
	$('#tratamiento_inicial').attr('disabled',true);	
	$('#tipo_diagnostico_id').attr('disabled',true);		
	$('#grupo_riesgo_id').attr('disabled',true);	
	$('#fecha_falla_bioquimica').attr('disabled',true);
	$('#psa_falla_bioquimica').attr('disabled',true);
	$('#tratamiento_falla_bioquimica').attr('disabled',true);
	
	$('#fecha_enfermedad_metastasica').attr('disabled',true);
	$('#psa_enfermedad_metastasica').attr('disabled',true);
	$('#sintomatico_enfermedad_metastasica').attr('disabled',true);
	$('#enfermedad_metastasica_oligometastasico').attr('disabled',true);		
	$('#organo_enfermedad_metastasica').attr('disabled',true);
	$('#tratamiento_enfermedad_metastasica').attr('disabled',true);
	$('#tecnica_radioterapia_enfermedad_metastasica').attr('disabled',true);
	$('#dosis_radioterapia_enfermedad_metastasica').attr('disabled',true);
	
	$('#fecha_segunda_enfermedad_progresiva').attr('disabled',true);
	$('#psa_segunda_enfermedad_progresiva').attr('disabled',true);
	$('#sintomatico_segunda_enfermedad_progresiva').attr('disabled',true);
	$('#segunda_enfermedad_progresiva_oligometastasico').attr('disabled',true);
	$('#organo_segunda_enfermedad_progresiva').attr('disabled',true);
	$('#tratamiento_segunda_enfermedad_progresiva').attr('disabled',true);
	$('#tecnica_radioterapia_segunda_enfermedad_progresiva').attr('disabled',true);
	$('#dosis_segunda_enfermedad_progresiva').attr('disabled',true);
	
	$('#fecha_tercera_enfermedad_progresiva').attr('disabled',true);
	$('#psa_tercera_enfermedad_progresiva').attr('disabled',true);
	$('#sintomatico_tercera_enfermedad_progresiva').attr('disabled',true);
	$('#tercera_enfermedad_progresiva_oligometastasico').attr('disabled',true);
	$('#organo_tercera_enfermedad_progresiva').attr('disabled',true);
	$('#tratamiento_tercera_enfermedad_progresiva').attr('disabled',true);
	$('#tecnica_radioterapia_tercera_enfermedad_progresiva').attr('disabled',true);
	$('#dosis_tercera_enfermedad_progresiva').attr('disabled',true);
	
	$('#fecha_cuarta_enfermedad_progresiva').attr('disabled',true);
	$('#psa_cuarta_enfermedad_progresiva').attr('disabled',true);
	$('#sintomatico_cuarta_enfermedad_progresiva').attr('disabled',true);
	$('#cuarta_enfermedad_progresiva_oligometastasico').attr('disabled',true);
	$('#organo_cuarta_enfermedad_progresiva').attr('disabled',true);
	$('#tratamiento_cuarta_enfermedad_progresiva').attr('disabled',true);
	$('#tecnica_radioterapia_cuarta_enfermedad_progresiva').attr('disabled',true);
	$('#dosis_cuarta_enfermedad_progresiva').attr('disabled',true);
	
	$('#buscar_cieo').hide();
		
}

function habilita_campos_hc_paciente(){
	
	$('#eco_paciente').attr('disabled',false);
	$('#fecha_ultimo_control').attr('disabled',false);
				
	$('#antecedente_raza').attr('disabled',false);
	$('#raza_id').attr('disabled',false);
	$('#antecedente_familiar').attr('disabled',false);
	$('#descripcion_familiar').attr('disabled',false);		
	$('#antecedente_genes').attr('disabled',false);	
	$('#antecedente_alimentacion').attr('disabled',false);	
	$('#antecedente_obesidad').attr('disabled',false);
	$('#imc').attr('disabled',false);
	$('#antecedente_exposicion_trabajo').attr('disabled',false);
	$('#antecedente_exposicion_trabajo_detalle').attr('disabled',false);
	$('#antecedente_prostatitis').attr('disabled',false);
	$('#antecedente_its').attr('disabled',false);
	$('#antecedente_sustancia').attr('disabled',false);
	$('#sustancia_descripcion').attr('disabled',false);
	$('#antecedente_neoplasia').attr('disabled',false);
	$('#antecedente_neoplasia_cieo').attr('disabled',false);	
	$('#psa_debut').attr('disabled',false);
	$('#histologia_id').attr('disabled',false);
	$('#histologia_especificacion').attr('disabled',false);
	$('#fecha_diagnostico_histologico').attr('disabled',false);
	$('#gleason_mayor').attr('disabled',false);
	$('#gleason_menor').attr('disabled',false);
	$('#gleason_total').attr('disabled',false);
	$('#categoria_t').attr('disabled',false);
	$('#categoria_t_patologico').attr('disabled',false);
	$('#categoria_n').attr('disabled',false);
	$('#categoria_m').attr('disabled',false);
	$('#categoria_g').attr('disabled',false);	
	$('#tratamiento_inicial').attr('disabled',false);	
	$('#tipo_diagnostico_id').attr('disabled',false);		
	$('#grupo_riesgo_id').attr('disabled',false);	
	$('#fecha_falla_bioquimica').attr('disabled',false);
	$('#psa_falla_bioquimica').attr('disabled',false);
	$('#tratamiento_falla_bioquimica').attr('disabled',false);
	
	$('#fecha_enfermedad_metastasica').attr('disabled',false);
	$('#psa_enfermedad_metastasica').attr('disabled',false);
	$('#sintomatico_enfermedad_metastasica').attr('disabled',false);
	$('#enfermedad_metastasica_oligometastasico').attr('disabled',false);		
	$('#organo_enfermedad_metastasica').attr('disabled',false);
	$('#tratamiento_enfermedad_metastasica').attr('disabled',false);
	$('#tecnica_radioterapia_enfermedad_metastasica').attr('disabled',false);
	$('#dosis_radioterapia_enfermedad_metastasica').attr('disabled',false);
	
	$('#fecha_segunda_enfermedad_progresiva').attr('disabled',false);
	$('#psa_segunda_enfermedad_progresiva').attr('disabled',false);
	$('#sintomatico_segunda_enfermedad_progresiva').attr('disabled',false);
	$('#segunda_enfermedad_progresiva_oligometastasico').attr('disabled',false);
	$('#organo_segunda_enfermedad_progresiva').attr('disabled',false);
	$('#tratamiento_segunda_enfermedad_progresiva').attr('disabled',false);
	$('#tecnica_radioterapia_segunda_enfermedad_progresiva').attr('disabled',false);
	$('#dosis_segunda_enfermedad_progresiva').attr('disabled',false);
	
	$('#fecha_tercera_enfermedad_progresiva').attr('disabled',false);
	$('#psa_tercera_enfermedad_progresiva').attr('disabled',false);
	$('#sintomatico_tercera_enfermedad_progresiva').attr('disabled',false);
	$('#tercera_enfermedad_progresiva_oligometastasico').attr('disabled',false);
	$('#organo_tercera_enfermedad_progresiva').attr('disabled',false);
	$('#tratamiento_tercera_enfermedad_progresiva').attr('disabled',false);
	$('#tecnica_radioterapia_tercera_enfermedad_progresiva').attr('disabled',false);
	$('#dosis_tercera_enfermedad_progresiva').attr('disabled',false);
	
	$('#fecha_cuarta_enfermedad_progresiva').attr('disabled',false);
	$('#psa_cuarta_enfermedad_progresiva').attr('disabled',false);
	$('#sintomatico_cuarta_enfermedad_progresiva').attr('disabled',false);
	$('#cuarta_enfermedad_progresiva_oligometastasico').attr('disabled',false);
	$('#organo_cuarta_enfermedad_progresiva').attr('disabled',false);
	$('#tratamiento_cuarta_enfermedad_progresiva').attr('disabled',false);
	$('#tecnica_radioterapia_cuarta_enfermedad_progresiva').attr('disabled',false);
	$('#dosis_cuarta_enfermedad_progresiva').attr('disabled',false);
	
	$('#buscar_cieo').show();
		
}
