import java.sql.*;
import java.util.Scanner;

class Users {
	
	void create()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter first name,last name,city and mobile no.");
		String f_name=sc.next();
		String l_name=sc.next();
		String city=sc.next();
		long mobile=sc.nextLong();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/experiments", "root", "");
		
			String query="insert into user_info (first_name, last_name, city, phone_number) values(?,?,?,?) ";
			
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, f_name);
			pst.setString(2, l_name);
			pst.setString(3, city);
			pst.setLong(4, mobile);
			
			int i=pst.executeUpdate();
			
			if(i==1)
				System.out.println("data successfully inserted");
			else
				System.out.println("data insertion failed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	void check(int e)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter first name,last name");
		String f_name1=sc.next();
		String l_name1=sc.next();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/experiments", "root", "");
			
			String query=" select * from user_info where first_name=? and last_name=? ";
			
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, f_name1);
			pst.setString(2, l_name1);
			ResultSet rs=pst.executeQuery();
			rs.next();
			int a = rs.getRow();
			if(a==1)
			{
				 long b = rs.getLong("id");
				 if(e==1)
					 update(b);
				 else
					delete(b);
			}
			else
			{
				System.out.println("Please Enter id of person from the following for update: ");
				while (rs.next())
			      {
					long id = rs.getLong("id");
			        String firstName = rs.getString("first_name");
			        String lastName = rs.getString("last_name");
			      
			        
			
			        System.out.format("%s, %s, %s\n", id, firstName, lastName);
			      }
				System.out.println("Enter Id: \n");
				long c = sc.nextLong();
				if(e==1)
					 update(c);
				 else
					delete(c);
			}
		
		}
		catch(Exception f)
		{
			f.printStackTrace();
		}
		
	}
	void update(long id)
	{
			Scanner sc=new Scanner(System.in);
			System.out.println("Please enter the updates (first name,last name,city and mobile no.)");
			String f_name=sc.next();
			String l_name=sc.next();
			String city=sc.next();
			long mobile=sc.nextLong();
			
			try
			{
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/experiments", "root", "");
				
				String query="update user_info set first_name=?,last_name=?,city=?,phone_number=? where id=? ";
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1, f_name);
				pst.setString(2, l_name);
				pst.setString(3, city);
				pst.setLong(4, mobile);
				pst.setLong(5, id);
				int i=pst.executeUpdate();
				
				if(i==1)
					System.out.println("data successfully updated");
				else
					System.out.println("data updation failed");
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		
	}
	
	void delete(long id)
	{
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/experiments", "root", "");
			
			String query="delete from user_info where id=? ";
			
			PreparedStatement pst=con.prepareStatement(query);
			pst.setLong(1, id);
			
			int i=pst.executeUpdate();
			
			if(i==1)
				System.out.println("data successfully deleted");
			else
				System.out.println("data deletion failed");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	void print()
	{
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/experiments", "root", "");
			
			String query="select * from user_info ";
			
			PreparedStatement pst=con.prepareStatement(query);
			
			ResultSet rs =pst.executeQuery();
			
			while (rs.next())
		      {
		        
		        String firstName = rs.getString("first_name");
		        String lastName = rs.getString("last_name");
		        String city = rs.getString("city");
		        long mobile = rs.getLong("phone_number");
		        
		  
		        System.out.format("%s, %s, %s, %s\n", firstName, lastName, city, mobile);
		      }
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
}
public class database1{

		
		public static void main(String[] args){
			
			Scanner sc=new Scanner(System.in);
			int a,n = 0;
			while(n==0)
			{
				System.out.println("### please enter number from following option ###");
				System.out.println("1. Create \n2. Update \n3. Delete \n4. Print ");
				
				a = sc.nextInt();
				
				Users obj = new Users();
				
				switch(a)
				{
					case 1:
					{
						obj.create();
						break;
						
					}
					case 2:
					{
						obj.check(1);
						break;
					}
					case 3:
					{
						obj.check(2);
						break;
					}
					case 4:
					{
						obj.print();
						break;
					}
					case 5:
					{
						n=1;
						break;
					}
				}
			}
			
		}
}
	