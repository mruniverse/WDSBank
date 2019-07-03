/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author yuril
 */
public class Conta {
    private int id;
    private String nome;
    private int num_ag;
    private int num_conta;
    private float saldo;

    public Conta(String nome, int num_ag, int num_conta) {
        this.nome = nome;
        this.saldo = 0;
        this.num_ag = num_ag;
        this.num_conta = num_conta;
    }

    public Conta() {
        this.id = 0;
        this.nome = "";
        this.num_ag = 0;
        this.num_conta = 0;
        this.saldo = 0;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum_ag() {
        return num_ag;
    }

    public void setNum_ag(int num_ag) {
        this.num_ag = num_ag;
    }

    public int getNum_conta() {
        return num_conta;
    }

    public void setNum_conta(int num_conta) {
        this.num_conta = num_conta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}