package repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Usuario;

public class UsuarioRepository extends Repository<Usuario> {
	
	
	public UsuarioRepository(EntityManager entityManager) {
		super(entityManager);
	}
	
	
	public Usuario getUsuario(String login, String senha) {
		Query query = 
				getEntityManager().
					createQuery("SELECT "
							  + "  u "
							  + "FROM "
							  + "  Usuario u "
							  + "WHERE "
							  + "  u.login = :login AND u.senha = :senha");
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		
		List<Usuario> lista = query.getResultList();
	
		if (lista == null || lista.isEmpty())
			return null;
		
		return lista.get(0);
	}
	
	
	public List<Usuario> getUsuarios(String nome) {
		
		Query query = 
				getEntityManager().
					createQuery("SELECT u FROM Usuario u WHERE lower(u.nome) like lower(:nome) Order by u.nome ");
		query.setParameter("nome", "%" + nome + "%");
		
		List<Usuario> lista = query.getResultList();
	
		if (lista == null)
			lista = new ArrayList<Usuario>();
		
		return lista;
	}

}
