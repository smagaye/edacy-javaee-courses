package sn.edacy.ws;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Path;

import sn.edacy.business.CohortService;
import sn.edacy.model.Cohort;

@Path("cohort")
public class CohortWS {

	@Inject
	CohortService cohortService;
	
	@Path("/")
	public List<Cohort> getAll() {
		return cohortService.getAllCohort();
	}
}
