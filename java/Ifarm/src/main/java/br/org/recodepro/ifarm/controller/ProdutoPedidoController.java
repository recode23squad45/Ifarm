package br.org.recodepro.ifarm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.org.recodepro.ifarm.dao.ProdutoPedidoDAO;
import br.org.recodepro.ifarm.modelo.ProdutoPedido;

@WebServlet("/produtos_pedidos")
public class ProdutoPedidoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idPedido = request.getParameter("idPedido");
		
		request.setAttribute("idPedido", idPedido);

		request.getRequestDispatcher("/cad_produto_pedido.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdutoPedidoDAO dao = new ProdutoPedidoDAO();
		
		ProdutoPedido produtoPedido = new ProdutoPedido();
		String idPedidoString = request.getParameter("idPedido");
		Integer idPedido = Integer.parseInt(idPedidoString);
		produtoPedido.setIdPedido(idPedido);
		String idProdutoString = request.getParameter("idProduto");
		Integer idProduto = Integer.parseInt(idProdutoString);
		produtoPedido.setIdProduto(idProduto);
		String quantidadeString = request.getParameter("quantidade");
		Integer quantidade = Integer.parseInt(quantidadeString);
		produtoPedido.setQuantidade(quantidade);
		String valorTotalString = request.getParameter("valorTotal");
		Double valorTotal = Double.parseDouble(valorTotalString);
		produtoPedido.setValorTotal(valorTotal);
		
		dao.create(produtoPedido);
		
		response.sendRedirect(request.getContextPath() + "/pedidos");
	}

}
