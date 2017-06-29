package pDaoProjetJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import JPAClass.Client;
import JPAClass.Passager;
import JPAClass.Reservation;
import pDao.Application;

@Repository
@Transactional
public  class ClientDaoJpa implements ClientDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Client> findAll() {
		Query query = em.createQuery("from Client");
		return query.getResultList();
	}

	@Override
	public Client find(Long id) {
		return em.find(Client.class, id);
	
	}

	@Override
	public void create(Client obj) {
		em.persist(obj);
		
	}

	@Override
	public Client update(Client obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Client obj) {
		em.remove(em.merge(obj));
		
	}

	
}





