/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miage.ServiceCommacial2;

import com.google.gson.Gson;
import com.miage.ServiceCommacial2.entities.CommandeClient;
import static com.miage.ServiceCommacial2.entities.CommandeClient_.CoteExact;
import static com.miage.ServiceCommacial2.entities.CommandeClient_.ReferenceCatalogue;
import static com.miage.ServiceCommacial2.entities.CommandeClient_.Tarif;
import com.miage.ServiceCommacial2.entities.Commercial;
import com.miage.ServiceCommacial2.services.ServiceComLocal;
import java.awt.List;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author AlaaCheurfa
 */
@Path("commercial")
@RequestScoped
public class CommercialResource {

    ServiceComLocal serviceCom = lookupServiceComLocal();

    @Context
    private UriInfo context;
    private Gson gson;

    /**
     * Creates a new instance of CommercialResource
     */
    public CommercialResource() {
        this.gson = new Gson();
        this.serviceCom = lookupServiceComLocal();
    }

    /**
     * Retrieves representation of an instance of
     * com.miage.ServiceCommacial2.CommercialResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of CommercialResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    @GET
    @Path("/Allcommande")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllComande() {
        java.util.List<CommandeClient> commandeC = serviceCom.findAllComande();
        if (commandeC == null) {
            return Response.created(context.getAbsolutePath()).status(Response.Status.INTERNAL_SERVER_ERROR).entity(null).build();
        } else {
            GenericEntity<java.util.List<CommandeClient>> listResult = new GenericEntity<java.util.List<CommandeClient>>(commandeC) {
            };
            return Response.ok(listResult).build();
        }
    }

    
    @POST
    @Path("/creerCommande")
    @Produces(MediaType.APPLICATION_JSON)
    public Response creerCommande(@QueryParam("ReferenceCatalogue") String ReferenceCatalogue, @QueryParam("CoteExact") String CoteExact,
            @QueryParam("Tarif") String Tarif, @QueryParam("idCommercial") long idCommercial, @QueryParam("idAffaire") long idAffaire) {
        Commercial co = serviceCom.findIdCom(idCommercial);
        if (co == null) {
            return Response.created(context.getAbsolutePath()).status(Response.Status.INTERNAL_SERVER_ERROR).entity(null).build();
        } else {
            CommandeClient c = serviceCom.creerCommande(ReferenceCatalogue, CoteExact, Tarif, co, idAffaire);
            if (c == null) {
                return Response.created(context.getAbsolutePath()).status(Response.Status.INTERNAL_SERVER_ERROR).entity(null).build();
            } else {
                
                return Response.ok(c).build();
            }
        }

        
    }

   
    @PUT
    @Path("/Validercommande/{idCommande}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response ValiderCommande(@PathParam("idCommande") Long idCommande) {
        CommandeClient c = serviceCom.ValiderCommande(idCommande);
        if (c == null) {
            return Response.created(context.getAbsolutePath()).status(Response.Status.INTERNAL_SERVER_ERROR).entity(null).build();
        } else {
            ;
            return Response.ok(c).build();
        }
    }
    
    
    @GET
    @Path("/AfficherCommande/{idCommande}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response AfficherCommande(@PathParam("idCommande") Long idCommande) {
        CommandeClient c = serviceCom.ValiderCommande(idCommande);
        if (c == null) {
            return Response.created(context.getAbsolutePath()).status(Response.Status.INTERNAL_SERVER_ERROR).entity(null).build();
        } else {
            ;
            return Response.ok(c).build();
        }
    }
    
   


 
    private ServiceComLocal lookupServiceComLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (ServiceComLocal) c.lookup("java:global/ServiceCommacial2-ear/ServiceCommacial2-ejb-1.0/ServiceCom");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
