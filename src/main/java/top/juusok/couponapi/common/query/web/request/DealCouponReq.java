package top.juusok.couponapi.common.query.web.request;

public class DealCouponReq {
 
	private String $class = "org.network.coupon.BuyCoupon";
	private String seller;
	private String buyer;
	private String coupon;
	
	public String get$Class() {
		return $class;
	}
	
	public String getSeller() {
		return seller;
	}
	
	public String getBuyer() {
		return buyer;
	}
	
	public String getCoupon() {
		return coupon;
	}
	
	public void setCoupon(String coupon) {
		this.coupon = "org.network.coupon.Coupon#" + coupon;
	}
	
	public void setSeller(String seller) {
		this.seller = "org.network.coupon.User#" + seller;
	}
	
	public void setBuyer(String buyer) {
		this.buyer = "org.network.coupon.User#" + buyer;
	}
	
}
