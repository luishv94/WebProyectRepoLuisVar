<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import ="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<script>

function alertMessage(alert_msg){
	var alert_msg="Message:"+msg;
	alert(alert_msg);
}

alert("Antes del usar el Copyright");

</script>

<%--Esto es un comentario JSP --%>
<!-- Esto es un comentario HTML -->
<%--http://localhost:8080/WebPoyect/AddTaskForm.jsp?test=hi --%>
<%--String test= request.getParameter("test");
out.println(test);
--%>
<%out.println("Hello World"+new Date().toString()); %>
<%@include file="Copyright.jspf" %>

<%
String[] values=new String[3];
values[0]="test";
values[1]="test1";
values[2]="test2";


for(String value:values){
out.println("<div>"+value+"</div>");
}
%>

<%--La linea 31 y la linea 17 son iguales --%>
<%="Hello World"+new Date().toString()%>

<script>
alertMesagge("Despues de fecha");
</script>
</body>
</html>