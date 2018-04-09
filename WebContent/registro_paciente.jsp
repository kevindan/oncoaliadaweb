<%@page import="entity.Paciente"%>
<%@page import="dao.PacienteDao"%>
<%@page import="entity.BaseDiagnostico"%>
<%@page import="dao.BaseDiagnosticoDao"%>
<%@page import="dao.DepartamentoDao"%>
<%@page import="entity.Departamento"%>
<%@page import="entity.Diagnostico"%>
<%@page import="dao.DiagnosticoDao"%>
<%@page import="dao.TipoDocumentoDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.TipoDocumento"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@page session="true"%>
		
	
	<link href="assets/css/datepicker.css" rel="stylesheet">	
	<!-- STYLES DATATABLES JQUERY -->
	<link href="assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
		
<!-- VARIABLES TEMPORALES  -->

<input type="hidden" id="paciente_id" value="">

<body>

<div class="row">
 	<div class="col-md-12">
    	<h2 class="text-primary"><strong>Registro de Paciente</strong></h2>   
	</div>
</div>             
<!-- LINEA  -->
 <hr />
 
<div class="row">
	<div class="col-md-12">                
		<div class="panel panel-primary">
			<div class="panel-heading">
                Datos del paciente
            </div>
			<div class="panel-body">
				<div class="row">
					<div class="col-md-12">                      
						<form role="form" Id="formulario_paciente">
							<div class="row">
								<div class="col-md-4">
                                    <div class="form-group" >
                                        <label>Tipo de Documento:</label>
										<select class="form-control" id="tipo_documento_id">                                                                            
                                            <%                                             
                                            	TipoDocumentoDao tipoDocumentoDao = new TipoDocumentoDao();
                                               	List<TipoDocumento> TipoDocumentos = tipoDocumentoDao.Listar();
                                            	
                                            	for(TipoDocumento td: TipoDocumentos ) {
                                            %>	                                            
                                            	<option value="<%=td.getTipo_documento_id()%>"><%=td.getTipo_documento()%></option>
                                            <%
                                            	}
                                            %> 
										</select>                                           
									</div>
								</div>                                    	
                                <div class="col-md-2">
                                	<div class="form-group" id="div_numero_documento">
                                    	<label>N° de Documento:</label>
                                        <input class="form-control" id="numero_documento" maxlength="8" onkeypress="validate(event, /[0-9]|\./)" autofocus="autofocus"/>                                           
                                    </div>
                                </div>
							</div>
							<div class="row">
                            	<div class="col-md-4">
                                	<div class="form-group" id="div_nombres">
                                    	<label>Nombres:</label>
                                        <input class="form-control" id="nombres"/>                                        
                                    </div>
                                </div>
                                <div class="col-md-4">
                                	<div class="form-group" id="div_apellido_paterno">
                                    	<label>Apellido paterno:</label>
                                        <input class="form-control" id="apellido_paterno"/>                                        
                                    </div>
                                </div>
								<div class="col-md-4" >
                                	<div class="form-group" id="div_apellido_materno">
                                    	<label>Apellido materno:</label>
                                        <input class="form-control" id="apellido_materno"/>                                        
                                    </div>
                                </div>
							</div>
							<div class="row">
                   				<div class="col-md-2">
                   			 		<div class="form-group" >
                                    	<label>Sexo:</label>
                                        <select class="form-control" id="sexo">                                           
                                        	<option value="1">Hombre</option>              	
                                        </select>                                            
                               		</div>
                   				</div>
                   				<div class="col-md-2">
                   					<div class="form-group" id="div_fecha_nacimiento">
										<label>Fecha Nacimiento : </label> 
										<input class="form-control" id="fecha_nacimiento" placeholder="Seleccione fecha">
									</div>
                   				</div>
                   				<div class="col-md-8">
                   			 		<div class="form-group">
                                    	<label>Dirección:</label>
                                        <input class="form-control" id="direccion"/>                                        
                                    </div>
                   				</div>
							</div>							
							<div class="row">
                 				<div class="col-md-4">
                 					<div class="form-group" >
                                    	<label>Departamento:</label>
                                    	<select class="form-control" id="departamento_lista">                                                  
                                            <% 
                                              DepartamentoDao departamentoDao = new DepartamentoDao();
                                               List<Departamento> departamentos = departamentoDao.Listar();
                                            	
                                           	  for(Departamento departamento: departamentos) {
                                            %>		
                                            		<option value="<%=departamento.getCodigo_departamento()%>"><%=departamento.getDepartamento()%></option>	                                        		
                                            <%
                                            	}
                                            %> 
                                        </select>                                            
                                    </div>              			
                 				</div>
                 				<div class="col-md-4">
                 					<div class="form-group" >
                                    	<label>Provincia:</label>
                                        <select class="form-control" id="provincia_lista">                                           		
                                        </select>                                            
                                    </div>
                 				</div>
                 				<div class="col-md-4">
                 					<div class="form-group" >
                                    	<label>Distrito:</label>
                                        <select class="form-control" id="distrito_lista">
                                        </select>                                            
                                     </div>    
                 				</div>
							</div>
							<div class="row">
                 				<div class="col-md-2">
                 					<div class="form-group">
                                    	<label>Teléfono:</label>
                                    	<input class="form-control" id="telefono"/>
                                    </div>
                 				</div>
                 				<div class="col-md-2">
                 		 			<div class="form-group" >
                                    	<label>Tipo de paciente:</label>
                                        <select class="form-control" id="tipo_paciente">                                         		
                                        	<option value="1">Nuevo</option>
                                        	<option value="2">Continuador</option>
                                        </select>                                            
                                     </div>
                 				</div>
                 				<div class="col-md-2">
                 					<div class="form-group" id="div_codigo_cieo">
										<label>Cie-O:</label>
                                        <input type="text" class="form-control" id="codigo_cieo" readonly="readonly"/>
                                     </div>
                 				</div>
                 				<div class="col-md-6">
                 					<div class="form-group" id="div_descripcion">
                                    	<label>Descripción:</label>
                                    	<div class="input-group">
                                      		<input type="text" class="form-control" id="descripcion" readonly="readonly">
                                             <span class="input-group-btn">                                          
                            					 <button class="btn btn-success" type="button" id="buscar_cieo" data-toggle="modal" data-target="#modal_cieo"><i class="fa fa-search"></i></button>
                                             </span> 
                                      	</div>
                         			</div>
                 				</div>
							</div>
							<div class="row">
 								<div class="col-md-2">
 									<div class="form-group" >
                                    	<label>Base del diagnóstico:</label>
                                        <select class="form-control" id="base_diagnostico_id">
                                            <% 
                                           	   BaseDiagnosticoDao baseDiagnosticoDao = new BaseDiagnosticoDao();
                                               List<BaseDiagnostico> baseDiagnosticos = baseDiagnosticoDao.Listar();
                                            	
                                           	  for(BaseDiagnostico bd: baseDiagnosticos) {
                                            %>		
                                            	<option value="<%=bd.getBase_diagnostico_id()%>"><%=bd.getBase_diagnostico()%></option>	                                        		
                                            <%
                                            	}
                                            %> 
                                        </select>                                            
                                    </div>
								</div>
						 		<div class="col-md-2">
						 			<div class="form-group" id="div_fecha_diagnostico">
										<label>Fecha de diag.:</label> 
										<input class="form-control" id="fecha_diagnostico" placeholder="Seleccione fecha">
									</div>               
						 		</div>
								<div class="col-md-8">
 		 							<div class="form-group">
                                    	<label>Observación:</label>
                                        <input class="form-control" id="observacion"/>
                                    </div>
								</div>
							</div>
 							<div class="row">
						 		<div class="col-md-12">
						 			<div class="form-group" id="panel_mensaje">
						 			</div>
						 		</div>
							</div>
 							<div class="row">
 								<div class="col-md-4 text-left">
 									<div class="form-group">
										<button type="button" id="btn_guardar_paciente" class="btn btn-primary">Guardar</button>										
										<button type="button" id="btn_nuevo_paciente" class="btn btn-default">Nuevo</button>
									</div>
 								</div>
							</div>          
						</form>                                      
 				   </div>
				</div>
			</div>			
		</div>
		<div class="panel panel-primary">
				<div class="panel-heading">
					<h5 class="panel-title">Lista de pacientes registrados</h5>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-md-12">
							<div class="table-responsive">
								<table class="table table-bordered table-hover table-striped" id="listado_pacientes_registrados">
									<thead>
										<tr class="info">
											<th>N°</th>									
	                						<th>N° Documento</th>
	                						<th>Nombres</th>
	               							<th>Ap. Paterno</th>
	                						<th>Ap. Materno</th>
	               							<th>Fech. Nacimiento</th>
	               							<th class="text-center">Opciones</th>
										</tr>
									</thead>
									<tbody id="listado_pacientes">										
									</tbody>								
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
	</div>
</div>
           

    
 <!-- INICIO DE MODAL LISTA CIE-O -->    
<div class="modal fade" tabindex="-1" id="modal_cieo" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
    	<div class="modal-content">
      		<div class="modal-header">
        		<h5 class="modal-title" ><strong>Lista de Cie-O</strong></h5>
     		</div>
			<div class="modal-body ">    
        		<div class="table-responsive">
          			<table class="table table-striped table-bordered table-hover" id="tabla_cieo">
						<thead>
                        	<tr class="info">
                            	<th>Cie-O</th>
                                <th>Descripción</th>                                                                        
                            </tr>
                        </thead>
						<tbody>
                        <% 
                        	DiagnosticoDao diagnosticoDao = new DiagnosticoDao();
                            List<Diagnostico> diagnosticos = diagnosticoDao.Listar();
                            String clase="odd gradeX";
                                            	
                            for(Diagnostico diagostico: diagnosticos ) {
                                           
                            if(clase.equals("odd gradeX")){                                            		
                            
                            	clase="even gradeC";                                            		                                            		
                            
                            }else{                                            		
                             
                            	clase="odd gradeX";                                            		
                                
                            }               		
                        %>		
                             <tr class="<%=clase%>">
                             	<td onclick="carga_cieo(event, '<%=diagostico.getCodigo_cieo()%>')" data-dismiss="modal" aria-label="Close" ><%=diagostico.getCodigo_cieo() %></td>
                                <td onclick="carga_cieo(event, '<%=diagostico.getCodigo_cieo()%>')" data-dismiss="modal" aria-label="Close" ><%=diagostico.getDescripcion() %></td>                               
                             </tr>                                            		
                        <%
                        	}
                        %>
						</tbody>
					</table>
				</div>
			</div>
		    <div class="modal-footer">       
		    	<a href="#" class="btn btn-primary" data-dismiss="modal" id="cerrar_modal" aria-label="Close">Cerrar</a>
		    </div>
		</div>
	</div>
</div>      
   <!-- FIN DE MODAL LISTA CIE-O -->
   
 <!-- INICIO DE MODAL DE CONFIRMACION ELIMINAR -->
<div class="modal fade"  id="modal_confirma_eliminar_paciente" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static">
  <div class="modal-dialog modal-ms">
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
         <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar" id="btn_cancelar">
         <input type="button" class="btn btn-danger" data-dismiss="modal" value="Eliminar" id="btn_eliminar">        
      </div>
    </div>
  </div>
</div>
 <!-- FIN DE MODAL DE CONFIRMACION ELIMINAR -->                   
            
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
<!-- JQUERY DATATABLES -->
<script src="js/paciente.js"></script>
<script src="js/registro_paciente.js"></script>

</body>
