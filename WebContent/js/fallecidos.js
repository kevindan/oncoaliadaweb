$('#btn_nuevo_fallecido').click(function(event){
	
	limpiar_formulario();
	
});

$('#btn_guardar_fallecido').on('click', function (e) {
	grabar_fallecido();
});

function grabar_fallecido() {
	var paciente_id = $("#paciente_id").val();
	var fecha_fallecimiento = $("#fecha_fallecimiento").val();
	var fallecido_neoplasia = $("#fallecido_neoplasia").val();
	var otras_causas = $("#otras_causas").val();
	var usuarioVar = $('#usuario_session').val();
	
	$.post('PacienteController', {
		opcion : 'registrar_fallecido',
		paciente_id : paciente_id,
		fecha_fallecimiento : fecha_fallecimiento,
		fallecido_neoplasia : fallecido_neoplasia,
		otras_causas : otras_causas,
		usuario : usuarioVar
	}, function(response) {

		if (response == 1) {
			 limpiar_formulario();
			 $('#btn_guardar_fallecido').hide();							 
			 $('#panel_mensaje_fallecido').html('<div class="alert alert-success" align="center" role="alert">Fallecimiento registrado con éxito</div>');
			 $('#btn_nuevo_fallecido').show();
			 
			 listar_fallecidos();			 
		} else if (response == 0) {
			 $('#panel_mensaje_fallecido').html('<div class="alert alert-danger" align="center" role="alert">¡Error!</div>');

		} 

	});
}

function carga_paciente_(paciente_id) {
	var opcionVar = "buscar_paciente_con_hc";
	var paciente_idVar = paciente_id;

	$.post('PacienteController', {

		opcion : opcionVar,
		paciente_id : paciente_idVar

	}, function(response) {
		
		if(response == 0){ 
			
			//limpiar();
			$('#panel_mensaje_fallecido').html('<div class="alert alert-warning" align="center" role="alert">Paciente aún no tiene registro de variables</div>');
			$('#btn_nuevo_fallecido').show();
			 
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

function limpiar_formulario(){
	
	$('#formulario_fallecido').trigger('reset');
	
	$('#paciente_id').val('');
	
	$('#panel_mensaje_fallecido ').html('');
	$('#btn_guardar_fallecido').show();
	
	$('#panel_datos_fallecido').hide();
	
	$('#btn_guardar_fallecido').hide();
	$('#btn_nuevo_fallecido').hide();
	
}

function listar_fallecidos() {
	$.ajax({
		url : 'PacienteController',
		method : 'GET',
		data : {
			opcion : 'listar_fallecidos'
		}
	}).success(function (response) {
		$("#listado_pacientes_fallecidos").empty();
		
		var body = "";
		
		response.forEach(function(value, index) {
			body += `<tr>
				<td>${index + 1}</td>
				<td class="text-center">${value.numero_documento}</td>
				<td>${value.nombres}</td>
				<td>${value.apellido_paterno}</td>
				<td>${value.apellido_materno}</td>
				<td class="text-center">${value.fecha_fallecimiento}</td>
				<td class="text-center">
					<button type="button" id="btn_ver_fallecido_paciente_${index+1}" class="btn btn-primary"  onclick="ver_datos_fallecido_paciente(${value.paciente_id})"><i class="glyphicon glyphicon-eye-open"></i></button>								
				</td>
			</tr>`;
		});
		
		$("#listado_pacientes_fallecidos").html(body);
		$('#lista_pacientes_fallecidos').dataTable();
	}).error(function (error) {
		console.log(error);
	});
}

function ver_datos_fallecido_paciente(paciente_id){
	
	limpiar_formulario();
	
	cargar_datos_fallecido_paciente(paciente_id);
	
	inhabilita_campos_fallecido_paciente();
	
	$('#btn_guardar_fallecido').attr('disabled',true);
	
}

function cargar_datos_fallecido_paciente(paciente_id) {
	$.ajax({
		url : 'PacienteController',
		method : 'GET',
		data : {
			opcion : 'buscar_fallecido',
			paciente_id : paciente_id
		}
	}).success(function(response) {
		$('#numero_documento_').val(response.numero_documento);
		$('#nombres_').val(response.nombres);
		$('#apellido_paterno_').val(response.apellido_paterno);
		$('#apellido_materno_').val(response.apellido_materno);			
		$('#codigo_cieo_').val(response.codigo_cieo);
		$('#descripcion_').val(response.descripcion);
		
		$('#panel_datos_fallecido').show();
		
		$("#fecha_fallecimiento").val(response.fecha_fallecimiento);
		$("#fallecido_neoplasia").val(response.fallecido_neoplasia);
		$("#otras_causas").val(response.otras_causas);
		
		$('#btn_nuevo_fallecido').show();
	}).error(function(error) {
		console.log(error);
	});
}

function inhabilita_campos_fallecido_paciente() {
	$('#numero_documento_').prop('disabled', true);
	$('#nombres_').prop('disabled', true);
	$('#apellido_paterno_').prop('disabled', true);
	$('#apellido_materno_').prop('disabled', true);			
	$('#codigo_cieo_').prop('disabled', true);
	$('#descripcion_').prop('disabled', true);
	$("#fecha_fallecimiento").prop('disabled', true);
	$("#fallecido_neoplasia").prop('disabled', true);
	$("#otras_causas").prop('disabled', true);
}

$(document).ready(function() {
	
	$('#lista_pacientes_').dataTable();
	$('#panel_datos_fallecido').hide();
	$('#btn_nuevo_fallecido').hide();
	$('#btn_guardar_fallecido').hide();
	
	$('#fecha_fallecimiento').datepicker();
	
	listar_fallecidos();
});
