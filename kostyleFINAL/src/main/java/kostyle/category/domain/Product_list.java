package kostyle.category.domain;

import java.util.List;

public class Product_list {
	private List<Product_category> list;

	public Product_list(List<Product_category> list) {
		super();
		this.list = list;
	}

	public List<Product_category> getList() {
		return list;
	}

	public void setList(List<Product_category> list) {
		this.list = list;
	}
	
}
