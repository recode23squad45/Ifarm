package br.org.recodepro.ifarm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.org.recodepro.ifarm.dao.PedidoDAO;
import br.org.recodepro.ifarm.modelo.Pedido;

@WebServlet("/pedidos")
public class PedidoController extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PedidoDAO dao = new PedidoDAO();

		List<Pedido> listaDePedidos = dao.readAll();

		request.setAttribute("pedidos", listaDePedidos);

		request.getRequestDispatcher("/list_pedidos.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PedidoDAO dao = new PedidoDAO();
		
		Pedido pedido = new Pedido();
		pedido.setCnpjCliente(request.getParameter("cnpjCliente"));
		pedido.setDtEntrega(request.getParameter("dtEntrega"));
		pedido.setTipoPedido(request.getParameter("tipoPedido"));
		pedido.setStatus("CRIADO");
		String valorTotalString = request.getParameter("valorTotal");
		Double totalString = Double.valueOf(valorTotalString);
		pedido.setValorTotal(totalString);
		
		dao.create(pedido);
		
		response.sendRedirect(request.getContextPath() + "/cad_pedido.jsp");
	}
}
