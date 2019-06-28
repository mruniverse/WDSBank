/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WSDBank;

import Classes.Conta;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import DB.DBQuery;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author cc47938751812
 */


@Path("Bank")
public class BankResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public BankResource() {
    }

    /**
     * Retrieves representation of an instance of WSDBank.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/nome/{nome}")
    public String Cadastrar(@PathParam("nome") String nome, int num_ag, int num_conta) throws SQLException, ClassNotFoundException {
        Conta a = new Conta(nome, num_ag, num_conta);
        Gson json = new Gson();
        String resultado = json.toJson(a);
        return resultado;
    }

    
    
}
