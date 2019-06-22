package top.juusok.couponapi.common.fabricentity.response;

public class CouponItemResp {

	private String seller;
	private String typeID;
	private double money;
	private String description;
	private int amount;
	private String effectiveTime;
	private String expireTime;
	
	public void setSeller(String seller) {
		this.seller = seller;
	}
	
	public void setTypeID(String typeid) {
		this.typeID = typeid;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void setEffectiveTime(String effectiveTime) {
		this.effectiveTime = effectiveTime;
	}
	
	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}
	
}
