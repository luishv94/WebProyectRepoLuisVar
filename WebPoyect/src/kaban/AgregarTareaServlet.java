package kaban;

//Import classes Tarea




import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AgregarTareaServlet
 */
public class AgregarTareaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter  writer = response.getWriter();
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
				+"<input type=\"Text\" name\"titulo\">"
				+"</td>"
				+"</tr>"
				+"<td>Categoria:</td>"
				+"<td>"
				+"<input type=\"Text\" name\"Categoria\">"
				+"</td>"
				+"</tr>"
				+"<td>Propietario:</td>"
				+"<td>"
				+"<input type=\"Text\" name\"Propietario\">"
				+"</td>"
				+"</tr>"
				+"<td>Descripcion:</td>"
				+"<td>"
				+"<input type=\"Text\" name\"Descripcion\">"
				+"</td>"
				+"</tr>"
				+"<td>Fecha de Entrega:</td>"
				+"<td>"
				+"<input type=\"Text\" name\"FechaDeEntrega\">"
				+"</td>"
				+"</tr>"
				+"<tr>"
				+"<td>Estado</td>"
				+"<td>"
				+"<select>"
				+"<option value=\"BACKLOG\" selected>Backlog</option>"
				+"<option value=\"TO_DO\">To do</option>"
				+"<option value=\"IN_PROGRESS\">In Progress</option>"
				+"<option value=\"DONE\">Done</option>"
				+"</select>"
				+"</td>"
				+"</tr>"
				+"<tr>"
				+"<td>Prioridad</td>"
				+"<td>"
				+"<select>"
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

		task.setTitulo(request.getParameter("titulo"));
		task.setCategoria(request.getParameter("Categoria"));
		task.setPropietario(request.getParameter("Propietario"));
		task.setDescripcion(request.getParameter("Descripcion"));
		task.setFechaDeEntrega(request.getParameter("FechaDeEntrega"));
		
		try {
			task.setState(State.valueOf(request.getParameter("state")));
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
		PrintWriter writer = response.getWriter();
		writer.print("<html><body>" + task.toHtml() + "</body></html>");
	}
	

}
