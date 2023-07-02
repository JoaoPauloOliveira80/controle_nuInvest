package Application.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Application.conection.ConexaoMySQL;
import Application.model.Depositos;
import Application.model.Proventos;

public class DepositoDao {

	public Depositos buscarByChave(int number) {
		String sql = "SELECT * FROM depositos WHERE id = ?";
		Depositos prod = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			conn = (Connection) ConexaoMySQL.create();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, number);
			rs = pstm.executeQuery();

			if (rs.next()) {
				// System.out.println();
				// System.out.println("Usuário encontrado...");
				prod = new Depositos();
				prod.setId(number);

			} else {

				//System.out.println("Fazer NOVO registro...");
			}

			return prod;

		} catch (Exception e) {
			return null;
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

	}

	public List<Depositos> getDepositos() {
		String sql = "SELECT * FROM depositos  order by data asc";

		List<Depositos> lista = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			conn = (Connection) ConexaoMySQL.create();
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			rs = pstm.executeQuery();

			
				while (rs.next()) {
					Depositos p = new Depositos();
					p.setId(rs.getInt(1));
					p.setDt_deposito(rs.getString(2));
					p.setOperacao(rs.getString(3));
					p.setDepositos(rs.getDouble(4));
					p.setDepositante(rs.getString(5));

					lista.add(p);
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

	
	
	public void insert(Depositos dep) throws SQLException {

		String sql = "INSERT INTO depositos (dt_deposito, operacao, depositos, 	depositante, id) VALUES (?,?,?,?,?)";

		Connection conn = null; // id,dt_negociacao, dt_negociacao, preco_cota, qtd_compra,
		PreparedStatement pstm = null;
		int cont = 1;
		try {
			conn = (Connection) ConexaoMySQL.create();
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, dep.getDt_deposito());
			pstm.setString(2, dep.getOperacao());
			pstm.setDouble(3, dep.getDepositos());
			pstm.setString(4, dep.getDepositante());
			pstm.setInt(5, dep.getId());

			pstm.execute();

			System.out.println("Deposito armazendo com sucesso...");

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
	
	public List<Proventos> getProventos() {
		String sql = "SELECT * FROM proventos  order by data asc";

		List<Proventos> lista = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			conn = (Connection) ConexaoMySQL.create();
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			rs = pstm.executeQuery();

			
				while (rs.next()) {
					Proventos prov = new Proventos();
					prov.setId(rs.getInt(1));
					prov.setDt_recebimeto(rs.getString(2));
					prov.setAtivo(rs.getString(3));
					prov.setValorDep(rs.getDouble(4));
					

					lista.add(prov);
					System.out.println();
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
	
	public Proventos getProvId(int number) {
		String sql = "SELECT * FROM proventos WHERE id = ?";
		Proventos prov = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			conn = (Connection) ConexaoMySQL.create();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, number);
			rs = pstm.executeQuery();

			if (rs.next()) {
				// System.out.println();
				// System.out.println("Usuário encontrado...");
				prov = new Proventos();
				prov.setId(number);

			} else {

				//System.out.println("Fazer NOVO registro...");
			}

			return prov;

		} catch (Exception e) {
			return null;
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

	}
	public void insertProventos(Proventos prov) throws SQLException {

		String sql = "INSERT INTO proventos (dt_recebimento, ativo, valor_dep, id) VALUES (?,?,?,?)";

		Connection conn = null; PreparedStatement pstm = null;
		
		try {
			conn = (Connection) ConexaoMySQL.create();
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, prov.getDt_recebimeto());
			pstm.setString(2, prov.getAtivo());
			pstm.setDouble(3, prov.getValorDep());
			pstm.setInt(4, prov.getId());

			pstm.execute();

			System.out.println("Proventos armazendo com sucesso...");

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

	public void update(Depositos dep) throws SQLException {

		String sql = "Update depositos SET 	statementNumber = ? WHERE id =?";

		Connection conn = null; // id,dt_negociacao, dt_negociacao, preco_cota, qtd_compra,
		PreparedStatement pstm = null;
		int cont = 1;
		try {

			conn = (Connection) ConexaoMySQL.create();
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			// pstm.setInt(1, dep.getStatementNumber());
			pstm.setInt(2, dep.getId());

			pstm.executeUpdate();

			System.out.println("Deposito armazendo com sucesso...");

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
