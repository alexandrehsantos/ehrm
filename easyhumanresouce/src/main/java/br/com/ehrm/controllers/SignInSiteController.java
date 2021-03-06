package br.com.ehrm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import br.com.ehrm.utils.DDLUtil;
import br.com.ehrm.vo.SignInVO;

@Controller
public class SignInSiteController {

	@Autowired
	private DDLUtil ddlUtil;

	@RequestMapping(value = "/signinsite")
	public String getIndex(Model model) {
		model.addAttribute("signInVO", new SignInVO());
		return "signinsite";
	}

	 
	@RequestMapping(value = "/signinsite", method = RequestMethod.POST)
	public RedirectView signSiteSubmit(@ModelAttribute("signInVO") SignInVO signInVO, Model model,
			RedirectAttributes redirectAttributes) {

		ddlUtil.createDataBase(signInVO.getSiteName());
		model.addAttribute("signInVO", signInVO);
		model.addAttribute("tenantid", signInVO.getUserName());

		redirectAttributes.addAttribute("context", signInVO.getSiteName());
		redirectAttributes.addFlashAttribute("signInVO", signInVO);
		RedirectView redirectView = new RedirectView();
		redirectView.setContextRelative(true);

		redirectView.setUrl("/panel/{context}");

		return redirectView;
	}

}
