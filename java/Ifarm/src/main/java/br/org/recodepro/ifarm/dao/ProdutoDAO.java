package br.org.recodepro.ifarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.org.recodepro.ifarm.modelo.Produto;

public class ProdutoDAO {

	// create
	public void create(Produto produto) {
		String sql = "INSERT INTO produto (nome_produto, quantidade, categoria) VALUES (?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, produto.getNomeProduto());
			pstm.setInt(2, produto.getQuantidade());
			pstm.setString(3, produto.getCategoria());

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
	public List<Produto> readAll() {
		String sql = "SELECT * FROM produto";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		List<Produto> listaProdutos = new ArrayList<>();

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();

			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Produto produto = new Produto();

				produto.setIdProduto(rset.getInt("id_produto"));
				produto.setNomeProduto(rset.getString("nome_produto"));
				produto.setQuantidade(rset.getInt("quantidade"));
				produto.setCategoria(rset.getString("categoria"));

				listaProdutos.add(produto);
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

		return listaProdutos;
	}

	// readById
	public Produto readById(Integer idProduto) {
		Produto produto = new Produto();
		String sql = "SELECT * FROM produto WHERE id_produto = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();

			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idProduto);
			rset = pstm.executeQuery();

			if (rset.next()) {
				produto.setIdProduto(rset.getInt("id_produto"));
				produto.setNomeProduto(rset.getString("nome_produto"));
				produto.setQuantidade(rset.getInt("quantidade"));
				produto.setCategoria(rset.getString("categoria"));
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

		return produto;
	}

	// update
	public void update(Produto produto) {
		String sql = "UPDATE produto SET id_produto = ?, nome_produto = ?, quantidade = ?, categoria = ? WHERE id_produto = ?";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, produto.getIdProduto());
			pstm.setString(2, produto.getNomeProduto());
			pstm.setInt(3, produto.getQuantidade());
			pstm.setString(4, produto.getCategoria());

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
	public void delete(Integer idProduto) {
		String sql = "DELETE FROM produto WHERE id_produto = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, idProduto);
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
