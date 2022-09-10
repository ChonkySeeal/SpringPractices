package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class testjdbc {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String ps = "hbstudent";

		try {
			System.out.println("Connecting to db: +" + url);

			Connection con = DriverManager.getConnection(url, user, ps);

			System.out.println("connection done!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
