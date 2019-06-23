package top.juusok.couponapi.common.model;

import java.util.Date;

public class Coupon {
	
	private String couponID;
	private double money;
	private Integer amount;
	private String validTime;
	private String invalidTime;
	private String description;
	
	public Coupon(double money, Integer amount, String validTime, String invalidTime, String description)
	{
		setMoney(money);
		setAmount(amount);
		setValidTime(validTime);
		setInvalidTime(invalidTime);
		setDescription(description);
	}
	
	public Coupon() {};
	
	public void setCouponID(String couponID)
	{
		this.couponID = couponID;
	}
	
	public void setMoney(double money)
	{
		this.money = money;
	}
	
	public void setAmount(Integer amount)
	{
		this.amount = amount;
	}
	
	public void setValidTime(String validTime)
	{
		if(validTime.length() > 19) {
			validTime = validTime.replace("T", " ");
			validTime = validTime.substring(0,19);
		}
		this.validTime = validTime;
	}
	
	public void setInvalidTime(String invalidTime)
	{
		if(invalidTime.length() > 19) {
			invalidTime = invalidTime.replace("T", " ");
			invalidTime = invalidTime.substring(0,19);
		}
		this.invalidTime = invalidTime;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public String getCouponID()
	{
		return couponID;
	}
	
	public double getMoney()
	{
		return money;
	}
	
	public Integer getAmount()
	{
		return amount;
	}
	
	public String getValidTime()
	{
		return validTime;
	}
	
	public String getInvalidTime()
	{
		return invalidTime;
	}
	
	public String getDescription()
	{
		return description;
	}
}
