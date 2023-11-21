package br.org.recodepro.ifarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.org.recodepro.ifarm.modelo.EmpresaParceira;

public class EmpresaParceiraDAO {

	// create
	public void create(EmpresaParceira empresa) {
		String sql = "INSERT INTO empresa_parceira (cnpj, nome_empresa, contato_empresa) VALUES (?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, empresa.getCnpj());
			pstm.setString(2, empresa.getNomeEmpresa());
			pstm.setString(3, empresa.getContatoEmpresa());

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
	public List<EmpresaParceira> readAll() {
		String sql = "SELECT * FROM empresa_parceira";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		List<EmpresaParceira> listaEmpresasParceiras = new ArrayList<>();

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();

			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				EmpresaParceira empresa = new EmpresaParceira();

				empresa.setCnpj(rset.getString("cnpj"));
				empresa.setNomeEmpresa(rset.getString("nome_empresa"));
				empresa.setContatoEmpresa(rset.getString("contato_empresa"));

				listaEmpresasParceiras.add(empresa);
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

		return listaEmpresasParceiras;
	}

	// readById
	public EmpresaParceira readByCNPJ(String cnpj) {
		EmpresaParceira empresa = new EmpresaParceira();
		String sql = "SELECT * FROM empresa_parceira WHERE cnpj = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cnpj);
			rset = pstm.executeQuery();

			if (rset.next()) {
				empresa.setCnpj(rset.getString("cnpj"));
				empresa.setNomeEmpresa(rset.getString("nome_empresa"));
				empresa.setContatoEmpresa(rset.getString("contato_empresa"));
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

		return empresa;
	}

	// update
	public void update(EmpresaParceira empresa) {
		String sql = "UPDATE empresa_parceira SET cnpj = ?, nome_empresa = ?, contato_empresa = ? WHERE cnpj = ?";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, empresa.getCnpj());
			pstm.setString(2, empresa.getNomeEmpresa());
			pstm.setString(3, empresa.getContatoEmpresa());
			pstm.setString(4, empresa.getCnpj());

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
	public void delete(String cnpj) {
		String sql = "DELETE FROM empresa_parceira WHERE cnpj = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cnpj);
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
