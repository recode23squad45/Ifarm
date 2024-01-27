package br.org.recodepro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.org.recodepro.dao.EmpresaParceiraRepository;
import br.org.recodepro.model.EmpresaParceira;

@Controller
@RequestMapping("/empresas_parceiras")
public class EmpresaParceiraController {

	@Autowired
	private EmpresaParceiraRepository empresaParceiraRepository;

	@GetMapping
	public String listarEmpresasParceiras(Model model) {
		List<EmpresaParceira> empresasParceiras = empresaParceiraRepository.findAll();
		model.addAttribute("empresasParceiras", empresasParceiras);

		return "list_empresas_parceiras";
	}

	@GetMapping("/cad_empresa_parceira")
	public String cadEmpresaParceira(Model model) {
		return "cad_empresa_parceira";
	}

	@PostMapping
	public String cadastrarEmpresaParceira(@Validated EmpresaParceira empresaParceira, Model model) {
		EmpresaParceira entity = empresaParceiraRepository.save(empresaParceira);

		model.addAttribute("alerta", "Empresa Parceira " + entity.getNomeEmpresa() + " cadastrado com sucesso");

		return cadEmpresaParceira(model);
	}

	@PostMapping("/deletar/{id}")
	public String deleteById(@PathVariable("id") String idPedido, Model model) {
		if (idPedido != null && idPedido != "") {
			EmpresaParceira empresaParceira = empresaParceiraRepository.findById(idPedido).orElseGet(null);
			if (empresaParceira != null) {
				// deletar empresaParceira
				empresaParceiraRepository.delete(empresaParceira);
				model.addAttribute("alerta", "Empresa Parceira " + empresaParceira.getNomeEmpresa() + " deletado com sucesso!");
			}
		}

		return listarEmpresasParceiras(model);
	}

}
