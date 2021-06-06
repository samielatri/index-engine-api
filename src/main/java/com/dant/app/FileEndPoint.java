package com.dant.app;

import com.dant.entity.link.MultipartLink;
import com.dant.service.ParserCSV;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/file")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.MULTIPART_FORM_DATA)
public class FileEndPoint {

    ParserCSV parserCsv = new ParserCSV();

    @POST
    @Path("/load")
    public String load (@MultipartForm MultipartLink multipartLink) {
        // verification that user provided a non null multipartform
        if(multipartLink == null) {
            throw new BadRequestException("body is empty");
        }

        boolean parse = parserCsv.loadFile(multipartLink.getName(),multipartLink.getFile());

        return (parse) ? "File uploaded" : "Error file uploading";
    }

}
