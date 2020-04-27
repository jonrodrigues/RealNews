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

import model.Comentarios;
import model.Noticias;

import service.NoticiaService;
import dao.NoticiasDAO;


@WebServlet("/CadastrarNoticia.do")
public class CadastrarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String descricao = request.getParameter("caddescricao");
		String titulo = request.getParameter("titulo");
		String textoNoticia = request.getParameter("cadtexto");

		Noticias n = new Noticias();
		n.setDescricao(descricao);
		n.setTitulo(titulo);
		n.setTextoNoticia(textoNoticia);

		NoticiasDAO nDAO = new NoticiasDAO();
		NoticiaService noticiaService = new NoticiaService();
		noticiaService.cadastrar(n);


		PrintWriter saida =  response.getWriter();
		ArrayList<Noticias> lista = nDAO.listarNoticias();
		response.setContentType("text/html");
		for (int i = 0; i < lista.size(); i++) {
			String titulo1 = lista.get(i).getTitulo();
			String cadtexto1 = lista.get(i).getTextoNoticia();

			saida.print("<h1>"+titulo1 +"</h1>");
			saida.print("<p>"+cadtexto1+"</p>");

		}
	}

}
