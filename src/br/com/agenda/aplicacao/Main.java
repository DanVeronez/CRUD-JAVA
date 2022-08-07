package br.com.agenda.aplicacao;

import java.util.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {
    
    public static void main(String[] args) {
        
        ContatoDAO contatoDAO =  new ContatoDAO();

        Contato contato = new Contato();
        contato.setName("indiana jones");
        contato.setIdade(57);
        contato.setDataCadastro(new Date());

        contatoDAO.save(contato);

        //Visualização de TODOS os registros do banco de dados

        for(Contato c: contatoDAO.getContatos()){
            System.out.println("\n CONTATO: " + c.getId());
            System.out.println("Nome: " + c.getName());
            System.out.println("Idade: " + c.getIdade());
            System.out.println("Data de Cadastro: " + c.getDataCadastro());
        }
    }
 
}