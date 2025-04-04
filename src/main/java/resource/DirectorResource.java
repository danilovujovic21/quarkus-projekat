package resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import repository.DirectorRepository;
import model.Director;

@Path("/directors")
public class DirectorResource {

    private DirectorRepository directorRepository = new DirectorRepository(); 

    
    @POST
    @Path("/createDirector")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDirector(Director director) {
        try {
            directorRepository.createDirector(director); 
            return Response.status(Response.Status.CREATED).entity(director).build();
        } catch (Exception e) {
        	e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Greska pri dodavanju rezisera").build();
        }
    }

    
    @GET
    @Path("/getAllDirectors")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDirectors() {
        try {
            List<Director> directors = directorRepository.getAllDirectors();
            return Response.ok(directors).build();
        } catch (Exception e) {
        	e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Greska pri dobijanju režisera").build();
        }
    }
}

