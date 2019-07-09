
import java.io.*;
import java.sql.*;

class SQLiteJDBC1
{

     int id1;
     String name1;
     int age1;
     String address1;
     int salary1;
     Connection Ex1con;
     Statement stmt;
  
     SQLiteJDBC1()
     {
	try
    {
	

	Class.forName("org.sqlite.JDBC");
         Ex1con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\V THANGARAJ\\Downloads\\semester 5\\advanced java programming\\3-java database\\test.db");
 
         // Ex1con = DriverManager.getConnection("jdbc:odbc:DEMO");

          stmt = Ex1con.createStatement();
	  System.out.println("Opened database successfully");
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	
	

     }
    
     void getDetails() throws SQLException,ClassNotFoundException,IOException
     {
            DataInputStream dis = new DataInputStream(System.in);
	    System.out.print("ENTER EMPLOYEE ID .... : ");
            String inputString1 = dis.readLine();
	    int id1 = Integer.parseInt(inputString1);
	    
	    System.out.print("ENTER EMPLOYEE NAME .... : ");
            name1 = dis.readLine();

            System.out.print("ENTER AGE .... : ");
	    String inputString2 = dis.readLine();
	    int age1 = Integer.parseInt(inputString2);
            
            System.out.print("ENTER Address.... : ");
            address1 = dis.readLine();

            System.out.print("ENTER Salary.... : ");
            String inputString3 = dis.readLine();
	    int salary1 = Integer.parseInt(inputString3);
 
          try
          {

          String str = "INSERT INTO COMPANY VALUES ('"+id1+"','"+name1+"','"+age1+"','"+address1+"','"+salary1+"')";

           stmt.executeUpdate(str);

	System.out.println("Data is inserted into database successfully");
           }
           catch(SQLException e5) {System.out.println(e5);}
    }

  
     void listDetails() throws SQLException,ClassNotFoundException,IOException
     {

          ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY");
  
          System.out.println("ID      NAME         AGE       ADDRESS      SALARY  ");
          while(rs.next())
          {
		 id1=rs.getInt(1);
                 name1 = rs.getString(2);
                 age1 = rs.getInt(3);
                 address1 = rs.getString(4);
                 salary1 = rs.getInt(5);
		 

                 System.out.println(id1+"       "+name1+ "            "+age1+"       "+ address1+ "       "+ salary1);

          }

     }
     public static void main(String args[])
     {
           SQLiteJDBC1 e1 = new SQLiteJDBC1();
           try
           {
               e1.getDetails();
               e1.listDetails();
           }
           catch(Exception e2) {System.out.println(e2);}
     }
}