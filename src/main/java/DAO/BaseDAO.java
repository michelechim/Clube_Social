package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	public static Connection getConnection() {
		try {
			//a string com a url para o banco de dados
			//sintaxe: protocolo:tecnologia://dom�nioDoServidor:porta/database
			final String url = "jdbc:mariadb://localhost:3306/clube_social";
			//argumentos: url para o banco, usu�rio, senha.
			//retorna um objeto da classe Connection (do pacote java.sql -> que segue a especifica��o JDBC).
			return DriverManager.getConnection(url,"root","senha5");
			//return DriverManager.getConnection(url, "mariadb", "mariadb");
		} catch (SQLException e) {
			e.printStackTrace();
			return null; //se n�o conectar, retorna null.
		}
	}
	
	//um main para testar a conex�o com o servidor do MariaDB
	public static void main(String[] args) {
		System.out.println(BaseDAO.getConnection());
	}
}