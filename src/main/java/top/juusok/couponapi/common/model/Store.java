package top.juusok.couponapi.common.model;

public class Store {
	
	private String name;
	private String address;
	private String phoneNumber;
	private String password;
 
	public Store(String name, String address, String phoneNumber, String password)
	{
		setName(name);
		setAddress(address);
		setPhoneNumber(phoneNumber);
		setPassword(password);
	}
	
	public Store() {};
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getAddress()
	{
		return address;
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