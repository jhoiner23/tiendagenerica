<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	String name = "";
	String id = "";
	if (request.getAttribute("name") != null)
	{
		name = (String)request.getAttribute("name");
		id = (String)request.getAttribute("id");
	}
%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<meta charset="ISO-8859-1">
	<title>Menu</title>
	<link  rel="icon" href="img/favicon.png" type="image/png" />
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
	<link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="css/nav.css">
    
    <style>
    	#salir a{color: var(--bs-red); cursor:pointer;}
    	#salir:hover a{ color: var(--purple_300); }
    </style>
</head>
<body>
	<header class="header">
        <nav class="header__nav">
            <div class="header__logo">
                <div class="d-flex justify-content-start align-items-center"
                        style="height:40px;">
                        <img src="img/logo.png"
                                alt="logo"
                                class="h-100">
                        <span class="text-primary fw-bold fs-2">StoreApp</span>
                </div>
            </div>
       
            <div class="header__links hide-mobile">
                <a href="User_Controlador?userID=<%=id%>" target="myFrame">Usuarios</a>
                <a href="Customer_Controlador?userID=<%=id%>" target="myFrame">Clientes</a>
            	<a href="Reporte_ventas?userID=<%=id%>" target="myFrame">Ventas por cliente</a>
                <a href="Vendor_Controlador?userID=<%=id%>" target="myFrame">Proveedores</a>
                <a href="Invoice_Controler?userID=<%=id%>" target="myFrame">Facturas</a>
            	<div class="user d-inline-block" id="salir">
          			<a href="index.jsp" class="m-0"><%=name%> [Salir]</a>
            	</div>
            </div>

            <a href="#" class="header__mobile-menu hide-desktop" id="headerMenu">
                <span></span>
                <span></span>
                <span></span>
            </a>
        </nav>
    </header>
	
	
	<div class="iframe_html" style="height: calc(100vh - 100px);">
		<iframe class="w-100 h-100" name="myFrame"></iframe>
	</div>
	
    <script src="js/nav.js"></script>
</body>
</html>