$(document).ready(function() {
	
	$('#lista_pacientes_').dataTable();
	$('#panel_datos_fallecido').hide();
	$('#btn_nuevo_fallecido').hide();
	$('#btn_guardar_fallecido').hide();
	
		
});

function carga_paciente_(paciente_id) {

	var opcionVar = "buscar_paciente_diag";
	var paciente_idVar = paciente_id;

	$.post('PacienteController', {

		opcion : opcionVar,
		paciente_id : paciente_idVar

	}, function(response) {
		
		if(response == 0){ 
			
			//limpiar();
			$('#panel_mensaje_fallecido').html('<div class="alert alert-warning" align="center" role="alert">Paciente aún no tiene registro de variables</div>');
			$('#btn_nuevo_hc').show();
			 
			$('#panel_datos_fallecido').hide();
				
			$('#btn_guardar_fallecido').hide();
			$('#btn_nuevo_fallecido').show();
			
		}else{
						
			$('#paciente_id').val(response.paciente_id);
			
			$('#numero_documento_').val(response.numero_documento);
			$('#nombres_').val(response.nombres);
			$('#apellido_paterno_').val(response.apellido_paterno);
			$('#apellido_materno_').val(response.apellido_materno);			
			$('#codigo_cieo_').val(response.codigo_cieo);
			$('#descripcion_').val(response.descripcion);
			
			$('#panel_datos_fallecido').show();
			
			$('#btn_guardar_fallecido').show();
			$('#btn_nuevo_fallecido').show();
			
		}
		
	});

}