/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wcbank;

import Client.NewJerseyClient;
import Classes.Conta;
import com.google.gson.Gson;

/**
 *
 * @author yuril
 */
public class WCBank {
    NewJerseyClient client;
    Gson gson;
    
    public WCBank() {
        this.client = new NewJerseyClient();
        this.gson = new Gson();
    }
    
    
    public static void main(String[] args) {
        WCBank wc = new WCBank();
        Conta c = new Conta("EuAmoASarahLinda", 123, 321);
        Conta d = new Conta();
        
//        wc.create(c);
        wc.alterar(c);
        wc.depositar(123, 321, (float) 100.12);
//        wc.sacar(123, 321, (float) 50.21);
        d = wc.consultar(123321);
        
        System.out.println(d.getNome());
    }

    public void depositar(int ag, int conta, float valor){
        String response = this.client.realizarDeposito(Integer.toString(ag) , Integer.toString(conta), Float.toString(valor));
        System.out.println(response);
        client.close();
    }
    
    public void sacar(int ag, int conta, float valor){
        String response = this.client.realizarSaque(Integer.toString(ag) , Integer.toString(conta), Float.toString(valor));
        System.out.println(response);
        client.close();
    }
    
    public void alterar(Conta c){        
        String response = this.client.alterarCadastro(this.gson.toJson(c));
        System.out.println(response);
        client.close();
   }
    
    public Conta consultar(int id){
        String response = this.client.consultaCadastro(Integer.toString(id));
        Gson gson = new Gson();
        client.close();
        return gson.fromJson(response, Conta.class );
    }
    
    public void create(Conta c){        
        String response = this.client.cadastrar(this.gson.toJson(c));
        System.out.println(response);
        client.close();
   }
    
   
    
}
