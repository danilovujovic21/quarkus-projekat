package repository;

import jakarta.persistence.EntityManager;
import jakarta.inject.Inject;
import java.util.List;
import model.Movie;
import jakarta.enterprise.context.Dependent;

@Dependent
public class MovieRepository {

    @Inject
    private EntityManager entityManager;

    
    public List<Movie> getAllMovies() {
        return entityManager.createNamedQuery(Movie.GET_ALL_MOVIES, Movie.class).getResultList();
    }

    
    public Movie getMovieByName(String name) {
        return entityManager.createNamedQuery(Movie.GET_MOVIE_BY_NAME, Movie.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}

