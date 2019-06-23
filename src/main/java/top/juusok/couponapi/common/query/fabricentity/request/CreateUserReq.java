package top.juusok.couponapi.common.query.fabricentity.request;

import java.util.ArrayList;

import com.alibaba.fastjson.annotation.JSONField;

import top.juusok.couponapi.common.model.User;

public class CreateUserReq {
	
	@JSONField(name = "$class")
	private String $class;
	private double money;
	private ArrayList ownedCoupons;
	private ArrayList soldCouponInfoList;
	private String userID;
	private String name;
	private String address;
	private String phoneNumber;
	private String password;
	private String salt;

	public CreateUserReq(User user)
	{
		$class = "org.network.coupon.User";

		
		userID = user.getId();
		name = "chr";
		address = "SCUT";
		phoneNumber = user.getPhoneNumber();
		password = user.getPassword();
		salt = user.getSalt();
	}
	
	public String get$Class() { 
		return $class; 
	}
	
	public double getMoney() {
		return money;
	}	
	
	public ArrayList getOwnedCoupons() {
		return ownedCoupons;
	}
	
	public ArrayList getSoldCouponInfoList() {
		return soldCouponInfoList;
	}
	
	public String getUserID( ) {
		return userID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getSalt() {
		return salt;
	}
	
}
