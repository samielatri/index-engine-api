package com.dant.app;


import com.dant.entity.link.IndexLink;
import com.dant.entity.Table;
import com.dant.service.IndexService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/index")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IndexEndPoint {

    IndexService indexService = new IndexService();
    @POST
    @Path("/createindex")
    public Table createIndex(IndexLink indexLink) throws Exception {
        if (indexLink == null){
            throw new BadRequestException("body is empty"); //on verifie si l'utilisateur à bien entrer qqch
        }
        return indexService.creationIndex(indexLink);
    }

}
