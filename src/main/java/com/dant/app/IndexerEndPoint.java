package com.dant.app;


import com.dant.entity.link.QueryLink;
import com.dant.service.IndexService;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Path("/api/select")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IndexerEndPoint {

    IndexService indexService = new IndexService();
    @POST
    @Path("/search")
    public Set<String> searchIndexes(QueryLink queryLink) throws Exception {
        if (queryLink == null){
            throw new BadRequestException("body is empty"); //on verifie si l'utilisateur à bien entrer qqch
        }
        Set<String> setIndexes = indexService.find(queryLink);
        return setIndexes;
    }


}
