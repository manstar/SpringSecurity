package com.springSec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springSec.dao.LoginDao;

@Controller
public class MainController {

	@Autowired
	private LoginDao loginDao;
	
	@RequestMapping("/loginPage.do")
	public String loginPage(Model model){
		return "loginPage";
	}
	
	@RequestMapping("/logout.do")
	public String logout(Model model){
		return "redirect:index.do";
	}
	
	@RequestMapping("/makeAccount.do")
	public String makeAccount(Model model){
		return "makeAccount";
	}
	
	@RequestMapping("/makeAccountSubmit.do")
	public String makeAccountSubmit(String userId, String password){
		loginDao.makeAccount(userId, password);
		return "redirect:loginPage.do";
	}
	
	@RequestMapping("/loginFailure.do")
	public String loginFailure(@RequestParam String error, @RequestParam String url, RedirectAttributes redirectAttributes) {
		String errorMessage ="로그인에 실패하였습니다.";
		redirectAttributes.addFlashAttribute("message", errorMessage);
		return "redirect:loginPage.do";
	}
	
	@RequestMapping("/interceptFailure.do")
	public String interceptFailure(@RequestParam String error, @RequestParam String url, RedirectAttributes redirectAttributes){
		String errorMessage ="로그인 해주시기 바랍니다.";
		redirectAttributes.addFlashAttribute("message", errorMessage);
		return "redirect:loginPage.do";
	}
	
	@RequestMapping("/accessDenied.do")
	public String accessDenied(@RequestParam String error, @RequestParam String url, RedirectAttributes redirectAttributes) {
		String errorMessage = "권한이 없습니다.";
		redirectAttributes.addFlashAttribute("message", errorMessage);
		return "redirect:loginPage.do";
	}
	
	@RequestMapping("/loginSuccess.do")
	public String loginSuccess(@RequestParam String error, @RequestParam String url, RedirectAttributes redirectAttributes) {
		String message = "로그인 하셨습니다.";
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:loginPage.do";
	}
}
