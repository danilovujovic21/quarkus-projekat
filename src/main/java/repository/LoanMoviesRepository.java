package repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;
import jakarta.inject.Inject;
import jakarta.enterprise.context.Dependent;
import model.LoanMovies;

@Dependent
public class LoanMoviesRepository {
	
	@Inject
	private EntityManager eManager;

	
	@Transactional
	public List<LoanMovies> getAllLoanMovies() {
		List<LoanMovies> loanMovies = eManager.createNamedQuery(LoanMovies.GET_ALL_LOAN_MOVIES, LoanMovies.class)
				.getResultList();
		return loanMovies;
	}
}
