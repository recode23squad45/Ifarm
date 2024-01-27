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

import br.org.recodepro.dao.ProdutoRepository;
import br.org.recodepro.model.Produto;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoDAO;

	@GetMapping
	public String listarPedidos(Model model) {
		List<Produto> produtos = produtoDAO.findAll();
		model.addAttribute("produtos", produtos);

		return "list_produtos";
	}

	@GetMapping("/cad_produto")
	public String cadProduto(Model model) {
		return "cad_produto";
	}

	@PostMapping
	public String cadastrarProduto(@Validated Produto produto, Model model) {
		Produto entity = produtoDAO.save(produto);

		model.addAttribute("alerta", "Produto " + entity.getNomeProduto() + " cadastrado com sucesso");

		return cadProduto(model);
	}
	
	@PostMapping("/deletar/{id}")
	public String deleteById(@PathVariable("id") String idProduto, Model model) {
		if (idProduto != null && idProduto != "") {
			Integer id = Integer.parseInt(idProduto);
			Produto produto = produtoDAO.findById(id).orElseGet(null);
			if (produto != null) {
				// deletar produto
				produtoDAO.delete(produto);
				model.addAttribute("alerta", "Produto " + produto.getNomeProduto() + " deletado com sucesso!");
			}
		}

		return listarPedidos(model);
	}

}
