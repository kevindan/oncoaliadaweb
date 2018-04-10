<%@page import="dao.UsuarioDao"%>
<%@page import="entity.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="dao.TipoUsuarioDao"%>
<%@page import="entity.TipoUsuario"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>    
<!-- Variables temporales -->
<input type="hidden" id="id_usuario" value="">
 
    

</br>		
		<div class="row">
			<div class="col-md-12">				
				<h3 class="text-primary text-left" ><strong>Registro de usuario</strong></h3>		
				<hr/>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						 Datos de Usuario 
					</div>
					<div class="panel-body">
						<form role="form" id="formulario_usuario">
							<br />
							<div class="form-group input-group" id="div_nombrecompleto">
								<span class="input-group-addon"><i class="fa fa-user"></i></span> 
								<input type="text"	class="form-control" id="nombrecompleto" placeholder="Nombres y apellidos" />								 
							 </div>
							
							<div class="form-group input-group" id="div_usuario">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<input type="text" id="usuario" class="form-control" placeholder="Nombre de usuario" />
							</div>
							
							<div class="form-group input-group" id="div_email">
								<span class="input-group-addon">@</span> <input type="text"
									class="form-control" id="email" placeholder="E-mail" />
							</div>
							<div class="form-group input-group" id="div_id_tipo_usuario">
								<span class="input-group-addon"><i class="fa fa-flash"></i></span>
								<select class="form-control" id="id_tipo_usuario">
								 	<% 
								 		TipoUsuarioDao tipoUsuarioDao = new TipoUsuarioDao();
								 		List<TipoUsuario> tipousuarios = tipoUsuarioDao.Listar();
								 		
								 		for(TipoUsuario tipoUsuario: tipousuarios){								 		
								 	%>
								 		<option value="<%=tipoUsuario.getTipo_usuario_id()%>"><%=tipoUsuario.getTipo_usuario()%></option>
								 	<% 
								 		}
								 	%>
								 </select>										
							</div>
							
							<div class="form-group input-group" id="div_contrasena">
								<span class="input-group-addon"><i class="fa fa-lock"></i></span>
								<input type="password" id="contrasena" class="form-control" placeholder="Escriba un acontraseña" />
							</div>
							
							<div class="form-group input-group" id="div_confirma_contrasena">
								<span class="input-group-addon"><i class="fa fa-lock"></i></span>
								<input type="password" id="confirmcontrasena" class="form-control" placeholder="Confirme su contraseña"/>
							</div>
							 <div class="form-group" id ="panel_mensaje">									
							 </div>
								<input type="button" class="btn btn-success " id="btnregistrarme" value="Registrar">
								<input type="button" class="btn btn-danger " id="btnactualizar" value="Actualizar">
								<input type="button" class="btn btn-default " id="btn_nuevo" value="Nuevo">
							<hr/>
							Para ingresar el nuevo usuario, haga clic <a href="UsuarioController?cerrar=true">aquí</a>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="panel panel-primary">
					<div class="panel panel-heading">
						Lista de usuarios activos
					</div>
					<div class="panel panel-body">
						<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover" id="listado_usuarios_registrados">
								<thead>
									<tr class="info">
										<th class="text-center">N°</th>
										<th>Nombre Completo</th>
										<th>Usuario</th>	
										<th>Tipo de usuario</th>									
										<th class="text-center">Opciones</th>
									</tr>
								</thead>
								<tbody id="listado_usuarios"></tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			
		</div>

 
 <!-- INICIO DE MODAL DE CONFIRMACION ELIMINAR -->
 	<div class="modal fade"  id="modal_confirma_eliminar" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
  <div class="modal-dialog modal-md">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" ><strong>Confirmación</strong></h5>                
      </div>
      <div class="modal-body">
      	<div class="row">
			<div class="col-sm-12">
				<div id="panel_mensaje_confirma">
				</div>
			</div>
      	</div>       
      </div>
      <div class="modal-footer">
      	<input type="button" class="btn btn-danger" data-dismiss="modal" value="Eliminar" id="btneliminar">      
      	<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">                 
      </div>
    </div>
  </div>
</div>
 <!-- FIN DE MODAL DE CONFIRMACION ELIMINAR -->
 
<script src="js/nuevo_usuario.js"></script>
<script src="js/usuario.js"></script>

<!-- JQUERY SCRIPTS -->
	
</body>
