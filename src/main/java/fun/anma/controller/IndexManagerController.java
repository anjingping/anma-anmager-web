package fun.anma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fun.anma.common.pojo.AnmaResult;
import fun.anma.search.service.SearchItemService;

@Controller
public class IndexManagerController {
	
	@Autowired
	private SearchItemService searchItemService;
	
	@RequestMapping("/index/import")
	@ResponseBody
	public AnmaResult importIndex(){
		AnmaResult importItemToIndex = searchItemService.importItemToIndex();
		
		return importItemToIndex;
	}
	
}
