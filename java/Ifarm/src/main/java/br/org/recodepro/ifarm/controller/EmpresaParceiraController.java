package br.org.recodepro.ifarm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.org.recodepro.ifarm.dao.ConcessaoCreditoDAO;
import br.org.recodepro.ifarm.dao.EmpresaParceiraDAO;
import br.org.recodepro.ifarm.modelo.EmpresaParceira;

@WebServlet("/empresas_parceiras")
public class EmpresaParceiraController extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpresaParceiraDAO dao = new EmpresaParceiraDAO();

		List<EmpresaParceira> listaDeEmpresasParceiras = dao.readAll();

		request.setAttribute("empresasParceiras", listaDeEmpresasParceiras);

		request.getRequestDispatcher("/list_empresas_parceiras.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cnpjEmpresaParceira = request.getParameter("delete");
		if (cnpjEmpresaParceira != null) {
			System.out.println("deletando empresa parceira: " + cnpjEmpresaParceira);
			deletar(cnpjEmpresaParceira);
			response.sendRedirect(request.getContextPath() + "/empresas_parceiras");
		} else {
			EmpresaParceiraDAO dao = new EmpresaParceiraDAO();
			
			EmpresaParceira empresa = new EmpresaParceira();
			empresa.setCnpj(request.getParameter("cnpj"));
			empresa.setNomeEmpresa(request.getParameter("nomeEmpresa"));
			empresa.setContatoEmpresa(request.getParameter("contatoEmpresa"));
			
			dao.create(empresa);
			
			response.sendRedirect(request.getContextPath() + "/cad_empresa_parceira.jsp");
		}
	}

	private void deletar(String cnpjEmpresaParceira) {
		ConcessaoCreditoDAO concessaoCreditoDao = new ConcessaoCreditoDAO();
		concessaoCreditoDao.deleteByEmpresaParceiraId(cnpjEmpresaParceira);
		
		EmpresaParceiraDAO dao = new EmpresaParceiraDAO();
		dao.delete(cnpjEmpresaParceira);
	}
}
