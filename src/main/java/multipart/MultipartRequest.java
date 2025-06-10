package multipart;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;
import jakarta.ws.rs.core.MediaType;

public class MultipartRequest {

    @RestForm("file")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    @Schema(implementation = MultipartResource.UploadSchema.class)
    private FileUpload file;

    @RestForm("filename")
    @PartType(MediaType.TEXT_PLAIN)
    private String filename;

    // Getteri i setteri
    public FileUpload getFile() {
    	return file; 
    }
    public void setFile(FileUpload file) { 
    	this.file = file; 
    }
    public String getFilename() { 
    	return filename; 
    }
    public void setFilename(String filename) { 
    	this.filename = filename; 
    }
}
