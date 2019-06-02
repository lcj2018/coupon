package top.juusok.couponapi.common.model;

public class User {
	
	private String phoneNumber;
	private String password;
	
	public User(String phoneNumber, String password)
	{
		setPhoneNumber(phoneNumber);
		setPassword(password);
	}
	
	public User() {};
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public String getPassword()
	{
		return password;
	}
}
