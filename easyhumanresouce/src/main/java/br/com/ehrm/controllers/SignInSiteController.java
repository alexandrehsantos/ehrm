package br.com.ehrm.controllers;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import br.com.ehrm.utils.DDLUtil;
import br.com.ehrm.vo.SignInVO;

@Controller
public class SignInSiteController {

	@Inject
	private DDLUtil ddlUtil;

	@RequestMapping(value = "/signinsite")
	public String getIndex(Model model) {
		model.addAttribute("signInVO", new SignInVO());
		return "signinsite";
	}

	@PostMapping("/signinsite")
	public String signSiteSubmit(@ModelAttribute("signInVO") SignInVO signInVO, Model model) {

		ddlUtil.createDataBase(signInVO.getSiteName());

		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("panel");

		return "redirect:/panel";
	}

}
