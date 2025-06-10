package multipart;

import jakarta.ws.rs.Produces;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.EntityExample;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
//import org.jboss.resteasy.reactive.RestForm;

//import org.jboss.resteasy.reactive.multipart.FileUpload; 

import java.nio.file.Path;

@jakarta.ws.rs.Path("/documents") 
public class MultipartResource {

    @Inject
    EntityManager entityManager;

    @GET
    @jakarta.ws.rs.Path("/test")
    public String test() {
        return "Radi!";
    }

    
    
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Transactional
    public Response uploadDocument(
        @QueryParam("entityId") Long entityId,
        @FormParam("file") java.io.File file,
        @FormParam("filename") String filename){

        try {
            // Validacija parametara
            if (entityId == null) {
                return Response.status(400).entity("entityId je obavezan").build();
            }
            if (file == null || filename == null || filename.isBlank()) {
                return Response.status(400).entity("Nedostaju file parametri").build();
            }

            // Provjera postojanja entiteta
            EntityExample entity = entityManager.find(EntityExample.class, entityId);
            if (entity == null) {
                return Response.status(404).entity("Entitet nije pronađen").build();
            }

            // Kreiranje direktorijuma
            Path uploadDir = Path.of("uploads");
            Files.createDirectories(uploadDir);

            // Sanitizacija imena fajla
            String safeFilename = sanitizeFilename(filename);
            String uniqueName = UUID.randomUUID() + "_" + safeFilename;
            Path targetPath = uploadDir.resolve(uniqueName);

            // Čuvanje fajla
            Files.copy(file.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);

            // Ažuriranje entiteta
            entity.setFilePath(targetPath.toString());
            entityManager.merge(entity);

            return Response.ok("Fajl '" + safeFilename + "' uspješno sačuvan").build();

        } catch (IOException e) {
            return Response.serverError().entity("Greška pri čuvanju fajla: " + e.getMessage()).build();
        }
    }

    private String sanitizeFilename(String filename) {
        return filename.replace("..", "")
                      .replace("/", "")
                      .replace("\\", "")
                      .trim();
    }

    @GET
    @jakarta.ws.rs.Path("/{id}/file")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadFile(@PathParam("id") Long entityId) {
        EntityExample entity = entityManager.find(EntityExample.class, entityId);
        if (entity == null || entity.getFilePath() == null) {
            return Response.status(404).entity("Entitet ili fajl nije pronađen").build();
        }
        
        java.nio.file.Path filePath = java.nio.file.Paths.get(entity.getFilePath());
        if (!java.nio.file.Files.exists(filePath)) {
            return Response.status(404).entity("Fajl nije pronađen na serveru").build();
        }

        return Response.ok(filePath.toFile())
                .header("Content-Disposition", "attachment; filename=\"" + filePath.getFileName() + "\"")
                .build();
    }


    @Schema(type = SchemaType.STRING, format = "binary")
    public static class UploadSchema {}
}