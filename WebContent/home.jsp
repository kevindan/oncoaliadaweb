<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Date"%>
<%@page import="entity.UsuarioView"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <meta charset="utf-8"/>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>:: Onco-Aliada ::</title>
	<!-- BOOTSTRAP STYLES-->	
       
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
     <!-- MORRIS CHART STYLES-->
    <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" /> 
        <!-- CUSTOM STYLES-->
    <link href="assets/css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
  
   
</head>
<body>
<%
	Date fechahoy = new Date();
	DateFormat formato = new SimpleDateFormat("dd/MM/YYYY - HH:mm:ss a");
	String fechayhora = formato.format(fechahoy);
	
	HttpSession sesion = request.getSession();
	UsuarioView usuarioView = new UsuarioView();
	
	if(sesion.getAttribute("usuario")!=null && sesion.getAttribute("tipo_usuario")!=null && sesion.getAttribute("nombrecompleto")!= null){
		usuarioView.setUsuario(sesion.getAttribute("usuario").toString());
		usuarioView.setNombrecompleto(sesion.getAttribute("nombrecompleto").toString());
		usuarioView.setTipo_usuario(sesion.getAttribute("tipo_usuario").toString());
		
	}else{
		
		out.print("<script>location.replace('login.jsp');</script>");
	}
%>
    <div id="wrapper">
        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>                
           		<a class="navbar-brand" href="home.jsp">Onco-Urología</a>
            </div>            
		     <div class="text-right" style="color: white;
					padding: 15px 50px 5px 50px;
					float: right;
					font-size: 14px;">Sesión:&nbsp;<%=usuarioView.getNombrecompleto()%>&nbsp;&nbsp;&nbsp;&nbsp;Inicio:&nbsp;<%=fechayhora%>
			</div>
    	 	 </nav>
	 	          
           <!-- /. NAV TOP  -->
                <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
				    <li class="text-center">
                         <img src="assets/img/aliada-logo.png" class="user-image img-responsive"/>
					</li>
					 <li>
                        <a class="active-menu"  href="home.jsp"><i class="fa fa-dashboard fa-3x" ></i> Inicio</a>
                    </li>					
                    <li id="menu_registro_usuarios">
                        <a href="#" onclick="cargacontenido('nuevo_usuario.jsp')"><i class="fa fa-key fa-3x" ></i> Registro de usuarios</a>
                    </li>
                     
                    <li  >
                        <a  href="#" onclick="cargacontenido('registro_paciente.jsp')"><i class="fa fa-user fa-3x"  ></i> Registro de paciente </a>
                    </li>
                     <li  >
                        <a  href="#" onclick="cargacontenido('hc_paciente.jsp')"><i class="fa fa-list-alt fa-3x"></i> Variables del Paciente </a>
                    </li>	
                    <li  >
                        <a  href="#"><i class="fa fa-bar-chart-o fa-3x"></i> Reportes</a>
                    </li>				
					 <li  >
                        <a   href="UsuarioController?cerrar=true"><i class="glyphicon glyphicon-log-out fa-3x"></i> Cerrar Sesión</a>
                    </li>	                     
				
                </ul>
               
            </div>
            
        </nav>  
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
    
                 <!-- /. ROW  -->           
            </div>
             <!-- /. PAGE INNER  -->
        </div>
         <!-- /. PAGE WRAPPER  -->
     </div>
     <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
   
   
   
   <!--  <script src="assets/js/morris/morris.js"></script>  -->
      <!-- CUSTOM SCRIPTS -->
   <!--  <script src="assets/js/custom.js"></script>  -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="assets/js/cargapanel.js"></script>
    
     <script src="assets/js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="assets/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="assets/js/jquery.metisMenu.js"></script>
     <!-- MORRIS CHART SCRIPTS -->
    <script src="assets/js/morris/raphael-2.1.0.min.js"></script>
     
    <script src="assets/js/bootstrap-datepicker.js"></script>
	<script src="assets/js/dataTables/jquery.dataTables.js"></script>
	<script src="assets/js/dataTables/dataTables.bootstrap.js"></script>    
    <script>
    
    
    $(function() {
    	  
    	  // elementos de la lista
    	     var menues = $(".nav li a"); 

    	  // manejador de click sobre todos los elementos
    	     menues.click(function() {
    	     // eliminamos active de todos los elementos
    	     menues.removeClass("active-menu");
    	     // activamos el elemento clicado.
    	     $(this).addClass("active-menu");
    	  });

    	});
    
    </script>
    <script type="text/javascript">
		$(document).ready(function(){
			
			var tipo_usuario = "<%=usuarioView.getTipo_usuario()%>";
			
			if(tipo_usuario == 'Administrador'){
				
				$('#menu_registro_usuarios').show();
				
			}else if(tipo_usuario == 'Usuario'){
				
				$('#menu_registro_usuarios').hide();
			}
			
			cargacontenido('inicio.jsp');
				
		});
	</script>
    
   </body> 
</html>