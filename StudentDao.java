package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao 
{
	public Connection connection;
	public Connection getConnection() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1_student","root","Pradnya@12!");
		return connection;	
	}
	
	public void addStudent(int id,String name,String address,long phone) throws SQLException, ClassNotFoundException
	{
		Connection connection=getConnection();
		PreparedStatement ps=connection.prepareStatement("insert into student values(?,?,?,?)");
		
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, address);
		ps.setLong(4, phone);
		
		int count=ps.executeUpdate();
		if(count>0)
		{
			System.out.println("added");
		}
		else
		{
			System.out.println("fail");
		}
		ps.close();
		connection.close();
	}
	public void fetchStudent(int id) throws ClassNotFoundException, SQLException
	{
		Connection connection=getConnection();
		PreparedStatement ps=connection.prepareStatement("select * from student where id=?");
		
		ps.setInt(1, id);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("address"));
			System.out.println(rs.getLong("phone"));
		}
		rs.close();
		ps.close();
		connection.close();
	}
	public void deleteStudent(int id) throws ClassNotFoundException, SQLException
	{
		Connection connection=getConnection();
		PreparedStatement ps=connection.prepareStatement("delete from student where id=?");
		ps.setInt(1, id);
		
		int count=ps.executeUpdate();
		if(count==1)
		{
			System.out.println("delete");
		}
		else
		{
			System.out.println("not deleted");
		}
		ps.close();
		connection.close();
	}
	public void updateStudent(int id) throws ClassNotFoundException, SQLException
	{
		Connection connection=getConnection();
		PreparedStatement ps=connection.prepareStatement("update student set name='pg'where id=?");
		ps.setInt(1, id);
		
		int count=ps.executeUpdate();
		if(count==1)
		{
			System.out.println("updated");
		}
		else
		{
			System.out.println("not updated");
		}
		ps.close();
		connection.close();
	}
	public void fetchAllStudent() throws ClassNotFoundException, SQLException
	{
		Connection connection=getConnection();
		PreparedStatement ps=connection.prepareStatement("select * from student");
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("address"));
			System.out.println(rs.getLong("phone"));
			System.out.println("----------------------------------------");
		}
		rs.close();
		ps.close();
		connection.close();
	}
	public void fetchStudentByName(String name) throws ClassNotFoundException, SQLException
	{
		Connection connection=getConnection();
		PreparedStatement ps=connection.prepareStatement("select * from student where name=?");
		
		ps.setString(1, name);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("address"));
			System.out.println(rs.getLong("phone"));
		}
		rs.close();
		ps.close();
		connection.close();
	}
	
}
