package resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Actor;
import repository.ActorRepository;

import java.util.List;
import jakarta.inject.Inject;


public class ActorResource {

	@Inject
	private ActorRepository actorRepository;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllActors")
	public Response getAllActors() {
		List<Actor> actors = actorRepository.getAllActors();
		return Response.ok().entity(actors).build();
	}
}
