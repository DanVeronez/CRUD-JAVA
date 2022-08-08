package br.com.agenda.aplicacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

    public static void main(String[] args) {

        // criarContato("Daniel Veronez", 23);

        // atualizarContato(23, "Fabio lima", 25);

        // removerContato(24);

        visualizarContatos();
    }

    // ********** CRIA UM CONTATO **********
    public static void criarContato(String nome, int idade){

        ContatoDAO contatoDAO = new ContatoDAO();
        Contato contato = new Contato();

        contato.setName(nome);
        contato.setIdade(idade);
        contato.setDataCadastro(new Date());

        contatoDAO.create(contato);
    }

    // ********** ATUALIZA O CONTATO **********
    public static void atualizarContato(int id, String nome, int idade){

        ContatoDAO contatoDAO = new ContatoDAO();
        Contato contato = new Contato();

        contato.setId(id);// Qual contato quer atualizar?
        contato.setName(nome);
        contato.setIdade(idade);
        contato.setDataCadastro(new Date());

        contatoDAO.update(contato);        
    }

    // ********** DELETA UM CONTATO PELO ID **********
    public static void removerContato(int id){
        
        ContatoDAO contatoDAO = new ContatoDAO();
        
        contatoDAO.delete(id);
    }

    // ********** VISUALIZAR TODOS OS CONTATOS **********
    public static void visualizarContatos(){
    
        ContatoDAO contatoDAO = new ContatoDAO();

        List<Contato> listaDeContatos = new ArrayList<Contato>();
        listaDeContatos = contatoDAO.read();

        for (Contato contato : listaDeContatos) {
            System.out.println("\nCONTATO: " + contato.getId());
            System.out.println("Nome: " + contato.getName());
            System.out.println("Idade: " + contato.getIdade());
            System.out.println("Data de Cadastro: " + contato.getDataCadastro());
        }
    }

}