package resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Movie;
import repository.MovieRepository;

import java.util.List;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

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
	
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/createMovie")
	@Transactional
    public Response createMovie(Movie movie) {
        try {
            movieRepository.createMovie(movie); // ili persist/merge, u zavisnosti od implementacije
            return Response.status(Response.Status.CREATED).entity(movie).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Greška pri dodavanju filma").build();
        }
    }
}
