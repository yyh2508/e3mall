package cn.e3mall.service;

import cn.common.pojo.DataguridPage;
import cn.e3mall.pojo.TbItem;

public interface ItemService {

	TbItem findByItemId(Long itemId);
	
	DataguridPage findByItemList(int page,int rows);
}
