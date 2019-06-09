package top.juusok.couponapi.common.model;

public class User {
	
	private String phoneNumber;
	private String password;
	private String salt;
	private String id;
	
	public User(String phoneNumber, String password)
	{
		setPhoneNumber(phoneNumber);
		setPassword(password);
	}
	
	public User() {};
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
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
	
	public String getSalt()
	{
		return salt;
	}
	
	public void setSalt(String salt) {
		this.salt = salt;
	}
}
