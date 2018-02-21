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
<input type="hidden" id="hc_cabecera_id" value="">

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
			<div class="panel-heading panel-primary">Datos del seguimiento del paciente</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-md-12">
							<form role="form" id = "formulario_hc">
								<div class="row">
									<div class="col-md-3">
										<div class="form-group" id="div_numero_documento">
											<label>N° de Documento:</label>
											<div class="input-group">
												<input class="form-control" id="numero_documento" readonly="readonly" />
												<span class="input-group-btn">
													<button class="btn btn-success" type="button" id="buscar_cieo" data-toggle="modal" data-target="#modal_lista_pacientes">
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
											<label>Nombres:</label> <input class="form-control"	id="nombres" readonly="readonly" />											
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group" id="div_apellido_paterno">
											<label>Apellido paterno:</label> <input class="form-control" id="apellido_paterno" readonly="readonly" />											
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group" id="div_apellido_materno">
											<label>Apellido materno:</label> <input class="form-control" id="apellido_materno" readonly="readonly" />											
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-2">
										<div class="form-group">
											<label>Sexo:</label> <select disabled="disabled" class="form-control" id="sexo">
												<option value="1">Hombre</option>												
											</select>
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group" id="div_fecha_nacimiento">
											<label>Fecha. Nac : </label> <input class="form-control" id="fecha_nacimiento" readonly="readonly">
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group" id="div_codigo_cieo">
											<label>Cie-O:</label> <input type="text" class="form-control" id="codigo_cieo" readonly="readonly" />											
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group" id="div_descripcion">
											<label>Descripción:</label>											
											<input type="text" class="form-control" id="descripcion" readonly="readonly">										
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-2">
										<div class="form-group">
											<label>E.C.O:</label> 
											<select  class="form-control" id="eco_paciente">
												<option value="0">ECO-0</option>
												<option value="1">ECO-1</option>
												<option value="2">ECO-2</option>
												<option value="3">ECO-3</option>
												<option value="4">ECO-4</option>
											</select>
										</div>
									</div>
									<div class="col-md-2">
										<div class="form-group">
											<label>Fech. ultimo control:</label> <input	class="form-control" id="fecha_ultimo_control" placeholder="Seleccione fecha">
										</div>
									</div>								
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="panel with-nav-tabs panel-primary">
											<div class="panel-heading">
												<ul class="nav nav-tabs">
													<li class="active"><a href="#tab_antecedentes" data-toggle="tab">Antecedentes</a></li>
													<li><a href="#tab_datos_tumor" data-toggle="tab">Datos tumor</a></li>
													<li><a href="#tab_diagnostico" data-toggle="tab">Diagnostico</a></li>
													<li><a href="#tab_seguimiento" data-toggle="tab">Seguimiento</a></li>
												</ul>
											</div>
											<div class="panel-body">
												<div class="tab-content">
													<div class="tab-pane fade in active" id="tab_antecedentes">
														<div class="form-group">
															<div class="col-md-12 columns">
																<span class="additional-info-wrap">
																	<label	class="checkbox-inline" id="label_antecedente_raza"> 
																		<input type="checkbox"	name="Checkboxes" id="antecedente_raza" value="">
																			Raza
																	</label>
																	<div class="additional-info hide"  id="panel_antecedente_raza">
																		<!--   <input type="text" id="CheckboxesNameOfGrape" name="CheckboxesNameOfGrape" placeholder="Name of Grape" class="form-control" disabled=""> -->
																		<select class="form-control" id="raza_id">
																				<option value=""></option>
																			<%
																				RazaDao razaDao = new RazaDao();
																				List<Raza> razas = razaDao.Listar();
																				for (Raza raza : razas) {
																			%>
																				<option value="<%=raza.getRaza_id()%>"><%=raza.getRaza()%></option>
																			<%
																				}
																			%>

																		</select>
																	</div>
																</span> 
																<span class="additional-info-wrap"> 
																	<label	class="checkbox-inline" id="label_antecedente_familiar"> 
																		<input type="checkbox"	name="Checkboxes" id="antecedente_familiar" value="">
																			Familiares con cáncer
																	</label>
																	<div class="additional-info hide" id="panel_antecedente_familiar">
																		<input type="text" id="descripcion_familiar" name="CheckboxesNameOfGrape" placeholder="Detallar" class="form-control">
																	</div>
																</span> 
																	<label class="checkbox-inline" id="label_antecedente_genes"> 
																		<input type="checkbox" name="Checkboxes" id="antecedente_genes" value=""> 
																		Genes (BRCA1-BRCA2)
																	</label> 
																<label class="checkbox-inline" id="label_antecedente_alimentacion"> <input type="checkbox" name="Checkboxes" id="antecedente_alimentacion" value="">
																	Alimentación rica en grasas
																</label> 
																<span class="additional-info-wrap"> 
																	<label class="checkbox-inline" id="label_antecedente_obesidad"> <input type="checkbox" name="Checkboxes" id="antecedente_obesidad" value="">
																		Obesidad
																	</label>
																	<div class="additional-info hide" id="panel_antecedente_obesidad">
																		<div class="input-group">
																			<input type="text" class="form-control" value="Peso" readonly="readonly"> 
																			<span class="input-group-addon">:</span> 
																			<input type="text" id="peso" name="CheckboxesNameOfGrape" placeholder="kg." class="form-control" onkeyup="calcula_imc()" disabled="">
																		</div>
																		<div class="input-group">
																			<input type="text" class="form-control" value="Estatura" readonly="readonly">
																			<span class="input-group-addon">:</span> 
																			<input type="text" id="estatura" name="CheckboxesNameOfGrape" placeholder="mts." class="form-control" onkeyup="calcula_imc()" disabled="">

																		</div>
																		<div class="input-group">
																			<input type="text" class="form-control" value="IMC" readonly="readonly"> 
																			<span class="input-group-addon">:</span> 
																			<input type="text" id="imc" name="CheckboxesNameOfGrape" placeholder="IMC" class="form-control" readonly="readonly">
																		</div>
																	</div>
																</span> 
																<span class="additional-info-wrap">
																	<label	class="checkbox-inline" id="label_antecedente_exposicion_trabajo"> 
																		<input type="checkbox"	name="Checkboxes" id="antecedente_exposicion_trabajo" value="">
																			Exposicion al lugar de trabajo
																	</label>
																	<div class="additional-info hide" id="panel_antecedente_exposicion_trabajo">																		
																		<select class="form-control" id="antecedente_exposicion_trabajo_detalle">
																			<option value=""></option>
																			<option value="1">Minería</option>
																			<option value="2">Radiaciones</option>
																			<option value="3">Otros</option>
																		</select>
																	</div>
																</span> 
																<label class="checkbox-inline" id="label_antecedente_prostatitis"> 
																	<input type="checkbox" name="Checkboxes" id="antecedente_prostatitis" value="">
																	Prostatitis
																</label>
																<label class="checkbox-inline" id="label_antecedente_its"> 
																	<input type="checkbox" name="Checkboxes" id="antecedente_its" value=""> 
																 	ITS
																</label> 
																<span class="additional-info-wrap"> 
																	<label class="checkbox-inline" id="label_antecedente_sustancia">
																		<input type="checkbox" name="Checkboxes" id="antecedente_sustancia" value="">
																		Sustancia química
																	</label>
																	<div class="additional-info hide" id="panel_antecedente_sustancia">
																		<input type="text" id="sustancia_descripcion" name="CheckboxesNameOfGrape" placeholder="Indique sustancia" class="form-control" disabled="">
																	</div>
																</span> 
																<span class="additional-info-wrap"> 
																	<label class="checkbox-inline" id="label_antecedente_neoplasia"> 
																	<input type="checkbox" name="Checkboxes" id="antecedente_neoplasia" value="">
																		Otras neoplasias
																	</label>
																	<div class="additional-info hide" id="panel_antecedente_neoplasia">
																		<div class="input-group">
																			<input type="text" id="antecedente_neoplasia_cieo" name="CheckboxesNameOfGrape" placeholder="seleccione" class="form-control" readonly="readonly" /> <span class="input-group-btn">
																				<button class="btn btn-success" type="button" id="buscar_cieo" data-toggle="modal" data-target="#modal_cieo"><i class="fa fa-search"></i>
																				</button>
																			</span>
																		</div>
																	</div>
																</span>
															</div>
														</div>
													</div>
													<div class="tab-pane fade" id="tab_datos_tumor">
														<div class="row">
															<div class="col-md-2">
																<div class="form-group">
																	<label>PSA debut (ng/mL): </label> 
																	<input class="form-control" id="psa_debut">
																</div>
															</div>
															<div class="col-md-2">
																<div class="form-group">
																	<label>Histología:</label> 
																		<select class="form-control" id="histologia_id">
																			<option value=""></option>
																			<%
																				HistologiaDao histologiaDao = new HistologiaDao();
																				List<Histologia> histologias = histologiaDao.Listar();
					
																				for (Histologia histologia : histologias) {
																			%>
																				<option value="<%=histologia.getHistologia_id()%>"><%=histologia.getDescripcion()%></option>
																			<%
																				}
																			%>
																		</select>
																</div>
															</div>
															<div class="col-md-3">
																<div class="form-group">
																	<label>Descripción</label> 
																	<input class="form-control" id="histologia_especificacion">
																</div>
															</div>
															<div class="col-md-2">
																<div class="form-group">
																	<label>F. diag. hist.:</label> 
																	<input class="form-control" id="fecha_diagnostico_histologico" placeholder="Seleccione fecha">
																</div>
															</div>
															<div class="col-md-4">	
																<div class="panel panel-info">
																	<div class="panel-heading">
																		Gleason score
																	</div>
																	<div class="panel-body">
																		<div class="row">
																			<div class="col-md-4">
																				<div class="form-group">
																					<label>Valor 1:</label>
																					<input type="text" class="form-control" onkeyup="calcula_gleason()" id="gleason_mayor" >
																				</div>
																			</div>																			
																			<div class="col-md-4">
																				<div class="form-group">
																					<label>Valor 2:</label>
																					<input type="text" class="form-control" onkeyup="calcula_gleason()" id="gleason_menor" >
																				</div>
																			</div>
																			<div class="col-md-4">
																				<div class="form-group">
																					<label>Score:</label>
																					<input type="text" class="form-control" id="gleason_total" readonly="readonly">
																				</div>
																			</div>																			
																		</div>
																	</div>																														
																</div>
															</div>
															<div class="col-md-8">	
																<div class="panel panel-info">
																	<div class="panel-heading">
																		Estadiaje (TNM)
																	</div>
																	<div class="panel-body">
																		<div class="row">
																			<div class="col-md-2">
																				<div class="form-group">
																					<label>Cat T:</label>
																					<select class="form-control" id="categoria_t">
																						<option value=""></option>
																						<option value="TX">TX</option>
																						<option value="T0">T0</option>
																						<option value="T1">T1</option>
																						<option value="T1a">T1a</option>
																						<option value="T1b">T1b</option>
																						<option value="T1c">T1c</option>
																						<option value="T2">T2</option>
																						<option value="T2a">T2a</option>
																						<option value="T2b">T2b</option>
																						<option value="T2c">T2c</option>
																						<option value="T3">T3</option>
																						<option value="T3a">T3a</option>
																						<option value="T3b">T3b</option>
																						<option value="T4">T4</option>																						
																					</select>
																				</div>
																			</div>
																			<div class="col-md-2">
																				<div class="form-group">
																					<label>T Pat:</label>
																					<select class="form-control" id="categoria_t_patologico">
																						<option value=""></option>
																						<option value="pT2">pT2</option>
																						<option value="pT2a">pT2a</option>
																						<option value="pT2b">pT2b</option>
																						<option value="pT2c">pT2c</option>
																						<option value="pT3">pT3</option>
																						<option value="pT3a">pT3a</option>
																						<option value="pT3b">pT3b</option>
																						<option value="pT4">pT4</option>																																											</select>
																				</div>
																			</div>																			
																			<div class="col-md-2">
																				<div class="form-group">
																					<label>Cat. N:</label>
																					<select class="form-control" id="categoria_n">
																						<option value=""></option>
																						<option value="NX">NX</option>
																						<option value="N0">N0</option>
																						<option value="N1">N1</option>
																					</select>
																				</div>
																			</div>
																			<div class="col-md-2">
																				<div class="form-group">
																					<label>Cat. M:</label>
																					<select class="form-control" id="categoria_m">
																						<option value=""></option>
																						<option value="MX">MX</option>
																						<option value="M0">M0</option>
																						<option value="M1">M1</option>
																					</select>
																				</div>
																			</div>
																			<div class="col-md-2">
																				<div class="form-group">
																					<label>Cat. G:</label>
																					<select class="form-control" id="categoria_g">
																						<option value=""></option>
																						<option value="GX">GX</option>
																						<option value="G1">G1</option>
																						<option value="G2">G2</option>
																						<option value="G3-4">G3-4</option>
																					</select>
																				</div>
																			</div>																			
																		</div>
																	</div>																														
																</div>
															</div>
															<div class="col-md-3">
																<div class="form-group">
																	<label>Tratamiento Inicial:</label>
																	<select class="form-control" id="tratamiento_inicial">
																		<option value=""></option>
																	<% 
																		TratamientoDao tratamientoDao = new TratamientoDao();
																		List<Tratamiento> tratamiento_inicial = tratamientoDao.Listar();
																		
																		for(Tratamiento tratamiento : tratamiento_inicial){
																	%>
																		<option value="<%=tratamiento.getTratamiento_id()%>"><%=tratamiento.getTratamiento()%></option>
																	<% 
																		}
																	%>														
																	</select>
																</div>
															</div>
														</div>
													</div>
													<div class="tab-pane fade" id="tab_diagnostico">													
														<div class="row">
															<div class="col-md-12">
																<div class="row">
																	<div class="col-md-2">
																		<div class="form-group">
																			<label>Tipo de Diag.:</label> 
																			<select class="form-control" id="tipo_diagnostico_id">																				
																					<%
																						Tipo_diagnosticoDao tipoDao = new Tipo_diagnosticoDao();
																						List<Tipo_diagnostico> tipo_diagnosticos = tipoDao.Listar();
			
																						for (Tipo_diagnostico td: tipo_diagnosticos) {
																					%>
																					<option value="<%=td.getTipo_diagnostico_id()%>"><%=td.getTipo_diagnostico()%></option>
																					<%
																						}
																					%>
																			</select>
																		</div>
																	</div>
																	<div class="col-md-3">
																		<div class="form-group">
																			<label>Grupo de riesgo:</label> 
																			<select class="form-control" id="grupo_riesgo_id">
																					<option></option>
																			</select>
																		</div>
																	</div>
																</div>
															</div>
														</div>	
													</div>													
													<div class="tab-pane fade" id="tab_seguimiento">
														<div class="row">
															<div class="col-md-6">
																<div class="panel panel-primary">
																	<div class="panel-heading">
																		Falla Bioquímica
																	</div>
																	<div class="panel-body">
															  			<div class="row">																	
																			<div class="col-md-4">
																				<div class="form-group">
																					<label>Fecha : </label> 
																					<input class="form-control" id="fecha_falla_bioquimica">
																				</div>
																			</div>
																			<div class="col-md-3">
																				<div class="form-group">
																					<label>PSA (ng/mL):</label> 
																					<input class="form-control" id="psa_falla_bioquimica">
																				</div>
																			</div>
																			<div class="col-md-5">
																				<div class="form-group">
																					<label>Tratamiento.:</label> 
																						<select class="form-control" id="tratamiento_falla_bioquimica">	
																							<option value=""></option>																				
																						<%
																							Tratamiento_metastasicoDao t_falla_bioquimicaDao = new Tratamiento_metastasicoDao();
																							List<Tratamiento_metastasico> t_falla_bioquimica = t_falla_bioquimicaDao.Listar();
																							
																							for(Tratamiento_metastasico tratamiento_metastasico: t_falla_bioquimica){
																						%>
																							<option value="<%=tratamiento_metastasico.getTratamiento_metastasico_id()%>"><%=tratamiento_metastasico.getTratamiento_metastasico()%></option>
																						<% 
																							}
																						%>																																									
																						</select>
																				</div>
																			</div>
																		 </div>
																	</div>
																</div>
															</div>
															<div class="col-md-6">
																<div class="panel panel-primary">
																	<div class="panel-heading">
																		Enfermedad Metastásica
																	</div>
																	<div class="panel-body">																
																		<div class="row">
																			<div class="col-md-4">
																				<div class="form-group">
																					<label>Fecha : </label> 
																					<input class="form-control" id="fecha_enfermedad_metastasica">
																				</div>
																			</div>
																			<div class="col-md-3">
																				<div class="form-group">
																					<label>PSA (ng/mL):</label> 
																					<input class="form-control" id="psa_enfermedad_metastasica">
																				</div>
																			</div>
																			<div class="col-md-3">
																				<div class="form-group">
																					<label>Sintomatico:</label> 
																					<select class="form-control" id="sintomatico_enfermedad_metastasica">																					
																						<option value="0">No</option>
																						<option value="1">Si</option>												
																					</select>
																				</div>
																			</div>
																		</div>
																		<div class="row">
																			<div class="col-md-4">
																				<div class="form-group">
																					<label>Oligometastásico:</label> 
																					<select class="form-control" id="enfermedad_metastasica_oligometastasico">																					
																						<option value="0">No</option>
																						<option value="1">Si</option>												
																					</select>
																				</div>
																			</div>
																			<div class="col-md-6">
																				<div class="form-group">
																					<label>Organo. Comp.:</label> 
																					<select class="form-control" id="organo_enfermedad_metastasica">
																						<option value=""></option>																					
																						<option value="1">Oseo</option>
																						<option value="2">Pulmonar</option>
																						<option value="3">Ganglionar</option>
																						<option value="4">Hepático</option>
																						<option value="5">Otros</option>																																											
																					</select>
																				</div>
																			</div>
																		</div>
																		<div class="row">	
																			<div class="col-md-6">
																				<div class="form-group">
																					<label>Trat. de 1° Linea:</label> 
																					<select class="form-control" id="tratamiento_enfermedad_metastasica">
																							<option value=""></option>																					
																						<%
																							Tratamiento_metastasicoDao t_metastasico_Dao = new Tratamiento_metastasicoDao();
																							List<Tratamiento_metastasico> t_metastasico = t_metastasico_Dao.Listar();
																							
																							for(Tratamiento_metastasico tratamiento_metastasico: t_metastasico){
																						%>
																							<option value="<%=tratamiento_metastasico.getTratamiento_metastasico_id()%>"><%=tratamiento_metastasico.getTratamiento_metastasico()%></option>
																						<% 
																							}
																						%>																																														
																					</select>
																				</div>
																			</div>
																			<div class="col-md-6">
																				<div class="form-group">
																					<label>Tec. Radioterapia:</label> 
																					<select class="form-control" id="tecnica_radioterapia_enfermedad_metastasica">																					
																						<option value=""></option>
																						<option value="1">RTE</option>
																						<option value="2">IMRT</option>
																						<option value="3">3D-CRT</option>
																						<option value="4">RCE</option>																																																																
																					</select>
																				</div>
																			</div>
																		</div>
																		<div class="row">	
																			<div class="col-md-4">
																				<div class="form-group">
																					<label>Dosis (Gray):</label> 
																					<input class="form-control" id="dosis_radioterapia_enfermedad_metastasica">
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
															<div class="col-md-6">
																<div class="panel panel-primary">
																	<div class="panel-heading">
																		Segunda Enfermedad Progresiva
																	</div>
																	<div class="panel-body">
																		<div class="row">
																			<div class="col-md-4">
																				<div class="form-group">
																					<label>Fecha : </label> 
																					<input class="form-control" id="fecha_segunda_enfermedad_progresiva">
																				</div>
																			</div>
																			<div class="col-md-3">
																				<div class="form-group">
																					<label>PSA (ng/mL):</label> 
																					<input class="form-control" id="psa_segunda_enfermedad_progresiva">
																				</div>
																			</div>
																			<div class="col-md-3">
																				<div class="form-group">
																					<label>Sintomatico:</label> 
																					<select class="form-control" id="sintomatico_segunda_enfermedad_progresiva">																					
																						<option value="0">No</option>
																						<option value="1">Si</option>												
																					</select>
																				</div>
																			</div>
																		</div>
																		<div class="row">	
																			<div class="col-md-4">
																				<div class="form-group">
																					<label>Oligometastásico:</label> 
																					<select class="form-control" id="segunda_enfermedad_progresiva_oligometastasico">																					
																						<option value="0">No</option>
																						<option value="1">Si</option>												
																					</select>
																				</div>
																			</div>
																			<div class="col-md-6">
																				<div class="form-group">
																					<label>Organo. Comp.:</label> 
																					<select class="form-control" id="organo_segunda_enfermedad_progresiva">
																						<option value=""></option>																					
																						<option value="1">Oseo</option>
																						<option value="2">Pulmonar</option>
																						<option value="3">Ganglionar</option>
																						<option value="4">Hepático</option>
																						<option value="5">Otros</option>																																											
																					</select>
																				</div>
																			</div>
																		</div>
																		<div class="row">	
																			<div class="col-md-6">
																				<div class="form-group">
																					<label>Trat. de 1° Linea:</label> 
																					<select class="form-control" id="tratamiento_segunda_enfermedad_progresiva">	
																							<option value=""></option>																				
																						<%
																							Tratamiento_metastasicoDao t_segundo_metastasico_Dao = new Tratamiento_metastasicoDao();
																							List<Tratamiento_metastasico> t_segundo_metastasico = t_segundo_metastasico_Dao.Listar();
																							
																							for(Tratamiento_metastasico tratamiento_metastasico: t_segundo_metastasico){
																						%>
																							<option value="<%=tratamiento_metastasico.getTratamiento_metastasico_id()%>"><%=tratamiento_metastasico.getTratamiento_metastasico()%></option>
																						<% 
																							}
																						%>																																											
																					</select>
																				</div>
																			</div>
																			<div class="col-md-6">
																				<div class="form-group">
																					<label>Tec. Radioterapia:</label> 
																					<select class="form-control" id="tecnica_radioterapia_segunda_enfermedad_progresiva">																					
																						<option value=""></option>
																						<option value="1">RTE</option>
																						<option value="2">IMRT</option>
																						<option value="3">3D-CRT</option>
																						<option value="4">RCE</option>																																																																
																					</select>
																				</div>
																			</div>
																		</div>
																		<div class="row">
																			<div class="col-md-4">
																				<div class="form-group">
																					<label>Dosis (Gray):</label> 
																					<input class="form-control" id="dosis_segunda_enfermedad_progresiva">
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
															<div class="col-md-6">
																<div class="panel panel-primary">
																	<div class="panel-heading">
																		Tercera Enfermedad Progresiva
																	</div>
																	<div class="panel-body">
																		<div class="row">
																			<div class="col-md-4">
																				<div class="form-group">
																					<label>Fecha : </label> 
																					<input class="form-control" id="fecha_tercera_enfermedad_progresiva">
																				</div>
																			</div>
																			<div class="col-md-3">
																				<div class="form-group">
																					<label>PSA (ng/mL):</label> 
																					<input class="form-control" id="psa_tercera_enfermedad_progresiva">
																				</div>
																			</div>
																			<div class="col-md-3">
																				<div class="form-group">
																					<label>Sintomatico:</label> 
																					<select class="form-control" id="sintomatico_tercera_enfermedad_progresiva">																					
																						<option value="0">No</option>
																						<option value="1">Si</option>												
																					</select>
																				</div>
																			</div>
																		</div>
																		<div class="row">	
																			<div class="col-md-4">
																				<div class="form-group">
																					<label>Oligometastásico:</label> 
																					<select class="form-control" id="tercera_enfermedad_progresiva_oligometastasico">																					
																						<option value="0">No</option>
																						<option value="1">Si</option>												
																					</select>
																				</div>
																			</div>
																			<div class="col-md-6">
																				<div class="form-group">
																					<label>Organo. Comp.:</label> 
																					<select class="form-control" id="organo_tercera_enfermedad_progresiva">
																						<option value=""></option>																					
																						<option value="1">Oseo</option>
																						<option value="2">Pulmonar</option>
																						<option value="3">Ganglionar</option>
																						<option value="4">Hepático</option>
																						<option value="5">Otros</option>																																											
																					</select>
																				</div>
																			</div>
																		</div>
																		<div class="row">	
																			<div class="col-md-6">
																				<div class="form-group">
																					<label>Trat. de 1° Linea:</label> 
																					<select class="form-control" id="tratamiento_tercera_enfermedad_progresiva">
																							<option value=""></option>																					
																						<%
																							Tratamiento_metastasicoDao t_tercero_metastasico_Dao = new Tratamiento_metastasicoDao();
																							List<Tratamiento_metastasico> t_tercero_metastasico = t_tercero_metastasico_Dao.Listar();
																							
																							for(Tratamiento_metastasico tratamiento_metastasico: t_tercero_metastasico){
																						%>
																							<option value="<%=tratamiento_metastasico.getTratamiento_metastasico_id()%>"><%=tratamiento_metastasico.getTratamiento_metastasico()%></option>
																						<% 
																							}
																						%>																																											
																					</select>
																				</div>
																			</div>
																			<div class="col-md-6">
																				<div class="form-group">
																					<label>Tec. Radioterapia:</label> 
																					<select class="form-control" id="tecnica_radioterapia_tercera_enfermedad_progresiva">																					
																						<option value=""></option>
																						<option value="1">RTE</option>
																						<option value="2">IMRT</option>
																						<option value="3">3D-CRT</option>
																						<option value="4">RCE</option>																																																																
																					</select>
																				</div>
																			</div>
																		</div>	
																		<div class="row">	
																			<div class="col-md-4">
																				<div class="form-group">
																					<label>Dosis (Gray):</label> 
																					<input class="form-control" id="dosis_tercera_enfermedad_progresiva">
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
																<div class="col-md-6">
																<div class="panel panel-primary">
																	<div class="panel-heading">
																		Cuarta Enfermedad Progresiva
																	</div>
																	<div class="panel-body">
																		<div class="row">
																			<div class="col-md-3">
																				<div class="form-group">
																					<label>Fecha : </label> 
																					<input class="form-control" id="fecha_cuarta_enfermedad_progresiva">
																				</div>
																			</div>
																			<div class="col-md-3">
																				<div class="form-group">
																					<label>PSA (ng/mL):</label> 
																					<input class="form-control" id="psa_cuarta_enfermedad_progresiva">
																				</div>
																			</div>
																			<div class="col-md-3">
																				<div class="form-group">
																					<label>Sintomatico:</label> 
																					<select class="form-control" id="sintomatico_cuarta_enfermedad_progresiva">																					
																						<option value="0">No</option>
																						<option value="1">Si</option>												
																					</select>
																				</div>
																			</div>
																		</div>
																		<div class="row">	
																			<div class="col-md-4">
																				<div class="form-group">
																					<label>Oligometastásico:</label> 
																					<select class="form-control" id="cuarta_enfermedad_progresiva_oligometastasico">																					
																						<option value="0">No</option>
																						<option value="1">Si</option>												
																					</select>
																				</div>
																			</div>
																			<div class="col-md-6">
																				<div class="form-group">
																					<label>Organo. Comp.:</label> 
																					<select class="form-control" id="organo_cuarta_enfermedad_progresiva">
																						<option value=""></option>																					
																						<option value="1">Oseo</option>
																						<option value="2">Pulmonar</option>
																						<option value="3">Ganglionar</option>
																						<option value="4">Hepático</option>
																						<option value="5">Otros</option>																																											
																					</select>
																				</div>
																			</div>
																		</div>	
																		<div class="row">	
																			<div class="col-md-6">
																				<div class="form-group">
																					<label>Trat. de 1° Linea:</label> 
																					<select class="form-control" id="tratamiento_cuarta_enfermedad_progresiva">
																							<option value=""></option>																					
																						<%
																							Tratamiento_metastasicoDao t_cuarto_metastasico_Dao = new Tratamiento_metastasicoDao();
																							List<Tratamiento_metastasico> t_cuarto_metastasico = t_cuarto_metastasico_Dao.Listar();
																							
																							for(Tratamiento_metastasico tratamiento_metastasico: t_cuarto_metastasico){
																						%>
																							<option value="<%=tratamiento_metastasico.getTratamiento_metastasico_id()%>"><%=tratamiento_metastasico.getTratamiento_metastasico()%></option>
																						<% 
																							}
																						%>																																											
																					</select>
																				</div>
																			</div>
																			<div class="col-md-6">
																				<div class="form-group">
																					<label>Tec. Radioterapia:</label> 
																					<select class="form-control" id="tecnica_radioterapia_cuarta_enfermedad_progresiva">																					
																						<option value=""></option>
																						<option value="1">RTE</option>
																						<option value="2">IMRT</option>
																						<option value="3">3D-CRT</option>
																						<option value="4">RCE</option>																																																																
																					</select>
																				</div>
																			</div>
																		</div>	
																		<div class="row">	
																			<div class="col-md-4">
																				<div class="form-group">
																					<label>Dosis (Gray):</label> 
																					<input class="form-control" id="dosis_cuarta_enfermedad_progresiva">
																				</div>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							<div class="row">
						 		<div class="col-md-12">
						 			<div class="form-group" id="panel_mensaje_hc">
						 			</div>
						 		</div>
							</div>								
							<div class="row">
								<div class="col-md-12">
									<input type="button" class="btn btn-primary" id="btn_guardar_hc" value="Grabar">
									<input type="button" class="btn btn-default" id="btn_nuevo_hc" value="Nuevo">	
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

<div class="modal fade" tabindex="-1" id="modal_lista_pacientes" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">
					<strong>Listado de Pacientes</strong>
				</h5>
			</div>
			<div class="modal-body ">				
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover" id="lista_pacientes">
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
									List<Paciente> Pacientes = pacienteDao.ListarSinHc();
									String clase = "odd gradeX";

									for (Paciente paciente : Pacientes) {

										if (clase.equals("odd gradeX")) {

											clase = "even gradeC";

										} else {

											clase = "odd gradeX";

										}
								%>
								<tr class="<%=clase%>">
									<td onclick="carga_paciente('<%=paciente.getPaciente_id()%>')" data-dismiss="modal" aria-label="Close"><%=paciente.getNumero_documento()%></td>
									<td onclick="carga_paciente('<%=paciente.getPaciente_id()%>')" data-dismiss="modal" aria-label="Close"><%=paciente.getNombres() + " " + paciente.getApellido_paterno() + " " + paciente.getApellido_materno()%></td>
									<td onclick="carga_paciente('<%=paciente.getPaciente_id()%>')" data-dismiss="modal" aria-label="Close"><%=paciente.getFecha_nacimiento()%></td>									
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

	<!--INICIO DE VENTANA MODAL PARA MENSAJES  -->
<div class="modal fade" tabindex="-1" id="modal_cieo" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">
						<strong>Listado de Diagtnósticos</strong>
					</h5>
				</div>
				<div class="modal-body ">				
					<div class="table-responsive">
						<table class="table table-striped table-bordered table-hover" id="tabla_cieo">
							<thead>
								<tr class="info">
									<th class="col-md-2">Cie-O</th>
									<th class="col-md-4">Descripcion</th>
								</tr>
							</thead>
							<tbody>
								<%
									DiagnosticoDao dxDao = new DiagnosticoDao();
									List<Diagnostico> diagnosticos = dxDao.Listar();
									
									for (Diagnostico diagnostico :diagnosticos) {

										if (clase.equals("odd gradeX")) {

											clase = "even gradeC";

										} else {

											clase = "odd gradeX";

										}
								%>
								<tr class="<%=clase%>">
									<td onclick="carga_cieo(event, '<%=diagnostico.getCodigo_cieo()%>')" data-dismiss="modal" aria-label="Close"><%=diagnostico.getCodigo_cieo()%></td>
									<td onclick="carga_cieo(event, '<%=diagnostico.getCodigo_cieo()%>')" data-dismiss="modal" aria-label="Close"><%=diagnostico.getDescripcion()%></td>
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
	<!-- FIN DE VENTANA MODAL PARA MENSAJES -->


	<!-- JQUERY CHECKBOXES -->
	<script src="assets/js/bootstrap-check.js"></script>
	<script src="js/hc_paciente.js"></script>
	
</body>