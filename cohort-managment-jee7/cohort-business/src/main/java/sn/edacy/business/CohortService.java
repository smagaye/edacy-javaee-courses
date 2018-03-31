package sn.edacy.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sn.edacy.model.Cohort;
import sn.edacy.model.Talent;

@Stateless
public class CohortService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void saveCohort(Cohort cohort) {
		
	}
	
	/**
	 * @return list of cohorts
	 */
	public List<Cohort> getAllCohort() {
		Query query =  entityManager.createQuery("select c from Cohort c");
		return query.getResultList();
	}
}
