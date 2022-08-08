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

    public void create(Contato contato) {

        String sql = "INSERT INTO contatos(nome, idade, datacadastro) VALUES(?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {

            // Criar uma conecx�o com banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();

            // Criamos uma PrepareStatement, para executar uma Query
            pstm = conn.prepareStatement(sql);

            // Adicionar os valores que s�o esperados pela Query
            pstm.setString(1, contato.getName());
            pstm.setInt(2, contato.getIdade());
            pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

            // Executar a Query
            pstm.execute();

            System.out.println("Contato Salvo Com Sucesso!");

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            // fechar as conecxões
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public List<Contato> read() {

        String sql = "SELECT * FROM contatos";

        List<Contato> contatos = new ArrayList<Contato>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;// Classe que vai recuperar os dados do banco. ****SELECT****

        try {

            // Cria uma conexão com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {

                Contato contato = new Contato();

                contato.setId(rset.getInt("id"));                       // Recuperar o ID
                contato.setName(rset.getString("nome"));                // Recuperar o NOME
                contato.setIdade(rset.getInt("idade"));                 // Recuperar IDADE
                contato.setDataCadastro(rset.getDate("datacadastro"));  // Recupera DATA DE CADASTRO

                contatos.add(contato);
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {

            try {

                if (rset != null) {
                    rset.close();
                }

                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return contatos;
    }

    public void update(Contato contato) {

        String sql = "UPDATE contatos SET nome = ?, idade = ?, datacadastro = ? " +
                     "WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {

            // Cria conexão com o banco
            conn = ConnectionFactory.createConnectionToMySQL();

            // Criar a classe para executar a query
            pstm = conn.prepareStatement(sql);

            // Adicionar os valores para atualizar
            pstm.setString(1, contato.getName());
            pstm.setInt(2, contato.getIdade());
            pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

            // ID do registro que deeja atualizar
            pstm.setInt(4, contato.getId());

            // Executar a query
            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {

            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(int id){
        
        String sql = "DELETE FROM contatos WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm =null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            pstm.setInt(1, id);
            pstm.execute();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{

                if(conn!=null){
                    conn.close();
                }

                if(pstm!=null){
                    pstm.close();
                }

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
