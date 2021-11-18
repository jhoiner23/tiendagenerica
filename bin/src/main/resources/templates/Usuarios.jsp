<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.G3.CiCLO03.TiendaFrontEnd03.model.Users"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Usuarios CRUD</title>
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/styles.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
</head>
<body class="py-5">
    <div class="container card o-hiddend border-0">
        <div class="card-body p-0">
        
            <div class="row py-4 px-3 px-md-5">
        
                <div class="col-12">
                    <h1 class="fw-bold"> Usuarios </h1>
                    <p>Interfaz para administrar los usuarios que administren la tienda</p>
                    <hr class="my-4">
                </div>


                <!-- lista -->
                <div class="col-12 col-lg-8 pe-3 mb-4 mb-lg-0">
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="headingOne">
                            <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                              Listado
                            </button>
                        </h2>
                        <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                            <div class="accordion-body p-0">
                                <table class="table table-secondary table-striped table-borderless mb-0">
                                    <thead class="table-dark">
                                        <th class="col-4">ID</th>
                                        <th class="col-4">Usuario</th>
                                        <th class="col-4">Contraseña</th>
                                        <th></th>
                                        <th></th>
                                    </thead>
                                    <tbody>
                                    	<%
                                   		ArrayList<Users> list = (ArrayList<Users>)request.getAttribute("list");
                                   		for( Users user: list ){
                                    		if( user.getCedula_usuario() != 0){
                                    	%>
	                                        <tr>
	                                        	<th> <%=user.getCedula_usuario() %> </th>
	                                            <td> <%=user.getUsuario() %> </td>
	                                            <td> <%=user.getPassword() %> </td>
	                                            <td>
	                                                <a class="btn btn-warning" href="User_Controlador?accion=editar&txtcedula=<%=user.getCedula_usuario() %>">
	                                                    <i class="fas fa-edit"></i>
	                                                </a>
	                                            </td>
	                                            <td>
	                                                <a class="btn btn-danger" href="User_Controlador?accion=eliminar&txtcedula=<%=user.getCedula_usuario() %>">
	                                                    <i class="far fa-trash-alt"></i>
	                                                </a>
	                                            </td>
	                                        </tr>
                                        <%}}%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                
                <!-- formulario -->
                <div class="col-12 col-lg-4 ps-3 border border-primary py-3">
                	<%  //Este pedazo me permite dar avisos en caso de guardar o editar
						String msj = (String)request.getAttribute("msj");
						if( msj != null ){
                			String value = (String)request.getAttribute("value");
							String path, bg;
							if( value.equals("true") ){ bg="alert-success";	path = "M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z";}
							else 					  { bg="alert-danger"; path = "M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z";}
					%>	
							<div class="alert <%=bg%> d-flex align-items-center" role="alert">
							  	<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-exclamation-triangle-fill flex-shrink-0 me-2" viewBox="0 0 16 16" role="img" aria-label="Warning:">
							    	<path d="<%=path%>"/> 
							  	</svg>
							 	<div><%=msj%></div>
							</div>
					<% }%>
                
                    <form method="post" action="User_Controlador">
                        <div class="row row-cols-2">
                            <div class="col-12 mb-4">
                                <label for="txtcedula">Cedula</label>
                                <input  type="number"
                                        class="form-control mt-2"
                                        placeholder="Ingrese la cedula"
                                        value="${userSelect.getCedula_usuario()}"
                                        name="txtcedula"
                                        id="txtcedula"
                                       	<%if( request.getAttribute("userSelect") != null ){%>
                                       		readonly
                                       	<%}%>
                                        >
                            </div>
                
                            <div class="col-12 mb-4">
                                <label for="txtnombre">Nombre Completo</label>
                                <input  type="text"
                                        class="form-control mt-2"
                                        placeholder="Ingrese el nombre completo"
                                        value="${userSelect.getNombre_usuario()}"
                                        name="txtnombre"
                                        id="txtnombre">
                            </div>
                
                            <div class="col-12 mb-4">
                                <label for="txtusuario">Usuario</label>
                                <input  type="text"
                                        class="form-control mt-2"
                                        placeholder="Ingrese el nombre para logearse"
                                        value="${userSelect.getUsuario()}"
                                        name="txtusuario"
                                        id="txtusuario">
                            </div>
            
                            <div class="col-12 mb-4">
                                <label for="txtemail">Email</label>
                                <input  type="email"
                                        class="form-control mt-2"
                                        placeholder="Ingrese el correo"
                                        value="${userSelect.getEmail_usuario()}"
                                        name="txtemail"
                                        id="txtemail">
                            </div>
                
                            <div class="col-12  mb-4">
                                <label for="txtpassword">Contraseña</label>
                                <input  type="password"
                                        class="form-control mt-2"
                                        placeholder="Ingrese la contraseña"
                                        value="${userSelect.getPassword()}"
                                        name="txtpassword"
                                        id="txtpassword">
                            </div>
                        </div>
						
						<%if( request.getAttribute("userSelect") == null ){%> <input type="submit" name="accion" id="btn" value="crear" class="btn btn-primary w-100 mb-4 mb-lg-0 py-2"/>
                    	<%} else {%> <input type="submit" name="accion" id="btn" value="actualizar" class="btn btn-success w-100 mb-4 mb-lg-0 py-2"/><%}%>
                    </form>
                </div>

            </div>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>