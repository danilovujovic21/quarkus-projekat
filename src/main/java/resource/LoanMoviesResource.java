package resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import repository.LoanMoviesRepository;
import model.LoanMovies;
import jakarta.inject.Inject;

@Path("/loanMovie")
public class LoanMoviesResource {
	
	@Inject
	private LoanMoviesRepository loanMoviesRespository;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllLoanMovies")
	public Response getAllLoanMovies() {
		List<LoanMovies> loanMovies = loanMoviesRespository.getAllLoanMovies();
		return Response.ok().entity(loanMovies).build();
	}

}
