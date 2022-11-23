package kr.co.three.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.three.dept.DeptService;
import kr.co.three.dept.Member;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/dept")
public class DeptController {
	private final DeptService deptService;
	
	@GetMapping
	public List<Member> list(){
		List<Member> m1= deptService.findByMember();
		
		for(Member m :m1) {
			System.out.println("m: "+m);
			System.out.println("m.dept: "+m.getDept().getDeptno()+", "+m.getDept().getDeptnm()+", "+m.getDept().getLoc());
		}
		return m1;
	}
}
