package repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import model.Actor;

import java.util.List;
import jakarta.inject.Inject;
import jakarta.enterprise.context.Dependent;

@Dependent
public class ActorRepository {

	@Inject
	private EntityManager em;
	
	@Transactional
	public List<Actor> getAllActors() {
		List<Actor> actors = em.createNamedQuery(Actor.GET_ALL_ACTORS, Actor.class).getResultList();
		return actors;
	}
	
}
