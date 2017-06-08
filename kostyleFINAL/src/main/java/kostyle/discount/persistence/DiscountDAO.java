package kostyle.discount.persistence;

import java.util.List;

import kostyle.discount.domain.TempShopVO;

public interface DiscountDAO {
	
	public void addSaleUrlInfoShop(TempShopVO vo) throws Exception;
	
	public List<String> getNewSaleUrlList();
	public List<String> getDiscountUrlList();
	
	
}//interface
