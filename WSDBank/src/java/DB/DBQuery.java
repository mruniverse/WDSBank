/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Classes.Conta;
import java.sql.*;

/**
 *
 * @author yuril
 */
public class DBQuery {
    Connection conn;

    public DBQuery(){
        Connector conector = new Connector();
        conn = conector.connect();
    }
    
//    ==========================================================================
    public Connection Connect(){
        Connector conector = new Connector();
        Connection conn = conector.connect();
        
        return conn;
    }
//    ==========================================================================
    public Conta ConsultarCadastro(int ag, int conta){
        Conta c = new Conta("", ag, conta);
//        Connection conn = this.Connect();
        
        try {
            Statement stmt = (Statement) this.conn.createStatement();
//            Query ============================================================
            String query = "SELECT * FROM conta "
                    + "WHERE num_ag = '"+ag+"' AND num_conta = '"+conta+"'";
//            Query ============================================================
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                c.setNome(rs.getString("nome"));
                c.setNum_ag(rs.getInt("num_ag"));
                c.setNum_conta(rs.getInt("num_conta"));
                c.setSaldo(rs.getFloat("saldo"));
            }
                
        } catch (SQLException e) {
            System.out.println("Erro ao realizar consulta: \n");
            System.err.println(e);
        }

        return c;
    }
//    ==========================================================================
    public boolean cadastroExistente(int ag, int conta){
        Conta c = new Conta("", 0, 0);
        
        try {
            Statement stmt = (Statement) this.conn.createStatement();
//            Query ============================================================
            String query = "SELECT * FROM conta "
                    + "WHERE num_ag = '"+ag+"' AND num_conta = '"+conta+"'";
//            Query ============================================================
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                c.setNome(rs.getString("nome"));
                c.setNum_ag(rs.getInt("num_ag"));
                c.setNum_conta(rs.getInt("num_conta"));
                c.setSaldo(rs.getFloat("saldo"));
            }
                
        } catch (SQLException e) {
            System.out.println("Erro ao realizar consulta: \n");
            System.err.println(e);
        }
        
        if(c.getNum_ag() == ag && c.getNum_conta() == conta) return true;
        else return false;
    }
//    ==========================================================================
    public String RegistrarConta(String nome, int ag, int conta){
        Conta c = new Conta(nome, ag, conta);
//        Connection conn = this.Connect();

        if(cadastroExistente(ag, conta)) return "Cadastro existente!";
        
        try {
            Statement stmt = (Statement) this.conn.createStatement();
//            Query ============================================================
            String query = 
                    "INSERT INTO conta (nome, num_ag, num_conta, saldo)"
                    + " VALUES "
                    + "('"+c.getNome()+"',"
                    + "'"+c.getNum_ag()+"',"
                    + "'"+c.getNum_conta()+"',"
                    + "'"+0+"')";
//            Query ============================================================
            stmt.executeUpdate(query);
            
        } catch (SQLException e) {            
            return e.getMessage();
        }
        
        return "ok";
    }
//    ==========================================================================
    public String AlterarCadastro(String nome, int ag, int conta){
//        Connection conn = this.Connect();
        try {
            Statement stmt = (Statement) this.conn.createStatement();
//            Query ============================================================
            String query = 
                    "UPDATE conta "
                    + "SET "
                    + "nome = '"+nome+"' "
//                    + "num_ag = '"+ag+"',"
//                    + "num_conta = '"+conta+"',"
                    + "WHERE num_ag = '"+ag+"' AND num_conta = '"+conta+"'";
//            Query ============================================================
            stmt.executeUpdate(query);
            
        } catch (SQLException e) {
            return e.getMessage();
        }
        return "ok";
    }
//    ==========================================================================
    public String Deposito(int ag, int conta, float saldo){
        float valor = 0;
//        Connection conn = this.Connect();
        
        try {
            Statement stmt = (Statement) this.conn.createStatement();
//            Query ============================================================
            String query = "SELECT * FROM conta "
                    + "WHERE num_ag = '"+ag+"' AND num_conta = '"+conta+"'";
//            Query ============================================================
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                valor = rs.getFloat("saldo");
            }
            saldo += valor;
            
//            Query2 ===========================================================
            String query2 = 
                    "UPDATE conta "
                    + "SET saldo = '"+saldo+"' "
                    + "WHERE num_ag = '"+ag+"' "
                    + "AND num_conta = '"+conta+"'";
//            Query2 ===========================================================
            stmt.executeUpdate(query2);
            
        } catch (SQLException e) {
            return e.getMessage();
        }
        
        return "ok";
    }
//    ==========================================================================
    public String RealizarSaque(int ag, int conta, float valor){
        float saldo = 0;
//        Connection conn = this.Connect();
        
        try {
            Statement stmt = (Statement) this.conn.createStatement();
//            Query ============================================================
            String query = "SELECT * FROM conta "
                    + "WHERE num_ag = '"+ag+"' AND num_conta = '"+conta+"'";
//            Query ============================================================
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                saldo = rs.getFloat("saldo");
            }
            saldo -= valor;
            
//            Query2 ============================================================
            String query2 = 
                    "UPDATE conta "
                    + "SET saldo = '"+saldo+"' "
                    + "WHERE num_ag = '"+ag+"' AND num_conta = '"+conta+"'";
//            Query ============================================================
            stmt.executeUpdate(query2);

                
        } catch (SQLException e) {
            return e.getMessage();
        }
        
        return "ok";
    }
//    ==========================================================================
    public Conta ConsultarCadastro(int id){    //##Consulta o cadastro pelo ID##
        Conta c = new Conta("", 0, 0);
//        Connection conn = this.Connect();
        
        try {
            Statement stmt = (Statement) this.conn.createStatement();
//            Query ============================================================
            String query = "SELECT * FROM conta "
                    + "WHERE CONCAT(num_ag, num_conta) = '"+id+"'";
//            Query ============================================================
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setNum_ag(rs.getInt("num_ag"));
                c.setNum_conta(rs.getInt("num_conta"));
                c.setSaldo(rs.getFloat("saldo"));
            }
                
        } catch (SQLException e) {
            System.out.println("Erro ao realizar consulta: \n");
            System.err.println(e);
        }

        return c;
    }
//    ==========================================================================
}