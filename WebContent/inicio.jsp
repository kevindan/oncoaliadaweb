
<%@ page language="java" contentType="text/html; charset=utf-8"	
	pageEncoding="utf-8"%>
	
		<!-- MORRIS CHART -->
		<link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
	
<!--  	<link href="assets/css/datepicker.css" rel="stylesheet"> -->
	
	<!-- STYLES DATATABLES JQUERY -->
<!--	<link href="assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" /> -->
		
<body>

<div class="row">
                    <div class="col-md-12">
                     	<h2 class="text-primary"><strong>Últimas estadísticas</strong></h2>   
                    </div>
</div>              
                 <!-- /. ROW  -->
                  <hr/>
<div class="row">
	<div class="col-md-12">
		<div class="row">
			<div class="col-md-6">
				<div class="panel panel-primary">
					<div class="panel panel-heading">
						N° de casos por grupos de edades
					</div>
					<div class="panel-body">
						<div id="bar-casos-edades">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
  
    <!--INICIO DE VENTANA MODAL PARA MENSAJES  -->
 <script src="assets/js/morris/raphael-2.1.0.min.js"></script>
 <script src="assets/js/morris/morris.js"></script>  
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
<script src="code/highcharts.js"></script>
<script src="code/modules/series-label.js"></script>
<script src="code/modules/exporting.js"></script>
<!-- JQUERY DATATABLES -->

<script>

$(document).ready(function(){
	
	$.post('<%=request.getContextPath()%>/EstadisticasController', {

		opcion : 'generagrafico'		

	}, function(response) {
		
		var datos = [];
				
		$.each(response, function(index, estadistica){
			
			var serie = new Array(estadistica.grupoetareo, estadistica.cantidad);
			datos.push(serie);
									
		});
				
		 genera_grafico(datos);
		
	});

	
});

function genera_grafico(datos){
	
	Highcharts.chart('bar-casos-edades', {
	    chart: {
	        plotBackgroundColor: null,
	        plotBorderWidth: null,
	        plotShadow: false,                                                                                                                                                                                                                                                                                                                                                   
	        type: 'pie'
	    },
	    title: {
	        text: '<strong>N° de Casos de CA de Próstata por Grupos Etareos</strong>'
	    },
	    tooltip: {
	        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	    },
	    plotOptions: {
	        pie: {
	            allowPointSelect: true,
	            cursor: 'pointer',
	            dataLabels: {
	                enabled: true,
	                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
	                style: {
	                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
	                }
	            }
	        }
	    },
	    series: [{
	        name: 'Grupos de Edades',
	        colorByPoint: true,
	        data: datos
	    }]
	});
}
		
</script>
</body>
