package DAO;

import model.Socio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SocioDAO extends BaseDAO {

	public static boolean RegSocio(Socio socio) {
		final String sql = "INSERT INTO socio (nome_socio, end_socio, tel_socio, email_socio, des_cat) "
				+ "VALUES(?,?,?,?,?)";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, socio.getNome_socio());
			pstmt.setString(2, socio.getEnd_socio());
			pstmt.setString(3, socio.getTel_socio());
			pstmt.setString(4, socio.getEmail_socio());
			pstmt.setString(5, socio.getDes_cat());
			int count = pstmt.executeUpdate();
			return count > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static Socio ConsSocio(Long cartao_socio) {
		final String sql = "SELECT * FROM Socio WHERE cartao_socio=?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setLong(1, cartao_socio);
			ResultSet rs = pstmt.executeQuery();
			Socio socio = null;
			if (rs.next()) {
				socio = resultsetToSocio(rs);
			}
			rs.close();
			return socio;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Socio> ListaSocio() {
		final String sql = "SELECT * FROM socio ORDER BY nome_socio";
		try // try-witch-resource
		(Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			List<Socio> socio = new ArrayList<>();
			while (rs.next()) {
				socio.add(resultsetToSocio(rs));
			}
			return socio;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Socio selectSocioById(Long cartao_socio) {
		final String sql = "SELECT * FROM socio WHERE cartao_socio=?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setLong(1, cartao_socio);
			ResultSet rs = pstmt.executeQuery();
			Socio socio = null;
			if (rs.next()) {
				socio = resultsetToSocio(rs);
			}
			rs.close();
			return socio;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// m�todo utilit�rio, converte ResultSet na classe de modelo (nesse caso, Socio)
	private static Socio resultsetToSocio(ResultSet rs) throws SQLException {
		Socio s = new Socio();
		s.setCartao_socio(rs.getLong("cartao_socio"));
		s.setNome_socio(rs.getString("nome_socio"));
		s.setEnd_socio(rs.getString("end_socio"));
		s.setTel_socio(rs.getString("tel_socio"));
		s.setEmail_socio(rs.getString("email_socio"));
		s.setDes_cat(rs.getString("des_cat"));
		return s;
	}

	public static void main(String[] args) {
		Socio socio = new Socio(1l, "michele", "teste", "teste", "teste", "atual");
		System.out.println(RegSocio(socio));
	}
}