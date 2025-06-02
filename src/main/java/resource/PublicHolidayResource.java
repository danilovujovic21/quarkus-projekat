package resource;

import client.CountryClient;
import model.Country;
import model.PublicHoliday;
import service.HolidayService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import java.util.List;

@Path("/holidays")
public class PublicHolidayResource {

    
    @RestClient
    CountryClient countryClient;

    @Inject
    HolidayService holidayService;

    @POST
    @Path("/sync/{countryCode}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response syncHolidays(@PathParam("countryCode") String countryCode) {
        holidayService.saveHolidaysForCountry(countryCode);
        return Response.ok().entity("Sinhronizacija završena").build();
    }
    
    // Endpoint za dostupne zemlje
    @GET
    @Path("/countries")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAvailableCountries() {
        List<Country> countries = countryClient.getAvailableCountries();
        return Response.ok(countries).build();
    }

    
    @GET
    @Path("/next/{countryCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNextPublicHolidays(@PathParam("countryCode") String countryCode) {
        List<PublicHoliday> holidays = countryClient.getNextPublicHolidays(countryCode);
        return Response.ok(holidays).build();
    }
}
