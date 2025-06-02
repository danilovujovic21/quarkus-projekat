package client;

import model.Country;
import model.PublicHoliday;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@RegisterRestClient(configKey = "nager-date-api")
public interface CountryClient {

    @GET
    @Path("/api/v3/AvailableCountries")
    @Produces(MediaType.APPLICATION_JSON)
    List<Country> getAvailableCountries();

    @GET
    @Path("/api/v3/NextPublicHolidays/{countryCode}")
    @Produces(MediaType.APPLICATION_JSON)
    List<PublicHoliday> getNextPublicHolidays(@PathParam("countryCode") String countryCode);
}
