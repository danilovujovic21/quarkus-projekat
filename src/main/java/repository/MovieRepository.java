package repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.inject.Inject;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import model.Genre;
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
    
    @Transactional
    public void createMovie(Movie movie) {
        // Dohvati žanrove iz baze prema ID-jevima
        Set<Genre> managedGenres = movie.getGenres().stream()
            .map(genre -> entityManager.find(Genre.class, genre.getId()))
            .collect(Collectors.toSet());
        
        movie.setGenres(managedGenres);
        entityManager.persist(movie);
    }

}

