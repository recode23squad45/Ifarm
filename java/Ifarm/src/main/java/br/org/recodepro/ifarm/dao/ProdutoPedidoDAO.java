package br.org.recodepro.ifarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.org.recodepro.ifarm.modelo.ProdutoPedido;

public class ProdutoPedidoDAO {

	// create
	public void create(ProdutoPedido produtoPedido) {
		String sql = "INSERT INTO produto_pedido (id_pedido, id_produto, quantidade, valor_total) VALUES (?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, produtoPedido.getIdPedido());
			pstm.setInt(2, produtoPedido.getIdProduto());
			pstm.setInt(3, produtoPedido.getQuantidade());
			pstm.setDouble(4, produtoPedido.getValorTotal());

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
	public List<ProdutoPedido> readAll() {
		String sql = "SELECT * FROM produto_pedido";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		List<ProdutoPedido> listaProdutoPedidos = new ArrayList<>();

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();

			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				ProdutoPedido produtoPedido = new ProdutoPedido();

				produtoPedido.setIdProdutoPedido(rset.getInt("id_produto_pedido"));
				produtoPedido.setIdPedido(rset.getInt("id_pedido"));
				produtoPedido.setIdProduto(rset.getInt("id_produto"));
				produtoPedido.setQuantidade(rset.getInt("quantidade"));
				produtoPedido.setValorTotal(rset.getDouble("valor_total"));

				listaProdutoPedidos.add(produtoPedido);
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

		return listaProdutoPedidos;
	}

	// readById
	public ProdutoPedido readById(Integer idProdutoPedido) {
		ProdutoPedido produtoPedido = new ProdutoPedido();
		String sql = "SELECT * FROM produto_pedido WHERE id_produto_pedido = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();

			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idProdutoPedido);
			rset = pstm.executeQuery();

			if (rset.next()) {
				produtoPedido.setIdProdutoPedido(rset.getInt("id_produto_pedido"));
				produtoPedido.setIdPedido(rset.getInt("id_pedido"));
				produtoPedido.setIdProduto(rset.getInt("id_produto"));
				produtoPedido.setQuantidade(rset.getInt("quantidade"));
				produtoPedido.setValorTotal(rset.getDouble("valor_total"));
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

		return produtoPedido;
	}

	public List<ProdutoPedido> findAllByIdPedido(Integer idPedido) {
		String sql = "SELECT * FROM produto_pedido WHERE id_pedido = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		List<ProdutoPedido> listaProdutoPedidos = new ArrayList<>();

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();

			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idPedido);
			rset = pstm.executeQuery();

			while (rset.next()) {
				ProdutoPedido produtoPedido = new ProdutoPedido();

				produtoPedido.setIdProdutoPedido(rset.getInt("id_produto_pedido"));
				produtoPedido.setIdPedido(rset.getInt("id_pedido"));
				produtoPedido.setIdProduto(rset.getInt("id_produto"));
				produtoPedido.setQuantidade(rset.getInt("quantidade"));
				produtoPedido.setValorTotal(rset.getDouble("valor_total"));

				listaProdutoPedidos.add(produtoPedido);
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

		return listaProdutoPedidos;
	}

	// update
	public void update(ProdutoPedido produtoPedido) {
		String sql = "UPDATE produto_pedido SET id_produto_pedido = ?, id_pedido = ?, id_produto = ?, quantidade = ?, valor_total = ? WHERE id_produto_pedido = ?";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, produtoPedido.getIdProdutoPedido());
			pstm.setInt(2, produtoPedido.getIdPedido());
			pstm.setInt(3, produtoPedido.getIdProduto());
			pstm.setInt(4, produtoPedido.getQuantidade());
			pstm.setDouble(5, produtoPedido.getValorTotal());
			pstm.setInt(6, produtoPedido.getIdProdutoPedido());

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
	public void delete(Integer idProdutoPedido) {
		String sql = "DELETE FROM produto_pedido WHERE id_produto_pedido = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, idProdutoPedido);
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

	public void deleteByProdutoId(Integer produtoId) {
		String sql = "DELETE FROM produto_pedido WHERE id_produto = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, produtoId);
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

	public void deleteByPedidoId(Integer pedidoId) {
		String sql = "DELETE FROM produto_pedido WHERE id_pedido = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, pedidoId);
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
