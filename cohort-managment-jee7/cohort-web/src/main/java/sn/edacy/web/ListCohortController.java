package sn.edacy.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import sn.edacy.business.CohortService;
import sn.edacy.model.Cohort;

@Named
@RequestScoped
public class ListCohortController {
	
	private List<Cohort> cohorts;
	@Inject
    CohortService cohortService;
	
	@PostConstruct
	public void init() {
		cohorts = cohortService.getAllCohort();
	}

	public List<Cohort> getCohorts() {
		return cohorts;
	}

	public void setCohorts(List<Cohort> cohorts) {
		this.cohorts = cohorts;
	}

}
