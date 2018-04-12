<%@page import="entity.Tratamiento_metastasico"%>
<%@page import="dao.Tratamiento_metastasicoDao"%>
<%@page import="dao.TratamientoDao"%>
<%@page import="entity.Tratamiento"%>
<%@page import="entity.Tipo_diagnostico"%>
<%@page import="entity.Paciente"%>
<%@page import="dao.PacienteDao"%>
<%@page import="dao.Grupo_riesgoDao"%>
<%@page import="entity.Grupo_tumor"%>
<%@page import="entity.Grupo_riesgo"%>
<%@page import="dao.Grupo_tumorDao"%>
<%@page import="entity.Histologia"%>
<%@page import="dao.HistologiaDao"%>
<%@page import="entity.Raza"%>
<%@page import="dao.RazaDao"%>
<%@page import="entity.BaseDiagnostico"%>
<%@page import="dao.BaseDiagnosticoDao"%>
<%@page import="dao.DepartamentoDao"%>
<%@page import="entity.Departamento"%>
<%@page import="entity.Diagnostico"%>
<%@page import="dao.DiagnosticoDao"%>
<%@page import="dao.Tipo_diagnosticoDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.TipoDocumento"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<link href="assets/css/datepicker.css" rel="stylesheet">
<!-- STYLES DATATABLES JQUERY -->
<link href="assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
<!-- TAB PILLS -->
<link href="assets/css/bootstrap-tab.css" rel="stylesheet" />
<!-- CHECK BOXES -->
<link href="assets/css/bootstrap-check.css" rel="stylesheet" />

<body>

<!-- Variables temporales -->
<input type="hidden" id="paciente_id" value="">

<!-- Fin de variables temporales -->

<div class="row">
	<div class="col-md-12">
		<h2 class="text-primary">
			<strong>Variables del paciente</strong>
		</h2>
	</div>
</div>
	<hr />
<div class="row">
	<div class="col-md-12">	
		<div class="panel panel-primary">
			<div class="panel-heading panel-primary">Datos del Fallecimiento del Paciente</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-md-12">
							<form role="form" id = "formulario_hc">
								<div class="row">
									<div class="col-md-3">
										<div class="form-group" id="div_numero_documento">
											<label>N° de Documento:</label>
											<div class="input-group">
												<input class="form-control" id="numero_documento_" readonly="readonly" />
												<span class="input-group-btn">
													<button class="btn btn-success" type="button" id="lista_pacientes" data-toggle="modal" data-target="#modal_lista_pacientes_">
														<i class="fa fa-search"></i>
													</button>
												</span>
											</div>											
										</div>
									</div>
								</div>								
								<div class="row">
									<div class="col-md-4">
										<div class="form-group" id="div_nombres">
											<label>Nombres:</label> <input class="form-control"	id="nombres_" readonly="readonly" />											
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group" id="div_apellido_paterno">
											<label>Apellido paterno:</label> <input class="form-control" id="apellido_paterno_" readonly="readonly" />											
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group" id="div_apellido_materno">
											<label>Apellido materno:</label> <input class="form-control" id="apellido_materno_" readonly="readonly" />											
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-2">
										<div class="form-group" id="div_codigo_cieo">
											<label>Cie-O:</label> <input type="text" class="form-control" id="codigo_cieo_" readonly="readonly" />											
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group" id="div_descripcion">
											<label>Descripción:</label>											
											<input type="text" class="form-control" id="descripcion_" readonly="readonly">										
										</div>
									</div>
								</div>								
								<div class="row" id="panel_datos_fallecido">
									<div class="col-md-12">
										<div class="panel panel-primary">
											<div class="panel-heading">
												Datos del fallecimiento											
											</div>
											<div class="panel-body">
											</div>
										</div>
									</div>											
								</div>
								<div class="row">
							 		<div class="col-md-12">
							 			<div class="form-group" id="panel_mensaje_fallecido">
							 			</div>
							 		</div>
								</div>								
								<div class="row">
									<div class="col-md-12">
										<input type="button" class="btn btn-primary" id="btn_guardar_fallecido" value="Grabar">
										<input type="button" class="btn btn-default" id="btn_nuevo_fallecido" value="Nuevo">	
									</div>
								</div>	
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<!-- 									
											 -->
										</div>
									</div>
									<div class="col-md-4"></div>
									<div class="col-md-4"></div>
								</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="panel panel-primary">
			<div class="panel-heading">
				Lista de Pacientes en Seguimiento
			</div>
			<div class="panel-body">
				<div class="row">
						<div class="col-md-12">
							<div class="table-responsive">
								<table class="table table-bordered table-hover table-striped" id="lista_pacientes_hc">
									<thead>
										<tr class="info">
											<th>N°</th>									
	                						<th>N° Documento</th>
	                						<th>Nombres</th>
	               							<th>Ap. Paterno</th>
	                						<th>Ap. Materno</th>
	               							<th>F. Último Control</th>
	               							<th class="text-center">Opciones</th>
										</tr>
									</thead>
									<tbody id="listado_pacientes_hc">										
									</tbody>								
								</table>
							</div>
						</div>
					</div>
			</div>
		</div>
	</div>
</div>


	<!-- VENTANA MODAL PACIENTES-->

<div class="modal fade" tabindex="-1" id="modal_lista_pacientes_" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">
					<strong>Listado de Pacientes</strong>
				</h5>
			</div>
			<div class="modal-body ">				
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover" id="lista_pacientes_">
						<thead>
							<tr class="info">
								<th class="col-md-2">Num. Documento</th>
								<th class="col-md-4">Nombres Completos</th>
								<th class="col-md-4">Fecha. Nac</th>								
							</tr>
						</thead>
							<tbody>
								<%
									PacienteDao pacienteDao = new PacienteDao();
									List<Paciente> Pacientes = pacienteDao.Listar();
									String clase = "odd gradeX";

									for (Paciente paciente : Pacientes) {

										if (clase.equals("odd gradeX")) {

											clase = "even gradeC";

										} else {

											clase = "odd gradeX";

										}
								%>
								<tr class="<%=clase%>">
									<td onclick="carga_paciente_('<%=paciente.getPaciente_id()%>')" data-dismiss="modal" aria-label="Close"><%=paciente.getNumero_documento()%></td>
									<td onclick="carga_paciente_('<%=paciente.getPaciente_id()%>')" data-dismiss="modal" aria-label="Close"><%=paciente.getNombres() + " " + paciente.getApellido_paterno() + " " + paciente.getApellido_materno()%></td>
									<td onclick="carga_paciente_('<%=paciente.getPaciente_id()%>')" data-dismiss="modal" aria-label="Close"><%=paciente.getFecha_nacimiento()%></td>									
								</tr>

								<%
									}
								%>
						</tbody>
					</table>
				</div>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn btn-primary" data-dismiss="modal" aria-label="Close">Aceptar</a>				
			</div>
		</div>
	</div>
</div>

	<!--INICIO DE VENTANA MODAL PARA cie-o  -->


<!--INICIO DE VENTANA MODAL PARA ELIMINAR -->
<div class="modal fade"  id="modal_confirma_eliminar_hc_paciente" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
  <div class="modal-dialog modal-ms">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" ><strong>Confirmación</strong></h5>                
      </div>
      <div class="modal-body">
      	<div class="row">
			<div class="col-sm-12">
				<div id="panel_mensaje_confirma_hc">
				</div>
			</div>
      	</div>       
      </div>
      <div class="modal-footer">      
         <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar" id="btn_cancelar_hc">
         <input type="button" class="btn btn-danger" data-dismiss="modal" value="Eliminar" id="btn_eliminar_hc">        
      </div>
    </div>
  </div>
</div>
<!-- FIN DE VENTANA MODAL PARA ELIMINAR -->		
	<!-- JQUERY CHECKBOXES -->	
	<script src="js/fallecidos.js"></script>
	
</body>