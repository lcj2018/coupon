package top.juusok.couponapi.common.query.web.request;

public class PutCouponReq {

	private String $class = "org.network.coupon.SellCoupon";
	private String user;
	private String coupon;
	private double price;
	
	public String get$Class() {
		return $class;
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
	
	public void setUser(String user) {
		this.user = "org.network.coupon.User#" + user;
	}
	
	public void setCoupon(String coupon) {
		this.coupon = "org.network.coupon.Coupon#" + coupon;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
}
