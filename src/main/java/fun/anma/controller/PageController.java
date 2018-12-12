package fun.anma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	//访问首页
	@RequestMapping("/")
	public String showIndex(){
		return "index";
	}

	//访问其他页面
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		
		return page;
	}
	
	

}
