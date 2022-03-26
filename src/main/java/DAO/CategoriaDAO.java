package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Categoria;

public class CategoriaDAO extends BaseDAO {
	public static List<Categoria> ConsCat() {
		final String sql = "SELECT * FROM categoria";
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			List<Categoria> categoria = new ArrayList<>();
			while (rs.next()) {
				categoria.add(resultsetToCategoria(rs));
			}
			return categoria;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean RegCat(Categoria categoria) {
		final String sql = "INSERT INTO categoria (des_cat) VALUES(?)";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, categoria.getDes_cat());
			int count = pstmt.executeUpdate();
			return count >0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Categoria selectCategoriaById(Long id_cat) {
		final String sql = "SELECT * FROM categoria WHERE id_cat=?";
		try
		(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		)
		{
			pstmt.setLong(1, id_cat);	
			ResultSet rs = pstmt.executeQuery();
			Categoria categoria = null;
			if(rs.next()) {
				categoria = resultsetToCategoria(rs);
			}
			rs.close();
			return categoria;
			
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static List<Categoria> selectCategoriaByDes(String des_cat) {
		final String sql = "SELECT * FROM categoria WHERE des_cat LIKE ? ORDER BY des_cat";
		try //try-witch-resource
			(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			)
		{
			pstmt.setString(1, des_cat);	
			ResultSet rs = pstmt.executeQuery();
			List<Categoria> categoria = new ArrayList<>();
			while(rs.next()) {
				categoria.add(resultsetToCategoria(rs));
			}
			return categoria;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// metodo utilitario, converte ResultSet na classe de modelo (nesse caso,categoria)
	private static Categoria resultsetToCategoria(ResultSet rs) throws SQLException {
		Categoria c = new Categoria();
		c.setId_cat(rs.getLong("id_cat"));
		c.setDes_cat(rs.getString("des_cat"));
		return c;
	}

	public static void main(String[] args) {
		Categoria categoria = new Categoria(1L,"Individual");
		System.out.println(RegCat(categoria));
	//	System.out.println(CategoriaDAO.RegCat(categoria));
	}
}