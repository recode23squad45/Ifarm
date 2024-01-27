package br.org.recodepro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sobrenos")
public class SobreNosController {

	@GetMapping
	public String getSobreNos(Model model) {
		return "sobrenos";
	}

}
