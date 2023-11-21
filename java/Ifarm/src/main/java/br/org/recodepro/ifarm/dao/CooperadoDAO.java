package br.org.recodepro.ifarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.org.recodepro.ifarm.modelo.Cooperado;

public class CooperadoDAO {

	// create
	public void create(Cooperado cooperado) {
		String sql = "INSERT INTO cooperado (nome_cooperado, cpf, endereco, telefone) VALUES (?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cooperado.getNomeCooperado());
			pstm.setString(2, cooperado.getCpf());
			pstm.setString(3, cooperado.getEndereco());
			pstm.setString(4, cooperado.getTelefone());

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
	public List<Cooperado> readAll() {
		String sql = "SELECT * FROM cooperado";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		List<Cooperado> listaCooperados = new ArrayList<>();

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();

			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Cooperado coop = new Cooperado();

				coop.setNomeCooperado(rset.getString("nome_cooperado"));
				coop.setCpf(rset.getString("cpf"));
				coop.setEndereco(rset.getString("endereco"));
				coop.setTelefone(rset.getString("telefone"));

				listaCooperados.add(coop);
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

		return listaCooperados;
	}

	// readById
	public Cooperado readByCPF(String cpf) {
		Cooperado coop = new Cooperado();
		String sql = "SELECT * FROM cooperado WHERE cpf = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cpf);
			rset = pstm.executeQuery();

			if (rset.next()) {
				coop.setNomeCooperado(rset.getString("nome_cooperado"));
				coop.setCpf(rset.getString("cpf"));
				coop.setEndereco(rset.getString("endereco"));
				coop.setTelefone(rset.getString("telefone"));
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

		return coop;
	}

	// update
	public void update(Cooperado coop) {
		String sql = "UPDATE cooperado SET nome_cooperado = ?, cpf = ?, endereco = ?, telefone = ? WHERE cpf = ?";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, coop.getNomeCooperado());
			pstm.setString(2, coop.getCpf());
			pstm.setString(3, coop.getEndereco());
			pstm.setString(4, coop.getTelefone());
			pstm.setString(5, coop.getCpf());

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
	public void delete(String cpf) {
		String sql = "DELETE FROM cooperado WHERE CPF = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cpf);
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
