package resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Movie;
import repository.MovieRepository;

import java.util.List;
import jakarta.inject.Inject;

@Path("/movie")
public class MovieResource {
	
	@Inject
	private MovieRepository movieRepository;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllMovies")
	public Response getAllMovies() {
		List<Movie> movies = movieRepository.getAllMovies();
		return Response.ok().entity(movies).build();
	}
}
