package pDaoProjetJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import JPAClass.CompagnieAerienneVol;


@Repository
@Transactional
public class CompagnieAerienneVolDaoJpa implements CompagnieAerienneVolDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<CompagnieAerienneVol> findAll() {
		Query query = em.createQuery("from CompagnieAerienneVol");
		return query.getResultList();
	}

	@Override
	public CompagnieAerienneVol find(Long id) {
		return em.find(CompagnieAerienneVol.class, id);
	}

	@Override
	public void create(CompagnieAerienneVol obj) {
		em.persist(obj);
	}

	@Override
	public CompagnieAerienneVol update(CompagnieAerienneVol obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(CompagnieAerienneVol obj) {
		em.remove(em.merge(obj));
	}

}
