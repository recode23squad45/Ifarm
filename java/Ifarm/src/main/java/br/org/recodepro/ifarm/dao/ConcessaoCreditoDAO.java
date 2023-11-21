package br.org.recodepro.ifarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.org.recodepro.ifarm.modelo.ConcessaoCredito;

public class ConcessaoCreditoDAO {

	// create
	public void create(ConcessaoCredito concessao) {
		String sql = "INSERT INTO concessao_credito (cpf_cooperado, cnpj_parceira, valor, dt_concessao) VALUES (?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, concessao.getCooperado().getCpf());
			pstm.setString(2, concessao.getEmpresaParceira().getCnpj());
			pstm.setDouble(3, concessao.getValor());
			pstm.setString(4, concessao.getDtConcessao());

			pstm.execute();
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// read all
	public List<ConcessaoCredito> readAll() {
		String sql = "SELECT * FROM concessao_credito";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		List<ConcessaoCredito> listaConcessoesDeCredito = new ArrayList<>();

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();

			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			ConcessaoCredito concessao = new ConcessaoCredito();
			CooperadoDAO cooperadoDAO = new CooperadoDAO();
			EmpresaParceiraDAO empresaParceiraDAO = new EmpresaParceiraDAO();

			while (rset.next()) {
				concessao.setIdConcessao(rset.getInt("id_concessao"));
				String cpfCooperado = rset.getString("cpf_cooperado");
				concessao.setCooperado(cooperadoDAO.readByCPF(cpfCooperado));
				String cnpjEmpresaParceira = rset.getString("cnpj_parceira");
				concessao.setEmpresaParceira(empresaParceiraDAO.readByCNPJ(cnpjEmpresaParceira));
				concessao.setValor(rset.getDouble("valor"));
				concessao.setDtConcessao(rset.getString("dt_concessao"));

				listaConcessoesDeCredito.add(concessao);
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return listaConcessoesDeCredito;
	}

	// readById
	public ConcessaoCredito readById(Integer idConcessao) {
		ConcessaoCredito concessao = new ConcessaoCredito();
		String sql = "SELECT * FROM concessao_credito WHERE id_concessao = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();

			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idConcessao);
			rset = pstm.executeQuery();

			if (rset.next()) {
				CooperadoDAO cooperadoDAO = new CooperadoDAO();
				EmpresaParceiraDAO empresaParceiraDAO = new EmpresaParceiraDAO();

				concessao.setIdConcessao(rset.getInt("id_concessao"));
				String cpfCooperado = rset.getString("cpf_cooperado");
				concessao.setCooperado(cooperadoDAO.readByCPF(cpfCooperado));
				String cnpjEmpresaParceira = rset.getString("cnpj_parceira");
				concessao.setEmpresaParceira(empresaParceiraDAO.readByCNPJ(cnpjEmpresaParceira));
				concessao.setValor(rset.getDouble("valor"));
				concessao.setDtConcessao(rset.getString("dt_concessao"));
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return concessao;
	}

	// update
	public void update(ConcessaoCredito concessao) {
		String sql = "UPDATE concessao_credito SET id_concessao = ?, cpf_cooperado = ?, cnpj_parceira = ?, valor = ?, dt_concessao = ? WHERE id_concessao = ?";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, concessao.getIdConcessao());
			pstm.setString(2, concessao.getCooperado().getCpf());
			pstm.setString(3, concessao.getEmpresaParceira().getCnpj());
			pstm.setDouble(4, concessao.getValor());
			pstm.setString(5, concessao.getDtConcessao());

			pstm.execute();
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// delete
	public void delete(Integer idConcessao) {
		String sql = "DELETE FROM concessao_credito WHERE id_concessao = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, idConcessao);
			pstm.execute();
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
