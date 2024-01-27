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

import br.org.recodepro.dao.PedidoRepository;
import br.org.recodepro.model.Pedido;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping
	public String listarPedidos(Model model) {
		List<Pedido> pedidos = pedidoRepository.findAll();
		model.addAttribute("pedidos", pedidos);

		return "list_pedidos";
	}

	@GetMapping("/cad_pedido")
	public String cadPedido(Model model) {
		return "cad_pedido";
	}

	@PostMapping
	public String cadastrarPedido(@Validated Pedido pedido, Model model) {
		Pedido entity = pedidoRepository.save(pedido);

		model.addAttribute("alerta", "Pedido " + entity.getIdPedido() + " cadastrado com sucesso");

		return cadPedido(model);
	}
	
	@PostMapping("/deletar/{id}")
	public String deleteById(@PathVariable("id") String idPedido, Model model) {
		if (idPedido != null && idPedido != "") {
			Integer id = Integer.parseInt(idPedido);
			Pedido pedido = pedidoRepository.findById(id).orElseGet(null);
			if (pedido != null) {
				// deletar pedido
				pedidoRepository.delete(pedido);
				model.addAttribute("alerta", "Pedido " + pedido.getIdPedido() + " deletado com sucesso!");
			}
		}

		return listarPedidos(model);
	}

}
