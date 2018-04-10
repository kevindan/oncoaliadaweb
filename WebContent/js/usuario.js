$('#btnactualizar').click(function(event){
		
		if($('#nombrecompleto').val()==''){
			limpiarpaneles();
			$('div .form-group').removeClass('has-error');
			$('#div_nombrecompleto').addClass('has-error');
			$('#panel_mensaje').html('<div class="alert alert-warning" role="alert">¡Ingrese el nombre completo del usuario!</div>');
		
		}else if($('#usuario').val()==''){
			limpiarpaneles();
			$('div .form-group').removeClass('has-error');
			$('#div_usuario').addClass('has-error');
			$('#panel_mensaje').html('<div class="alert alert-warning" role="alert">¡Ingrese un nombre de usuario!</div>');
			
		}else if($('#email').val()==''){
			limpiarpaneles();
			$('div .form-group').removeClass('has-error');
			$('#div_email').addClass('has-error');
			$('#panel_mensaje').html('<div class="alert alert-warning" role="alert">¡Ingrese un e-mail!</div>');
			
		}else if($('#contrasena').val()==''){
			limpiarpaneles();
			$('div .form-group').removeClass('has-error');
			$('#div_contrasena').addClass('has-error');
			$('#panel_mensaje').html('<div class="alert alert-warning" role="alert">¡Ingrese una contraseña!</div>');
		
		}else if($('#contrasena').val() == $('#confirmcontrasena').val()){
			
			
			var opcionVar = "actualizar";

			var id_usuarioVar = $('#id_usuario').val();
			var nombrecompletoVar = $('#nombrecompleto').val();					
			var usuarioVar = $('#usuario').val();
			var contrasenaVar = $('#contrasena').val();
			var emailVar = $('#email').val();
			var id_tipo_usuarioVar = $('#id_tipo_usuario').val();			
			
			// Inicio de Post
			$.post('UsuarioController', {

						opcion : opcionVar,
						id_usuario: id_usuarioVar,
						nombrecompleto : nombrecompletoVar,
						usuario : usuarioVar,
						contrasena : contrasenaVar,
						email : emailVar,
						id_tipo_usuario : id_tipo_usuarioVar
					

					}, function(response) {
						
						if(response == 1){
							$('div .form-group').removeClass('has-error');
							limpiarpaneles();
							limpiarcampos();
							$('#panel_mensaje').html('<div class="alert alert-success" role="alert">Usuario actualizado con éxito</div>');
							
							$('#btnactualizar').hide();
							$('#btnregistrarme').show();					
																					
						}else if(response == 2){
							limpiarpaneles();
							$('div .form-group').removeClass('has-error');
							$('#div_usuario').addClass('has-error');
							$('#panel_mensaje').html('<div class="alert alert-warning" role = "alert">¡Usuario existente!</h5>');
						
						}else if(response == 0){
							limpiarpaneles();
							$('div .form-group').removeClass('has-error');
							$('#div_email').addClass('has-error');
							$('#panel_mensaje').html('<div class="alert alert-warning" role="alert">¡E-mail existente!</div>');
						
						}
					});
			
			//Fin de Post
			
		}else if($('#contrasena').val() != $('#confirmcontrasena').val()){
			limpiarpaneles();
			$('div .form-group').removeClass('has-error');
			$('#div_confirma_contrasena').addClass('has-error');
			$('#panel_mensaje').html('<div class="alert alert-danger">¡Las contraseñas no coinciden!</div>');
			
		}
		
	});
	
$('#btnregistrarme').click(function(event){
	
	if($('#nombrecompleto').val()==''){
		limpiarpaneles();
		$('div .form-group').removeClass('has-error');
		$('#div_nombrecompleto').addClass('has-error');
		$('#panel_mensaje').html('<div class="alert alert-warning" role="alert">¡Ingrese el nombre completo del usuario!</div>');
	
	}else if($('#usuario').val()==''){
		limpiarpaneles();
		$('div .form-group').removeClass('has-error');
		$('#div_usuario').addClass('has-error');
		$('#panel_mensaje').html('<div class="alert alert-warning" role="alert">¡Ingrese un nombre de usuario!</div>');
		
	}else if($('#email').val()==''){
		limpiarpaneles();
		$('div .form-group').removeClass('has-error');
		$('#div_email').addClass('has-error');
		$('#panel_mensaje').html('<div class="alert alert-warning" role="alert">¡Ingrese un e-mail!</div>');
		
	}else if($('#contrasena').val()==''){
		limpiarpaneles();
		$('div .form-group').removeClass('has-error');
		$('#div_contrasena').addClass('has-error');
		$('#panel_mensaje').html('<div class="alert alert-warning" role="alert">¡Ingrese una contraseña!</div>');
	
	}else if($('#contrasena').val() == $('#confirmcontrasena').val()){
		
		
		var opcionVar = "registrar";

		var nombrecompletoVar = $('#nombrecompleto').val();					
		var usuarioVar = $('#usuario').val();
		var contrasenaVar = $('#contrasena').val();
		var emailVar = $('#email').val();
		var id_tipo_usuarioVar = $('#id_tipo_usuario').val();			
		
		// Inicio de Post
		$.post('UsuarioController', {

					opcion : opcionVar,
					nombrecompleto : nombrecompletoVar,
					usuario : usuarioVar,
					contrasena : contrasenaVar,
					email : emailVar,
					id_tipo_usuario : id_tipo_usuarioVar
				

				}, function(response) {
					
					if(response == 1){
						$('div .form-group').removeClass('has-error');
						limpiarpaneles();
						limpiarcampos();
						listar_usuarios()
						$('#panel_mensaje').html('<div class="alert alert-success" role="alert">Usuario registrado con éxito</div>');
													
						
					}else if(response == 2){
						limpiarpaneles();
						$('div .form-group').removeClass('has-error');
						$('#div_usuario').addClass('has-error');
						$('#panel_mensaje').html('<div class="alert alert-warning" role = "alert">¡Usuario existente!</h5>');
					
					}else if(response == 0){
						limpiarpaneles();
						$('div .form-group').removeClass('has-error');
						$('#div_email').addClass('has-error');
						$('#panel_mensaje').html('<div class="alert alert-warning" role="alert">¡E-mail existente!</div>');
					
					}
				});
		
		//Fin de Post
		
	}else if($('#contrasena').val() != $('#confirmcontrasena').val()){
		limpiarpaneles();
		$('div .form-group').removeClass('has-error');
		$('#div_confirma_contrasena').addClass('has-error');
		$('#panel_mensaje').html('<div class="alert alert-danger">¡Las contraseñas no coinciden!</div>');
		
	}
	
});

function carga_usuario(id_usuario){
	
	var opcionVar = 'buscar';
	var id_usuarioVar = id_usuario;
	
	$.get('UsuarioController',{
		
			opcion : opcionVar,
			id_usuario : id_usuarioVar 
		
	}, function(response){
		
		$('#id_usuario').val(response.id_usuario);
		$('#nombrecompleto').val(response.nombrecompleto);
		$('#usuario').val(response.usuario);
		$('#contrasena').val(response.contrasena);
		$('#id_tipo_usuario option[value="'+response.id_tipo_usuario+'"]').attr('selected',true)
		
		$('#email').val(response.email);			
			
		
	});
	
}

function ver_usuario(id_usuario){
	
	limpiarcampos();
	
	carga_usuario(id_usuario);
	
	inhabilita_campos_usuario();
	
	$('#btnactualizar').hide();
	$('#btnregistrarme').hide();	
	
}

function editar_usuario(id_usuario){
	
	limpiarcampos();
	
	carga_usuario(id_usuario);
	
	habilita_campos_usuario();
	
	$('#btnactualizar').show();
	$('#btnregistrarme').hide();
	
	
}

function carga_usuario_eliminar(id_usuario,usuario){
	
	$('#id_usuario').val(id_usuario);
	$('#panel_mensaje_confirma').html('<h5>¿Confirma eliminar al usuario : <strong>'+usuario+'</strong>?</h5>');
}

$('#btneliminar').click(function(event){
	var id_usuario = $('#id_usuario').val();
	elimina_usuario(id_usuario);
});

$('#btncancelar').click(function(event){
	$('#id_usuario').val('');
});
	

function elimina_usuario(id_usuario){
	
		var opcionVar = 'eliminar';
	
		$.get('UsuarioController',{
			
			opcion: opcionVar,
			id_usuario : id_usuario
			
		},function(response){
			
			if(response == 1){
				
				listar_usuarios();
				
			}else if(response == 0){
				alert('Error');
			}
			
		});
			
}

function listar_usuarios() {
	var opcionVar = "listar_usuarios";
	
	$.get('UsuarioController', {
		
		opcion : opcionVar		
				
	},function(response){
		var usuario_nombre = $('#usuario_session').val();
		
		$('#listado_usuarios').empty();
		
		var body = "";
		
		$.each(response, function(index, usuario){
			if(usuario.nombrecompleto != "Administrador" ){	
				if (usuario_nombre == usuario.usuario) {
					body += `
							<tr class="current-user">
								<td class="text-center">${index + 1}</td>
								<td>${usuario.nombrecompleto}</td>
								<td>${usuario.usuario}</td>		
								<td class="text-center"><b>${usuario.id_tipo_usuario == 1 ? "Administrador" : "Usuario"}</b></td>										
								<td class="text-center">
										<button class="btn btn-default" onclick="editar_usuario('${usuario.id_usuario}')" data-dismiss="modal" ><i class="glyphicon glyphicon-edit"></i></button>								
								</td>
							</tr>					
					`;
				} else {
					body += `
							<tr>
								<td class="text-center">${index + 1}</td>
								<td>${usuario.nombrecompleto}</td>
								<td>${usuario.usuario}</td>	
								<td class="text-center"><b>${usuario.id_tipo_usuario == 1 ? "Administrador" : "Usuario"}</b></td>													
								<td class="text-center">									
										<button class="btn btn-primary" onclick="ver_usuario('${usuario.id_usuario}')" data-dismiss="modal" ><i class="glyphicon glyphicon-eye-open"></i></button>
										<button class="btn btn-default" onclick="editar_usuario('${usuario.id_usuario}')" data-dismiss="modal" ><i class="glyphicon glyphicon-edit"></i></button>											
										<button  class="btn btn-danger" onclick="carga_usuario_eliminar('${usuario.id_usuario}','${usuario.usuario}')" data-toggle="modal" data-target="#modal_confirma_eliminar"><i class="glyphicon glyphicon-remove"></i></button>									
								</td>
							</tr>					
					`;
				}
			}													
		});
					
		$('#listado_usuarios').html(body);
		$('#listado_usuarios_registrados').dataTable();
			
						
	});
}

listar_usuarios();