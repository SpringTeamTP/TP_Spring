package pDaoProjetJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import JPAClass.Client;
import JPAClass.ClientEI;
import pDao.Application;



@Repository
@Transactional
public class ClientEIDaoJpa implements ClientEIDao {
	

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<ClientEI> findAll() {
		Query query = em.createQuery("from ClientEI");
		return query.getResultList();
	}

	@Override
	public ClientEI find(Long id) {
		return em.find(ClientEI.class, id);
	}

	@Override
	public void create(ClientEI obj) {
		em.persist(obj);
		
	}

	@Override
	public ClientEI update(ClientEI obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(ClientEI obj) {
		em.remove(em.merge(obj));
		
	}

}










