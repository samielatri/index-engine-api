package com.dant.app;


import com.dant.entity.Table;
import com.dant.entity.link.TableLink;
import com.dant.service.TableService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/table")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TableEndpoint {

    TableService tableService = new TableService();
    @POST
    @Path("/create")
    public Table createTable(TableLink tableLink) throws Exception {
        if (tableLink == null){
            throw new BadRequestException("body is empty"); //on verifie si l'utilisateur à bien entrer qqch
        }
        Table table= tableService.creationTable(tableLink);
        return table;
    }

}
