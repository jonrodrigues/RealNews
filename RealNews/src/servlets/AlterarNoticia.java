package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NoticiasDAO;
import model.Noticias;


@WebServlet("/AlterarNoticia.do")
public class AlterarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int idNoticia =(Integer.parseInt(request.getParameter("id")));
			String titulo = request.getParameter("titulo");
			String textoNoticia = request.getParameter("alttexto");
			String descricao = request.getParameter("altdescricao");
			
			Noticias n = new Noticias();
			NoticiasDAO nDAO = new NoticiasDAO();
			PrintWriter saida = response.getWriter();
			n.setIdNoticia(idNoticia);
			n.setTitulo(titulo);
			n.setTextoNoticia(textoNoticia);
			n.setDescricao(descricao);
			nDAO.alterar(n);
			ArrayList<Noticias> lista = new ArrayList();
			lista.add(n);
			for(Noticias c: lista) {
				saida.print("Alterado com Sucesso");
				saida.println(
					"ID: "+ c.getIdNoticia() +  "<br>" +
					"Titulo: "+ c.getTitulo() +  "<br>" +
					"Texto: "+ c.getTextoNoticia() +  "<br>" +
					"Descrição: "+ c.getDescricao()  +  "<br>" 
						);
			}
	}

}
