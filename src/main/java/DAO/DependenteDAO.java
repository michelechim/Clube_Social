package DAO;

import model.Dependente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DependenteDAO extends BaseDAO {
	public static List<Dependente> selectDependente() {
		final String sql = "SELECT * FROM dependente ORDER BY nome_dep";
		try //try-witch-resource
		(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			List<Dependente> dependente = new ArrayList<>();
			while(rs.next()) {
				dependente.add(resultsetToDependente(rs));
			}
			return dependente;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
    public static boolean RegDep(Dependente dependente){
    	final String sql = "INSERT INTO Dependente (nome_dep, parentesco, email_dep, cartao_socio) VALUES (?, ?, ?, ?);";
		try //try-witch-resource
		(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		)
        {
			pstmt.setString(1, dependente.getNome_dep());
			pstmt.setString(2, dependente.getParentesco());
			pstmt.setString(3, dependente.getEmail_dep());
			pstmt.setLong(4, dependente.getCartao_socio());
            int count = pstmt.executeUpdate();
			return count > 0;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
    
	//método utilitário, converte ResultSet na classe de modelo (nesse caso, Dependente)
    private static Dependente resultsetToDependente(ResultSet rs) throws SQLException {
		Dependente d = new Dependente();
		d.setNome_dep(rs.getString("nome_dep"));
		d.setParentesco(rs.getString("parentesco"));
		d.setEmail_dep(rs.getString("email_dep"));
		d.setCartao_socio(rs.getLong("cartao_socio"));
		return d;
	}

	public static void main(String[] args) {
		System.out.println(DependenteDAO.selectDependente());
	}
}