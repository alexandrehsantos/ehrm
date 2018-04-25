package br.com.ehrm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ehrm.vo.SignInVO;

@Controller
public class PanelController {

	@RequestMapping(value = "/panel")
	public String showPanel(Model model) {
		// TODO implementar a criação do usuário principal para o contexto atual.
		// model.addAttribute("tenantid", context);
		// System.out.println(context);
		System.out.println(model);
		return "systempages/panel";
	}

}
