package resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Genre;
import repository.GenreRepository;

import java.util.List;

@Path("/genre")
public class GenreResource {

	
	private GenreRepository genreRepository = new GenreRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllGenres")
	public Response getAllGenres() {
		List<Genre> genres = genreRepository.getAllGenres();
		return Response.ok().entity(genres).build();
	}
	
}
