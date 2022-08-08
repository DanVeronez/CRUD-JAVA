package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	// Nome do usuario MySql
	private static final String USERNAME = "root";

	// Senha do Banco
	private static final String PASSWORD = "";

	// Caminho banco de dados, porta, nome do bando de dados
	private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/agenda";

	// Conexo com banco de dados
	public static Connection createConnectionToMySQL() throws Exception {

		// Faz com que a classe seja carregada pela jvm
		// Class.forName("com.mysql.jdbc.driver");

		// Cria conecxo com banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		return connection;
	}

	public static void main(String[] args) throws Exception {

		// Recuperar conecxo com banco de dados
		Connection con = createConnectionToMySQL();

		// Testar se a conecxo nula

		if (con != null) {
			System.out.println("Conecxo obtida com sucesso");
			con.close();
		}

	}
}
