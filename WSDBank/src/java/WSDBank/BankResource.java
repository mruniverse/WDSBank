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
    private DBQuery db;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public BankResource() {
        this.db = new DBQuery();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public String Cadastrar(String content) throws SQLException{
        Gson json = new Gson();
        Conta c = json.fromJson(content, Conta.class);
        return this.db.RegistrarConta(c.getNome(), c.getNum_ag(), c.getNum_conta());
    }

    
    
}
