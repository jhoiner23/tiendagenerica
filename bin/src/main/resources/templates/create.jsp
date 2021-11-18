<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Crear usuario</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
 integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<div class="container">
<H1>Crear usuario</H1>

<form th:action="@{/save}"  method="post">
<div class="mb-3">

  <label for="formGroupExampleInput" class="form-label">NOMBRE</label>
  <input type="text" class="form-control" name="nombre" id="formGroupExampleInput" placeholder="Escriba el nombre del usuario">
</div>
<div class="mb-3">
  <label for="formGroupExampleInput2" class="form-label">USUARIO</label>
  <input type="text" class="form-control" name="usuario" id="formGroupExampleInput2" placeholder="Escriba la descripción del usuario">
</div>
<div class="mb-3">
  <label for="formGroupExampleInput3"  class="form-label">correo</label>
  <input type="text" class="form-control" name="correo" id="formGroupExampleInput2" placeholder="El correo">
</div>
<div class="mb-3">
  <label for="formGroupExampleInput3"  class="form-label">password</label>
  <input type="text" class="form-control" name="password" id="formGroupExampleInput2" placeholder="El password">
</div>

<button type="submit" class="btn btn-success">Guardar</button>
</form>

</div>
</body>
</html>