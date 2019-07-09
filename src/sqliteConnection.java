import java.sql.*;
import javax.swing.*;
public class sqliteConnection
{
	Connection con = null;
	public static Connection dbConnector(){
		try{
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:C:/Users/V THANGARAJ/Desktop/EmployeeData.db");
			return con;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
		return null;
	}
}
