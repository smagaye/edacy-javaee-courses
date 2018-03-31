package sn.edacy.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import sn.edacy.business.TalentService;
import sn.edacy.model.Cohort;

@Named
@RequestScoped
public class CreateController {
	
    private Cohort newCohort = new Cohort();
    
    @Inject
    TalentService talentService;

    /**
     * Create a new cohort
     */
    public String create() {
        talentService.saveCohort(newCohort);
    		return "/index";
    }

	public Cohort getNewCohort() {
		return newCohort;
	}

	public void setNewCohort(Cohort newCohort) {
		this.newCohort = newCohort;
	}

}
