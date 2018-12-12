package fun.anma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fun.anma.common.pojo.AnmaResult;
import fun.anma.common.pojo.EasyUITreeNode;
import fun.anma.content.service.ContentCategoryService;

@Controller
public class ContentCategoryController {

	@Autowired
	private ContentCategoryService contentCategoryService;
	
	@RequestMapping("/content/category/list")
	@ResponseBody
	public List<EasyUITreeNode> getContentCategoryList(@RequestParam(name="id",defaultValue="0") Long id){
		
		List<EasyUITreeNode> contentCategoryList = contentCategoryService.getContentCategoryList(id);
		
		return contentCategoryList;
		
	}
	
	
	@RequestMapping("/content/category/create")
	@ResponseBody
	public AnmaResult addContentCategory(Long parentId,String name){
		AnmaResult contentCategory = contentCategoryService.addContentCategory(parentId, name);
		
		return contentCategory;
	}
	
	@RequestMapping("/content/category/update")
	@ResponseBody
	public AnmaResult updateContentCategory(Long id,String name){
		AnmaResult conentCategory = contentCategoryService.updateConentCategory(id, name);
		
		return conentCategory;
	}
	
	@RequestMapping("/content/category/delete")
	@ResponseBody
	public AnmaResult delContentCategory(Long id){
		AnmaResult contentCategory = contentCategoryService.delContentCategory(id);
		
		return contentCategory;
	}
}
