package pDaoProjetJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import JPAClass.ClientMoral;
import JPAClass.ClientPhysique;
import pDao.Application;


@Repository
@Transactional
public class ClientPhysiqueDaoJpa implements ClientPhysiqueDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<ClientPhysique> findAll() {
		Query query = em.createQuery("from ClientPhysique");
		return query.getResultList();
	}

	@Override
	public ClientPhysique find(Long id) {
		return em.find(ClientPhysique.class, id);
	}

	@Override
	public void create(ClientPhysique obj) {
		em.persist(obj);
		
	}

	@Override
	public ClientPhysique update(ClientPhysique obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(ClientPhysique obj) {
		em.remove(em.merge(obj));
	}

}










