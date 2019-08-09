/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

/**
 * Jersey REST client generated for REST resource:BankResource [Bank]<br>
 * USAGE:
 * <pre>
 *        NewJerseyClient client = new NewJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author yuril
 */
public class NewJerseyClient {

    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/WDSBank/webresources";

    public NewJerseyClient() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("Bank");
    }

    public String realizarDeposito(String ag, String conta, String valor) throws UniformInterfaceException {
        return webResource.path(java.text.MessageFormat.format("deposito/{0}/{1}/{2}", new Object[]{ag, conta, valor})).post(String.class);
    }

    public String realizarSaque(String ag, String conta, String valor) throws UniformInterfaceException {
        return webResource.path(java.text.MessageFormat.format("saque/{0}/{1}/{2}", new Object[]{ag, conta, valor})).post(String.class);
    }

    public String alterarCadastro(Object requestEntity) throws UniformInterfaceException {
        return webResource.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(String.class, requestEntity);
    }

    public String consultaCadastro(String id) throws UniformInterfaceException {
        WebResource resource = webResource;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public String CadastroExistente(String ag, String conta) throws UniformInterfaceException {
        return webResource.path(java.text.MessageFormat.format("CadastroExistente/{0}/{1}", new Object[]{ag, conta})).get(String.class);
    }
    
    public String cadastrar(Object requestEntity) throws UniformInterfaceException {
        return webResource.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(String.class, requestEntity);
    }
    
    public String realizarTransferencia(String ag1, String conta1, String ag2, String conta2, String valor) throws UniformInterfaceException {
        return webResource.path(java.text.MessageFormat.format("transferencia/{0}/{1}/{2}/{3}/{4}", new Object[]{ag1, conta1, ag2, conta2, valor})).post(String.class);
    }

    public void close() {
        client.destroy();
    }
    
}
