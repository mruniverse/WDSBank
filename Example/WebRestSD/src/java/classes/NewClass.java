/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import classes.Alunos;
import java.sql.SQLException;

/**
 *
 * @author Fábio Moreno
 */
public class NewClass {
     public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
        Alunos a = new Alunos();
        a.getAluno(1);
        System.out.println(a.getNome());
        
    }
}
