package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Comentarios;
import model.Noticias;

public class ComentarioDAO {
private Connection conexao;
	
	public ComentarioDAO() {
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Comentarios n) {
			
		String inserir = "INSERT INTO comentario "
				+ " ( nome, texto, fk_noticia_id) "
				+ " VALUES ( ?, ?, ?) ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
		
			pst.setString(1, n.getNome());
			pst.setString(2, n.getTextoComentario());
			pst.setInt(3, n.getIdNoticia());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Comentarios.");
			ex.printStackTrace();
			
		}
	}
public Comentarios consultar(int id) {
		
		String inserir = "SELECT * FROM comentario"
				+ " WHERE fk_noticia_id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, id);
			ResultSet resultado = pst.executeQuery();
			
			Comentarios p = new Comentarios();
			if (resultado.next()) {
				p.setNome(resultado.getString("nome"));
				p.setTextoComentario(resultado.getString("texto"));
			}
			return p;
			
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Noticias.");
			ex.printStackTrace();
			
			return null;
		}
	}


public ArrayList<Comentarios> listarComentario() {
		
		String inserir = "SELECT * FROM comentario";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Comentarios> lista = new ArrayList<>();
			while (resultado.next()) {
				Comentarios p = new Comentarios();
				p.setNome(resultado.getString("nome"));
				p.setTextoComentario(resultado.getString("texto"));
				p.setIdNoticia(resultado.getInt("fk_noticia_id"));
				p.setIdComentario(resultado.getInt("id"));
				lista.add(p);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Comentarios.");
			ex.printStackTrace();
			
			return null;
		}
}

}

