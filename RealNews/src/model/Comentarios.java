package model;

public class Comentarios extends Noticias{
	
	private int idComentario;
	private String nome;
	private String textoComentario;
	
	public Comentarios() {};

	

	


	public Comentarios(int idComentario, String nome, String textoComentario , int idNoticia, String descricao, String titulo, String textoNoticia) {
		super(idNoticia,descricao,titulo,textoNoticia);
		this.idComentario = idComentario;
		this.nome = nome;
		this.textoComentario = textoComentario;
	
	}






	public int getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTextoComentario() {
		return textoComentario;
	}

	public void setTextoComentario(String textoComentario) {
		this.textoComentario = textoComentario;
	}






	@Override
	public String toString() {
		return  " Nome: " + this.nome +"<br>"+
	"Comentario: " + this.textoComentario +"<br><br><br>";
	}
	
	
	

}
