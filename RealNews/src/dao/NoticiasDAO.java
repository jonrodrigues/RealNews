package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Noticias;

public class NoticiasDAO {
	private Connection conexao;
	
	public NoticiasDAO() {
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Noticias n) {
			
		String inserir = "INSERT INTO noticia "
				+ " ( descricao, titulo, texto) "
				+ " VALUES ( ?, ?, ?) ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
		
			pst.setString(1, n.getDescricao());
			pst.setString(2, n.getTitulo());
			pst.setString(3, n.getTextoNoticia());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Noticias.");
			ex.printStackTrace();
			
		}
	}
	
	public void alterar(Noticias n) {
		
		String inserir = "UPDATE noticia "
				+ "SET descricao = ?, titulo = ?, texto = ? "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setString(1, n.getDescricao());
			pst.setString(2, n.getTitulo());
			pst.setString(3, n.getTextoNoticia());
			pst.setInt(4, n.getIdNoticia());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Noticias.");
			ex.printStackTrace();
			
		}
	}
	
	public void excluir(Noticias noticia) {
		
		String inserir = "DELETE FROM noticia "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, noticia.getIdNoticia());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Noticias.");
			ex.printStackTrace();
		}
	}
	
	public Noticias consultar(int id) {
		
		String inserir = "SELECT * FROM notcia"
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, id);
			ResultSet resultado = pst.executeQuery();
			
			Noticias p = new Noticias();
			if (resultado.next()) {
				p.setDescricao(resultado.getString("descricao"));
				p.setTitulo(resultado.getString("titulo"));
				p.setIdNoticia(id);
				p.setTextoNoticia(resultado.getString("texto"));
			}
			return p;
			
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Noticias.");
			ex.printStackTrace();
			
			return null;
		}
	}

	
	public ArrayList<Noticias> listarNoticias() {
		
		String inserir = "SELECT * FROM noticia";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Noticias> lista = new ArrayList<>();
			while (resultado.next()) {
				Noticias p = new Noticias();
				p.setDescricao(resultado.getString("descricao"));
				p.setTitulo(resultado.getString("titulo"));
				p.setIdNoticia(resultado.getInt("id"));
				p.setTextoNoticia(resultado.getString("texto"));
				lista.add(p);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Noticias.");
			ex.printStackTrace();
			
			return null;
		}
	}

}
