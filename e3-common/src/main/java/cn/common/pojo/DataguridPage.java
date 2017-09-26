package cn.common.pojo;
import java.io.Serializable;
import java.util.List;

public class DataguridPage implements Serializable{

	private Long page;
	private List rows;
	public Long getTotal() {
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
}
