package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.common.pojo.DataguridPage;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;

/**
 * 商品管理Controller
 * @author 闫一航
 *
 */
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/id/{ItemId}")
	@ResponseBody
	public TbItem findItemById(@PathVariable Long ItemId){
		TbItem item = itemService.findByItemId(ItemId);
		return item;
	}
	
	/**
	 * 分页展示所有商品信息
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public DataguridPage findByTbItem(int page,int rows){
		DataguridPage dataguridPage = itemService.findByItemList(page, rows);
		return dataguridPage;
	}
}
