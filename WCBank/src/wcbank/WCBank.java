/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wcbank;

import Classes.Conta;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import Client.*;

/**
 *
 * @author yuril
 */
public class WCBank {
    NewJerseyClient client;

    public WCBank() {
        this.client = new NewJerseyClient();
    }
    
    
    public static void main(String[] args) {
        WCBank wc = new WCBank();
        Conta c = new Conta("Robertinho", 123, 321);
        wc.create(c);
    }
    
    public void create(Conta c){        
        Gson gson = new Gson();
        String response = this.client.Cadastrar(String.class, gson.toJson(c));
        client.close();
        System.out.println(response);
   }
    
}
