<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Tarea</title>
</head>
<body>

<script>
function alerta(Msg){
	alert(Msg+" está vacío");
}
function validate(){
	var titulo=document.forms["addnewtask"]["Titulo"].value;
	var categoria=document.forms["addnewtask"]["Categoria"].value;
	var propietario=document.forms["addnewtask"]["Propietario"].value;
	var descripcion=document.forms["addnewtask"]["Descripcion"].value;
	var fechadeentrega=document.forms["addnewtask"]["FechaDeEntrega"].value;
	
	if(!titulo){
		alerta("Titulo");
		return false;
	}else if(!categoria){
		alerta("Categoria");
		return false;
	}else if(!propietario){
		alerta("Propietario");
		return false;
	}else if(!descripcion){
		alerta("Descripción");
		return false;
	}else if(!fechadeentrega){
		alerta("Fecha de entrega");
		return false;
	}
	return true;
}
</script>

<form name="addnewtask" method="post" action="AgregarTareaServlet" onsubmit="return validate()"> 
    <table>
	<tr>
	<td>Titulo</td>
	<td>
	<input type="text" name="Titulo">
	</td>
	</tr>
	<tr>
	<td>Categoria</td>
	<td>
	<input type="text" name="Categoria">
	</td>
	</tr>
	<tr>
	<td>Propietario</td>
	<td>
	<input type="text" name="Propietario">
	</td>
	</tr>
	<tr>
	<td>Descripcion</td>
	<td>
	<input type="text" name="Descripcion">
	</td>
	</tr>
	<tr>
	<td>Fecha de entrega</td>
	<td>
	<input type="text" name="FechaDeEntrega">
	</td>
	</tr>
	
	<tr>
    <td>Estado:</td>
	<td>
	<select name=\"Estado\">
	<option value=\"BACKLOG\"selected>BackloG</option>
	<option value=\"TO_DO\">To do</option>
	<option value=\"IN_PROGRESS\">In progress</option>
	<option value=\"DONE\">done</option>
	</select>
	</td>
	</tr>
	
	<tr>
	<td>Prioridad</td>
	<td>
	<select name=\"Prioridad\">
	<option value=\"3\" selected>Baja</option>
	<option value=\"2\">Media</option>
	<option value=\"1\">Alta</option>
	</select>
	</td>
	</tr>
	
	

		<tr>
		<td>
		<input type="submit" name="agregar" value="Agregar Cliente">
				</td>
				</tr>
				</table>
				</form>

</body>
</html>