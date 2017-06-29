package pDaoProjetJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import JPAClass.Aeroport;
import JPAClass.Vol;
import pDao.Application;

@Repository
@Transactional
public class VolDaoJpa implements VolDao {

	@PersistenceContext
	// Recherche un bean spring de type EntityManagerFactory et appelle la
	// méthode .createEntityManager()
	private EntityManager em;
	
	
	@Override
	public List<Vol> findAll() {
	
		
		

			Query query = em.createQuery("from Vol");
			return query.getResultList();
			
	
	}

	@Override
	public Vol find(Long id) {
		

			return em.find(Vol.class, id);
			
	
	}

	@Override
	public void create(Vol obj) {
	
		
	

			em.persist(obj);
		
	
		
	}

	@Override
	public Vol update(Vol obj) {
	

			return em.merge(obj);
			

	}

	@Override
	public void delete(Vol obj) {
		
		Vol vol = em.merge(obj);
		em.remove(vol);
			

	}





	
}

