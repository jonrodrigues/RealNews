package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NoticiasDAO;
import model.Comentarios;
import model.Noticias;



@WebServlet("/ListarNoticia.do")
public class ListarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Comentarios c = new Comentarios();
		Noticias n = new Noticias();
		NoticiasDAO nDAO = new NoticiasDAO();
		
		HttpSession sessao = request.getSession();
		PrintWriter saida =  response.getWriter();
		ArrayList<Noticias> lista = nDAO.listarNoticias();
		
		lista.add(c);
		// Adicionando a lista de contatos à sessão do usuário:
		sessao.setAttribute("lista_contatos", lista);
		response.setContentType("text/html");
		
		for (int i = 0; i < lista.size(); i++) {
			String titulo1 = lista.get(i).getTitulo();
			String cadtexto1 = lista.get(i).getTextoNoticia();
			int idNoticia = lista.get(i).getIdNoticia();
		saida.print("<h1>"+titulo1 +"</h1>");
		saida.print("<p>"+cadtexto1+"</p>");
		
		saida.print("<h4>Comentarios</h4><div>" +
				"<form name=\"comentario\" action=\"CadastrarComent.do\" method=\"post\">\r\n" + 
				"<h5>Adicionar Comentarios</h5>\r\n" + 
				"<br> \r\n" + 
				"<div >\r\n" + 
				"<label>Nome:</label>\r\n" + 
				"<input type=\"text\" name=\"nomeUsuario\" style=\"width: inherit;\"min=\" 0\"/>\r\n" + 
				"<br> \r\n" + 
				"<label>Comentario:</label>\r\n" + 
				"<textarea name=\"comentario\" id=\"obs\" rows=\"3\" cols=\"58\"></textarea>\r\n" + 
				"<br>\r\n" + 
				"<input type='hidden' name='idComentario' style='width: inherit'; value="+idNoticia+">" + 
				"<div class=\"Enviar\">\r\n" + 
				"<button type=\"submit\" value=\"Enviar\" class=\"btn btn-success\">Enviar</button>\r\n" + 
				"</div>\r\n" + 
				"</form>");
		}
	}

       
	}


