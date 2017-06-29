package pDaoProjetJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import JPAClass.Escale;
import pDao.Application;

@Repository
@Transactional
public class EscaleDaoJpa implements EscaleDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Escale> findAll() {
		Query query = em.createQuery("from Escale");
		return query.getResultList();
	}

	@Override
	public Escale find(Long id) {
		return em.find(Escale.class, id);	
	}

	@Override
	public void create(Escale obj) {
		em.persist(obj);
	}

	@Override
	public Escale update(Escale obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Escale obj) {
			em.remove(em.merge(obj));
	}

}






