package kr.co.ca;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	
	
	public String insert( Model model,String name){
		name=toKor(name);
		
		model.addAttribute("name","name");
		return "insert";
		
				}
	
	
	private String tokor(String name) {
		
		try {
		
		return new String (name.getBytes("8859_1"),"UTF-8");
	}catch (Exception e) {
		e.printStackTrace();
	}

}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list() {
		return "list";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		model.addAttribute("servertime","안녕하세요");
		
		return "home";
	}
	
}
