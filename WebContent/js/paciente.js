function guardar_paciente(){

	var opcionVar = "guardar";
		var operacionVar = "";
		
		var paciente_idVar = $('#paciente_id').val();
		
		if(paciente_idVar == ''){
			
			operacionVar = "registrar";
			
		}else{
			
			operacionVar = "actualizar";
			
		}
		 			
	var tipo_documento_idVar = $('#tipo_documento_id').val();					
	var numero_documentoVar = $('#numero_documento').val();
	var nombresVar = $('#nombres').val();
	var apellido_paternoVar = $('#apellido_paterno').val();
	var apellido_maternoVar = $('#apellido_materno').val();
	var sexoVar = $('#sexo').val();
	var fecha_nacimientoVar = $('#fecha_nacimiento').val();					
	var direccionVar = $('#direccion').val();
	var telefonoVar = $('#telefono').val();
	var tipo_pacienteVar = $('#tipo_paciente').val();
	var base_diagnostico_idVar = $('#base_diagnostico_id').val();
	var codigo_cieoVar = $('#codigo_cieo').val();
	var codigo_ubigeoVar = $('#departamento_lista').val()+$('#provincia_lista').val()+$('#distrito_lista').val();
	var fecha_diagnosticoVar = $('#fecha_diagnostico').val();
	var observacionVar = $('#observacion').val();
	
	if(numero_documentoVar == ''){
		
		$('div .form-group').removeClass('has-error');
		$('#div_numero_documento').addClass('has-error');
		$('#panel_mensaje').html('<div class="alert alert-warning" align="center" role="alert">Ingrese un número de documento</div>');
		
	}else if(nombresVar == ''){
		
		$('div .form-group').removeClass('has-error');
		$('#div_nombres').addClass('has-error');
		$('#panel_mensaje').html('<div class="alert alert-warning" align="center" role="alert">Ingrese el nombre del paciente</h5>');
	
	}
	else if(apellido_paternoVar == ''){
		
		$('div .form-group').removeClass('has-error');
		$('#div_apellido_paterno').addClass('has-error');
		$('#panel_mensaje').html('<div class="alert alert-warning" align="center" role="alert">Escriba el apellido paterno del paciente</h5>');
	}
	else if(apellido_maternoVar == ''){
		
		$('div .form-group').removeClass('has-error');
		$('#div_apellido_materno').addClass('has-error');
		$('#panel_mensaje').html('<div class="alert alert-warning" align="center" role="alert">Escriba el apellido materno del paciente</h5>');
	
	}else if(fecha_nacimientoVar == ''){
		
		$('div .form-group').removeClass('has-error');
		$('#div_fecha_nacimiento').addClass('has-error');			
		$('#panel_mensaje').html('<div class="alert alert-warning" align="center" role="alert">Ingrese la fecha de nacimiento del paciente</h5>');
		
	}else if(codigo_cieoVar == ''){
		
		$('div .form-group').removeClass('has-error');
		$('#div_codigo_cieo').addClass('has-error');
		$('#div_descripcion').addClass('has-error');
		$('#panel_mensaje').html('<div class="alert alert-warning" align="center" role="alert">Seleccione el diagnóstico del paciente</h5>');
		
	}else if (fecha_diagnosticoVar == ''){
		
		$('div .form-group').removeClass('has-error');
		$('#div_fecha_diagnostico').addClass('has-error');
		$('#panel_mensaje').html('<div class="alert alert-warning" align="center" role="alert">Ingrese una fecha de diagnóstico</h5>');
		
	}else{
			
	$.post('PacienteController', {

	opcion : opcionVar,
	operacion: operacionVar,
	
	paciente_id: paciente_idVar,
	tipo_documento_id	: tipo_documento_idVar,			
	numero_documento : numero_documentoVar ,
	nombres	: nombresVar,
	apellido_paterno	: apellido_paternoVar ,
	apellido_materno	: apellido_maternoVar,
	sexo	: sexoVar ,
	fecha_nacimiento	: fecha_nacimientoVar ,				
	direccion	: direccionVar ,
	telefono	: telefonoVar ,
	tipo_paciente	: tipo_pacienteVar,
	base_diagnostico_id	: base_diagnostico_idVar,
	codigo_cieo	: codigo_cieoVar ,
	codigo_ubigeo	: codigo_ubigeoVar,
	fecha_diagnostico	: fecha_diagnosticoVar ,
	observacion	: observacionVar 

			}, function(response) {
				
				if(response == 1){
					
					limpiar();
					$('#panel_mensaje').html('<div class="alert alert-success" align="center" role="alert">¡Paciente guardado con éxito!</h5>');
					lista_pacientes();
					
				}else if(response == 0){
					
					limpiar();
					$('#panel_mensaje').html('<div class="alert alert-warning" align="center" role="alert">¡El n° de documento ya existe!</h5>');
					
				}
			
		});	
	}	
}

function carga_paciente_eliminar(paciente_id,numero_documento){
	
	$('#paciente_id').val(paciente_id);
	$('#panel_mensaje_confirma').html('<h5>¿Confirma eliminar al paciente con n° de documento : <strong>'+numero_documento+'</strong>?</h5>');
}

$('#btn_eliminar').click(function(event){
	var paciente_id = $('#paciente_id').val();
	eliminar_datos_paciente(paciente_id);
});

$('#btn_cancelar').click(function(event){
	$('#paciente_id').val('');
});
	

function eliminar_datos_paciente(paciente_id) {

	var opcionVar = "eliminar";
	var paciente_idVar = paciente_id;

	$.post('PacienteController', {

		opcion : opcionVar,
		paciente_id : paciente_idVar

	}, function(response) {
		
		if(response == 1){
						
			 lista_pacientes();
			 			
		}else if(response == 0){
						
			alert('Error');
			
		}
		
	});

}

function lista_pacientes(){
	
	var opcionVar = "listar_pacientes";
		
	$.get('PacienteController', {
		
		opcion : opcionVar		
		
		
	},function(response){
			
			$('#listado_pacientes').empty();
			
			var body = "";
			
			$.each(response, function(index, paciente){
				
				body += `
						<tr>					  
							<td class="text-center">${index+1}</td>
							<td>${paciente.numero_documento}</td>
							<td>${paciente.nombres}</td>
							<td>${paciente.apellido_paterno}</td>
							<td>${paciente.apellido_materno}</td>
							<td>${paciente.fecha_nacimiento}</td>																	
							<td class="text-center">
								<button type="button" id="btn_ver_paciente" class="btn btn-primary"  onclick="ver_datos_paciente(${paciente.paciente_id})"><i class="glyphicon glyphicon-eye-open"></i></button> 
								<button type="button" id="btn_editar_paciente" class="btn btn-default" onclick="editar_datos_paciente(${paciente.paciente_id})"><i class="glyphicon glyphicon-edit"></i></button>
								<button type="button" id="btn_elimina_paciente" class="btn btn-danger" data-toggle="modal" data-target="#modal_confirma_eliminar_paciente" onclick="carga_paciente_eliminar(${paciente.paciente_id},${paciente.numero_documento})"><i class="glyphicon glyphicon-remove"></i></button>
							</td>
					    </tr>						
				`;
														
			});
			
			$('#listado_pacientes').html(body);
			$('#listado_pacientes_registrados').dataTable();
			
						
	});
	
}

function cargar_datos_paciente(paciente_id) {

	var opcionVar = "buscar";
	var paciente_idVar = paciente_id;

	$.get('PacienteController', {

		opcion : opcionVar,
		paciente_id : paciente_idVar

	}, function(response) {
		
		$('#paciente_id').val(response.paciente_id);
				
		document.ready = document.getElementById("tipo_documento_id").value = response.tipo_documento_id;
				
		$('#numero_documento').val(response.numero_documento);
		$('#nombres').val(response.nombres);
		$('#apellido_paterno').val(response.apellido_paterno);
		$('#apellido_materno').val(response.apellido_materno);
		
		document.ready = document.getElementById("sexo").value = response.sexo;
		
		$('#fecha_nacimiento').val(response.fecha_nacimiento);
		$('#direccion').val(response.direccion);
		$('#telefono').val(response.telefono);
		
		document.ready = document.getElementById("tipo_paciente").value = response.tipo_paciente;
		
		document.ready = document.getElementById("base_diagnostico_id").value = response.base_diagnostico_id;
		
		$('#codigo_cieo').val(response.codigo_cieo);
		
		carga_cieo(event, response.codigo_cieo);
		
		var ubigeo = response.codigo_ubigeo;
		var codigo_departamento =  ubigeo.substring(0,2);
		var codigo_provincia =  ubigeo.substring(2,4);
		var codigo_distrito =  ubigeo.substring(4,6);
		
		$(document).ready(function(){
			
			carga_ubigeo(codigo_departamento, codigo_provincia, codigo_distrito);
			
		});
		
		$('#fecha_diagnostico').val(response.fecha_diagnostico);
		$('#observacion').val(response.observacion);
		
	});

}

function ver_datos_paciente(paciente_id){
	
	limpiar();
	
	cargar_datos_paciente(paciente_id);
	
	inhabilita_campos_paciente();
	
	$('#btn_guardar_paciente').hide();
	
}

function editar_datos_paciente(paciente_id){
	
	limpiar();
	
	cargar_datos_paciente(paciente_id);
	
	habilita_campos_paciente();
	
	$('#btn_guardar_paciente').show();
	
};

function inhabilita_campos_paciente(){
	
	$('#tipo_documento_id').attr('disabled',true);
	
	$('#numero_documento').attr('disabled',true);
	$('#nombres').attr('disabled',true);
	$('#apellido_paterno').attr('disabled',true);
	$('#apellido_materno').attr('disabled',true);
	
	$('#sexo').attr('disabled',true);
	
	$('#fecha_nacimiento').attr('disabled',true);
	$('#direccion').attr('disabled',true);
	$('#telefono').attr('disabled',true);
	
	$('#tipo_paciente').attr('disabled',true);
	
	$('#base_diagnostico_id').attr('disabled',true);
	
	$('#codigo_cieo').attr('disabled',true);
	
	$('#departamento_lista').attr('disabled',true);
	$('#provincia_lista').attr('disabled',true);
	$('#distrito_lista').attr('disabled',true);
	
	$('#fecha_diagnostico').attr('disabled',true);
	$('#observacion').attr('disabled',true);
	
}

function habilita_campos_paciente(){
	
	$('#tipo_documento_id').attr('disabled',false);
	
	$('#numero_documento').attr('disabled',false);
	$('#nombres').attr('disabled',false);
	$('#apellido_paterno').attr('disabled',false);
	$('#apellido_materno').attr('disabled',false);
	
	$('#sexo').attr('disabled',false);
	
	$('#fecha_nacimiento').attr('disabled',false);
	$('#direccion').attr('disabled',false);
	$('#telefono').attr('disabled',false);
	
	$('#tipo_paciente').attr('disabled',false);
	
	$('#base_diagnostico_id').attr('disabled',false);
	
	$('#codigo_cieo').attr('disabled',false);
	
	$('#departamento_lista').attr('disabled',false);
	$('#provincia_lista').attr('disabled',false);
	$('#distrito_lista').attr('disabled',false);
	
	$('#fecha_diagnostico').attr('disabled',false);
	$('#observacion').attr('disabled',false);
	
}





