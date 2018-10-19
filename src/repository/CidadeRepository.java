package repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Cidade;
import model.Cliente;

public class CidadeRepository extends Repository<Cidade> {
	
	
	public CidadeRepository(EntityManager entityManager) {
		super(entityManager);
	}
	
	
	public List<Cidade> getCidades(String nome) {
		
		Query query = 
				getEntityManager().
					createQuery("SELECT c FROM Cidade c WHERE lower(c.nome) like lower(:nome) Order by c.nome ");
		query.setParameter("nome", "%" + nome + "%");
		
		List<Cidade> lista = query.getResultList();
	
		if (lista == null)
			lista = new ArrayList<Cidade>();
		
		return lista;
	}

}
