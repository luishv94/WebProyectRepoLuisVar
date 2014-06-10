package kaban;




import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kaban.Programa;
import kaban.State;
import kaban.Tarea;

/**
 * Servlet implementation class AgregarTareaServlet
 */
public class AgregarTareaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer= response.getWriter();
		writer.print("<html>"
				+"<head>"
				+"<title>Add task</title>"
				+"</head>"
				+"<body>"
				+"<form method=\"POST\">"
				+"<table>"
				+"<tr>"
				+"<td>Titulo:</td>"
				+"<td>"
				+"<input type=\"text\" name=\"Titulo\"/>"
				+"</td>"
				+"</tr>"
				+"<td>Categoria:</td>"
				+"<td>"
				+"<input type=\"text\" name=\"Categoria\"/>"
				+"</td>"
				+"</tr>"
				+"<td>Propietario:</td>"
				+"<td>"
				+"<input type=\"text\" name=\"Propietario\"/>"
				+"</td>"
				+"</tr>"
				+"<td>Descripcion:</td>"
				+"<td>"
				+"<input type=\"text\" name=\"Descripcion\"/>"
				+"</td>"
				+"</tr>"
				+"<td>Fecha de Entrega:</td>"
				+"<td>"
				+"<input type=\"text\" name=\"FechaDeEntrega\"/>"
				+"</td>"
				+"</tr>"
				
+"<tr>"
+"<td>Estado:</td>"
+"<td>"
+"<select name=\"Estado\">"
+"<option value=\"BACKLOG\"selected>Backlog</option>"
+"<option value=\"TO_DO\">To do</option>"
+"<option value=\"IN_PROGRESS\">In progress</option>"
+"<option value=\"DONE\">done</option>"
+"</select>"	
+"</td>"
+"</tr>"

				
				+"<tr>"
				+"<td>Prioridad</td>"
				+"<td>"
				+"<select name=\"Prioridad\">"
				+"<option value=\"Baja\" selected>Baja</option>"
				+"<option value=\"Media\">Media</option>"
				+"<option value=\"Alta\">Alta</option>"
				+"</select>"
				+"</td>"
				+"</tr>"
				+"<tr>"
				+"<td colspan=\"2\">"
				+"<input type=\"submit\" value=\"Add\" />"
				+"</td>"
				+"</tr>"
				+"</table>"
				+"</form>"	
				+"</body>"
				+"</html>"
				
				);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Tarea task = new Tarea();
		PrintWriter writer = response.getWriter();

		task.setTitulo(request.getParameter("Titulo"));
		task.setCategoria(request.getParameter("Categoria"));
		task.setPropietario(request.getParameter("Propietario"));
		task.setDescripcion(request.getParameter("Descripcion"));
		task.setFechaDeEntrega(request.getParameter("FechaDeEntrega"));
		
		try {
			task.setState(State.valueOf(request.getParameter("Estado")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			task.setPriority(Short.parseShort(request.getParameter("priority")));
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		Programa.dashboard.add(task);

		response.setContentType("text/html");
		writer.print("<html><body>" + task.toHtml() + "</body></html>");
		/*writer.print("<html>"
				+"<body>"
				+"Title: "+task.getTitulo()
				+"<br>"
				+"Description: "+task.getDescripcion()
				+"<br>"
				+"Owner: "+task.getPropietario()
				+"<br>"
				+"Category: "+task.getCategoria()
				+"<br>"
				+"Due Date: "+task.getFechaDeEntrega()
				+"<br>"
				+"Priority: "+task.getPrioridad()
				+"<br>"
				+"State: "+task.getEstado()
				+"</body>"
				+"</html>");*/
	}
	

}
