package sn.edacy.business;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sn.edacy.model.Cohort;
import sn.edacy.model.Talent;

@Stateless
public class TalentService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void saveTalent(Talent talent) {
		
	}
	
	public void saveCohort(Cohort cohort) {
		entityManager.persist(cohort);
	}
}
