package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://@localhost:3306/new_schema","root","Shrutika@123");
				Statement st = con.createStatement();)
		{
		String query = "UPDATE EMP SET EID=5 WHERE ENAME='SAM' ";
		int count = st.executeUpdate(query);
		if (count==0) {
			System.out.println("Record Not updated");
		}
		else {
			System.out.println("Record updated");
		}
			
		}catch (SQLException se) {
		System.out.println(se.getMessage());
		se.printStackTrace();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
			
	}

}
