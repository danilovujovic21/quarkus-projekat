package repository;


//import java.util.HashSet;
//import java.util.Set;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;
import jakarta.inject.Inject;
import jakarta.enterprise.context.Dependent;
import model.Director;
//import model.Movie;

@Dependent
public class DirectorRepository {

    @Inject
    private EntityManager entityManager;

    @Transactional
    public Director createDirector(Director director) {
        return entityManager.merge(director); 
    }

    @Transactional
    public List<Director> getAllDirectors() {
    	
    	return entityManager.createNamedQuery(Director.GET_ALL_DIRECTORS, Director.class).getResultList();
    	
    }
    
   
}