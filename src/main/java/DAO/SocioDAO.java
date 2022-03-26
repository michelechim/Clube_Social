package DAO;

import model.Socio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SocioDAO extends BaseDAO {

	public static List<Socio> SelectSocio(final Long id_cat) {
		final String sql = "SELECT * FROM socio ORDER BY nome_socio";
		try //try-witch-resource
		(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			pstmt.setLong(1,id_cat);
			ResultSet rs = pstmt.executeQuery();
			List<Socio> socio = new ArrayList<>();
			while(rs.next()) {
				socio.add(resultsetToSocio(rs));
			}
			return socio;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
    public static boolean RegSocio(Socio Socio){
    	final String sql = "INSERT INTO socio (nome_socio, end_socio, tel_socio, email_socio, id_cat) VALUES (?, ?, ?, ?, ?);";
		try //try-witch-resource
		(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		)
        {
            pstmt.setString(1, Socio.getNome_socio());
            pstmt.setString(2, Socio.getEnd_socio());
            pstmt.setString(3, Socio.getTel_socio());
            pstmt.setString(4, Socio.getEmail_socio());
            pstmt.setLong(5, Socio.getCategoria().getId_cat());
            int count = pstmt.executeUpdate();
			return count > 0;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
    
    public static Socio ConsSocio(Long cartao_socio) {
		final String sql = "SELECT * FROM Socio WHERE cartao_socio=?";
		try (
				Connection conn = getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
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
    public static List<Socio> selectSocio() {
		final String sql = "SELECT * FROM socio ORDER BY nome_socio";
		try // try-witch-resource
		(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
		)
		{
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
		try
		(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		)
		{
			pstmt.setLong(1,cartao_socio);	
			ResultSet rs = pstmt.executeQuery();
			Socio socio = null;
			if(rs.next()) {
				socio = resultsetToSocio(rs);
			}
			rs.close();
			return socio;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
    
	//m�todo utilit�rio, converte ResultSet na classe de modelo (nesse caso, Socio)
	private static Socio resultsetToSocio(ResultSet rs) throws SQLException {
		Socio s = new Socio();
		s.setCartao_socio(rs.getLong("cartao_socio"));
		s.setNome_socio(rs.getString("nome_socio"));
		s.setEnd_socio(rs.getString("end_socio"));
		s.setTel_socio(rs.getString("tel_socio"));
		s.setEmail_socio(rs.getString("email_socio"));
		s.setCategoria(CategoriaDAO.selectCategoriaById(rs.getLong("id_cat")));
		return s;
	}
	
	public static void main(String[] args) {
		Socio socio = new Socio (1l,"michele","teste","teste","teste",CategoriaDAO.selectCategoriaById((long) 1));		
		System.out.println(RegSocio(socio));		
	}
}