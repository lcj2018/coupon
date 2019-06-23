package top.juusok.couponapi.common.query.fabricentity.request;

import java.text.SimpleDateFormat;
import java.util.Date;

import top.juusok.couponapi.common.model.Coupon;

public class CreateCouponReq {

	private String $class;
	private String seller;
	private int amount;
	private double money;
	private String effectiveTime;
	private String expireTime;
	private String description;
	
	public CreateCouponReq(String id, Coupon coupon)
	{
		$class = "org.network.coupon.PublishCoupons";
		seller = "org.network.coupon.Seller#" + String.valueOf(id);
		amount = coupon.getAmount();
		money = coupon.getMoney();
		effectiveTime = coupon.getValidTime() + ".104Z";
		expireTime = coupon.getInvalidTime() + ".104Z";
		effectiveTime = effectiveTime.replace(" ", "T");
		expireTime = expireTime.replace(" ", "T");
		description = coupon.getDescription();
	}
	
	public String get$Class() {
		return $class;
	}
	
	public String getSeller() {
		return seller;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public double getMoney() {
		return money;
	}
	
	public String getEffectiveTime() {
		return effectiveTime;
	}
	
	public String getExpireTime() {
		return expireTime;
	}
	
	public String getDescription() {
		return description;
	}
	
}
