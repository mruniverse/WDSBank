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
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import DB.DBQuery;
import com.google.gson.Gson;
import java.sql.SQLException;
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
    public String cadastrar(String content) throws SQLException{
        Gson json = new Gson();
        Conta c = json.fromJson(content, Conta.class);
        return this.db.RegistrarConta(c.getNome(), c.getNum_ag(), c.getNum_conta());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String consultaCadastro(@PathParam("id") int id) throws SQLException, ClassNotFoundException {
        Conta c = new Conta();
        c = db.ConsultarCadastro(id);
        Gson gson = new Gson();
        String resultado = gson.toJson(c);
        return resultado;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("CadastroExistente/{ag}/{conta}")
    public String CadastroExistente(@PathParam("ag") int ag, @PathParam("conta") int conta) throws SQLException, ClassNotFoundException {
        return db.cadastroExistente(ag, conta);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String alterarCadastro(String content) throws SQLException{
        Gson json = new Gson();
        Conta c = json.fromJson(content, Conta.class);
        return db.AlterarCadastro(c.getNome(), c.getNum_ag(), c.getNum_conta());
    }
    
    @POST
//    @Consumes(MediaType.APPLICATION_JSON) It doesn't consumes any object!
    @Produces(MediaType.APPLICATION_JSON)
    @Path("saque/{ag}/{conta}/{valor}")
    public String realizarSaque(@PathParam("ag") int ag, @PathParam("conta") int conta, @PathParam("valor") float valor) throws SQLException{
        return db.RealizarSaque(ag, conta, valor);
    }
    
    @POST
//    @Consumes(MediaType.APPLICATION_XML) It doesn't consumes any object!
    @Produces(MediaType.APPLICATION_JSON)
    @Path("deposito/{ag}/{conta}/{valor}")
    public String realizarDeposito(@PathParam("ag") int ag, @PathParam("conta") int conta, @PathParam("valor") float valor) throws SQLException{
        return db.Deposito(ag, conta, valor);
    }
    
    @POST
//    @Consumes(MediaType.APPLICATION_XML) It doesn't consumes any object!
    @Produces(MediaType.APPLICATION_JSON)
    @Path("transferencia/{ag1}/{conta1}/{ag2}/{conta2}/{valor}")
    public String realizarTransferencia(@PathParam("ag1") int ag1, @PathParam("conta1") int conta1, @PathParam("ag2") int ag2, @PathParam("conta2") int conta2, @PathParam("valor") float valor) throws SQLException{
        return db.Transferir(ag1, conta1, ag2, conta2, valor);
    }
}
