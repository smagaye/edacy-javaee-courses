package sn.edacy.web.cohort;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import sn.edacy.business.CohortService;
import sn.edacy.business.utils.CohortSearch;
import sn.edacy.model.Cohort;

@Model
public class ListeCohortBean {
	
	@Inject
	private CohortService cohortService;
	
	private List<Cohort> listCohorts;
	
	private CohortSearch cohortSearch = new CohortSearch();
	
	@PostConstruct
	public void init() {
		listCohorts = cohortService.getAll();
	}
	
	public void search() {
		System.out.println("Recherche par identifiant " + cohortSearch.getIdentifier() + " name " + cohortSearch.getName());
		listCohorts = cohortService.search(cohortSearch);
	}

	public List<Cohort> getListCohorts() {
		return listCohorts;
	}

	public void setListCohorts(List<Cohort> listCohorts) {
		this.listCohorts = listCohorts;
	}

	public CohortSearch getCohortSearch() {
		return cohortSearch;
	}

	public void setCohortSearch(CohortSearch cohortSearch) {
		this.cohortSearch = cohortSearch;
	}
	
}
