package kostyle.admin.domain;

public class ShopStateAdmin {
	private ShoppingMallAdmin shop;
	private String shopState;
	private AdShoppingMallAdmin adShop;
	
	public ShoppingMallAdmin getShop() {
		return shop;
	}
	public void setShop(ShoppingMallAdmin shop) {
		this.shop = shop;
	}
	public String getShopState() {
		return shopState;
	}
	public void setShopState(String shopState) {
		this.shopState = shopState;
	}
	public AdShoppingMallAdmin getAdShop() {
		return adShop;
	}
	public void setAdShop(AdShoppingMallAdmin adShop) {
		this.adShop = adShop;
	}
	
}
