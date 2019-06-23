package top.juusok.couponapi.common.query.web.response;

public class Coupon4SaleResp {

	private String user;
	private String coupon;
	private double price;
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getUser() {
		return user;
	}
	
	public String getCoupon() {
		return coupon;
	}
	
	public double getPrice() {
		return price;
	}
	
}
