package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	//Nome do usuario MySql
	private static final String USERNAME = "Root";
	
	//Senha do Banco
	private static final String PASSWORD = "";
	
	//Caminho banco de dados, porta, nome do bando de dados
	private static final String DATABASE_URL = "jdbc:mysql://locahost:3306/agenda";
	
	
	//Conexão com banco de dados
	 public static Connection createConnectionToMySQL() throws Exception {
		 
		 //Faz com que a classe seja carregada pela jvm
		 Class.forName("com.mysql.jdbc.driver");
		 
		 //Cria conecxão com banco de dados
		 Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		 
		 return connection;
	 }
	 
	 public static void main(String[] args) throws Exception {
		
		 //Recuperar conecxão com banco de dados
		 Connection con = createConnectionToMySQL();
		 
		 //Testar se a conecxão é nula
		 
		 if(con!=null) {
			 System.out.println("Conecxão obtida com sucesso");
			 con.close();
		 }
		 
	}
}
