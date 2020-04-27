package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ComentarioDAO;
import model.Comentarios;
import model.Noticias;
import service.ComentarioService;


@WebServlet("/CadastrarComent.do")
public class CadastrarComent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Comentarios> lista = new ArrayList<Comentarios>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {





	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String nome = request.getParameter("nomeUsuario");
		String texto = request.getParameter("comentario");
		int idC =Integer.parseInt(request.getParameter("idComentario"));

		Comentarios c = new Comentarios();
		c.setNome(nome);
		c.setTextoComentario(texto);
		c.setIdNoticia(idC);


		ComentarioDAO cDAO = new ComentarioDAO();
		ComentarioService serv = new ComentarioService();
		serv.cadastrar(c);

		PrintWriter saida =  response.getWriter();
		HttpSession sessao = request.getSession();


		@SuppressWarnings("unchecked")
		ArrayList<Noticias> lista = (ArrayList<Noticias>)sessao.getAttribute("lista_contatos"); 
		for (int i = 0; i < lista.size(); i++) {
			String titulo1 = lista.get(i).getTitulo();
			String cadtexto1 = lista.get(i).getTextoNoticia();
			int idNoticia = lista.get(i).getIdNoticia();

			saida.print("<h1>"+titulo1 +"</h1>");
			saida.print("<p>"+cadtexto1+"</p>");
			saida.print("<p>"+idNoticia+"</p>");
			saida.print("<h4>Comentarios</h4><div>" +
					"<form name=\"comentario\" action=\"CadastrarComent.do\" method=\"post\">\r\n");
			saida.print(cDAO.consultar(idNoticia));
			if(idC == idNoticia) {
				saida.print(
						"Nome do Usuário: "+ c.getNome() +"<br>"+
								"Comentario: " +c.getTextoComentario()
								+"<br>");
				}
			saida.print("<h5>Adicionar Comentarios</h5>\r\n" + 

				"<br> \r\n" + 
				"<div style=\"border-bottom: 1px solid #111111\">\r\n" + 
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

		//RequestDispatcher d = request.getRequestDispatcher("Index.jsp");
		//request.setAttribute("lista", lista);

		//request.setAttribute("nomeUsuario",nome);
		//request.setAttribute("comentario",nome);
		//d.forward(request, response);


	}

}
