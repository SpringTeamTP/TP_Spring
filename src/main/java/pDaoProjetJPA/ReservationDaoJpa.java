package pDaoProjetJPA;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


import JPAClass.Reservation;

@Repository
@Transactional
public class ReservationDaoJpa implements ReservationDao {

	@PersistenceContext
	// Recherche un bean spring de type EntityManagerFactory et appelle la
	// méthode .createEntityManager()
	private EntityManager em;

	@Override
	public List<Reservation> findAll() {
		Query query = em.createQuery("from Reservation");
		return query.getResultList();
	}

	@Override
	public Reservation find(Long id) {
		return em.find(Reservation.class, id);
	}

	@Override
	public void create(Reservation obj) {
		em.persist(obj);
	}

	@Override
	public Reservation update(Reservation obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Reservation obj) {
		
		em.remove(em.merge(obj));
	}

}
