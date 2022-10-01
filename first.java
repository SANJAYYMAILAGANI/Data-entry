import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class EmpProject {
	
	
	void displayEmp()
	{
		
		 try {
			
			  
			 DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			 
			 
			 // establish connection 
			 
			 Connection con = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/cdu","root", "");
		             
			     if(con!=null)
			     {
			    	 System.out.println("Connected");
			     }
			     
			     // create a statement object 
			     
			     Statement st = con.createStatement();
			     
			     
			     String sql = "select * from emp";
			     
			     ResultSet rs =st.executeQuery(sql);
			     
			     while(rs.next())
			     {
			    	 System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			     }
			     
			     rs.close();
			     st.close();
			     con.close();
			     
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	void updateEmp()
	{
		
		Scanner sc  = new Scanner(System.in);
		
		System.out.println("Enter the eno");
		
		int eno = sc.nextInt();
		
		System.out.println("Enter the new Salary");
		
		double esal = sc.nextDouble();
		
		
		try {
			
 DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			 
			 
			 // establish connection 
			 
		Connection con = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/cdu","root", "");
		             
			     if(con!=null)
			     {
			    	 System.out.println("Connected");
			     }
			     
			     // create a statement object 
			     
			     Statement st = con.createStatement();
			     
			     
			     String sql = "update emp set esal = "+esal+" where eno ="+eno;
		 
			     int x = st.executeUpdate(sql);
			     
			     if(x==1)
			     {
			    	 System.out.println("Emp info updated successfully");
			     }
			     else 
			     {
			    	 System.out.println("Emp not found");
			     }
			     
			     st.close();
			     con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	void deleteEmp()
	{
		Scanner sc = new Scanner(System.in);
	   System.out.println("Enter the eno to remove the record");
	   int eno = sc.nextInt();
		 try {
			
 DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			 
			 
			 // establish connection 
			 
			 Connection con = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/cdu","root", "");
		             
			     if(con!=null)
			     {
			    	 System.out.println("Connected");
			     }
			     
			     // create a statement object 
			     
			     Statement st = con.createStatement();
			     
			     
			     String sql = "delete from emp where eno ="+eno;
			     
			     int x = st.executeUpdate(sql);
			     
			     if(x==1)
			     {
			    	 System.out.println("Emp delete successfully");
			     }
			     else
			     {
			    	 System.out.println("Emp not found");
			     }
			     st.close();
			     
			     con.close();
			     
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
	}
	void searchByEno()
	{
		
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Enter the eno");
            int eno = sc.nextInt();
		 try {
			
			  
			 DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			 
			 
			 // establish connection 
			 
			 Connection con = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/cdu","root", "");
		             
			     if(con!=null)
			     {
			    	 System.out.println("Connected");
			     }
			     
			     // create a statement object 
			     
			     Statement st = con.createStatement();
			     
			     
			     String sql = "select * from emp";
			     
			     ResultSet rs =st.executeQuery(sql);
			     
			     while(rs.next())
			     {
			    	 if(rs.getInt(1)==eno)
			    	 {
			    	 System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
			    	 }
			     }
			     
			     rs.close();
			     st.close();
			     con.close();
			     
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		
	}
	void searchByEsal()
	{

		Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the esal");
        double esal = sc.nextDouble();
	 try {
		
		  
		 DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		 
		 
		 // establish connection 
		 
		 Connection con = 
			DriverManager.getConnection("jdbc:mysql://localhost:3306/cdu","root", "");
	             
		     if(con!=null)
		     {
		    	 System.out.println("Connected");
		     }
		     
		     // create a statement object 
		     
		     Statement st = con.createStatement();
		     
		     
		     String sql = "select * from emp";
		     
		     ResultSet rs =st.executeQuery(sql);
		     
		     while(rs.next())
		     {
		    	 if(rs.getDouble(3)>=esal)
		    	 {
		    	 System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
		    	 }
		     }
		     
		     rs.close();
		     st.close();
		     con.close();
		     
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}


	}
	void insertEmp()
	{
		  try {
			  
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the eno");
        int eno = sc.nextInt();
        
        System.out.println("Enter the ename");
        String ename = sc.next();
        
        System.out.println("Enter the esal");
        double esal = sc.nextDouble();
			
			  // register the Driver 
			  
	 DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	 
	 
	 // establish connection 
	 
	 Connection con = 
		DriverManager.getConnection("jdbc:mysql://localhost:3306/cdu","root", "");
             
	     if(con!=null)
	     {
	    	 System.out.println("Connected");
	     }
	     
	     // create a statement object 
	     
	     Statement st = con.createStatement();
	     
	     String sql = "insert into emp value("+eno+",'"+ename+"',"+esal+")";
	     
	    int x = st.executeUpdate(sql);
	    
	    if(x==1)
	    {
	    	System.out.println("Emp inserted successfully");
	    }
	    
	    st.close();
	    
	    con.close();
		  
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
	}
	void checkCredential()
	{
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("Enter the username");
			String uname = sc.next();
			System.out.println("Enter the password");
			String password = sc.next();
			
			if(uname.equals("bhargav") && password.equals("prudhvi"))
			{
				System.out.println("Welcome to Admin Bhargav");
				break;
			}
			else
			{
				System.out.println("wrong username and password");
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmpProject di = new EmpProject();
		
		
		System.out.println("Welcome to Employee Management System");
		System.out.println("*************");
		di.checkCredential();
		int ch;
		Scanner sc = new Scanner(System.in);
		
	     do 
	     {
	    	 System.out.println("1. Add Emp");
	    	 System.out.println("2. Display Emp");
	    	 System.out.println("3. Update Emp");
	    	 System.out.println("4. Delete Emp");
	    	 System.out.println("5. Search Emp By Eno");
	    	 System.out.println("6. Search Emp by Sal ");
	    	 System.out.println("7. Exit");
	    	 
	    	 ch = sc.nextInt();
	    	 
	    	 switch(ch)
	    	 {
	    	 case 1:
	    		        di.insertEmp();
	    		        break;
	    	 case 2:
	    		         di.displayEmp();
	    		         break;
	    	 case 3:
	    		         di.updateEmp();
	    		         break;
	    	 case 4:
	    		         di.deleteEmp();
	    		         break;
	    	 case 5:
	    		         di.searchByEno();
	    		         break;
	    	 case 6:
	    		         di.searchByEsal();
	    		         break;
	    	 case 7:
	    		         System.out.println("Thank you");
	    		         break;
	         default:
	        	         System.out.println("Incorrect Choice");
	    		         break;
	    	 }
	     }
	     while(ch!=7);

	}

}