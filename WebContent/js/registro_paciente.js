$(document).ready(function () {
            	
     $('#tabla_cieo').dataTable();
     $('#fecha_nacimiento').datepicker();
     $('#fecha_diagnostico').datepicker();
                
     carga_ubigeo('01','01','01');
     
     lista_pacientes();
                
});

$('#btn_guardar_paciente').click(function(event){
	
 	guardar_paciente();
		
	});

$('#btn_nuevo_paciente').click(function(event){
	
	limpiar();
	habilita_campos_paciente();
	$('#btn_guardar_paciente').show();

});

$('#departamento_lista').on('change',function(){
	
	var opcionVar = "filtraprovincias";
	var codigo_departamentoVar = $('#departamento_lista').val();
	
	carga_provincias(codigo_departamentoVar);
	carga_distritos(codigo_departamentoVar,'01');
					
	});

$('#provincia_lista').on('change',function(){

var opcionVar = "filtradistritos";
var codigo_departamentoVar = $('#departamento_lista').val();
var codigo_provinciaVar = $('#provincia_lista').val();
			
carga_distritos(codigo_departamentoVar,codigo_provinciaVar);

});

  
function carga_provincias(codigo_departamento, codigo_provincia, codigo_distrito){
		codigo_provincia = codigo_provincia || null;
		
		var opcionVar = "filtraprovincias";
		var codigo_departamentoVar = codigo_departamento;
		
					
		$.post('DepartamentoController', {

					opcion : opcionVar,						
					codigo_departamento : codigo_departamentoVar
					
				}, function(response) {
															
					$('#provincia_lista').empty();
					
					var body = "";
					
					$.each(response, function(index, provincia){							
						

					body += `<option value="${provincia.codigo_provincia}">${provincia.provincia}</option>`;
						
					});
					
					$('#provincia_lista').html(body);
					
					
					if (codigo_provincia != null){
						carga_distritos(codigo_departamento, codigo_provincia, codigo_distrito);
						$("#provincia_lista").val(codigo_provincia);
					} else {
						carga_distritos(codigo_departamento, null, null);
					}

				});
}
	
function carga_distritos(codigo_departamento, codigo_provincia, codigo_distrito){
	
	codigo_distrito = codigo_distrito || null;
		
		var opcionVar = "filtradistritos";
		var codigo_departamentoVar = codigo_departamento;
		var codigo_provinciaVar = codigo_provincia;

					
		$.post('ProvinciaController', {

					opcion : opcionVar,
					codigo_departamento : codigo_departamentoVar,
					codigo_provincia : codigo_provinciaVar
					
				}, function(response) {
					
					$('#distrito_lista').empty();
										
					var body = "";
					
					$.each(response, function(index, distrito){							
									
					body += `<option value="${distrito.codigo_distrito}">${distrito.distrito}</option>`;
						
					});
					
					$('#distrito_lista').html(body);
					
					if (codigo_distrito != null){
						$("#distrito_lista").val(codigo_distrito);
					}
				});
		
}

function carga_cieo(event, codigo_cieoVar) {
		
		event.preventDefault();
		
		$.post('DiagnosticoController', {
				opcion: "buscacieo", 
				codigo_cieo: codigo_cieoVar
			}, 
		
	        function(response){
								
					$('#codigo_cieo').val(response.codigo_cieo);
					$('#descripcion').val(response.descripcion);
									
			});
}	
 
function limpiar(){
	
		$('#formulario_paciente').trigger('reset');
		
		$('#paciente_id').val('');
		
		$('div .form-group').removeClass('has-error');
		
		$('#panel_mensaje').html('');
	}

function carga_ubigeo(codigo_departamento, codigo_provincia, codigo_distrito){
	
	$('#departamento_lista').val(codigo_departamento);
	
	carga_provincias(codigo_departamento, codigo_provincia, codigo_distrito);
		
}