package kr.co.first.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {

	@RequestMapping(value= {"/"})
	public String idx() {
		return "redirect:index.jsp";
		
	}
	@RequestMapping(value= {"/home"})
	public String home(LocalDateTime local, Model model) {
		DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		model.addAttribute("toDate",dateTimeFormatter.format(LocalDateTime.now()));
		return "home";
		
	}
	@RequestMapping("/ajaxHome")
	public String ajaxHome() {
		return "ajaxHome";
	}
	
}



