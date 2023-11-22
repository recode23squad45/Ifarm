package br.org.recodepro.ifarm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.org.recodepro.ifarm.dao.ConcessaoCreditoDAO;
import br.org.recodepro.ifarm.dao.CooperadoDAO;
import br.org.recodepro.ifarm.modelo.Cooperado;

@WebServlet("/cooperados")
public class CooperadoController extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CooperadoDAO dao = new CooperadoDAO();

		List<Cooperado> listaDeCooperados = dao.readAll();

		request.setAttribute("cooperados", listaDeCooperados);

		request.getRequestDispatcher("/list_cooperados.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpfToDelete = request.getParameter("delete");
		if (cpfToDelete != null) {
			System.out.println("deletando cooperado: " + cpfToDelete);
			deletar(cpfToDelete);
			response.sendRedirect(request.getContextPath() + "/cooperados");
		} else {
			CooperadoDAO dao = new CooperadoDAO();
			
			Cooperado cooperado = new Cooperado();
			cooperado.setCpf(request.getParameter("cpf"));
			cooperado.setNomeCooperado(request.getParameter("nomeCooperado"));
			cooperado.setEndereco(request.getParameter("endereco"));
			cooperado.setTelefone(request.getParameter("telefone"));
			
			dao.create(cooperado);
			
			response.sendRedirect(request.getContextPath() + "/cad_cooperado.jsp");
		}
	}

	private void deletar(String cpfToDelete) {
		// deletar dependencia de concessao_credito
		ConcessaoCreditoDAO concessaoCreditoDao = new ConcessaoCreditoDAO();
		concessaoCreditoDao.deleteByCooperadoId(cpfToDelete);
		
		CooperadoDAO dao = new CooperadoDAO();
		dao.delete(cpfToDelete);
	}
}
