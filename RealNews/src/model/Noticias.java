package model;

public class Noticias {
	
	private int idNoticia;
	private String descricao;
	private String titulo;
	private String textoNoticia;
	
	
public Noticias() {};
	
	public Noticias(int idNoticia, String descricao, String titulo, String textoNoticia) {
	
		this.idNoticia = idNoticia;
		this.descricao = descricao;
		this.titulo = titulo;
		this.textoNoticia = textoNoticia;
	}
	
	

	public int getIdNoticia() {
		return idNoticia;
	}

	public void setIdNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTextoNoticia() {
		return textoNoticia;
	}

	public void setTextoNoticia(String textoNoticia) {
		this.textoNoticia = textoNoticia;
	}

	@Override
	public String toString() {
		return "Noticias [idNoticia=" + idNoticia + ", descricao=" + descricao + ", titulo=" + titulo
				+ ", textoNoticia=" + textoNoticia + "]";
	}
	
	
	

	

}
