package cn.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.common.pojo.DataguridPage;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.service.ItemService;
/**
 * 商品管理Service
 * @author 闫一航
 *
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	public TbItem findByItemId(Long itemId) {
		TbItem item = itemMapper.selectByPrimaryKey(itemId);
		return item;
	}
	
	/**
	 * 利用PageHelper插件实现分页
	 */
	public DataguridPage findByItemList(int page, int rows) {
		//设置分页
		PageHelper.startPage(page, rows);
		//执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		//从结果中获取分页信息
		PageInfo<TbItem> pageinfo = new PageInfo<>(list);
		//获取总记录数封装到DataguridPage
		DataguridPage dataguridPage = new DataguridPage();
		//总记录数
		dataguridPage.setPage(pageinfo.getTotal());
		//当前页数据
		dataguridPage.setRows(list);
		return dataguridPage;
	}

}
