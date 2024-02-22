package controller;

import java.sql.SQLException;
import java.util.Scanner;

import dao.StudentDao;

public class MainController 
{
	public static void main(String[] args) throws SQLException, ClassNotFoundException 
	{
		StudentDao sd=new StudentDao();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Choice:\n1.Add Student \n2.Fetch Student \n3.Delete Student \n4.Update Student \n5.Fetch All Student \n6.Fetch Student By Name");
		int choice=sc.nextInt();
		
		switch(choice)
		{
		case 1:
		{
			System.out.println("Enter your id:");
			int id=sc.nextInt();
			System.out.println("Enter your name:");
			String name=sc.next();
			System.out.println("Enter your address:");
			String address=sc.next();
			System.out.println("Enter your phone:");
			long phone=sc.nextLong();
			
			sd.addStudent(id,name,address,phone);
			break;
		}
		case 2:
		{
			System.out.println("Enter your id:");
			int id=sc.nextInt();
			
			sd.fetchStudent(id);
			break;
		}
		case 3:
		{
			System.out.println("Enter your id:");
			int id=sc.nextInt();
			
			sd.deleteStudent(id);
			break;
		}
		case 4:
		{
			System.out.println("Enter your id:");
			int id=sc.nextInt();
			
			sd.updateStudent(id);
			break;
		}
		case 5:
		{
			sd.fetchAllStudent();
			break;
		}
		case 6:
		{
			System.out.println("Enter your name:");
			String name=sc.next();
			
			sd.fetchStudentByName(name);
			break;
		}
	    default:
		{
			System.out.println("wrong choice!!");
			break;
		}
		}
	}
}
