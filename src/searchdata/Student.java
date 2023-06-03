package searchdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Student {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Studentt", "root", "abc123");
		Statement st = con.createStatement();
		try {
			boolean found = false;
			Scanner s=new Scanner(System.in);

			System.out.print("Enter the roll no to search: ");
			int searchroll = Integer.parseInt(s.nextLine());
			
			ResultSet rs = st.executeQuery("SELECT * FROM stu WHERE id = " + searchroll + "");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
				found = true;
			}
			if (!found) {
				System.out.println("Student not found");
			}

		} catch (Exception p) {
			System.out.println("Enter the no. :" + p);

		}
		
		
		
		
		
	}

}
