package top.juusok.couponapi.common.query.web.request;

public class AdoptCouponReq {
	
	private String $class = "org.network.coupon.GetCoupon";
	private String user;
	private String coupon;
	
	public String get$class() {
		return $class;
	}
	
	public String getUser() {
		return user;
	}
	
	public String getCoupon() {
		return coupon;
	}
	
	public void setCoupon(String coupon) {
		this.coupon = "org.network.coupon.Coupon#" + coupon;
	}
	
	public void setUser(String user) {
		this.user = "org.network.coupon.User#" + user;
	}

}
