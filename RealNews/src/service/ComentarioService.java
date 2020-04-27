package service;

import javax.swing.JOptionPane;

import dao.ComentarioDAO;
import model.Comentarios;

public class ComentarioService {
	ComentarioDAO cDAO = new ComentarioDAO();
	
	public void cadastrar(Comentarios c) {
		if(c.getTextoComentario().contentEquals("" )) {
			return;
		}
		if(c.getNome().contentEquals("")) {
			return;
		}
		cDAO.cadastrar(c);
	}
}
