package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.Mensalidade;

public class MensalidadeDAO extends BaseDAO {
	public static Mensalidade ConsMens(Long nro_mens) {
		final String sql = "SELECT * FROM mensalidade WHERE nro_mens=?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setLong(1, nro_mens);
			ResultSet rs = pstmt.executeQuery();
			Mensalidade mensalidade = null;
			if (rs.next()) {
				mensalidade = resultsetToMensalidade(rs);
			}
			rs.close();
			return mensalidade;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean RegMens(Mensalidade mensalidade) {
		final String sql = "INSERT INTO mensalidade (data_mens, valor_mens, data_pgto_mens, juros_mens, valor_pago,quit_mens, cartao_socio)"
				+ " VALUES(?,?,?,?,?,?,?)";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setDate(1, (java.sql.Date) new Date(new java.util.Date().getTime()));
			pstmt.setDouble(2, mensalidade.getValor_mens());
			pstmt.setDate(3, (java.sql.Date) new Date(new java.util.Date().getTime()));
			pstmt.setDouble(4, mensalidade.getJuros_mens());
			pstmt.setDouble(5, mensalidade.getValor_pago());
			pstmt.setBoolean(6, true);
			pstmt.setLong(7, mensalidade.getSocio().getCartao_socio());
			int count = pstmt.executeUpdate();
			return count > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static List<Mensalidade> SelectMensalidade() {
		final String sql = "SELECT * FROM mensalidade";
		try // try-witch-resource
		(Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			List<Mensalidade> mensalidade = new ArrayList<>();
			while (rs.next()) {
				mensalidade.add(resultsetToMensalidade(rs));
			}
			return mensalidade;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Mensalidade selectMensalidadeById(Long nro_mens) {
		final String sql = "SELECT * FROM mensalidade WHERE nro_mens=?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setLong(1, nro_mens);
			ResultSet rs = pstmt.executeQuery();
			Mensalidade mensalidade = null;
			if (rs.next()) {
				mensalidade = resultsetToMensalidade(rs);
			}
			rs.close();
			return mensalidade;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// metodo utilitario, converte ResultSet na classe de modelo (nesse // caso,categoria)
	private static Mensalidade resultsetToMensalidade(ResultSet rs) throws SQLException {
		Mensalidade m = new Mensalidade();
		m.setNro_mens(rs.getLong("nro_mens"));
		m.setData_mens(dateToCalendar(rs.getDate("data_mens")));
		m.setValor_mens(rs.getDouble("valor_pago"));
		m.setData_pgto_mens(dateToCalendar(rs.getDate("data_pgto_mens")));
		m.setJuros_mens(rs.getDouble("juros_mens"));
		m.setValor_pago(rs.getDouble("valor_pago"));
		m.setQuit_mens(rs.getBoolean("quit_mens"));
		m.setSocio(SocioDAO.selectSocioById(rs.getLong("cartao_socio")));
		return m;
	}

	public static void main(String[] args) {
		Mensalidade mensalidade = new Mensalidade(1L, null, null, null, null, null, null, null);
		System.out.println(RegMens(mensalidade));
	}
	private static Calendar dateToCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
}