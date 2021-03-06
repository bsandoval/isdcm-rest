/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restisdcm;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author fiblabs
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }
    
    
    /**
     * Sample of GET method
     * @param info
     * @param fecha
     * @return 
     */
    @Path("getInfo")
    @GET    
    @Produces(MediaType.TEXT_HTML)
    public String getInfo(@QueryParam("info") String info, 
                            @QueryParam("fecha") String fecha) {
        
        return "<html><head></head> <body> Info" + info + " en fecha " + fecha + " </body></html>";
    }

    /**
     * Sample of POST method
     * 
     * @param info
     * @param fecha
     * @return 
     */
    @Path("postInfo")   
    @POST    
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.TEXT_HTML)
    public String postInfo (@FormParam("info") String info, 
                             @FormParam("fecha") String fecha) 
    {                
        return "<html><head></head> <body> Información recibida " + info + "en fecha" + fecha + " </body></html>";
    }

    /**
     * Retrieves representation of an instance of restisdcm.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        return "<html><head></head><body><h1>Hello World!</h1></body></html>";
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
}
