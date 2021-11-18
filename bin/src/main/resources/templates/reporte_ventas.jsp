<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.G3.CiCLO03.TiendaFrontEnd03.model.Customers"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Reportes</title>
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/styles.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
</head>
<body class="py-5">
    <div class="container card o-hiddend border-0">
        <div class="card-body p-0">
        
            <div class="row py-4 px-3 px-md-5">
        
                <div class="col-12">
                    <h1 class="fw-bold"> Registro de ventas por clientes </h1>
                    <p>Interfaz para administrar los usuarios que administren la tienda</p>
                    <hr class="my-4">
                </div>
                
                <!-- lista -->
                <table class="table table-light table-striped table-hover mb-0">
                    <thead class="table-light">
                    	<th class="col">#</th>
                        <th class="col-4">Cedula</th>
                        <th class="col-4">Nombre</th>
                        <th class="col-4">Ventas totales</th>	
                    </thead>
                    <tbody id="list">
                         <!--  code in ajax  -->
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="application/javascript">
    	$(document).ready( ()=>{
    		let accion = "listar"
    		$.ajax({
                url: 'Reporte_ventas',
                type: 'POST',
                data: {accion},
                success: function(response){
                	if( /^\[/.test(response) )
                	{   						
   						line="";
   						console.log(response);
   						//Elimino charCode 13.
   						for(i=0; i< response.length; i++){
   							if( response.charCodeAt(i) != 13 ) line+=response.charAt(i);
   						}
   						customers = JSON.parse(line);
   						template = "";
   						let total = 0;
   						i=0;
   						
   						for( customer of customers){
   							i++;
   							template += "<tr>"+
   											"<th>"+i+"</th>"+
   											"<td>"+customer.id+"</td>"+
   											"<td>"+customer.name+"</td>"+
   											"<td>"+customer.sales.toFixed(2)+"</td>"+
   										"<tr>";
   							total += parseFloat(customer.sales.toFixed(2));
   						}
   						
   						template += "<tr>"+
										"<td colspan='3' class='table-active text-end fw-bold'>TOTAL :</td>"+
										"<td class='table-active fw-bold'>"+total.toFixed(2)+"</td>"+
									"<tr>";
   						document.querySelector("#list").innerHTML = template;
   					}
            	}
    		});
    	});
    </script>
</body>
</html>