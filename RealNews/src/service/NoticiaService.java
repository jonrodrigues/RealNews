package service;

import dao.NoticiasDAO;

import model.Noticias;

public class NoticiaService {
	
private NoticiasDAO nDAO = new NoticiasDAO();
	
	
    public void cadastrar(Noticias n) {
    	if(n.getTitulo().length() > 126)
    		return;
    	if(n.getDescricao().length() > 14)
    		return;
    	 
    	nDAO.cadastrar(n);
    }
    
    public void alterar(Noticias n) {
    	if(n.getTitulo().length() > 126)
    		return;
    	if(n.getDescricao().length() > 14)
    		return;
    	 if(n.getIdNoticia() == 0)
    		 return;
    	nDAO.alterar(n);
    }
    
    

}
