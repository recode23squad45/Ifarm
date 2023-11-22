package br.org.recodepro.ifarm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.org.recodepro.ifarm.dao.ProdutoDAO;
import br.org.recodepro.ifarm.dao.ProdutoPedidoDAO;
import br.org.recodepro.ifarm.modelo.Produto;

@WebServlet("/produtos")
public class ProdutoController extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdutoDAO dao = new ProdutoDAO();

		List<Produto> listaDeProdutos = dao.readAll();

		request.setAttribute("produtos", listaDeProdutos);

		request.getRequestDispatcher("/list_produtos.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idProduto = request.getParameter("delete");
		if (idProduto != null) {
			System.out.println("deletando produto: " + idProduto);
			deletar(idProduto);
			response.sendRedirect(request.getContextPath() + "/produtos");
		} else {
			ProdutoDAO dao = new ProdutoDAO();
			
			Produto produto = new Produto();
			produto.setNomeProduto(request.getParameter("nomeProduto"));
			produto.setCategoria(request.getParameter("categoria"));
			String quantidadeString = request.getParameter("quantidade");
			Integer quantidade = Integer.parseInt(quantidadeString);
			produto.setQuantidade(quantidade);
	
			dao.create(produto);
			
			response.sendRedirect(request.getContextPath() + "/cad_produto.jsp");
		}
	}

	private void deletar(String idProduto) {
		Integer id = Integer.parseInt(idProduto);
		
		ProdutoPedidoDAO produtoPedidoDao = new ProdutoPedidoDAO();
		produtoPedidoDao.deleteByProdutoId(id);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.delete(id);
	}
}
