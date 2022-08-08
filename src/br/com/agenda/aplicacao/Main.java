package br.com.agenda.aplicacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

    public static void main(String[] args) {

        ContatoDAO contatoDAO = new ContatoDAO();

        // ********** CRIA UM CONTATO **********
        Contato contatoCriar = new Contato();

        contatoCriar.setName("indiana jones");
        contatoCriar.setIdade(57);
        contatoCriar.setDataCadastro(new Date());

        // contatoDAO.create(contatoCriar);

        // ********** ATUALIZA O CONTATO **********
        Contato contatoAtualizar = new Contato();

        contatoAtualizar.setName("Daniel Veronez Barboza");
        contatoAtualizar.setIdade(23);
        contatoAtualizar.setDataCadastro(new Date());

        contatoAtualizar.setId(1);// Qual contato quer atualizar?

        // contatoDAO.update(contatoAtualizar);

        // ********** VISUALIZAR TODOS OS CONTATOS **********
        List<Contato> listaDeContatos = new ArrayList<Contato>();

        listaDeContatos = contatoDAO.read();

        for (Contato contatoVisualizar : listaDeContatos) {
            System.out.println("\nCONTATO: " + contatoVisualizar.getId());
            System.out.println("Nome: " + contatoVisualizar.getName());
            System.out.println("Idade: " + contatoVisualizar.getIdade());
            System.out.println("Data de Cadastro: " + contatoVisualizar.getDataCadastro());
        }

    }

}