package com.naver.controller;

import java.lang.reflect.Member;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.MemberDTO;
import kr.co.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	

	@Inject
	private MemberService memberService;

	
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) {
		List<MemberDTO> list = memberService.list();
		model.addAttribute("list", list);

	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(MemberDTO dto) {
		memberService.insert(dto);

		return "redirect:/member/list";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		return "member/insert";
	}

	@RequestMapping(value = "/read{id}", method = RequestMethod.GET)
	public void read(String id, Model model) {
		MemberDTO dto = memberService.read(id);
		model.addAttribute("dto", dto);
	}
//업데이트 화면으로 가는것
	@RequestMapping(value = "/update/{id}",method=RequestMethod.GET)
	public String updateui(@PathVariable("id")String id,Model model) {
	
		MemberDTO dto=memberService.updateui(id);
		
		model.addAttribute("dto",dto);
		return "member/update";
	}
	//업데이트  할 것을 디비에 넘겨줌
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(MemberDTO dto) {
		memberService.upate(dto);
		return "redirect:/member/list";
	}
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
	public String delete(@PathVariable("id")String id,Model model) {
		
		memberService.delete(id);
		return "redirect:/member/list"; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
