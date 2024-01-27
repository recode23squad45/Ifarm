package br.org.recodepro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping
	public String getHome(Model model) {
		model.addAttribute("something", "this is a hello world");
		return "index";
	}

}
