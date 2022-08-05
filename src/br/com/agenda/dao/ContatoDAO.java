package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import br.com.agenda.factory.ConnectionFactory;

// import com.mysql.jdbc.Connection;

import br.com.agenda.model.Contato;

/*
 * CRUD
 * C: CREATE
 * R: READ
 * U: UPDATE
 * D: DELETE
 */

public class ContatoDAO {
    
    public void save (Contato contato){
        
        String sql = "INSERT INTO contatos(nome, idade, datacadastro) VALUES(?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;
    
        try{
            //Criar uma conecxão com banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            //Criamos uma PrepareStatement, para executar uma Query
            pstm = conn.prepareStatement(sql);
            //Adicionar os valores que são esperados pela Query
            pstm.setString(1, contato.getName());
            pstm.setInt(2, contato.getIdade());
            pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

            //Executar a Query
            pstm.execute();
            
            System.out.println("Contato Salvo Com Sucesso!");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //fechar as conecxões
            try{
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    
    }
}
