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
		String errorMessage ="�α��ο� �����Ͽ����ϴ�.";
		redirectAttributes.addFlashAttribute("message", errorMessage);
		return "redirect:loginPage.do";
	}
	
	@RequestMapping("/interceptFailure.do")
	public String interceptFailure(@RequestParam String error, @RequestParam String url, RedirectAttributes redirectAttributes){
		String errorMessage ="�α��� ���ֽñ� �ٶ��ϴ�.";
		redirectAttributes.addFlashAttribute("message", errorMessage);
		return "redirect:loginPage.do";
	}
	
	@RequestMapping("/accessDenied.do")
	public String accessDenied(@RequestParam String error, @RequestParam String url, RedirectAttributes redirectAttributes) {
		String errorMessage = "������ �����ϴ�.";
		redirectAttributes.addFlashAttribute("message", errorMessage);
		return "redirect:loginPage.do";
	}
	
	@RequestMapping("/loginSuccess.do")
	public String loginSuccess(@RequestParam String error, @RequestParam String url, RedirectAttributes redirectAttributes) {
		String message = "�α��� �ϼ̽��ϴ�.";
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:loginPage.do";
	}
}
