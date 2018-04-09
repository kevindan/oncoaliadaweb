$(document).ready(function(){
			
	$('#btnactualizar').hide();
			
});

$('#btn_nuevo').click(function(event){
	
	limpiarcampos();
	limpiarpaneles();
	habilita_campos_usuario();
	
	$('#btnregistrarme').show();
	$('#btnactualizar').hide();
	
});

function limpiarpaneles(){
	
	$('#panel_mensaje').html('');
			
}
function limpiarcampos(){
	
	$('#id_usuario').val('');	
	$('#formulario_usuario').trigger('reset');
	$('div .form-group').removeClass('has-error');
	
}

function inhabilita_campos_usuario(){
		
	$('#nombrecompleto').attr('disabled',true);
	$('#usuario').attr('disabled',true);
	$('#contrasena').attr('disabled',true);
	$('#email').attr('disabled',true);
	$('#confirmcontrasena').attr('disabled',true);
	$('#id_tipo_usuario').attr('disabled',true);
	

	
}

function habilita_campos_usuario(){
	
	$('#nombrecompleto').attr('disabled',false);
	$('#usuario').attr('disabled',false);
	$('#contrasena').attr('disabled',false);
	$('#email').attr('disabled',false);
	$('#confirmcontrasena').attr('disabled',false);
	$('#id_tipo_usuario').attr('disabled',false);
	
}