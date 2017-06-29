package pDaoProjetJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import JPAClass.ClientEI;
import JPAClass.ClientMoral;
import pDao.Application;


@Repository
@Transactional
public class ClientMoralDaoJpa implements ClientMoralDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<ClientMoral> findAll() {
		Query query = em.createQuery("from ClientMoral");
		return query.getResultList();
	}

	@Override
	public ClientMoral find(Long id) {
		return em.find(ClientMoral.class, id);
	}

	@Override
	public void create(ClientMoral obj) {
		em.persist(obj);
		
	}

	@Override
	public ClientMoral update(ClientMoral obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(ClientMoral obj) {
		em.remove(em.merge(obj));
		
	}




	
}









