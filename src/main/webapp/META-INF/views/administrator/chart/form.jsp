<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<h2 align="center">
	<acme:message code="administrator.chart.form.title.ratioApplication"/>
</h2>
	
<div>
	<canvas id="canvas"></canvas>
</div>
	
<script type="text/javascript">
	$(document).ready(function(){
		var data = {
			labels : [
				"PENDING","ACCEPTED", "REJECTED"
			],
			datasets : [
				{
					data : [
						<jstl:out value="${ratioPendingApplication}"/>,
						<jstl:out value="${ratioAcceptedApplication}"/>,
						<jstl:out value="${ratioRejectedApplication}"/>
					],
					backgroundColor: [
						'rgba(255,0,0,0.6)',
						'rgba(0,255,0,0.6)',
						'rgba(0,0,255,0.6)'
					]
				}
			]
		};
		var options = {
			scales : {
				yAxes : [
					{
						ticks : {
							suggestedMin : 0.0,
							suggestedMax : 1.0
						}
					}
				]
			},
			legend : {
				display : false
			},
			responsive: true
		};
		
		var canvas,context;
		
		canvas = document.getElementById("canvas");
		context = canvas.getContext("2d");
		new Chart(context, {
			type : "pie",
			data : data,
			options : options
		});
	});
</script>
	
<h2 align="center">
	<acme:message code="administrator.chart.form.title.ratioJob"/>
</h2>
	
<div>
	<canvas id="canvas2"></canvas>
</div>

<script type="text/javascript">
	$(document).ready(function(){
		var data = {
			labels:["DRAFT","PUBLISHED"
			],
			datasets:[
				{
				data:[
						<jstl:out value="${ratioDraftJob}"/>,
						<jstl:out value="${ratioPublishedJob}"/>
					],
				backgroundColor: [
					'rgba(255,0,0,0.6)',
					'rgba(0,255,0,0.6)'
				]
				}
			]
		};
		var options = {
			scales:{
				yAxes:[
					{
						ticks: {
							suggestedMin: 0.0,
							suggestedMax: 1.0
						}
					}
				]
			},
			legend :{
				display:false
			},
			responsive: true
			
		};
		
		var canvas,context;
		
		canvas = document.getElementById("canvas2");
		context = canvas.getContext("2d");
		new Chart(context, {
			type:"pie",
			data:data,
			options: options
		});
	});
</script>

<h2 align="center">
	<acme:message code="administrator.chart.form.title.ratioApplication4weeks"/>
</h2>
	
<div>
	<canvas id="canvas3"></canvas>
</div>
	
<script type="text/javascript">
	$(document).ready(function(){
		var data = {
			labels : [
				"PENDING","ACCEPTED", "REJECTED"
			],
			datasets : [
				{
					data : [
						<jstl:out value="${ratioPendingApplication4weeks}"/>,
						<jstl:out value="${ratioAcceptedApplication4weeks}"/>,
						<jstl:out value="${ratioRejectedApplication4weeks}"/>
					],
					backgroundColor: [
						'rgba(255,0,0,0.6)',
						'rgba(0,255,0,0.6)',
						'rgba(0,0,255,0.6)'
					]
				}
			]
		};
		var options = {
			scales : {
				yAxes : [
					{
						ticks : {
							suggestedMin : 0.0,
							suggestedMax : 1.0
						}
					}
				]
			},
			legend : {
				display : false
			},
			responsive: true
		};
		
		var canvas,context;
		
		canvas = document.getElementById("canvas3");
		context = canvas.getContext("2d");
		new Chart(context, {
			type : "pie",
			data : data,
			options : options
		});
	});
</script>