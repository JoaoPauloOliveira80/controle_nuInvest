package Application.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Application.conection.ConexaoMySQL;
import Application.model.Negociacao;
import Application.model.Proventos;

public class ProventosDao {

	public List<Proventos> getProventos() {
		String sql = "SELECT * FROM proventos";

		List<Proventos> lista = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			conn = (Connection) ConexaoMySQL.create();
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			rs = pstm.executeQuery();
			
			if (rs.next()) {
				while (rs.next()) {
					Proventos p = new Proventos();
					p.setId(rs.getInt(1));
					p.setDt_recib(rs.getString(2));
					p.setAtivo(rs.getString(3));
					p.setProventos(rs.getDouble(4));					

					lista.add(p);
				}
			} else {
				System.out.println("Não foram encontrado proventos...");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

				if (rs != null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

		return lista;
	}

	public void insert(Proventos prov) throws SQLException {

		String sql = "INSERT INTO proventos (dt_recebimento	, ativo, proventos) VALUES (?,?,?)";

		Connection conn = null; // id,dt_negociacao, dt_negociacao, preco_cota, qtd_compra,
		PreparedStatement pstm = null;
		int cont = 1;
		try {
			conn = (Connection) ConexaoMySQL.create();
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, prov.getDt_recib());
			pstm.setString(2, prov.getAtivo());
			pstm.setDouble(3, prov.getProventos());
			

			pstm.execute();
			
			System.out.println("Registro armazendo com sucesso...");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
	}

}
