package com.springSec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
