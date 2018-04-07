package sn.edacy.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import sn.edacy.business.utils.CohortSearch;
import sn.edacy.model.Cohort;

@Stateless
public class CohortService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Save a new cohort
	 * @param cohort
	 */
	public void saveCohort(Cohort cohort) {
		entityManager.persist(cohort);
	}
	
	/**
	 * Return all cohorts
	 * @return
	 */
	public List<Cohort> getAll() {
		Query query = entityManager.createQuery("select c from Cohort c");
		return query.getResultList();
	}
	
	/**
	 * Search cohort by name and identifier
	 * @return
	 */
	public List<Cohort> search(CohortSearch cohortSearch) {
		
		Long id = NumberUtils.toLong(cohortSearch.getIdentifier());
		String queryString = "select c from Cohort c where 1=1 ";
		if(StringUtils.isNotEmpty(cohortSearch.getIdentifier()) && id > 0) {
			queryString += " and c.id = :ident";
		}
		if(StringUtils.isNotEmpty(cohortSearch.getName())) {
			queryString += " and c.name like :fullName";
		}
		Query query = entityManager.createQuery(queryString);
		
		if(StringUtils.isNotEmpty(cohortSearch.getIdentifier()) && id > 0) {
			query.setParameter("ident", NumberUtils.toLong(cohortSearch.getIdentifier()));
		}
		if(StringUtils.isNotEmpty(cohortSearch.getName())) {
			query.setParameter("fullName", "%" + cohortSearch.getName() + "%");
		}
		return query.getResultList();
	}

}
