package repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Genre;

import java.util.List;

@Dependent
public class GenreRepository {
		
	@Inject
	private EntityManager em;
		
	@Transactional
	public List<Genre> getAllGenres() {
		List<Genre> genres = em.createNamedQuery(Genre.GET_ALL_GENRES, Genre.class).getResultList();
		return genres;
	}
	
	
}
