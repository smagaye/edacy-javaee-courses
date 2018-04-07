package sn.edacy.web.cohort;


import javax.enterprise.inject.Model;
import javax.inject.Inject;

import sn.edacy.business.CohortService;
import sn.edacy.model.Cohort;

@Model
public class CreateCohortBean {
	
	private Cohort cohort = new Cohort();
	
	@Inject
	private CohortService cohortService;
	
	/**
	 * Called when user save the object
	 */
	public void create() {
		cohortService.saveCohort(cohort);
		
		System.out.println("Nom de la cohorte " + cohort.getName() + " id: "+ cohort.getId());
	}
	
	public String navigateToHome() {
		return "/index";
	}

	public Cohort getCohort() {
		return cohort;
	}

	public void setCohort(Cohort cohort) {
		this.cohort = cohort;
	}
}
