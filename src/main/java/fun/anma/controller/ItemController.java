package fun.anma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fun.anma.common.pojo.AnmaResult;
import fun.anma.common.pojo.EasyUIDataGridResult;
import fun.anma.pojo.TbItem;
import fun.anma.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{id}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long id) {
		TbItem item = itemService.getItemById(id);
		return item;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(int page,int rows) {
		EasyUIDataGridResult itemList = itemService.getItemList(page, rows);
		return itemList;
	}
	
	@RequestMapping("/item/save")
	@ResponseBody
	public AnmaResult addItem(TbItem item,String desc) {
		
		try {
			AnmaResult result = itemService.createItem(item, desc);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return AnmaResult.build(500, "商品添加失败");
		}
		
		
	}

}
