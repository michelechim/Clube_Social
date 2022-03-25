package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	public static Connection getConnection() {
		try {
			final String url = "jdbc:mariadb://localhost:3306/clube_social";
			//argumentos: url para o banco, usuario, senha.
			//retorna um objeto da classe Connection (do pacote java.sql -> que segue a especificao  JDBC).
			return DriverManager.getConnection(url,"root","senha5");
			//return DriverManager.getConnection(url, "mariadb", "mariadb");
		} catch (SQLException e) {
			e.printStackTrace();
			return null; //se n�o conectar, retorna null.
		}
	}
	
	//um main para testar a conexao com o servidor do MariaDB
	public static void main(String[] args) {
		System.out.println(BaseDAO.getConnection());
	}
}