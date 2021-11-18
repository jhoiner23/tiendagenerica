<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="com.G3.CiCLO03.TiendaFrontEnd03.model.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>FACTURAS</title>

	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="librerias/avgrund.css" />
	<link rel="stylesheet" href="css/styles.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
</head>
<body class="py-5">
	<!-- spinner -->
	<div class="w-100 h-100 position-absolute d-none justify-content-center align-items-center"
		 style="background: #00000088 ;z-index:100; margin: -48px 0 0 0" id="spinner">
		<div class="spinner-border text-light" role="status"
				style="width: 3rem; height: 3rem;">
		 	<span class="visually-hidden">Loading...</span>
		</div>
	</div>

	<!--  datalist -->
	<datalist id="dl-products"><%
    		ArrayList<Products> list_products = (ArrayList<Products>)request.getAttribute("list-products");
  			for( Products product: list_products ){
  				Double iva = product.getIva_compra(); 
  				%>
	    		<option data-value="<%=product.getCodigo_producto()%>"
    				data-value_venta="<%=product.getPrecio_venta()+( product.getPrecio_venta()*(iva/100) )%>"
    				data-value_iva="<%=iva%>"
     				value="<%=product.getNombre_producto()%>"/>
    	  <%}%>
    </datalist>

	<datalist id="dl-clients"><%
	   		ArrayList<Customers> list_customers = (ArrayList<Customers>)request.getAttribute("list-clients");
	 		for( Customers customer: list_customers ){%>
	   		<option data-value="<%=customer.getCedula_cliente()%>"
	    			value="<%=customer.getNombre_cliente()%>"/>
	      <%}%>
	</datalist>
	
	<!--  modal -->
	<div class="avgrund-cover"></div>
	<aside id="default-popup" class="avgrund-popup">
			<button id="btn-close-modal" class="btn btn-danger ms-auto d-block">
				<i class="fas fa-times"></i>
			</button>
			<h2>Inventario</h2>
			<p>Por favor, suba el archivo .csv</p>
			<input type="file" class="form-control" id="update-data"/>
			<span class="text-danger"></span>
	</aside>
	
	
    <div class="container position-relative card o-hiddend border-0">
    	<%
    		String msj = (String)request.getAttribute("msj");
    		if( msj != null )
    		{%>    		
		        <div class="position-fixed bottom-0 end-0 p-3" style="z-index: 11">
					<div id="liveToast" class="toast hide" role="alert" aria-live="assertive" aria-atomic="true">
					    <div class="toast-header">
					      <img src="img/favicon.png" class="rounded me-2 h-100" alt="...">
					      <strong class="me-auto">Tienda Generica</strong>
					      <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
					    </div>
					    <div class="toast-body" style="color: #fff; background: #240046;">
					    	<%=msj%>
					    </div>
					</div>
				</div>
    		<%}%>
        
        <div class="card-body p-0">
            <div class="py-5 px-2 px-md-5">
                <h1 class="fw-bold mb-4"> Generar factura </h1>
                <button id="btn-modal"
                		class="btn btn-primary ms-auto d-block position-absolute end-0 top-0"
                		style="margin-top:50px; margin-right:70px;">
                	<i class="fas fa-dolly"></i>
                	Actualizar
                </button>

                <form action="Invoice_Controler" method="post" enctype="multipart/form-data">
                    <div class="card mb-4">
                        <div class="card-header">
                            <div class="col-4 col-lg-2 ms-auto">
                                <input  name="txtcodigoventa"
                                        id="txtcodigoventa"
                                        class="form-control text-end"
                                        value="${id}"
                                        readonly>
                            </div>
                        </div>

                        <div class="card-body">
                            <div class="row row-cols-2">
                                <div class="col-12 col-lg-9 mb-4 mb-lg-0">
                                    <label for="txtnombre">Nombre del Cliente</label>
                                    <input  list="dl-clients"
                                    		type="text"
                                            class="form-control mt-2"
                                            placeholder="Ingrese el nombre"
                                            id="txtnombre"
                                            autocomplete="off">
                                </div>

                                <div class="col-12 col-lg-3">
                                    <label for="txtcedulacliente">Cédula</label>
                                    <input  type="number"
                                            class="form-control mt-2"
                                            placeholder="000"
                                            name="txtcedulacliente"
                                            id="txtcedulacliente" readonly>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card mb-4">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th class="col">#</th>
                                            <th class="col-1">Código</th>
                                            <th class="col-3">Nombre</th>
                                            <th class="col-3">Cantidad</th>
                                            <th class="col-3">Valor total</th>
                                            <th class="col"></th>
                                            <th class="col"></th>
                                        </tr>
                                    </thead>
    
                                    <tbody>
                                        <tr>
                                            <th>1</th>
                                            
                                            <td>
                                                <input  type="number"
                                                        class="code_product form-control h-100"
                                                        placeholder="000"
                                                        readonly>
                                            </td>
                                            
                                            <td>
                                                <input  list="dl-products"
                                                		type="text"
                                                        class="name_product form-control h-100"
                                                        placeholder="Nombre del producto">
                                            </td>
    
                                            <td>
                                                <input  type="number"
                                                        class="amount_product form-control h-100"
                                                        placeholder="Cantidad" min="1" pattern="^[0-9]+">
                                            </td>
    
                                            <td>
                                                <input  type="number"
                                                        class="value_product form-control h-100"
                                                        iva="0"
                                                        placeholder="$$$"
                                                        readonly>
                                            </td>
    
                                            <td>
                                                <button class="btn_new_product btn btn-success w-100" disabled>
                                                	<i class="fas fa-cart-plus text-primary"></i>
                                                </button>
                                            </td>
                                            <td>
                                                <button class="btn_delete_product btn btn-danger w-100">
                                                	<i class="far fa-trash-alt"></i>
                                                </button>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>                    

                    <div class="col-5 text-end ms-auto">
                        <table class="table">
                            <tbody>
                                <tr style="border-style: hidden">
                                    <th class="align-middle">Total:</th>
                                    <td>
                                        <input  type="number"
                                        class="form-control h-100 border-0 text-center"
                                        placeholder="$$$"
                                        name="txtvalor"
                                        id="txtvalor" readonly>
                                    </td>
                                </tr>

                                <tr style="border-style: hidden">
                                    <th class="align-middle">Total Iva:</th>
                                    <td>
                                        <input  type="number"
                                        class="form-control h-100 border-0 text-center"
                                        placeholder="$$$"
                                        name="txtiva"
                                        id="txtiva" readonly>
                                    </td>
                                </tr>

                                <tr style="border-style: hidden">
                                    <th class="align-middle">Total con Iva:</th>
                                    <td>
                                        <input  type="number"
                                        class="form-control h-100 border-0 text-center"
                                        placeholder="$$$"
                                        name="txtvalorFinal"
                                        id="txtvalorFinal" readonly>
                                    </td>
                                </tr>

                                <tr style="border-style: hidden">
                                    <th></th>
                                    <td>
                                        <input type="submit" name="accion" value="facturar" class="btn btn-success w-100" id="buy" disabled>
                                    	<input type="number" class="d-none" name="userID" value="<%=request.getAttribute("userID")%>" />
                                    	<input type="text" class="d-none" name="data_products" id="data_products" />
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </form>
            </div>
        </div>
    </div>

	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="js/ventas.js"></script>
    <script src="librerias/avgrund.js"></script>
</body>
</html>