package fun.anma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fun.anma.common.pojo.AnmaResult;
import fun.anma.common.pojo.EasyUIDataGridResult;
import fun.anma.content.service.ContentService;
import fun.anma.pojo.TbContent;

@Controller
public class ContentController {

	@Autowired
	private ContentService contentService;
	
	//查询内容
	@RequestMapping("/content/query/list")
	@ResponseBody
	public EasyUIDataGridResult getContentList(Long categoryId,Integer page,Integer rows){
		EasyUIDataGridResult easyUIDataGridResult = contentService.getContentList(categoryId, page, rows);
		
		return easyUIDataGridResult;
	}
	
	//添加内容
	@RequestMapping("/content/save")
	@ResponseBody
	public AnmaResult addContent(TbContent content) {
		AnmaResult result = contentService.addContent(content);
		return result;
	}
	
	//获取内容
	@RequestMapping("/content/getContent")
	@ResponseBody
	public AnmaResult getContent(Long id){
		AnmaResult content = contentService.getContent(id);
		return content;
	}
	
	//更新内容
	@RequestMapping("/content/update")
	@ResponseBody
	public AnmaResult updateContent(TbContent content){
		AnmaResult result = contentService.updateContent(content);
		
		return result;
	}
	
	@RequestMapping("/content/delete")
	@ResponseBody
	public AnmaResult deleteContent(String ids){
		AnmaResult result = contentService.deleteContent(ids);
		return result;
	}
	
}
