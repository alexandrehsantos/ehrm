package br.com.ehrm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PanelController {

	@RequestMapping(value = "/panel/{}")
	public String showPanel(Model model) {
		return "systempages/panel";
	}

}
