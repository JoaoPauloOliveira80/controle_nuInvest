package Application.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Application.conection.ConexaoMySQL;
import Application.model.Negociacao;

public class NegociacaDao {

	public List<Negociacao> getLista() {
		String sql = "SELECT * FROM compra_venda";

		List<Negociacao> lista = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			conn = (Connection) ConexaoMySQL.create();
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			rs = pstm.executeQuery(); 
			
			if (rs.next()) {
				while (rs.next()) {
					Negociacao negocio = new Negociacao();

					negocio.setId(rs.getInt("id"));
					negocio.setDt_negociacao(rs.getString("dt_negociacao"));
					negocio.setAtivo(rs.getString("ativo"));
					negocio.setPreco_cota(rs.getDouble("preco"));
					negocio.setQtd_compra(rs.getInt("qtd_compra"));
					negocio.setQtd_venda(rs.getInt("qtd_venda"));
					negocio.setTotalCompra(rs.getDouble("valor_compra"));
					negocio.setTotalVenda(rs.getDouble("valor_venda"));

					lista.add(negocio);
				}
			} else {
				System.out.println("N�o foram encontrado registros...");

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

	public void insert(Negociacao negocio) throws SQLException {

		String sql = "INSERT INTO compra_venda (dt_negociacao, ativo, preco, qtd_compra, qtd_venda, valor_compra, valor_venda) VALUES (?,?, ?, ?,?,?,?)";

		Connection conn = null; // id,dt_negociacao, dt_negociacao, preco_cota, qtd_compra,
		PreparedStatement pstm = null;
		int cont = 1;
		try {
			conn = (Connection) ConexaoMySQL.create();
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, negocio.getDt_negociacao());
			pstm.setString(2, negocio.getAtivo());
			pstm.setDouble(3, negocio.getPreco_cota());
			pstm.setInt(4, negocio.getQtd_compra());
			pstm.setInt(5, negocio.getQtd_venda());
			pstm.setDouble(6, negocio.getTotalCompra());
			pstm.setDouble(7, negocio.getTotalVenda());

			pstm.execute();
			
			System.out.println("Compra armazendo com sucesso...");
			cont++;
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
