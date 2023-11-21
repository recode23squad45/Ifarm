package br.org.recodepro.ifarm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.org.recodepro.ifarm.dao.ConcessaoCreditoDAO;
import br.org.recodepro.ifarm.modelo.ConcessaoCredito;
import br.org.recodepro.ifarm.modelo.Cooperado;
import br.org.recodepro.ifarm.modelo.EmpresaParceira;

@WebServlet("/concessao_credito")
public class ConcessaoCreditoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConcessaoCreditoDAO dao = new ConcessaoCreditoDAO();

		List<ConcessaoCredito> listaConcessoesDeCredito = dao.readAll();

		request.setAttribute("concessoesCredito", listaConcessoesDeCredito);

		request.getRequestDispatcher("/list_concessoes_credito.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConcessaoCreditoDAO dao = new ConcessaoCreditoDAO();
		
		ConcessaoCredito concessao = new ConcessaoCredito();
		Cooperado cooperado = new Cooperado();
		cooperado.setCpf(request.getParameter("cpfCooperado"));
		concessao.setCooperado(cooperado);
		EmpresaParceira empresaParceira = new EmpresaParceira();
		empresaParceira.setCnpj(request.getParameter("cnpjEmpresaParceira"));
		concessao.setEmpresaParceira(empresaParceira);
		String valorString = request.getParameter("valor");
		Double valor = Double.parseDouble(valorString);
		concessao.setValor(valor);
		concessao.setDtConcessao(request.getParameter("dtConcessao"));
		
		dao.create(concessao);
		
		response.sendRedirect(request.getContextPath() + "/cad_concessao_credito.jsp");
	}
	
}
