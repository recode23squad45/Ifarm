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

import br.org.recodepro.dao.CooperadoRepository;
import br.org.recodepro.model.Cooperado;

@Controller
@RequestMapping("/cooperados")
public class CooperadoController {

	@Autowired
	private CooperadoRepository cooperadoRepository;

	@GetMapping
	public String listarCooperados(Model model) {
		List<Cooperado> cooperados = cooperadoRepository.findAll();
		model.addAttribute("cooperados", cooperados);

		return "list_cooperados";
	}

	@GetMapping("/cad_cooperado")
	public String cadCooperado(Model model) {
		return "cad_cooperado";
	}

	@PostMapping
	public String cadastrarCooperado(@Validated Cooperado cooperado, Model model) {
		Cooperado entity = cooperadoRepository.save(cooperado);

		model.addAttribute("alerta", "Cooperado " + entity.getNomeCooperado() + " cadastrado com sucesso");

		return cadCooperado(model);
	}
	
	@PostMapping("/deletar/{id}")
	public String deleteById(@PathVariable("id") String cpfCooperado, Model model) {
		if (cpfCooperado != null && cpfCooperado != "") {
			Cooperado cooperado = cooperadoRepository.findById(cpfCooperado).orElseGet(null);
			if (cooperado != null) {
				// deletar cooperado
				cooperadoRepository.delete(cooperado);
				model.addAttribute("alerta", "Cooperado " + cooperado.getNomeCooperado() + " deletado com sucesso!");
			}
		}

		return listarCooperados(model);
	}
	
	@PostMapping("/editar/{id}")
	public String editarById(@PathVariable("id") String cpfCooperado, Model model) {
		if (cpfCooperado != null && cpfCooperado != "") {
			Cooperado cooperado = cooperadoRepository.findById(cpfCooperado).orElseGet(null);
			if (cooperado != null) {
				model.addAttribute("cooperado", cooperado);
			}
		}

		return cadCooperado(model);
	}

}
