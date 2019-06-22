package top.juusok.couponapi.common.fabricentity.request;

import java.util.ArrayList;

import com.alibaba.fastjson.annotation.JSONField;

import top.juusok.couponapi.common.model.Store;

public class CreateStoreReq {
	
	@JSONField(name = "$class")
	private String $class;
	private int publishedCount;
	private ArrayList publishedCoupons;
	private String userID;
	private String name;
	private String address;
	private String phoneNumber;
	private String password;
	private String salt;

	public CreateStoreReq(Store store)
	{
		$class = "org.network.coupon.Seller";
		publishedCount = 0;
		publishedCoupons = new ArrayList();
		userID = store.getId();
		name = store.getName();
		address = store.getAddress();
		phoneNumber = store.getPhoneNumber();
		password = store.getPassword();
		salt = store.getSalt();
	}
	
	public String get$Class() { 
		return $class; 
	}
	
	public int getPublishedCount() {
		return publishedCount;
	}	
	
	public ArrayList getPublishedCoupons() {
		return publishedCoupons;
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
