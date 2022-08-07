package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
            //Criar uma conecx�o com banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            //Criamos uma PrepareStatement, para executar uma Query
            pstm = conn.prepareStatement(sql);
            //Adicionar os valores que s�o esperados pela Query
            pstm.setString(1, contato.getName());
            pstm.setInt(2, contato.getIdade());
            pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

            //Executar a Query
            pstm.execute();
            
            System.out.println("Contato Salvo Com Sucesso!");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //fechar as conecx�es
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

    public List<Contato> getContatos(){
        String sql = "SELECT * FROM contatos";

        List<Contato> contatos = new ArrayList<Contato>();

        Connection conn = null;
        PreparedStatement pstm = null;

        //Classe que vai recuperar os dados do banco. ****SELECT****
        ResultSet rset = null;

        try {
            //Cria uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            
            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while(rset.next()){
                Contato contato = new Contato();
                
                //Recuperar o ID
                contato.setId(rset.getInt("id"));

                //Recuperar o NOME
                contato.setName(rset.getString("nome"));

                //Recuperar IDADE
                contato.setIdade(rset.getInt("idade"));

                //Recupera DATA DE CADASTRO
                contato.setDataCadastro(rset.getDate("datacadastro"));

                contatos.add(contato);
            }

        }catch(Exception e){
            e.printStackTrace();
        
        }finally{
            
           try{

                if(rset!=null){
                    rset.close();
                }

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

        return contatos;
    }
}
