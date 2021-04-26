/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restisdcm;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import restisdcm.dao.VideoDAO;

/**
 * REST Web Service
 *
 * @author fiblabs
 */
@Path("videos")
public class VideosResource {

    @Context
    private UriInfo context;
    
    private final VideoDAO videoDAO;

    /**
     * Creates a new instance of VideosResource
     */
    public VideosResource() {
        this.videoDAO = new VideoDAO();
    }

    /**
     * PUT method for updating the views of a given video
     * @param id
     * @return 
     */
    @PUT
    @Path("{id}/reproducciones")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateReproducciones(@PathParam("id") int id) {
        if(!videoDAO.checkVideoExists(id)){
            String notFoundMessage = "Video con id: " + id + " no existe!";
            return Response.status(404).entity(notFoundMessage).build();
        }
        
        try {
            videoDAO.incrementarReproducciones(id);
        } catch (Exception ex) {
            Logger.getLogger(VideosResource.class.getName()).log(Level.SEVERE, null, ex);
            String errorMessage = "Ha ocurrido un error al incrementar video id: " + id;
            return Response.status(500).entity(errorMessage).build();
        }
        
        return Response.status(200).entity("Operación Exitosa").build();
    }
}
