package kr.co.three.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.three.board.Board;
import kr.co.three.board.BoardService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class FirstController {

	private final BoardService service;

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/ajaxHome")
	public String ajaxHome() {
		return "ajaxHome";
	}

	@RequestMapping(value = "/boards/insert", method = RequestMethod.GET)
	public String insert() {
		return "ajaxInsert";
	}

	@RequestMapping(value = "/boards/insert", method = RequestMethod.POST)
	public String insert(Board vo) {
	
		vo.setRegDate(LocalDateTime.now());
		System.out.println("tttest"+vo.toString());
		service.insertBoard(vo);
		return "redirect:/boards/list";
	}

	@RequestMapping(value = "/boards/list")
	public String list(Model model) {

		model.addAttribute("boardList", service.findByBoard());

		return "ajaxList";
	}

}
