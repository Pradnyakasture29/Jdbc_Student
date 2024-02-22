package dto;

public class Student 
{
	private int id;
	private String name;
	private String address;
	private long phone;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getAddress() 
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public long getPhone() 
	{
		return phone;
	}
	public void setPhone(long phone) 
	{
		this.phone = phone;
	}
	public Student(int id, String name, String address, long phone)
	{
		this.id=id;
		this.name=name;
		this.address=address;
		this.phone=phone;
	}
}
