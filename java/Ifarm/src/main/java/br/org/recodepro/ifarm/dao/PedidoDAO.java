package br.org.recodepro.ifarm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.org.recodepro.ifarm.modelo.Pedido;
import br.org.recodepro.ifarm.modelo.Produto;
import br.org.recodepro.ifarm.modelo.ProdutoPedido;

public class PedidoDAO {

	// create
	public void create(Pedido pedido) {
		String sql = "INSERT INTO pedido (dt_entrega, tipo_pedido, status, valor_total, cnpj_cliente) VALUES (?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, pedido.getDtEntrega());
			pstm.setString(2, pedido.getTipoPedido());
			pstm.setString(3, pedido.getStatus());
			pstm.setDouble(4, pedido.getValorTotal());
			pstm.setString(5, pedido.getCnpjCliente());

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
	public List<Pedido> readAll() {
		String sql = "SELECT * FROM pedido";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		List<Pedido> listaPedidos = new ArrayList<>();

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();

			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			ProdutoPedidoDAO produtoPedidoDAO = new ProdutoPedidoDAO();
			ProdutoDAO produtoDAO = new ProdutoDAO();

			while (rset.next()) {
				Pedido pedido = new Pedido();

				pedido.setIdPedido(rset.getInt("id_pedido"));
				pedido.setDtEntrega(rset.getString("dt_entrega"));
				pedido.setTipoPedido(rset.getString("tipo_pedido"));
				pedido.setStatus(rset.getString("status"));
				pedido.setValorTotal(rset.getDouble("valor_total"));
				pedido.setCnpjCliente(rset.getString("cnpj_cliente"));

				List<ProdutoPedido> listaProdutosPedidos = produtoPedidoDAO.findAllByIdPedido(rset.getInt("id_pedido"));

				List<Produto> produtos = new ArrayList<>();
				for (int x = 0; x < listaProdutosPedidos.size(); x++) {
					produtos.add(produtoDAO.readById(listaProdutosPedidos.get(x).getIdProduto()));
				}
				pedido.setListaProdutos(produtos);

				listaPedidos.add(pedido);
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

		return listaPedidos;
	}

	// readById
	public Pedido readById(String idPedido) {
		Pedido pedido = new Pedido();
		String sql = "SELECT * FROM pedido WHERE id_pedido = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, idPedido);
			rset = pstm.executeQuery();

			ProdutoPedidoDAO produtoPedidoDAO = new ProdutoPedidoDAO();
			ProdutoDAO produtoDAO = new ProdutoDAO();

			if (rset.next()) {
				pedido.setIdPedido(rset.getInt("id_pedido"));
				pedido.setDtEntrega(rset.getString("dt_entrega"));
				pedido.setTipoPedido(rset.getString("tipo_pedido"));
				pedido.setStatus(rset.getString("status"));
				pedido.setValorTotal(rset.getDouble("valor_total"));
				pedido.setCnpjCliente(rset.getString("cnpj_cliente"));

				List<ProdutoPedido> listaProdutosPedidos = produtoPedidoDAO.findAllByIdPedido(rset.getInt("id_pedido"));

				List<Produto> produtos = new ArrayList<>();
				for (int x = 0; x < listaProdutosPedidos.size(); x++) {
					produtos.add(produtoDAO.readById(listaProdutosPedidos.get(x).getIdProduto()));
				}
				pedido.setListaProdutos(produtos);
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

		return pedido;
	}

	// update
	public void update(Pedido pedido) {
		String sql = "UPDATE pedido SET id_pedido = ?, dt_entrega = ?, tipo_pedido = ?, status = ?, valor_total = ?, cnpj_cliente = ? WHERE id_pedido = ?";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, pedido.getIdPedido());
			pstm.setString(2, pedido.getDtEntrega());
			pstm.setString(3, pedido.getTipoPedido());
			pstm.setString(4, pedido.getStatus());
			pstm.setDouble(5, pedido.getValorTotal());
			pstm.setString(6, pedido.getCnpjCliente());

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
	public void delete(Integer idPedido) {
		String sql = "DELETE FROM pedido WHERE id_pedido = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			ConectarDB conectarDb = new ConectarDB();
			conn = conectarDb.conectar();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, idPedido);
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
