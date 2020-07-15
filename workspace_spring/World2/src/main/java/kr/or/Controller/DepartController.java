package kr.or.Controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.DepartDTO;
import kr.co.domain.MemberDTO;
import kr.co.service.DepartService;
import kr.co.service.MemberService;

@Controller
 @RequestMapping("depart") 
public class DepartController {

	
	 @Inject 
	 private DepartService dService;
	 
	 @RequestMapping(value = "/delete/{did}",method = RequestMethod.GET)
		public String delete(@PathVariable("did")String did, Model model) {
		dService.delete(did);
		return "redirect:/depart/list";
	 }
	
	 
	 @RequestMapping(value = "/update/{did}",method=RequestMethod.GET)
	 public String updateui(@PathVariable("did")String did, Model model) {
//		 수정하기전 기존정보 찍어줌
		DepartDTO dto=dService.updateui(did);
		model.addAttribute("dto", dto);
		 return "depart/update";
	 }
	 
	 @RequestMapping(value = "/update",method=RequestMethod.POST)
	 public String update(DepartDTO dto) {
//수정작업
		 dService.update(dto);
		 return "redirect:/depart/list";
	 }	 
	 

	 
	
	 
	 @RequestMapping(value = "/read/{did}",method=RequestMethod.GET)
	 public String read(@PathVariable("did")String did,Model model) {
		 DepartDTO dto=dService.read(did);
		 model.addAttribute("dto", dto);
		 return "depart/read";
	 }
	 @RequestMapping(value = "/list",method = RequestMethod.GET)
		 public void list(Model model) {
			List<DepartDTO> list = dService.list();
			
			model.addAttribute("list",list);
		 }
	 
	 
	 @RequestMapping(value = "/insert", method=RequestMethod.GET)
	 public void insert() {
		 
	 }
	
	@RequestMapping(value = "/insert", method=RequestMethod.POST)
	public String insert(DepartDTO dto) {
		
		dService.insert(dto);
		return "redirect:/depart/list";
	}
}
