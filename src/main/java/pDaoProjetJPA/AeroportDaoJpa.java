package pDaoProjetJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import JPAClass.Aeroport;
import pDao.Application;

@Repository
@Transactional
public class AeroportDaoJpa implements AeroportDao {

	@PersistenceContext
	// Recherche un bean spring de type EntityManagerFactory et appelle la
	// méthode .createEntityManager()
	private EntityManager em;
		
	
	@Override
	public List<Aeroport> findAll() {

		Query query = em.createQuery("from Aeroport");
	
		return query.getResultList();
	}
	
	
	
	@Override
	public Aeroport find(Long id) {
	

	
		return em.find(Aeroport.class, id);
	}

	@Override
	public void create(Aeroport obj) {
		
		em.persist(obj);
	}

	@Override
	public Aeroport update(Aeroport obj) {
		
		return  em.merge(obj);
	}

	@Override
	public void delete(Aeroport obj) {
	
			Aeroport aeroport = em.merge(obj);
			em.remove(aeroport);
			
	
	}
	
}










