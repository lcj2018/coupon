package top.juusok.couponapi.common.model;

import java.util.Date;

public class Coupon {
	
	private double money;
	private Integer amount;
	private Date validTime;
	private Date invalidTime;
	
	public Coupon(double money, Integer amount, Date validTime, Date invalidTime)
	{
		setMoney(money);
		setAmount(amount);
		setValidTime(validTime);
		setInvalidTime(invalidTime);
	}
	
	public Coupon() {};
	
	public void setMoney(double money)
	{
		this.money = money;
	}
	
	public void setAmount(Integer amount)
	{
		this.amount = amount;
	}
	
	public void setValidTime(Date validTime)
	{
		this.validTime = validTime;
	}
	
	public void setInvalidTime(Date invalidTime)
	{
		this.invalidTime = invalidTime;
	}
	
	public double getMoney()
	{
		return money;
	}
	
	public Integer getAmount()
	{
		return amount;
	}
	
	public Date getValidTime()
	{
		return validTime;
	}
	
	public Date getInvalidTime()
	{
		return invalidTime;
	}
}
